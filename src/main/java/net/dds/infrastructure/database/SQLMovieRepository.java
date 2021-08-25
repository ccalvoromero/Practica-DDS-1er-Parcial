package net.dds.infrastructure.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.movie.MovieState;
import net.dds.domain.exceptions.UnavailableMovieException;

import net.dds.infrastructure.database.connection.DatabaseConnector;

import static net.dds.domain.movie.MovieState.*;

public class SQLMovieRepository implements MovieRepository {

    private final DatabaseConnector databaseConnector;

    public SQLMovieRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Movie findAvailableMovie(Integer movieId) {
        Movie movie = null;
        try {
            Connection dbConnection = databaseConnector.create();
            String query = "select * from movie where movie_id = " + movieId + " and movie_state_id = 1;";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), AVAILABLE);
        }catch(Exception ignored) {}
        if(movie == null)
            throw new UnavailableMovieException();
        return movie;
    }

    @Override
    public Movie findRentedMovie(Integer physicalMovieId) {
        Movie movie = null;
        try {
            Connection dbConnection = databaseConnector.create();
            String query = "select * from movie where physical_movie_id = " + physicalMovieId + " and movie_state_id = 2;";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), RENTED);
        }catch(Exception ignored) {}
        return movie;
    }

    @Override
    public void update(Movie movie) {
        try {
            Connection dbConnection = databaseConnector.create();
            String query = "UPDATE movie SET movie_state_id = " + movie.state().id() + " WHERE physical_movie_id = " + movie.physicalMovieId() + ";";
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate(query);
        }catch(Exception ignored) {}
    }

    @Override
    public Movie findById(Integer physicalMovieId) {
        Movie movie = null;
        try {
            Connection dbConnection = databaseConnector.create();
            String query = "select * from movie where physical_movie_id = " + physicalMovieId + ";";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), idToMovieState(rs.getInt(5)));
        }catch(Exception ignored) {}
        return movie;
    }

    private MovieState idToMovieState(Integer movieState){
        switch (movieState){
            case 1: return AVAILABLE;
            case 2: return RENTED;
            case 3: return SOLD;
            default: throw new RuntimeException();
        }
    }

    private Integer movieStateToId(MovieState movieState){
        switch (movieState.name()){
            case "Careless": return 1;
            case "Regular": return 2;
            case "Loyal": return 3;
            default: throw new RuntimeException();
        }
    }

}
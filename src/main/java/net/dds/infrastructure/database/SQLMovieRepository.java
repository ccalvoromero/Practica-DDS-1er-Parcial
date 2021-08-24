package net.dds.infrastructure.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.infrastructure.database.connection.DbConnector;

public class SQLMovieRepository implements MovieRepository {

    @Override
    public Movie findAvailableMovie(Integer movieId) {
        Movie movie = null;
        try {
            Connection dbConnection = DbConnector.connect();
            String query = "select * from movie where movie_id = " + movieId + " and movie_state_id = 1;";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
        }catch(Exception ignored) {}
        return movie;
    }

    @Override
    public Movie findRentedMovie(Integer physicalMovieId) {
        Movie movie = null;
        try {
            Connection dbConnection = DbConnector.connect();
            String query = "select * from movie where physical_movie_id = " + physicalMovieId + " and movie_state_id = 2;";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
        }catch(Exception ignored) {}
        return movie;
    }

    @Override
    public void update(Movie movie) {
        try {
            Connection dbConnection = DbConnector.connect();
            String query = "UPDATE movie SET movie_state_id = " + movie.state() + " WHERE physical_movie_id = " + movie.physicalMovieId() + ";";
            Statement stmt = dbConnection.createStatement();
            stmt.executeQuery(query);
        }catch(Exception ignored) {}
    }

    @Override
    public Movie findById(Integer physicalMovieId) {
        Movie movie = null;
        try {
            Connection dbConnection = DbConnector.connect();
            String query = "select * from movie where physical_movie_id = " + physicalMovieId + ";";
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4));
        }catch(Exception ignored) {}
        return movie;
    }

}
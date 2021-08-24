package net.dds.infrastructure.database;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.infrastructure.database.connection.DbConnector;
import net.dds.infrastructure.database.jpa.JpaMovie;
import net.dds.infrastructure.database.jpa.JpaMovieRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLMovieRepository implements MovieRepository {

    @Override
    public Movie findAvailableMovie(Integer id) {
        Movie movie = null;
        try {
            Connection dbConnection = DbConnector.connect();
            String query = "select * from movie where movie_id = " + id;
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next())
                movie = new Movie(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            if(movie == null)
                throw new RuntimeException();
        }catch(Exception ignored) {}
        return movie;
    }

    @Override
    public Movie findRentedMovie(Integer id) {
        return new Movie(id, "", 0.0);
    }

    @Override
    public void save(Movie movie) { }

    @Override
    public Movie findById(Integer id) {
        return new Movie(id, "", 0.0);
    }

}
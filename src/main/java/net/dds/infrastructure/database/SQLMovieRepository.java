package net.dds.infrastructure.database;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;

public class SQLMovieRepository implements MovieRepository {

    private final MovieDataAccessObject movieDataAccessObject;

    public SQLMovieRepository(MovieDataAccessObject movieDataAccessObject) {
        this.movieDataAccessObject = movieDataAccessObject;
    }

    @Override
    public Movie findAvailableMovie(Integer id) {
        return new Movie(id, "", 0.0);
    }

    @Override
    public Movie findRentedMovie(Integer id) {
        return new Movie(id, "", 0.0);
    }

    @Override
    public void save(Movie movie) { }

}
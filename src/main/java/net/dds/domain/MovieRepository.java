package net.dds.domain;

import net.dds.domain.movie.Movie;

public interface MovieRepository {
    void update(Movie movie);
    Movie findById(Integer physicalMovieId);
    Movie findRentedMovie(Integer physicalMovieId);
    Movie findAvailableMovie(Integer movieId);
}
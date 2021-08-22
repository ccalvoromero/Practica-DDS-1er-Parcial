package net.dds.domain;

import net.dds.domain.movie.Movie;

public interface MovieRepository {
    void save(Movie movie);
    Movie findById(Integer id);
    Movie findRentedMovie(Integer id);
    Movie findAvailableMovie(Integer id);
}
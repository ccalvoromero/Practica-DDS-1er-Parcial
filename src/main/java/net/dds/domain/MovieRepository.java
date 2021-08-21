package net.dds.domain;

import net.dds.domain.movie.Movie;

public interface MovieRepository {
    Movie findAvailableMovie(Integer id);
    void save(Movie movie);
}
package net.dds.infrastructure;

import net.dds.domain.MovieRepository;
import net.dds.domain.exceptions.NotAvailableMovie;
import net.dds.domain.movie.Movie;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMovieRepository implements MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    @Override
    public Movie findAvailableMovie(Integer id) {
        return movies.stream()
            .filter(movie -> movie.equalsId(id) && movie.isAvailable())
            .findFirst()
            .orElseThrow(NotAvailableMovie::new);
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

}
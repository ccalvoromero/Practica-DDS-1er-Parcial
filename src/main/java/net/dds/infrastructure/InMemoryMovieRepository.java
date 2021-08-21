package net.dds.infrastructure;

import java.util.List;
import java.util.ArrayList;

import net.dds.domain.MovieRepository;
import net.dds.domain.movie.Movie;
import net.dds.domain.exceptions.NotAvailableMovie;

import static net.dds.domain.movie.State.AVAILABLE;

public class InMemoryMovieRepository implements MovieRepository {

    private final List<Movie> movies = new ArrayList<>();

    @Override
    public Movie findAvailableMovie(Integer id) {
        return movies.stream()
            .filter(movie -> movie.id().equals(id) && movie.state().equals(AVAILABLE))
            .findFirst()
            .orElseThrow(NotAvailableMovie::new);
    }

    @Override
    public void save(Movie movie) {
        movies.add(movie);
    }

}
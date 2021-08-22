package net.dds.usecase;

import net.dds.domain.MovieRepository;
import net.dds.domain.MovieReview;
import net.dds.domain.movie.Movie;

public class SearchMovieReview {

    private final MovieReview movieReview;
    private final MovieRepository movieRepository;

    public SearchMovieReview(MovieReview movieReview, MovieRepository movieRepository) {
        this.movieReview = movieReview;
        this.movieRepository = movieRepository;
    }

    public String execute(Integer movieId) {
        Movie movie = movieRepository.findById(movieId);
        return movieReview.findByName(movie.name());
    }

}
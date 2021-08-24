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

    public String execute(Integer physicalMovieId) {
        Movie movie = movieRepository.findById(physicalMovieId);
        return movieReview.findByName(movie.name());
    }

}
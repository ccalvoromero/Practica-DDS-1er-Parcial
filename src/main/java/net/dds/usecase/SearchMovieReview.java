package net.dds.usecase;

import net.dds.domain.MovieReview;

public class SearchMovieReview {

    private final MovieReview movieReview;

    public SearchMovieReview(MovieReview movieReview) {
        this.movieReview = movieReview;
    }

    public String execute(String movieName) {
        return movieReview.findByName(movieName);
    }

}
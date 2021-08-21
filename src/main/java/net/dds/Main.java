package net.dds;

import net.dds.domain.MovieReview;
import net.dds.infrastructure.api.moviereview.MovieReviewAPI;

public class Main {

    public static void main(String[] args) {
        MovieReview movieReview = new MovieReviewAPI();
        String response = movieReview.findByName("Harry Potter");
        System.out.println(response);
    }

}
package net.dds.infrastructure.api;

import net.dds.domain.MovieReview;

public class MovieReviewAPI implements MovieReview {

    @Override
    public String findByName(String name) {
        return "This movie is funny!";
    }

}
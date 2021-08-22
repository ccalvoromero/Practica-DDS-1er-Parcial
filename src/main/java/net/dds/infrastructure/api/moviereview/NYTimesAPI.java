package net.dds.infrastructure.api.moviereview;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NYTimesAPI {

    @GET("search.json")
    Call<MovieReviewsResponse> moviesReview(@Query("api-key") String apiKey, @Query("query") String movieName);

}
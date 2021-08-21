package net.dds.infrastructure.api.moviereview;

import net.dds.domain.MovieReview;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MovieReviewAPI implements MovieReview {

    private final Retrofit retrofit;
    private final static String endpoint = "https://api.nytimes.com/svc/movies/v2/reviews/";
    private final static String apiKey = "Vv6rjyS3WfPeKdnW5H26FNKMQNCNZ9Ft";

    public MovieReviewAPI() {
        this.retrofit = new Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }


    @Override
    public String findByName(String name) {
        try {
            NYTimesAPI nyTimesAPI = retrofit.create(NYTimesAPI.class);
            Call<MovieReviewsResponse> request = nyTimesAPI.moviesReview(apiKey, name);
            Response<MovieReviewsResponse> response = request.execute();
            return response.body().toString(); //TODO Revisar bien response :)
        }catch(IOException e) {
            throw new RuntimeException();
        }
    }

}
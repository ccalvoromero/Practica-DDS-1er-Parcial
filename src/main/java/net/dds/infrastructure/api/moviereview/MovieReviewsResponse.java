package net.dds.infrastructure.api.moviereview;

import java.util.List;

public class MovieReviewsResponse {
    public String status;
    public String copyright;
    public String has_more;
    public Integer num_results;
    public List<Result> results;
}
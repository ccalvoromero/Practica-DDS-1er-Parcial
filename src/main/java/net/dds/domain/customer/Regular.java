package net.dds.domain.customer;

public class Regular implements CustomerType {

    private static CustomerType instance;
    private static final int maximumMovieIssues = 5;
    private static final int minimumMovieWithoutIssues = 20;
    private static final int minimumPurchasedMovies = 5;

    public static CustomerType instance() {
        if(instance == null)
            instance = new Regular();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.movieIssues() >= maximumMovieIssues){
            customer.setType(Uncertain.instance());
            customer.resetMovieIssues();
        } else if(customer.rentedMoviesWithoutIssues() >= minimumMovieWithoutIssues &&
            customer.totalPurchasedMovies() >= minimumPurchasedMovies)
            customer.setType(Loyal.instance());
    }

    @Override
    public Double customerPrice(Double rentPrice) {
        return rentPrice;
    }

}
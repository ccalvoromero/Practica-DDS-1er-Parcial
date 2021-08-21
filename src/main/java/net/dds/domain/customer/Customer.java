package net.dds.domain.customer;

import java.util.List;
import java.util.ArrayList;

import net.dds.domain.movie.Movie;
import net.dds.domain.payment.PaymentMethod;

public class Customer {

    private final Integer documentNumber;
    private final List<Movie> rentedMovies = new ArrayList<>();
    private final List<Movie> purchasedMovies = new ArrayList<>();
    private CustomerState state;

    private Integer issues;
    private Integer rentedMoviesWithoutIssues;

    public Customer(Integer documentNumber) {
        this.documentNumber = documentNumber;
        this.issues = 0;
        this.rentedMoviesWithoutIssues = 0;
        this.state = Regular.instance();
    }

    public void rentMovie(Movie movie, Integer days, PaymentMethod paymentMethod) {
        paymentMethod.pay(state.membershipPrice(movie.rentPrice(days)));
        movie.rented();
        this.rentedMovies.add(movie);
    }

    public void buyMovie(Movie movie, PaymentMethod paymentMethod){
        paymentMethod.pay(movie.buyPrice());
        movie.sold();
        this.purchasedMovies.add(movie);
    }

    public void returnMovie(Movie movie) {
        movie.returned();
        this.rentedMovies.remove(movie);
        state.change(this); // #1 Aca o en el use case
    }

    private void changeState(){
        this.state.change(this);
    }

    protected void setState(CustomerState state){
        this.state = state;
    }

    public void addIssue(){
        this.issues++;
    }

    public void resetIssues(){
        this.issues = 0;
    }

    public void resetRentedMoviesWithoutIssues (){
        this.rentedMoviesWithoutIssues = 0;
    }

    public void addRentedMovieWithoutIssue (){
        this.rentedMoviesWithoutIssues++;
    }

    public Integer issues() {
        return issues;
    }

    public Integer rentedMoviesWithoutIssues() {
        return rentedMoviesWithoutIssues;
    }

    public Integer totalPurchasedMovies(){
        return this.purchasedMovies.size();
    }
}
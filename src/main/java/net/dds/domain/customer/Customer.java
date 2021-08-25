package net.dds.domain.customer;

import java.util.List;
import java.util.ArrayList;
import net.dds.domain.movie.Movie;
import net.dds.domain.payment.PaymentMethod;

public class Customer {

    private final Integer documentNumber;
    private final List<Movie> rentedMovies = new ArrayList<>();
    private final List<Movie> purchasedMovies = new ArrayList<>();
    private CustomerType type;

    private Integer movieIssues;
    private Integer rentedMoviesWithoutIssues;

    public Customer(Integer documentNumber, Integer rentedMoviesWithoutIssues, Integer movieIssues, CustomerType type) {
        this.documentNumber = documentNumber;
        this.rentedMoviesWithoutIssues = rentedMoviesWithoutIssues;
        this.movieIssues = movieIssues;
        this.type = type;
    }

    public void rentMovie(Movie movie, Integer days, PaymentMethod paymentMethod) {
        Double rentPrice = movie.rentPrice(days);
        paymentMethod.pay(type.customerPrice(rentPrice));
        movie.rented();
        rentedMovies.add(movie);
    }

    public void buyMovie(Movie movie, PaymentMethod paymentMethod) {
        paymentMethod.pay(movie.buyPrice());
        movie.sold();
        purchasedMovies.add(movie);
    }

    public void returnMovie(Movie movie) {
        movie.returned();
        rentedMovies.remove(movie);
        type.change(this);
    }

    protected void setType(CustomerType type){
        this.type = type;
    }

    public void addMovieIssue(){
        this.movieIssues++;
    }

    public void resetMovieIssues(){
        this.movieIssues = 0;
    }

    public void resetRentedMoviesWithoutIssues (){
        this.rentedMoviesWithoutIssues = 0;
    }

    public void addRentedMovieWithoutIssue (){
        this.rentedMoviesWithoutIssues++;
    }

    public Integer movieIssues() {
        return this.movieIssues;
    }

    public Integer rentedMoviesWithoutIssues() {
        return this.rentedMoviesWithoutIssues;
    }

    public Integer totalPurchasedMovies(){
        return this.purchasedMovies.size();
    }

    public void addRentedMovie(Movie movie) {
        rentedMovies.add(movie);
    }

    public void addPurchasedMovies(Movie movie){
        purchasedMovies.add(movie);
    }

    public CustomerType type() {
        return this.type;
    }

    public Integer documentNumber() {
        return documentNumber;
    }

}
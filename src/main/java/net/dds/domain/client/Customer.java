package net.dds.domain.client;

import java.util.List;
import java.util.ArrayList;

import net.dds.domain.movie.Movie;
import net.dds.domain.payment.PaymentMethod;

public class Customer {

    private final Long documentNumber;
    private final List<Movie> rentedMovies = new ArrayList<>();
    private final List<Movie> soldMovies = new ArrayList<>();
    private CustomerState state;

    public Customer(Long documentNumber) {
        this.documentNumber = documentNumber;
        this.state = Regular.instance();
    }

    public void rentMovie(Movie movie, Integer days, PaymentMethod paymentMethod) {
        paymentMethod.pay(movie.rentPrice(days));
        movie.rented();
        rentedMovies.add(movie);
    }

    public void buyMovie(Movie movie, PaymentMethod paymentMethod){
        paymentMethod.pay(movie.buyPrice());
        movie.sold();
        soldMovies.add(movie);
    }

    public void returnMovie(Movie movie) {
        movie.returned();
        rentedMovies.remove(movie);
    }

    private void changeState(){
        this.state.change(this);
    }

    protected void setState(CustomerState state){
        this.state = state;
    }

}
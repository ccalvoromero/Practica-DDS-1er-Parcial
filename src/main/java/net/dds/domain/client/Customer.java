package net.dds.domain.client;

import net.dds.domain.movie.Movie;
import net.dds.domain.payment.PaymentMethod;

import java.util.List;
import java.util.ArrayList;

public class Customer {

    private final Long identification;
    private final List<Movie> rentedMovies = new ArrayList<>();
    private CustomerState state;

    public Customer(Long identification) {
        this.identification = identification;
        this.state = Regular.instance();
    }

    public void rentMovie(Movie movie, Integer days, PaymentMethod paymentMethod) {
        paymentMethod.pay(movie.rentPrice(days));  // TODO Meter una excepción por si el pago falla
        movie.rent();
        rentedMovies.add(movie);
    }

    public void buyMovie(Movie movie, PaymentMethod paymentMethod){
        paymentMethod.pay(movie.buyPrice());
    }

    private void changeState(){
        this.state.change(this);
    }

    protected void setState(CustomerState state){
        this.state = state;
    }

}
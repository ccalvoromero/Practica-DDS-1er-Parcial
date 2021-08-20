package net.dds.dominio;

import java.util.List;

public class Client {
    private final String name;
    private final Integer identification;
    private List<Movie> rentedMovies = null;

    public Client(String name, Integer identification) {
        this.name = name;
        this.identification = identification;
    }

    public void rentMovie(Movie aMovie, Integer days, PaymentMethod paymentMethod){
        paymentMethod.pay(aMovie.rentPrice(days));
        // Meter una excepcion por si el pago falla
        rentedMovies.add(aMovie);
    }

    public void buyMovie(Movie aMovie, PaymentMethod paymentMethod){
        paymentMethod.pay(aMovie.buyPrice());
    }
}

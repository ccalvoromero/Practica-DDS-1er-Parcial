package net.dds.usecase;

import net.dds.domain.ClientRepository;
import net.dds.domain.MovieRepository;
import net.dds.domain.client.Customer;
import net.dds.domain.movie.Movie;
import net.dds.domain.payment.PaymentMethod;

public class RentMovie {

    private final MovieRepository movieRepository;
    private final ClientRepository clientRepository;
    private final PaymentMethod paymentMethod;

    public RentMovie(MovieRepository movieRepository, ClientRepository clientRepository, PaymentMethod paymentMethod) {
        this.movieRepository = movieRepository;
        this.clientRepository = clientRepository;
        this.paymentMethod = paymentMethod;
    }

    public void execute(Integer movieId, Integer rentalDays, Long clientId) {
        Movie movie = movieRepository.findAvailableMovie(movieId);
        Customer client = clientRepository.findById(clientId);
        client.rentMovie(movie, rentalDays, paymentMethod);
        movieRepository.save(movie);
        clientRepository.update(client);
    }

}
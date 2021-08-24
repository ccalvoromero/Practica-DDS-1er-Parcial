package net.dds.usecase;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.CustomerRepository;
import net.dds.domain.payment.PaymentMethod;

public class BuyMovie {

    private final PaymentMethod paymentMethod;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;

    public BuyMovie(PaymentMethod paymentMethod, MovieRepository movieRepository, CustomerRepository customerRepository) {
        this.paymentMethod = paymentMethod;
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
    }

    public void execute(Integer movieId, Integer customerDocumentNumber) {
        Movie movie = movieRepository.findAvailableMovie(movieId);
        Customer customer = customerRepository.findByDocumentNumber(customerDocumentNumber);
        customer.buyMovie(movie, paymentMethod);
        movieRepository.update(movie);
        customerRepository.save(customer);
    }

}
package net.dds.usecase;

import net.dds.domain.OperationRepository;
import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.CustomerRepository;
import net.dds.domain.payment.PaymentMethod;
import net.dds.infrastructure.database.operationtype.BuySave;

public class BuyMovie {

    private final PaymentMethod paymentMethod;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final OperationRepository operationRepository;

    public BuyMovie(PaymentMethod paymentMethod, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
            this.paymentMethod = paymentMethod;
            this.movieRepository = movieRepository;
            this.customerRepository = customerRepository;
            this.operationRepository = operationRepository;
    }

    public void execute(Integer movieId, Integer customerDocumentNumber) {
        Movie movie = movieRepository.findAvailableMovie(movieId);
        Customer customer = customerRepository.findByDocumentNumber(customerDocumentNumber);
        customer.buyMovie(movie, paymentMethod);
        movieRepository.update(movie);
        operationRepository.save(customer, movie, new BuySave());
    }

}
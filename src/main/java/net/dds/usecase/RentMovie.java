package net.dds.usecase;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.CustomerRepository;
import net.dds.domain.OperationRepository;
import net.dds.domain.payment.PaymentMethod;
import net.dds.infrastructure.database.operationtype.RentSave;

public class RentMovie {

    private final PaymentMethod paymentMethod;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final OperationRepository operationRepository;

    public RentMovie(PaymentMethod paymentMethod, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
            this.paymentMethod = paymentMethod;
            this.movieRepository = movieRepository;
            this.customerRepository = customerRepository;
            this.operationRepository = operationRepository;
    }

    public void execute(Integer movieId, Integer rentalDays, Integer customerDocumentNumber) {
        Movie movie = movieRepository.findAvailableMovie(movieId);
        Customer customer = customerRepository.findByDocumentNumber(customerDocumentNumber);
        customer.rentMovie(movie, rentalDays, paymentMethod);
        movieRepository.update(movie);
        customerRepository.save(customer);
        operationRepository.save(customer, movie, new RentSave());
    }

}
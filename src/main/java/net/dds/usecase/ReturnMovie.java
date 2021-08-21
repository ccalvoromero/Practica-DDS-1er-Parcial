package net.dds.usecase;

import net.dds.domain.CustomerRepository;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.movie.Movie;

public class ReturnMovie {

    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;

    public ReturnMovie(MovieRepository movieRepository, CustomerRepository customerRepository) {
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
    }

    public void execute(Integer movieId, Integer documentNumber, boolean movieHasIssues) {
        Movie movie = movieRepository.findRentedMovie(movieId);
        Customer customer = customerRepository.findByDocumentNumber(documentNumber);
        customer.returnMovie(movie, movieHasIssues);
        movieRepository.save(movie);
        customerRepository.save(customer);
    }

}
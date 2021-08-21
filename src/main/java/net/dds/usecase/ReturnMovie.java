package net.dds.usecase;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.CustomerRepository;
import net.dds.domain.movie.QualityChecker;

public class ReturnMovie {

    private final QualityChecker qualityStrategy;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;

    public ReturnMovie(QualityChecker issuesStrategy, MovieRepository movieRepository, CustomerRepository customerRepository) {
        this.qualityStrategy = issuesStrategy;
        this.movieRepository = movieRepository;
        this.customerRepository = customerRepository;
    }

    public void execute(Integer movieId, Integer documentNumber) {
        Movie movie = movieRepository.findRentedMovie(movieId);
        Customer customer = customerRepository.findByDocumentNumber(documentNumber);
        qualityStrategy.check(customer);
        customer.returnMovie(movie);
        movieRepository.save(movie);
        customerRepository.save(customer);
    }

}
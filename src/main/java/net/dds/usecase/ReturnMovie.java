package net.dds.usecase;

import net.dds.domain.movie.Movie;
import net.dds.domain.MovieRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.CustomerRepository;
import net.dds.domain.movie.QualityChecker;
import net.dds.domain.OperationRepository;
import net.dds.infrastructure.database.operationtype.ReturnSave;

public class ReturnMovie {

    private final QualityChecker qualityChecker;
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final OperationRepository operationRepository;

    public ReturnMovie(QualityChecker qualityChecker, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
            this.qualityChecker = qualityChecker;
            this.movieRepository = movieRepository;
            this.customerRepository = customerRepository;
            this.operationRepository = operationRepository;
    }

    public void execute(Integer physicalMovieId, Integer documentNumber) {
        Movie movie = movieRepository.findRentedMovie(physicalMovieId);
        Customer customer = customerRepository.findByDocumentNumber(documentNumber);
        qualityChecker.check(customer);
        customer.returnMovie(movie);
        movieRepository.update(movie);
        customerRepository.save(customer);
        operationRepository.save(customer, movie, new ReturnSave());
    }

}
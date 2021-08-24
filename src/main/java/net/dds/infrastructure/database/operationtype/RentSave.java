package net.dds.infrastructure.database.operationtype;

import net.dds.domain.movie.Movie;
import net.dds.domain.customer.Customer;

// insert customer_rented_movies (customer_id, physical_movie_id, rented_start_date) values (2, 1, sysdate()); -- cuando rentan
public class RentSave implements OperationType {

    @Override
    public String buildQuery(Customer customer, Movie movie) {
        String customerQuery =
                "(select customer_id from customer where document_number = " + customer.documentNumber() + ")";
        String customerPurchasedMovies = "insert customer_rented_movies (customer_id, physical_movie_id, rented_start_date) values (" + customerQuery + ", "+ movie.physicalMovieId() + ", sysdate());";
        return customerPurchasedMovies;
    }

}

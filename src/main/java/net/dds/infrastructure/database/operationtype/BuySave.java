package net.dds.infrastructure.database.operationtype;

import net.dds.domain.movie.Movie;
import net.dds.domain.customer.Customer;

// insert customer_purchased_movies (customer_id, physical_movie_id, purchase_date) values (2, 1, sysdate()); -- cuando compran la peli
// insert customer_purchased_movies (customer_id, physical_movie_id, purchase_date) values ((select customer_id from customer where document_number = 39561928), 1, sysdate());

public class BuySave implements OperationType {

    @Override
    public String buildQuery(Customer customer, Movie movie) {
        String customerQuery =
            "(select customer_id from customer where document_number = " + customer.documentNumber() + ")";
        String customerPurchasedMovies = "insert customer_purchased_movies (customer_id, physical_movie_id, purchase_date) values (" + customerQuery + ", "+ movie.physicalMovieId() + ", sysdate());";
        return customerPurchasedMovies;
    }

}
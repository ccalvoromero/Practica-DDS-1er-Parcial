package net.dds.infrastructure.database.operationtype;

import net.dds.domain.movie.Movie;
import net.dds.domain.customer.Customer;

//update customer_rented_movies set rented_end_date = sysdate() where customer_id = 2 and physical_movie_id = 1; -- cuando devuelven la peli
public class ReturnSave implements OperationType {

    @Override
    public String buildQuery(Customer customer, Movie movie) {
        String customerQuery =
                "(select customer_id from customer where document_number = " + customer.documentNumber() + ")";
        String customerPurchasedMovies = "update customer_rented_movies set rented_end_date = sysdate() where customer_id = " + customerQuery + " and physical_movie_id = "+ movie.physicalMovieId() + ";";
        return customerPurchasedMovies;
    }
}

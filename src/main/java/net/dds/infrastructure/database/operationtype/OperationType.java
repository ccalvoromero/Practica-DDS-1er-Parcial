package net.dds.infrastructure.database.operationtype;

import net.dds.domain.movie.Movie;
import net.dds.domain.customer.Customer;

public interface OperationType {
    String buildQuery(Customer customer, Movie movie);
}

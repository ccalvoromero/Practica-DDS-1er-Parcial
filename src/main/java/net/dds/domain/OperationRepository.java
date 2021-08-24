package net.dds.domain;

import net.dds.domain.customer.Customer;
import net.dds.domain.movie.Movie;
import net.dds.infrastructure.database.operationtype.OperationType;

public interface OperationRepository {
    void save(Customer customer, Movie movie, OperationType operationType);
}
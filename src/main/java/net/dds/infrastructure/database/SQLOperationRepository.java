package net.dds.infrastructure.database;

import java.sql.Connection;
import java.sql.Statement;

import net.dds.domain.movie.Movie;
import net.dds.domain.customer.Customer;
import net.dds.domain.OperationRepository;
import net.dds.infrastructure.database.connection.DatabaseConnector;
import net.dds.infrastructure.database.operationtype.OperationType;

public class SQLOperationRepository implements OperationRepository {

    private final DatabaseConnector databaseConnector;

    public SQLOperationRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public void save(Customer customer, Movie movie, OperationType operationType) {
        String query = operationType.buildQuery(customer, movie);
        Connection connection = databaseConnector.create();
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch(Exception ignored) {}
    }

}
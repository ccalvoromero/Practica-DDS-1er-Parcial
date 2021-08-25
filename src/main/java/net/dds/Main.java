package net.dds;

import net.dds.domain.CustomerRepository;
import net.dds.domain.MovieRepository;
import net.dds.domain.OperationRepository;
import net.dds.domain.customer.Customer;
import net.dds.domain.payment.Cash;
import net.dds.infrastructure.database.SQLCustomerRepository;
import net.dds.infrastructure.database.SQLMovieRepository;
import net.dds.infrastructure.database.SQLOperationRepository;
import net.dds.infrastructure.database.connection.DatabaseConnector;
import net.dds.infrastructure.database.connection.MySQLConnector;
import net.dds.usecase.BuyMovie;

public class Main {

    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new MySQLConnector();
        MovieRepository movieRepository = new SQLMovieRepository(databaseConnector);
        CustomerRepository customerRepository = new SQLCustomerRepository(databaseConnector);
        OperationRepository operationRepository = new SQLOperationRepository(databaseConnector);
        BuyMovie buyMovie = new BuyMovie(new Cash(), movieRepository, customerRepository, operationRepository);
        buyMovie.execute(1, 39561928);

    }

}
package net.dds;

import net.dds.domain.CustomerRepository;
import net.dds.domain.MovieRepository;
import net.dds.domain.OperationRepository;
import net.dds.domain.movie.GoodQuality;
import net.dds.domain.movie.QualityChecker;
import net.dds.domain.payment.Cash;
import net.dds.domain.payment.CreditCard;
import net.dds.domain.payment.PaymentMethod;
import net.dds.infrastructure.database.SQLCustomerRepository;
import net.dds.infrastructure.database.SQLMovieRepository;
import net.dds.infrastructure.database.SQLOperationRepository;
import net.dds.infrastructure.database.connection.DatabaseConnector;
import net.dds.infrastructure.database.connection.MySQLConnector;
import net.dds.usecase.BuyMovie;
import net.dds.usecase.RentMovie;
import net.dds.usecase.ReturnMovie;

public class Main {

    public static void main(String[] args) {
        DatabaseConnector databaseConnector = new MySQLConnector();
        MovieRepository movieRepository = new SQLMovieRepository(databaseConnector);
        CustomerRepository customerRepository = new SQLCustomerRepository(databaseConnector);
        OperationRepository operationRepository = new SQLOperationRepository(databaseConnector);
        PaymentMethod cash = new Cash();
        PaymentMethod creditCard = new CreditCard();
        QualityChecker qualityStrategy = new GoodQuality();

     //   buyMovie(cash, movieRepository, customerRepository, operationRepository);
     //   rentMovie(creditCard, movieRepository, customerRepository, operationRepository);
        returnMovie(qualityStrategy, movieRepository, customerRepository, operationRepository);
    }

    private static void buyMovie(PaymentMethod paymentMethod, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
            BuyMovie buyMovie = new BuyMovie(paymentMethod, movieRepository, customerRepository, operationRepository);
            buyMovie.execute(1, 39561928);
    }

    private static void rentMovie(PaymentMethod paymentMethod, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
        RentMovie rentMovie = new RentMovie(paymentMethod, movieRepository, customerRepository, operationRepository);
        rentMovie.execute(1, 10, 39561928);
    }

    private static void returnMovie(QualityChecker qualityChecker, MovieRepository movieRepository,
        CustomerRepository customerRepository, OperationRepository operationRepository) {
            ReturnMovie returnMovie = new ReturnMovie(qualityChecker, movieRepository, customerRepository, operationRepository);
            returnMovie.execute(1, 39561928);
    }

}
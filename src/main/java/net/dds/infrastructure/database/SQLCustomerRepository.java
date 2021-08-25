package net.dds.infrastructure.database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import net.dds.domain.customer.*;
import net.dds.domain.movie.Movie;
import net.dds.domain.CustomerRepository;

import net.dds.infrastructure.database.connection.DatabaseConnector;

public class SQLCustomerRepository implements CustomerRepository {

    private final DatabaseConnector databaseConnector;

    public SQLCustomerRepository(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public Customer findByDocumentNumber(Integer documentNumber){
        Customer customer = null;
        ResultSet rs;
        try {
            Connection dbConnection = databaseConnector.create();
            String customerAndRentedMovies =
                "select c.document_number, c.rented_movies_without_issues, c.movie_issues," +
                " c.customer_type_id, m.movie_id, m.physical_movie_id, m.movie_name, m.buy_price\n" +
                "from customer c\n" +
                "inner join customer_rented_movies crm on c.customer_id = crm.customer_id\n" +
                "inner join movie m on m.physical_movie_id = crm.physical_movie_id\n" +
                "where c.document_number = " + documentNumber;
            Statement stmt = dbConnection.createStatement();
            rs = stmt.executeQuery(customerAndRentedMovies);
            while (rs.next()){
                if(rs.isFirst())
                    customer = new Customer(rs.getInt(1), rs.getInt(2), rs.getInt(3), idToCustomerType(rs.getInt(4)));
                customer.addRentedMovie(new Movie(rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDouble(8)));
            }
            String purchasedMovies = "select m.movie_id, m.physical_movie_id, m.movie_name, m.buy_price\n" +
                "from customer c\n" +
                "inner join customer_purchased_movies cpm on c.customer_id = cpm.customer_id\n" +
                "inner join movie m on m.physical_movie_id = cpm.physical_movie_id\n" +
                "where c.document_number = " + documentNumber;
            stmt = dbConnection.createStatement();
            rs = stmt.executeQuery(purchasedMovies);
            while (rs.next())
                customer.addPurchasedMovies(new Movie(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4)));
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }

    @Override
    public void save(Customer customer){
        try {
            Connection dbConnection = databaseConnector.create();
            String updateCustomer =
                "UPDATE customer " +
                "SET rented_movies_without_issues = " + customer.rentedMoviesWithoutIssues() +
                ", movie_issues = " + customer.movieIssues() + ", customer_type_id = " + customerTypeToId(customer.type()) +
                " WHERE document_number = " + customer.documentNumber() + ";";
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate(updateCustomer);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private CustomerType idToCustomerType(Integer customerType){
        switch (customerType){
            case 1: return Careless.instance();
            case 2: return Regular.instance();
            case 3: return Loyal.instance();
            default: throw new RuntimeException();
        }
    }

    private Integer customerTypeToId(CustomerType customerType){
        switch (customerType.getClass().getSimpleName()){
            case "Careless": return 1;
            case "Regular": return 2;
            case "Loyal": return 3;
            default: throw new RuntimeException();
        }
    }

}
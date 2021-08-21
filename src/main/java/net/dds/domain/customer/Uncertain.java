package net.dds.domain.customer;

public class Uncertain implements CustomerType {

    private static CustomerType instance;
    private static final double membershipCoefficient = 1.05;
    private static final int minimumRentedMoviesWithoutIssues = 10;

    public static CustomerType instance() {
        if(instance == null)
            instance = new Uncertain();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.rentedMoviesWithoutIssues() >= minimumRentedMoviesWithoutIssues)
            customer.setType(Regular.instance());
    }

    @Override
    public Double customerPrice(Double rentPrice) {
        return rentPrice * membershipCoefficient;
    }

}
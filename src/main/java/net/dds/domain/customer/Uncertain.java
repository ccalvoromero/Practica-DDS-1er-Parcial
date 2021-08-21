package net.dds.domain.customer;

public class Uncertain implements CustomerState {

    private static CustomerState instance;
    private static double membershipCoefficient = 1.05;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Uncertain();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.rentedMoviesWithoutIssues() >= 10 ){
            customer.setState(Regular.instance());
        }
    }

    @Override
    public Double membershipPrice(Double rentPrice) {
        return rentPrice * membershipCoefficient;
    }

}
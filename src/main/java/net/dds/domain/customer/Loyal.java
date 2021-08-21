package net.dds.domain.customer;

public class Loyal implements CustomerType {

    private static CustomerType instance;
    private static final double membershipCoefficient = 0.85;
    private static final int maximumMovieIssues = 8;

    public static CustomerType instance() {
        if(instance == null)
            instance = new Loyal();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.movieIssues() >= maximumMovieIssues){
            customer.setType(Regular.instance());
            customer.resetMovieIssues();
        }
    }

    @Override
    public Double customerPrice(Double rentPrice) {
        return rentPrice * membershipCoefficient;
    }

}

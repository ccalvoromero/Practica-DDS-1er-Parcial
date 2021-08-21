package net.dds.domain.customer;

public class Loyal implements CustomerState {

    private static CustomerState instance;
    private static double membershipCoefficient = 0.85;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Loyal();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.issues() >= 8 ){
        customer.setState(Regular.instance());
        customer.resetIssues();
    }}

    @Override
    public Double membershipPrice(Double rentPrice) {
        return rentPrice * membershipCoefficient;
    }

}

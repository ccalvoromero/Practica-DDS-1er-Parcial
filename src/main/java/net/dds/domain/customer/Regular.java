package net.dds.domain.customer;

public class Regular implements CustomerState {

    private static CustomerState instance;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Regular();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        if(customer.issues() >= 5 ){
            customer.setState(Uncertain.instance());
            customer.resetIssues();
        }
        else if(customer.rentedMoviesWithoutIssues() >= 20 && customer.totalPurchasedMovies() >= 5)
            customer.setState(Loyal.instance());
    }

    @Override
    public Double membershipPrice(Double rentPrice) {
        return rentPrice;
    }

}
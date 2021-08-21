package net.dds.domain.customer;

public class Uncertain implements CustomerState {

    private static CustomerState instance;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Uncertain();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        customer.setState(Regular.instance());
    }

}
package net.dds.domain.client;

public class Loyal implements CustomerState {

    private static CustomerState instance;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Loyal();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        customer.setState(Uncertain.instance());
    }

}

package net.dds.domain.client;

public class Regular implements CustomerState {

    private static CustomerState instance;

    public static CustomerState instance() {
        if(instance == null)
            instance = new Regular();
        return instance;
    }

    @Override
    public void change(Customer customer) {
        customer.setState(Loyal.instance()); //TODO Uncertain o Loyal
    }

}
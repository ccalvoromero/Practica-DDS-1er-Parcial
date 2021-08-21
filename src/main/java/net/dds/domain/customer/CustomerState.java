package net.dds.domain.customer;

public interface CustomerState { // Hay que aniadir instance?
    void change(Customer customer);

    Double membershipPrice(Double rentPrice);
}

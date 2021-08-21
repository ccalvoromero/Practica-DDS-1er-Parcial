package net.dds.domain.customer;

public interface CustomerType {
    void change(Customer customer);
    Double customerPrice(Double rentPrice);
}

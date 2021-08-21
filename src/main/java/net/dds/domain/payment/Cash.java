package net.dds.domain.payment;

public class Cash implements PaymentMethod {

    private static final Double discount = 0.05;

    @Override
    public void pay(Double amount) {
        System.out.println("Final price: " + amount * -discount);
    }

}
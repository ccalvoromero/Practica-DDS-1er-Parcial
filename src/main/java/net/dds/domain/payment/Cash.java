package net.dds.domain.payment;

public class Cash implements PaymentMethod {

    private static final Double discount = 0.95;

    @Override
    public void pay(Double amount) {
        System.out.println("Cash pay successfully. Amount: " + amount * discount);
    }

}
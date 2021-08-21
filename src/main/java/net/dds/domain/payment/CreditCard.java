package net.dds.domain.payment;

public class CreditCard implements PaymentMethod {

    private static final Double charge = 1.1;

    @Override
    public void pay(Double price) {
        System.out.println("Final price: " + price * charge);
    }

}

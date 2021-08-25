package net.dds.domain.payment;

public class CreditCard implements PaymentMethod {

    private static final Double charge = 1.1;

    @Override
    public void pay(Double amount) {
        System.out.println("Credit card pay successfully. Amount: " + amount * charge);
    }

}

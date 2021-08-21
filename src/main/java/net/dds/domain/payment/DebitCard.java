package net.dds.domain.payment;

public class DebitCard implements PaymentMethod {

    @Override
    public void pay(Double amount) {
        System.out.println("Final price: " + amount);
    }

}
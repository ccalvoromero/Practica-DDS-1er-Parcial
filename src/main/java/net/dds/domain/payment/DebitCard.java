package net.dds.domain.payment;

public class DebitCard implements PaymentMethod {

    @Override
    public void pay(Double price) {
        System.out.println("Final price: " + price);
    }

}
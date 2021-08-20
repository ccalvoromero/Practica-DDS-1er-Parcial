package net.dds.dominio;

public class CreditCard implements PaymentMethod{

    @Override
    public void pay(Double price) {
        System.out.println("Final price: " + price * 1.1);
    }
}

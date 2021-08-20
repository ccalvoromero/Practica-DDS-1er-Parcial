package net.dds.dominio;

public class DebitCard implements PaymentMethod{
    @Override
    public void pay(Double price) {
        System.out.println("Final price: " + price);
    }
}

package net.dds.dominio;

public class Cash implements PaymentMethod{
    @Override
    public void pay(Double price) {
        System.out.println("Final price: " + price * (-0.05));
    }
}

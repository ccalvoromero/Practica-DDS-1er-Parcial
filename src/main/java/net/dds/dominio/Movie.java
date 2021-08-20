package net.dds.dominio;

public class Movie {
    private final String name;
    private final Double price;
    private State state;

    public Movie(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double rentPrice(Integer days){
        return price * 0.05  * days;
    }

    public Double buyPrice(){
        return price;
    }
}

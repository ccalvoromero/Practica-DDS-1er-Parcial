package net.dds.domain.movie;

import static net.dds.domain.movie.MovieState.*;

public class Movie {

    private final Integer id;
    private final String name;
    private final Double buyPrice;
    private MovieState state = AVAILABLE;
    private static final Double rentalCoefficient = 0.05;

    public Movie(Integer id, String name, Double buyPrice) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
    }

    public Integer id() {
        return this.id;
    }

    public Double buyPrice(){
        return this.buyPrice;
    }

    public MovieState state() {
        return this.state;
    }

    public Double rentPrice(Integer days){
        return buyPrice * rentalCoefficient * days;
    }

    public void rented() {
        this.state = RENTED;
    }

    public void sold() {
        this.state = SOLD;
    }

    public void returned() {
        this.state = AVAILABLE;
    }

}
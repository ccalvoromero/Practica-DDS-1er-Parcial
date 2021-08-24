package net.dds.domain.movie;

import net.dds.domain.pack.MovieComponent;

import static net.dds.domain.movie.MovieState.*;

public class Movie implements MovieComponent {

    private final Integer movieId;
    private final Integer physicalMovieId;
    private final String name;
    private final Double buyPrice;
    private MovieState state = AVAILABLE;
    private static final Double rentalCoefficient = 0.05;

    public Movie(Integer id, Integer physicalMovieId, String name, Double buyPrice) {
        this.movieId = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.physicalMovieId = physicalMovieId;
    }

    public Integer id() {
        return this.movieId;
    }

    public String name() {
        return this.name;
    }

    public Double buyPrice() {
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

    public Integer physicalMovieId() {
        return this.physicalMovieId;
    }

}
package net.dds.domain.movie;

public class Movie {

    private final Integer id;
    private final String name;
    private final Double buyPrice;
    private MovieState state;

    private static final Double rentalCoefficient = 0.05;

    public Movie(Integer id, String name, Double buyPrice) {
        this.id = id;
        this.name = name;
        this.buyPrice = buyPrice;
        this.state = MovieState.AVAILABLE;
    }

    public Double rentPrice(Integer days){
        return buyPrice * rentalCoefficient * days;
    }

    public Double buyPrice(){
        return buyPrice;
    }

    public void rent() {
        this.state = MovieState.RENTED;
    }

    public boolean equalsId(Integer id) {
        return this.id.equals(id);
    }

    public boolean isAvailable() {
        return this.state == MovieState.AVAILABLE;
    }

}
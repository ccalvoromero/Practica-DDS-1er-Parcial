package net.dds.infrastructure.database.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
public class JpaMovie {

    @Id
    @Column(name = "physical_movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "buy_price")
    private Double buyPrice;

    @Column(name = "movie_state_id")
    private Integer movieStateID;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
    private List<CustomerRentedMovies> rentedMovies;

    public Long movieId() {
        return movieId;
    }

    public String movieName() {
        return movieName;
    }

    public Double buyPrice() {
        return buyPrice;
    }
}

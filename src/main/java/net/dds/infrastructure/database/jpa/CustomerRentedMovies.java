package net.dds.infrastructure.database.jpa;

import net.dds.domain.customer.Customer;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
public class CustomerRentedMovies {

    @Id
    @Column(name = "customer_id")
    @JoinColumn(name = "customer_id__rented_fk", nullable = false, updatable = false)
    private Long customerId;

    @Id
    @Column(name = "physical_movie_id")
    @JoinColumn(name = "physical_movie_id_rented_fk", nullable = false, updatable = false)
    private Long physicalMovieId;

    @Column(name = "rented_start_date")
    private LocalDateTime rentedStartDate;

    @Column(name = "rented_end_date")
    private LocalDateTime rentedEndDate;


}
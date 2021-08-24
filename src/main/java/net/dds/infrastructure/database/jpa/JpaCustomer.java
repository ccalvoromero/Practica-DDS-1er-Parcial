package net.dds.infrastructure.database.jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Customer")
public class JpaCustomer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_number", nullable = false)
    private Long documentNumber;

    @Column(name = "rented_movies_without_issues")
    private Integer rentedMoviesWithoutIssues;

    @Column(name = "movie_issues")
    private Integer movieIssues;

    @Column(name = "customer_type_id")
    private Integer customerTypeId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<CustomerRentedMovies> rentedMovies;


}

/*

create table Customer(
	customer_id integer auto_increment primary key,
	document_number bigint not null,
    rented_movies_without_issues integer,
    movie_issues integer,
    customer_type_id integer,
    constraint customer_type_id_fk foreign key (customer_type_id) references customer_types(customer_type_id)
);


 */
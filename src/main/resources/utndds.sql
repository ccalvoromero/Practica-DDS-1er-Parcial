create database utndds;
use utndds;

create table Customer_Types(
    customer_type_id integer auto_increment primary key,
    description_type varchar(20) not null
);

create table Customer(
    customer_id integer auto_increment primary key,
    document_number bigint not null,
    rented_movies_without_issues integer,
    movie_issues integer,
    customer_type_id integer,
    constraint customer_type_id_fk foreign key (customer_type_id) references customer_types(customer_type_id)
);

create table Movie_States(
    movie_state_id integer auto_increment primary key,
    description_type varchar(20) not null
);

create table Movie(
    physical_movie_id integer auto_increment primary key,
    movie_id bigint not null,
    movie_name varchar(50),
    buy_price double,
    movie_state_id integer,
    constraint movie_state_id_fk foreign key (movie_state_id) references movie_states(movie_state_id)
);

create table customer_rented_movies(
    customer_id integer,
    physical_movie_id integer,
    rented_start_date datetime,
    rented_end_date datetime,
    constraint customer_id_rented_fk foreign key (customer_id) references customer(customer_id),
    constraint physical_movie_id_rented_fk foreign key (physical_movie_id) references movie(physical_movie_id)
);

create table customer_purchased_movies(
    customer_id integer,
    physical_movie_id integer,
    purchase_date datetime,
    constraint customer_id_purchased_fk foreign key (customer_id) references customer(customer_id),
    constraint physical_movie_id_purchased_fk foreign key (physical_movie_id) references movie(physical_movie_id)
);
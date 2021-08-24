package net.dds;


import net.dds.domain.MovieRepository;
import net.dds.domain.movie.Movie;
import net.dds.infrastructure.database.SQLMovieRepository;

public class Main {

    public static void main(String[] args) {
        MovieRepository movieRepository = new SQLMovieRepository();
        Movie movie = movieRepository.findAvailableMovie(1);
    }

}
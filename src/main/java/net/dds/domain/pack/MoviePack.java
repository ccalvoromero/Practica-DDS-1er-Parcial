package net.dds.domain.pack;

import java.util.List;
import java.util.ArrayList;

public class MoviePack implements MovieComponent {

    private final List<MovieComponent> movies = new ArrayList<>();

    @Override
    public Double buyPrice() {
        return movies.stream()
            .mapToDouble(MovieComponent::buyPrice)
            .sum();
    }

    public void addMovieComponent(MovieComponent movieComponent) {
        movies.add(movieComponent);
    }

    public void removeMovieComponent(MovieComponent movieComponent) {
        movies.remove(movieComponent);
    }

}
package net.dds;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static java.util.stream.Collectors.*;

public enum Genre {
    ONE_GENRE, OTHER_GENRE, LAST_GENRE
}

class Book {

    private Genre genre;

    public boolean matchGenre(Genre genre) {
        return this.genre.equals(genre);
    }

}

class FilterClass {

    private final List<Book> books = new ArrayList<>();
    private final List<List<Book>> allBooks = new ArrayList<>();

    public void booksByGenre() {
        List<Genre> allGenres = Arrays.asList(Genre.values());
        allGenres.forEach(genre -> {
            List<Book> booksByGenre = books.stream()
                .filter(book -> book.matchGenre(genre))
                .collect(toList());
            allBooks.add(booksByGenre);
        });

    }

}
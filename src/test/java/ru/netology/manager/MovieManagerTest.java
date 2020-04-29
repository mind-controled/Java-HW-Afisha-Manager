package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MovieManagerTest {
    private MovieManager manager = new MovieManager();
    private Movie movieToAdd = new Movie(29, "Star Wars Ep.29", "action/sci-fi");
    private Movie[] expected;

    @BeforeEach
    void setUp() {
        manager.addMovie(movieToAdd);
        expected = new Movie[] {
                new Movie(29, "Star Wars Ep.29", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi"),
                new Movie(9, "Star Wars Ep.9", "action/sci-fi"),
                new Movie(8, "Star Wars Ep.8", "action/sci-fi"),
                new Movie(7, "Star Wars Ep.7", "action/sci-fi"),
                new Movie(6, "Star Wars Ep.6", "action/sci-fi")
        };
    }

    @Test
    public void shouldGetMovieNegative() {
        Movie[] actual = manager.getLimited(-25);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesMoreThanAll() {
        Movie[] actual = manager.getLimited(100);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesPositive() {
        Movie[] actual = manager.getLimited(6);
        Movie[] expected = {
                new Movie(29, "Star Wars Ep.29", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetMoviesAboveMax() {
        Movie[] actual = manager.getLimited(11);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetAll() {
        Movie[] actual = manager.getAll();
        Movie[] expected = {
                new Movie(29, "Star Wars Ep.29", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi"),
                new Movie(9, "Star Wars Ep.9", "action/sci-fi"),
                new Movie(8, "Star Wars Ep.8", "action/sci-fi"),
                new Movie(7, "Star Wars Ep.7", "action/sci-fi"),
                new Movie(6, "Star Wars Ep.6", "action/sci-fi"),
                new Movie(5, "Star Wars Ep.5", "action/sci-fi"),
                new Movie(4, "Star Wars Ep.4", "action/sci-fi"),
                new Movie(3, "Star Wars Ep.3", "action/sci-fi"),
                new Movie(2, "Star Wars Ep.2", "action/sci-fi"),
                new Movie(1, "Star Wars Ep.1", "action/sci-fi")
        };
        assertArrayEquals(expected, actual);
    }
}
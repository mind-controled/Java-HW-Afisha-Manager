package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRepositoryTest {
    private MovieRepository repository = new MovieRepository();
    private Movie movieToAdd = new Movie(29, "Star Wars Ep.29", "action/sci-fi");

    @BeforeEach
    void setUp() {
        repository.save(movieToAdd);
    }

    @Test
    void findAll() {
        Movie[] actual = repository.findAll();
        Movie[] expected = {
                new Movie(1, "Star Wars Ep.1", "action/sci-fi"),
                new Movie(2, "Star Wars Ep.2", "action/sci-fi"),
                new Movie(3, "Star Wars Ep.3", "action/sci-fi"),
                new Movie(4, "Star Wars Ep.4", "action/sci-fi"),
                new Movie(5, "Star Wars Ep.5", "action/sci-fi"),
                new Movie(6, "Star Wars Ep.6", "action/sci-fi"),
                new Movie(7, "Star Wars Ep.7", "action/sci-fi"),
                new Movie(8, "Star Wars Ep.8", "action/sci-fi"),
                new Movie(9, "Star Wars Ep.9", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(29, "Star Wars Ep.29", "action/sci-fi")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void save() {
        Movie movieToAdd = new Movie(30, "Star Wars Ep.30", "action/sci-fi");
        repository.save(movieToAdd);
        Movie[] actual = repository.findAll();
        Movie[] expected = {
                new Movie(1, "Star Wars Ep.1", "action/sci-fi"),
                new Movie(2, "Star Wars Ep.2", "action/sci-fi"),
                new Movie(3, "Star Wars Ep.3", "action/sci-fi"),
                new Movie(4, "Star Wars Ep.4", "action/sci-fi"),
                new Movie(5, "Star Wars Ep.5", "action/sci-fi"),
                new Movie(6, "Star Wars Ep.6", "action/sci-fi"),
                new Movie(7, "Star Wars Ep.7", "action/sci-fi"),
                new Movie(8, "Star Wars Ep.8", "action/sci-fi"),
                new Movie(9, "Star Wars Ep.9", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(29, "Star Wars Ep.29", "action/sci-fi"),
                new Movie(30, "Star Wars Ep.30", "action/sci-fi")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void findById() {
        Movie actual = repository.findById(29);
        Movie expected = new Movie(29, "Star Wars Ep.29", "action/sci-fi");
        assertEquals(expected, actual);
    }

    @Test
    void removeById() {
        repository.removeById(1);
        Movie[] actual = repository.findAll();
        Movie[] expected = {
                new Movie(2, "Star Wars Ep.2", "action/sci-fi"),
                new Movie(3, "Star Wars Ep.3", "action/sci-fi"),
                new Movie(4, "Star Wars Ep.4", "action/sci-fi"),
                new Movie(5, "Star Wars Ep.5", "action/sci-fi"),
                new Movie(6, "Star Wars Ep.6", "action/sci-fi"),
                new Movie(7, "Star Wars Ep.7", "action/sci-fi"),
                new Movie(8, "Star Wars Ep.8", "action/sci-fi"),
                new Movie(9, "Star Wars Ep.9", "action/sci-fi"),
                new Movie(10, "Star Wars Ep.10", "action/sci-fi"),
                new Movie(11, "Star Wars Ep.11", "action/sci-fi"),
                new Movie(12, "Star Wars Ep.12", "action/sci-fi"),
                new Movie(13, "Star Wars Ep.13", "action/sci-fi"),
                new Movie(14, "Star Wars Ep.14", "action/sci-fi"),
                new Movie(29, "Star Wars Ep.29", "action/sci-fi")
        };
        assertArrayEquals(expected, actual);
    }

    @Test
    void removeByIdThatNotExist() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> repository.removeById(6666) );
    }

    @Test
    void removeAll() {
        repository.removeAll();
        Movie[] expected = {};
        Movie[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }
}
package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = {
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
            new Movie(14, "Star Wars Ep.14", "action/sci-fi")
    };

    public Movie[] findAll() {
        return movies;
    }

    public void save(Movie movie) {
        Movie[] tmpArray = new Movie[movies.length + 1];
        System.arraycopy(movies, 0, tmpArray, 0, movies.length);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = movie;
        movies = tmpArray;
    }

    public Movie findById(int id) {
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        return null;
    }

    void removeById(int id) {
        int length = movies.length - 1;
        Movie[] tmpArray = new Movie[length];
        int i = 0;
        for (Movie movie : movies) {
            if (movie.getId() != id) {
                tmpArray[i] = movie;
                i++;
            }
        }
        movies = tmpArray;
    }

    void removeAll() {
        movies = new Movie[0];
    }
}
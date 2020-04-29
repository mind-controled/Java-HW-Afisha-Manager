package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    Movie[] movies = {
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

    public void addMovie(Movie movie) {
        int moviesLength = movies.length;
        Movie[] tmpArray = new Movie[moviesLength + 1];
        System.arraycopy(movies, 0, tmpArray, 0, moviesLength);
        int lastIndex = tmpArray.length - 1;
        tmpArray[lastIndex] = movie;
        movies = tmpArray;
    }

    public Movie[] getLimited(int numberOfMoviesToShow) {
        int moviesLength = movies.length;
        int feedMax = 10;
        if (numberOfMoviesToShow <= 0 || numberOfMoviesToShow > feedMax) {
            numberOfMoviesToShow = feedMax;
        }
        if (feedMax > moviesLength) {
            feedMax = moviesLength;
        }
        if (numberOfMoviesToShow <= feedMax) {
            feedMax = numberOfMoviesToShow;
        } else {
            feedMax = moviesLength;
        }
        Movie[] customMovie = new Movie[feedMax];
        for (int current = 0; current < customMovie.length; current++) {
            int result = moviesLength - current - 1;
            customMovie[current] = movies[result];
        }
        return customMovie;
    }
}
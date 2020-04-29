package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MovieManager {
    private MovieRepository repository = new MovieRepository();

    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getLimited(int numberOfMoviesToShow) {
        Movie[] movies = repository.findAll();
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

    public Movie[] getAll(){
        Movie[] movies = repository.findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
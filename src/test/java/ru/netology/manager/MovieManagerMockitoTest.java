package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieManagerMockitoTest {
    @Mock
    private MovieRepository repository;
    @InjectMocks
    private MovieManager manager;
    Movie first = new Movie(333, "SW333", "Mockito");
    Movie second = new Movie(444, "SW444", "Mockito");
    Movie third = new Movie(555, "SW555", "Mockito");

    @Test
    void addMovieWithMock() {
        Movie[] returned = new Movie[]{first, second, third};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(third);
        manager.addMovie(third);
        Movie[] expected = new Movie[]{third, second, first};
        Movie[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }
}
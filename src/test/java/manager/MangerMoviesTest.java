package manager;

import domain.Movies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MangerMoviesTest {
    private MoviesManager manager = new MoviesManager();
    public Movies first = new Movies(1, "Бладшот", "Боевик");
    public Movies second = new Movies(2, "Вперёд", "Мультфильм");
    public Movies third = new Movies(3, "Джентльмены", "Боевик");
    public Movies fourth = new Movies(4, "Человек-Невидимка", "Ужасы");
    public Movies fifth = new Movies(5, "Тролли", "Мультфильм");

    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void addMoviesEmpty() {
        manager.add(first);
        Movies[] expected = new Movies[]{first};
        Movies[] actual = manager.getAllMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addMoviesToExisting() {
        manager.add(first);
        Movies[] expected = new Movies[]{first};
        Movies[] actual = manager.getAllMovies();
        assertArrayEquals(expected, actual);

        manager.add(second);
        Movies[] expectedAdd = new Movies[]{second, first};
        Movies[] actualAdd = manager.getAllMovies();
        assertArrayEquals(expectedAdd, actualAdd);
    }

    @Test
    public void moviesFind() {
        setUp();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        Movies[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void MoviesMinFind() {
        manager = new MoviesManager(3);
        setUp();
        Movies[] expected = new Movies[]{fifth, fourth, third};
        Movies[] actual = manager.getMovies();
        assertArrayEquals(expected, actual);
    }
}

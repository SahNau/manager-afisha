package manager;

import domain.Movies;
import domain.PurchaseItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MangerMovies {
    private MoviesManager manager = new MoviesManager();
    public Movies first = new Movies("Бладшот", 1, "Боевик");
    public Movies second = new Movies("Вперёд", 2, "Мультфильм");
    public Movies third = new Movies("Джентльмены", 3, "Боевик");
    public Movies fourth = new Movies("Человек-Невидимка", 4, "Ужасы");
    public Movies fifth = new Movies("Тролли", 5, "Мультфильм");

    @BeforeEach
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
        Movies[] actual = manager.getAllMovies();
        Movies[] expected = new Movies[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void addMoviesToExisting() {
        manager.add(first);
        Movies[] actual = manager.getAllMovies();
        Movies[] expected = new Movies[]{first};
        assertArrayEquals(expected, actual);

        manager.add(second);
        Movies[] actualAdd = manager.getAllMovies();
        Movies[] expectedAdd = new Movies[]{second, first};
        assertArrayEquals(expectedAdd, actualAdd);
    }

    @Test
    public void moviesFind() {
        setUp();
        Movies[] actual = manager.getMovies();
        Movies[] expected = new Movies[]{fifth, fourth, third, second, first};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void MoviesMinFind() {
        manager = new MoviesManager(4);
        setUp();
        Movies[] actual = manager.getMovies();
        Movies[] expected = new Movies[]{fifth, fourth};
        assertArrayEquals(expected, actual);
    }


}

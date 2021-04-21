package manager;

import domain.Movies;

public class MoviesManager {
    public Movies[] movies = new Movies[0];
    private int findСount = 10;

    public MoviesManager(int findСount) {
        this.findСount = findСount;
    }

    public MoviesManager() {
    }

    public void add(Movies movie) {
        int lenght = movies.length + 1;
        Movies[] tmp = new Movies[lenght];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Movies[] getAllMovies() {
        Movies[] result = new Movies[movies.length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movies[] getMovies() {
        int find = this.findСount;
        if (find > movies.length)
            find = movies.length;
        Movies[] result = new Movies[find];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}

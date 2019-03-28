package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Movie;

import java.util.List;

public interface MovieDAO {
    Movie save(Movie movie);

    Movie update(Movie movie);

    Movie delete(Movie movie);

    void delete_all_movies();

    Movie findByMovieId(int movieId);

    List<Movie> getAllMovies();
}

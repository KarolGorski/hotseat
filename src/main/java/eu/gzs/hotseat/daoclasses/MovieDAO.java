package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Movie;

import java.util.List;

public interface MovieDAO {
    void save(Movie movie);

    void update(Movie movie);

    void delete(Movie movie);

    void delete_all_movies();

    Movie findByMovieId(int movieId);

    List<Movie> getAllMovies();
}

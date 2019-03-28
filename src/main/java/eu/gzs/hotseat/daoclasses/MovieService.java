package eu.gzs.hotseat.daoclasses;

import eu.gzs.hotseat.model.Movie;

import java.util.List;

public class MovieService {
    private static MovieDAOImpl movieDaoImpl;

    public MovieService() {
        movieDaoImpl=new MovieDAOImpl();
    }

    public void save(Movie movie){
        movieDaoImpl.openCurrentSessionwithTransaction();
        movieDaoImpl.save(movie);
        movieDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void update(Movie movie){
        movieDaoImpl.openCurrentSessionwithTransaction();
        movieDaoImpl.update(movie);
        movieDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void delete(Movie movie){
        movieDaoImpl.openCurrentSessionwithTransaction();
        movieDaoImpl.delete(movie);
        movieDaoImpl.closeCurrentSessionwithTransaction();
    }

    public void delete_all(){
        movieDaoImpl.openCurrentSessionwithTransaction();
        movieDaoImpl.delete_all_movies();
        movieDaoImpl.closeCurrentSessionwithTransaction();
    }

    public Movie findByMovieId(int movieId){
        movieDaoImpl.openCurrentSessionwithTransaction();
        Movie movie=movieDaoImpl.findByMovieId(movieId);
        movieDaoImpl.closeCurrentSessionwithTransaction();
        return movie;
    }

    public List<Movie> getAllMovies(){
        movieDaoImpl.openCurrentSessionwithTransaction();
        List<Movie> movies=movieDaoImpl.getAllMovies();
        movieDaoImpl.closeCurrentSessionwithTransaction();
        return movies;
    }
}

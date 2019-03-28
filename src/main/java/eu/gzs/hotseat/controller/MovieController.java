package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.MovieService;
import eu.gzs.hotseat.model.Movie;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/movies"})
public class MovieController {
    private MovieService movieService = new MovieService();

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping(path = {"/{id}"})
    public Movie findByMovieId(@PathVariable int id){
        return movieService.findByMovieId(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie){
        return movieService.save(movie);

    }

    @PutMapping(value="/{id}")
    public Movie update(@PathVariable("id") int id,
                       @RequestBody Movie movie){
        Movie movie_temp=findByMovieId(id);
        movie_temp.setName(movie.getName());
        movie_temp.setDuration(movie.getDuration());
        return movieService.update(movie_temp);

    }

    @DeleteMapping(value = "/{id}")
    public Movie delete(@PathVariable("id") int id){
        return movieService.delete(findByMovieId(id));
    }

}
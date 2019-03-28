package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.MovieService;
import eu.gzs.hotseat.model.Movie;
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
    public void create(@RequestBody Movie contact){
        movieService.save(contact);
    }

    @PutMapping(value="/{id}")
    public void update(@PathVariable("id") int id,
                       @RequestBody Movie movie){
        movieService.update(movie);
    }

}
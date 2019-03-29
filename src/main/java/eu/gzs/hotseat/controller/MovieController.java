package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.MovieService;
import eu.gzs.hotseat.model.Movie;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/movies"})
public class MovieController implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Autowired
    MovieService movieService;
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

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
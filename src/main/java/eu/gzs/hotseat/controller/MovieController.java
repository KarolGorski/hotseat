package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.daoclasses.MovieDAO;
import eu.gzs.hotseat.daoclasses.MovieDAOImpl;
import eu.gzs.hotseat.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping({"/movies"})
public class MovieController {
    /*private MovieRepository repository;

    MovieController(MovieRepository movieRepository){
        this.repository = movieRepository;
    }

    @GetMapping
    public List<Movie> getHello() {
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Movie> findById(@PathVariable int id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie create(@RequestBody Movie contact){
        return repository.save(contact);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Movie> update(@PathVariable("id") int id,
                                        @RequestBody Movie movie){
        return repository.findById(id)
                .map(record -> {
                    record.setName(movie.getName());
                    record.setDuration(movie.getDuration());
                    Movie updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }
*/


private MovieDAO movieDAO = new MovieDAOImpl();


    public void setMovieDAO(MovieDAO md){
    this.movieDAO = md;
}

    @RequestMapping({"/movies"})
    public List<Movie> getAllMovies(MovieDAOImpl movie){
        return movie.getAllMovies();
    }


    @GetMapping(path = {"/movies/{id}"})
    public String findById(@PathVariable int id){
       return this.movieDAO.findByMovieId(id).getName() + " " + movieDAO.findByMovieId(id).getDuration();
    }

    @PutMapping(path="/movies/{id}")
    public void update(MovieDAOImpl movie){

    }
}

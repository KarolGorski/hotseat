package eu.gzs.hotseat.controller;

import eu.gzs.hotseat.model.Movie;
import eu.gzs.hotseat.Repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/movies"})
public class MovieController {
    private MovieRepository repository;

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


}

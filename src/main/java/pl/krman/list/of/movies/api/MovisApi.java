package pl.krman.list.of.movies.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.krman.list.of.movies.dao.entity.Movie;
import pl.krman.list.of.movies.manager.MovieManager;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovisApi {

    private MovieManager movieManager;

    @Autowired
    public MovisApi(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    @GetMapping("/all")
    public Iterable<Movie> getAll(){
        return movieManager.findAll();
    }

    @GetMapping
    public Optional<Movie> getById(@RequestParam Long index) {
        return movieManager.findById(index);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieManager.save(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie){
        return movieManager.save(movie);
    }

    @DeleteMapping
    public void deleteMovie(@RequestParam Long index){
        movieManager.deleteById(index);
    }

}

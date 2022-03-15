package pl.krman.list.of.movies;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovisApi {

    private List<Movie> movieList;

    public MovisApi() {
        movieList = new ArrayList<>();
        movieList.add(new Movie(1l,"Titanik","dramat","Lukas", LocalDate.of(2009,1,1)));
        movieList.add(new Movie(2l,"twierdza","sensacyjny","Frank Darabont", LocalDate.of(2007,2,25)));
    }

    @GetMapping("/all")
    public List<Movie> getAll(){
        return movieList;
    }

    @GetMapping
    public Movie getById(@RequestParam int index) {
        Optional<Movie> first = movieList.stream().filter(element -> element.getId() == index).findFirst();
        return first.get();
    }

    @PostMapping
    public boolean addMovie(@RequestBody Movie movie){
        return movieList.add(movie);
    }

    @PutMapping
    public boolean updateMovie(@RequestBody Movie movie){
        return movieList.add(movie);
    }

    @DeleteMapping
    public boolean deleteMovie(@RequestParam int index){
        return movieList.removeIf(element -> element.getId() == index);
    }

}

package pl.krman.list.of.movies.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.krman.list.of.movies.dao.MovieRepo;
import pl.krman.list.of.movies.dao.entity.Movie;
import java.util.List;
import java.util.Optional;

@Service
public final class MovieManager {

    private MovieRepo movieRepo;

    @Autowired
    public MovieManager(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public MovieManager() {
    }

    public Optional <Movie> findById(Long id){
        return movieRepo.findById(id);
    }

    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    public List<Movie> findAll(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return movieRepo.findAll();
        } else {
            return movieRepo.search(filterText);
        }
    }

    public Movie save (Movie movie){
        return movieRepo.save(movie);
    }

    public void deleteById (Long id){
        movieRepo.deleteById(id);
    }



}

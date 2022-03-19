package pl.krman.list.of.movies.manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.krman.list.of.movies.dao.MovieRepo;
import pl.krman.list.of.movies.dao.entity.Movie;
import java.time.LocalDate;
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

    public Iterable<Movie> findAll() {
        return movieRepo.findAll();
    }

    public Movie save (Movie movie){
        return movieRepo.save(movie);
    }

    public void deleteById (Long id){
        movieRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Movie(1l,"Titanik","dramat","Lukas",LocalDate.of(2009,1,1)));
        save(new Movie(2l,"twierdza","sensacyjny","Frank Darabont", LocalDate.of(2007,2,25)));
    }

}

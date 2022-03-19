package pl.krman.list.of.movies.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krman.list.of.movies.dao.entity.Movie;


@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {
}

package pl.krman.list.of.movies.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.krman.list.of.movies.dao.entity.Movie;

import java.util.List;


@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m" +
            "where lower(m.genre) like lower(concat('%', :searchTerm, '%'))")
        List<Movie> search(@Param("searchTerm") String searchTerm);

}

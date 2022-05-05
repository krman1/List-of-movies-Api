package pl.krman.list.of.movies.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.krman.list.of.movies.dao.entity.Movie;
import java.util.List;


@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Query("Select m from Movie m " +
            "WHERE m.genre like CONCAT('%', :searchTerm, '%')" +
            "OR m.title like CONCAT('%', :searchTerm, '%')" +
            "OR m.director like CONCAT('%', :searchTerm, '%')" +
            "OR m.productionYear like CONCAT('%', :searchTerm, '%')")
        List<Movie> search(@Param("searchTerm") String searchTerm);

}

package movies.example.movies.movies;

import movies.example.movies.directors.directors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface moviesRepository extends JpaRepository<movies,Long>{
    @Query("SELECT s FROM movies s where s.id=?1")
    Optional <movies> findmoviebyid(long id);
}

package movies.example.movies.stars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface starsRepository extends JpaRepository<stars,Long>{
    @Query("SELECT s FROM stars s where s.person_id=?1")
    List<stars> findStarsById(Long id);

    @Query("SELECT s FROM stars s where s.movie_id=?1")
    List<stars> findMoviesID(Long id);
   }

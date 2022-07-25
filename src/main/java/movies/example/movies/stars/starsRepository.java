package movies.example.movies.stars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface starsRepository extends JpaRepository<stars,Long>{
    @Query("SELECT s FROM stars s where s.id=?1")
    Optional<stars> findStarsById(Long id);
}

package movies.example.movies.ratings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ratingRepository extends JpaRepository<ratings,Long> {
    @Query("SELECT s FROM ratings s where s.id=?1")
    Optional<ratings> findRatingById(Long id);

}

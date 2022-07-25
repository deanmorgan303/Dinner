package movies.example.movies.directors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface directorsRepository extends JpaRepository<directors,Long>{
    @Query("SELECT s FROM directors s where person_id=?1")
    Optional <directors> findDirectorbyId(Long id);


}

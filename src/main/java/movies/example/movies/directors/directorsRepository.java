package movies.example.movies.directors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface directorsRepository extends JpaRepository<directors,Long>{
    @Query("SELECT s FROM directors s where s.person_id=?1")
    List <directors> findDirectorbyId(Long id);

    @Query("SELECT s FROM directors s where s.movie_id=?1")
    List<directors> findMovieId(long id);


}

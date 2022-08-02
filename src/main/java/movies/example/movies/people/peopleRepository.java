package movies.example.movies.people;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface peopleRepository  extends  JpaRepository<people,Long>{
   @Query("SELECT s FROM people s where s.id=?1")
    Optional<people> findPeopleById(Long Id);

   @Query("SELECT count(s)>0 FROM people s where s.name=?1")
    boolean existByName(String Name);

   @Query("SELECT s FROM people s where s.name=?1")
    Optional<people> findPeopleByName(String Name);
}

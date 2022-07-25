package movies.example.movies.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface usersRepository extends JpaRepository<users,Long>{
     @Query("SELECT s FROM s user where s.id=?1")
     Optional<users> findUserById(Long id);

}

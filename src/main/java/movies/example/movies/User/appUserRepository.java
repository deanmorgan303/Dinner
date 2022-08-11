package movies.example.movies.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface appUserRepository extends JpaRepository<AppUser,Long> {

    //@Query("SELECT s FROM AppUser s WHERE s.username=?1 ")
    AppUser findByUsername(String Username);
    //AppUser findById(Long Id);
}

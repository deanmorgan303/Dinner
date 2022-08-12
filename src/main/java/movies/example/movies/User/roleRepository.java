package movies.example.movies.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface roleRepository extends JpaRepository<Role,Long> {
    List<Role> findByName(String name);
}

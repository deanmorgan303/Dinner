package movies.example.movies.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface roleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name);
}

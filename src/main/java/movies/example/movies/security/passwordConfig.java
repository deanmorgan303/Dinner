package movies.example.movies.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration

public class passwordConfig {
@Bean
    PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
}

}

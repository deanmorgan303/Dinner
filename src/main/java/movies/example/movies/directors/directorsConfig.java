package movies.example.movies.directors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class directorsConfig {
    @Bean
    CommandLineRunner commandLineRunner (directorsRepository repository){
        return args->{
            repository.findAll();
        };
    }
}

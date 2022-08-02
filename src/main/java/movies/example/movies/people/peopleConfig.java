package movies.example.movies.people;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class peopleConfig {
    @Bean
    CommandLineRunner peopleCommandLineRunner (peopleRepository repository){
        return args->{
            repository.findAll();
        };
    }

}

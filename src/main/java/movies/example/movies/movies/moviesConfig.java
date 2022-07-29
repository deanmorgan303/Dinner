package movies.example.movies.movies;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class moviesConfig {
    @Bean
    CommandLineRunner movieCommandLineRunner (moviesRepository repository){
        return args->{
            repository.findAll();
        };
    }
}

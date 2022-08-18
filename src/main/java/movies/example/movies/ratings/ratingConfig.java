package movies.example.movies.ratings;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ratingConfig {
    @Bean
    CommandLineRunner ratingCommandLineRunner (ratingRepository repository){
        return args->{
            repository.findAll();
        };
    }

}

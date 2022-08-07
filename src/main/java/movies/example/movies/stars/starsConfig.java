package movies.example.movies.stars;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class starsConfig {
    @Bean
    CommandLineRunner starsCommandLineRunner(starsRepository repository){
        return args->{
          repository.findAll();
        };
    }

}

package movies.example.movies.User;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class userConfig {
    @Bean
    CommandLineRunner userCommandLineRunner (appUserService service){

    return args->{

         //service.saveRole(new Role(null,"ROLE_USER"));
         //service.saveRole(new Role(null,"ROLE_ADMIN"));

         //service.saveUser(new AppUser(null,"vibe78","password1234",new ArrayList<>()));
         //service.saveUser(new AppUser(null,"vision67","password1678",new ArrayList<>()));

         //service.addRoleToUser("vibe78","ROLE_USER");
         //service.addRoleToUser("vision67","ROLE_ADMIN");
         service.getUsers();
    };
    }
}

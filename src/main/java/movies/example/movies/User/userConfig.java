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
         //List<AppUser> allUsers=service.getUsers();
         //System.out.println("Gazazzzzzzaazzazazazazzazazazazazaz");
         //System.out.println(allUsers);
         //service.saveRole(new Role(null,"ROLE_USER"));
         //service.saveRole(new Role(null,"ROLE_ADMIN"));

         //service.saveUser(new AppUser(null,"DeanTestUser89","password1234",new ArrayList<>()));
         //service.saveUser(new AppUser(null,"DeanTestUser3","password1678",new ArrayList<>()));

         //service.addRoleToUser("DeanTestUser89","ROLE_USER");
         //service.addRoleToUser("DeanTestUser3","ROLE_ADMIN");
         service.getUsers();
    };
    }
}

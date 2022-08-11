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
         /*List<AppUser> allUsers=service.getUsers();
         System.out.println("Gazazzzzzzaazzazazazazzazazazazazaz");
         System.out.println(allUsers);
         service.saveRole(new Role(Long.valueOf(5690),"ROLE_USER"));
         service.saveRole(new Role(Long.valueOf(7895),"ROLE_ADMIN"));

         service.saveUser(new AppUser(null,"goodman404@gmail.com","password1234",new ArrayList<>()));
         service.saveUser(new AppUser(null,"wilson6789@gmail.com","password1678",new ArrayList<>()));

         service.addRoleToUser(Long.valueOf(5690),"ROLE_USER");
         service.addRoleToUser(Long.valueOf(7895),"ROLE_ADMIN");*/
        service.getUsers();
    };
    }
}

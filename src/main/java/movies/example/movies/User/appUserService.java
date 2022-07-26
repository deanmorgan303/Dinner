package movies.example.movies.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class appUserService implements UserDetailsService {

    private final appUserRepository AppUserRepository;
    private final roleRepository RoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public appUserService (appUserRepository AppUserRepository,roleRepository RoleRepository,PasswordEncoder passwordEncoder){

        this.AppUserRepository= AppUserRepository;
        this.RoleRepository = RoleRepository;
        this.passwordEncoder =passwordEncoder;
     }

     public AppUser saveUser (AppUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return AppUserRepository.save(user);
     }

     public Role saveRole (Role role){
        return RoleRepository.save(role);
     }

     public void addRoleToUser (String username,String roleName){

        AppUser user = AppUserRepository.findByUsername(username);
        Role role =RoleRepository.findByName(roleName).get(0);
        user.getRoles().add(role);
     }

     public AppUser getAppUser (String Username){
        return AppUserRepository.findByUsername(Username);
     }
     public List<AppUser> getUsers (){
        return AppUserRepository.findAll();
     }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user =AppUserRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User  not found ");
        }
        else{
            System.out.println(user);
            System.out.println("we found the person ");
        }

        Collection<SimpleGrantedAuthority> authorities=new ArrayList<>();

        user.getRoles().forEach( role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }
}

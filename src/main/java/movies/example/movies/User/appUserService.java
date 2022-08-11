package movies.example.movies.User;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class appUserService {

    private final appUserRepository AppUserRepository;
    private final roleRepository RoleRepository;

    @Autowired
    public appUserService (appUserRepository AppUserRepository,roleRepository RoleRepository){
        this.AppUserRepository= AppUserRepository;
        this.RoleRepository = RoleRepository;
     }

     public AppUser saveUser (AppUser user){
        return AppUserRepository.save(user);
     }

     public Role saveRole (Role role){
        return RoleRepository.save(role);
     }

     public void addRoleToUser (Long Id,String roleName){
        Optional<AppUser> optionalUser =AppUserRepository.findById(Id);
        AppUser user= optionalUser.get();
        Role role =RoleRepository.findByName(roleName);
        user.getRoles().add(role);
     }

     public AppUser getAppUser (String Username){
        return AppUserRepository.findByUsername(Username);
     }
     public List<AppUser> getUsers (){
        return AppUserRepository.findAll();
     }
}

package movies.example.movies.User;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/users")
public class userController {

    private  final appUserService AppUserService;

    @Autowired
    public userController (appUserService AppUserService){
        this.AppUserService = AppUserService;
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> getUsers(){
        return ResponseEntity.ok().body(AppUserService.getUsers());
    }

    @PostMapping(path="/save")
    public ResponseEntity<AppUser> saveUser( @RequestBody AppUser user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/save").toUriString());
        return ResponseEntity.created(uri).body( AppUserService.saveUser(user));
    }

    @PostMapping(path="/role/save")
    public ResponseEntity<Role> saveRole( @RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/users/role/save").toUriString());
        return ResponseEntity.created(uri).body( AppUserService.saveRole(role));
    }

    @PostMapping(path="/role/addrole")
    public ResponseEntity<?> addRoleToUser( @RequestBody  roleToUserForm form){
        AppUserService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();
    }



}
@Data
class roleToUserForm {
    private String username;
    private String roleName;
}
package movies.example.movies.directors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/movies/directors")

public class directorsController {
    private final directorsService DirectorsService;

    @Autowired
    public directorsController(directorsService DirectorsService){
        this.DirectorsService = DirectorsService;
    }

    @GetMapping
    public List<directors> getDirectors(){
        return DirectorsService.getDirectors();
    }

    @GetMapping(path="/director/{personId}")
    public directors getDirector(@PathVariable("dogId") Long peronId){
        return DirectorsService.getDirector(peronId);


    }


}

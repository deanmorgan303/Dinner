package movies.example.movies.directors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/directors")

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

    @GetMapping(path="/{personId}")
    public List <directors> getMovies(@PathVariable("personId") Long peronId){
        return DirectorsService.getMovies(peronId);


    }

    @GetMapping(path="page/{offset}/{pageSize}")
    public Page<directors> getDirectorsPage(@PathVariable("offset") int offset,@PathVariable("pageSize")int pageSize){
        return DirectorsService.getAllDirectorsPage(offset,pageSize);
    }


}

package movies.example.movies.stars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;


import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/stars")
public class starsController {
    private final starsService StarsService;

    @Autowired
    public starsController (starsService StarsService){
        this.StarsService=StarsService;
    }

    @GetMapping
    public List<stars> getStars(){
        return StarsService.getStars();
    }

    @GetMapping(path="/{id}")
    public List<stars> getData(@PathVariable("id") Long id){
        return StarsService.getStars(id);
    }

    @GetMapping(path="movies/{id}")
    public List<stars> getDirectors(@PathVariable("id") Long id){
        return StarsService.getMovies(id);
    }

}

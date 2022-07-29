package movies.example.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/movies/movies")
public class moviesController {
    private final moviesService MoviesService;

    @Autowired
    public moviesController(moviesService MoviesService){
        this.MoviesService =MoviesService;
    };

   @GetMapping
    public List<movies> getMovies(){
       return MoviesService.getMovies();
   }
}

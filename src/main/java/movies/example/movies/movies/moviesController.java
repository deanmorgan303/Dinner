package movies.example.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/movies")
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

   @GetMapping(path="title/{movieTitle}")
    public List<movies> getMovieByTitle(@PathVariable("movieTitle") String movieTitle){

       return MoviesService.getMovieByTitle(movieTitle);

   }

   @GetMapping(path="id/{Id}")
    public movies getMovieById(@PathVariable("Id")long id){
       return MoviesService.getMovieById(id);
   }


}

package movies.example.movies.movies;

import movies.example.movies.movies_directors.movies_directors;
import movies.example.movies.movies_stars.movies_stars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

  @GetMapping(path="page/{offset}/{pageSize}")
    public Page<movies> getMoviesPage(@PathVariable("offset") int offset,@PathVariable("pageSize")int pageSize){
       return MoviesService.getAllMoviesPage(offset,pageSize);
  }

  @GetMapping(path="directors/all")
    public List<movies_directors> getMoviesByDirector(){
       return MoviesService.getMoviesDirectors();
  }

  @GetMapping(path="director/{id}")
    public List<movies_directors> getMoviesByDirectorID(@PathVariable("id") Long id){
       return MoviesService.getMoviesByDirectorID(id);
  }

  @GetMapping(path="stars/all")
    public List<movies_stars> getMovieStars(){
       return MoviesService.getMovieStars();
  }

  @GetMapping(path="star/{id}")
    public List<movies_stars> getMoviesByStarID(@PathVariable("id")Long id){
     return MoviesService.getMoviesByStarID(id);
  }

  @PostMapping(path="/add")
    public void addNewMovie (@RequestBody movies newMovie){
       MoviesService.addNewMovie(newMovie);

  }

  @DeleteMapping(path="/delete/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
     MoviesService.deleteMovie(movieId);
  }

    @PostMapping(path="/updatetile/{movieId}/{newTitle}")
    public void updateMovieName (@PathVariable("movieId") Long movieId,
                                 @PathVariable("newTitle") String newTitle){
        MoviesService.updateMovieName(movieId,newTitle);

    }


    @PostMapping(path="/updateyear/{movieId}/{updateYear}")
    public void updateMovieYear (@PathVariable("movieId") Long movieId,
                                 @PathVariable("updateYear") Long updateYear){
        MoviesService.updateMovieYear(movieId,updateYear);

    }


}

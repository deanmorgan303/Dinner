package movies.example.movies.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class moviesService {
    private final moviesRepository MoviesRepository;

    @Autowired
    public moviesService(moviesRepository MoviesRepository){
        this.MoviesRepository= MoviesRepository;
    }

    public List<movies> getMovies(){
        return MoviesRepository.findAll();
    }

    @Transactional
    public void updateTitle(Long Id,String title){
        boolean exists=MoviesRepository.existsById(Id);
        Optional <movies> optionalMovies=MoviesRepository.findmoviebyid(Id);
        movies Movies=optionalMovies.get();

        if (!exists){
            throw new IllegalStateException("movie not found");

        }
        else{
           Movies.setTitle(title);
        }
    }


    @Transactional
    public void updateYear(Long Id,Long year){
        boolean exists = MoviesRepository.existsById(Id);
        Optional <movies> optionalMovies = MoviesRepository.findmoviebyid(Id);
        movies Movies=optionalMovies.get();

        if (!exists){
            throw new IllegalStateException("movie not found");
        }
        else{
           Movies.setYear(year);
        }
     }

     @Transactional
     public void updateId(Long Id ,Long updateId){
        boolean exists = MoviesRepository.existsById(Id);
        Optional <movies> optionalMovies = MoviesRepository.findmoviebyid(Id);
        movies Movies=optionalMovies.get();

        if (!exists){
            throw new IllegalStateException("movie not found");
        }
        else{
            Movies.setId(updateId);
        }
     }

     @Transactional
    public movies getMovie(Long Id){
        boolean exist= MoviesRepository.existsById(Id);
         Optional <movies> optionalMovies = MoviesRepository.findmoviebyid(Id);
         movies Movie=optionalMovies.get();

         if (!exist){
             throw new IllegalStateException("movie not found");
         }
         else{
             return Movie;
         }

     }

    public List<movies> getMovieByTitle(String tittle){

        boolean exist =MoviesRepository.existByTittle(tittle);
        Optional <movies> optionalMovies = MoviesRepository.findMovieByTitle(tittle);
        System. out. println("Gazaaaaaaaaaaaa");
        System. out. println(optionalMovies);
        List<movies> Movies =optionalMovies.stream().toList();

        if (!exist){
            throw new IllegalStateException("movie not found");
        }
        else{
            //System. out. println("Gazaaaaaaaaaaaa");
            //System. out. println(Movies);
            return Movies;
        }


    }



}

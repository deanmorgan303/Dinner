package movies.example.movies.movies;

import movies.example.movies.directors.*;

import movies.example.movies.movies_directors.movies_directors;
import movies.example.movies.movies_stars.movies_stars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Optional <movies> optionalMovies=MoviesRepository.findMovieById(Id);
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
        Optional <movies> optionalMovies = MoviesRepository.findMovieById(Id);
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
        Optional <movies> optionalMovies = MoviesRepository.findMovieById(Id);
        movies Movies=optionalMovies.get();

        if (!exists){
            throw new IllegalStateException("movie not found");
        }
        else{
            Movies.setId(updateId);
        }
     }

     @Transactional
    public movies getMovieById(Long Id){
        boolean exist= MoviesRepository.existsById(Id);
         Optional <movies> optionalMovies = MoviesRepository.findMovieById(Id);
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
        List<movies> Movies = MoviesRepository.findMovieByTitle(tittle);

        //List<movies> Movies =optionalMovies.stream().toList();

        if (!exist){
            throw new IllegalStateException("movie not found");
        }
        else{
            //System. out. println("Gazaaaaaaaaaaaa");
            //System. out. println(Movies);
            return Movies;
        }


    }

    @Transactional
    public Page<movies> getAllMoviesPage(int offset,int pageSize){
         Page <movies> Movies =MoviesRepository.findAll(PageRequest.of(offset,pageSize));
         return Movies;
    }


    @Transactional
    public List<movies_directors> getMoviesDirectors(){
        List<movies_directors>  allMoviesDirectors = MoviesRepository.getMoviesDirectors();
       return allMoviesDirectors;
    }

    @Transactional
    public List<movies_directors> getMoviesByDirectorID(Long id){
        List<movies_directors>  allMoviesByDirectorsID = MoviesRepository.getMoviesByDirectorsID(id);
        return allMoviesByDirectorsID;
    }

    @Transactional
    public List<movies_stars> getMovieStars(){
        List<movies_stars> allMovieStars= MoviesRepository.getMovieStars();
        return allMovieStars;
    }

    @Transactional
    public List<movies_stars> getMoviesByStarID(Long id){
        List<movies_stars> allMoviesByStarsId=MoviesRepository.getMovieByStarsId(id);
        return allMoviesByStarsId;
    }

}

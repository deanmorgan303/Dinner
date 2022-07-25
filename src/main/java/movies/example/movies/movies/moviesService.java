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

}

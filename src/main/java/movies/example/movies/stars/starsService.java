package movies.example.movies.stars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class starsService {
    private final starsRepository StarsRepository;

    @Autowired
    public starsService(starsRepository StarsRepository){
        this.StarsRepository=StarsRepository;
    }

    public List<stars> getStars(){
        return StarsRepository.findAll();
    }

    @Transactional
    public void updatePersonId(Long Id,Long updateId){
        boolean exists=StarsRepository.existsById(Id);
         Optional <stars> optionalStars = StarsRepository.findStarsById(Id);
         stars Stars =optionalStars.get();
         if (!exists){
             throw new IllegalStateException("star count does not exist");
         }
         else{
             Stars.setPerson_id(updateId);
         }
    }

    @Transactional
    public void updateMovieId(Long Id,Long updateId){
        boolean exists=StarsRepository.existsById(Id);
        Optional <stars> optionalStars = StarsRepository.findStarsById(Id);
        stars Stars =optionalStars.get();
        if (!exists){
            throw new IllegalStateException("star count does not exist");
        }
        else{
            Stars.setMovie_id(updateId);
        }
    }

}

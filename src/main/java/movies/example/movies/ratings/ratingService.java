package movies.example.movies.ratings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ratingService {

    private final ratingRepository RatingRepository;

    @Autowired
    public ratingService(ratingRepository RatingRepository){
        this.RatingRepository=RatingRepository;
    }

    public List<ratings> getRating(){
        return RatingRepository.findAll();
    }

    @Transactional
    public void updateRating(Long Id,Long Rating){
        boolean exists =RatingRepository.existsById(Id);
        Optional <ratings> optionalRatings = RatingRepository.findRatingById(Id);
        ratings Ratings= optionalRatings.get();

        if (!exists){
            throw new IllegalStateException("rating does not exist");
        }
        else {
            Ratings.setRating(Rating);
        }
    }

    @Transactional
    public void updateVotes(Long Id,Long Votes){
        boolean exists=RatingRepository.existsById(Id);
        Optional <ratings> optionalRatings = RatingRepository.findRatingById(Id);
        ratings Ratings= optionalRatings.get();

        if(!exists){
            throw new IllegalStateException("rating does not exists");
        }
        else{
          Ratings.setVotes(Votes);
        }
    }

    @Transactional
    public void updateId(Long Id,Long UpdateMovieId){
        boolean exists = RatingRepository.existsById(Id);
        Optional <ratings> optionalRatings=RatingRepository.findRatingById(Id);
        ratings Ratings=optionalRatings.get();

        if (!exists){
            throw new IllegalStateException("rating does not exists");
        }
        else{
            Ratings.setMovie_id(UpdateMovieId);
        }
    }
}

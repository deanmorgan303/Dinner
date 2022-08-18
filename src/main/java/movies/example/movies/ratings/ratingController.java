package movies.example.movies.ratings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="api/rating")
public class ratingController {
    private final ratingService RatingService;

    @Autowired
    public ratingController(ratingService RatingService){
        this.RatingService=RatingService;
    }

    @GetMapping
    public List<ratings> getRatings (){
        return RatingService.getRating();
    }

}

package movies.example.movies.ratings;

import javax.persistence.*;

@Table
public class ratings {
    private Long movie_id;
    private Long rating;
    private Long votes;

    public Long getMovie_id(){
        return movie_id;
    }

    public void setMovie_id( Long movie_id){
        this.movie_id = movie_id;
    }

    public Long getRating(){
        return rating;
    }

    public void setRating( Long rating){
        this.rating = rating;
    }

    public Long getVotes(){
        return votes;
    }

    public void setVotes( Long votes){
        this.votes=votes;
    }

    public ratings(){

    }

    public ratings( Long movie_id,Long rating,Long votes){
        this.movie_id=movie_id;
        this.rating=rating;
        this.votes=votes;
    }

   @Override
    public String toString(){
        return "ratings{"+
                " movie_id=" + movie_id + '\''+
                ", rating='"+ rating + '\'' +
                ", votes='" + votes + '\"' +
                "}";
   }
}

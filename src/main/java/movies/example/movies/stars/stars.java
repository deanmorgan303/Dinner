package movies.example.movies.stars;

import javax.persistence.*;

@Entity
@Table
public class stars {
    private Long movie_id;
    @javax.persistence.Id
    @Column(name="person_id",nullable = false)
    private Long person_id;

    public Long getMovie_id(){
        return movie_id;
    }

    public void setMovie_id(Long movie_id){
        this.movie_id = movie_id;
    }

    public Long getPerson_id(){
        return person_id;
    }

    public void setPerson_id( Long person_id){
        this.person_id=person_id;
    }

    public stars (){

    }

    public stars (Long movie_id,Long person_id){
        this.movie_id=movie_id;
        this.person_id=person_id;
    }

    @Override
    public String toString(){
        return "stars{" +
                "movie_id="+ movie_id + '\''+
                ", person_id="+ person_id + '\''+
                "}";
    }
}

package movies.example.movies.directors;
import movies.example.movies.movies.movies;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
@Entity
@Table
public class directors {
    @Column(name = "movie_id")
    private Long movie_id;
    @javax.persistence.Id
    @Column(name = "person_id", nullable = false)
    private Long person_id;

    public Long getMovie_id(){
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public directors(){

    }

    public directors (Long person_id, Long movie_id){
        this.person_id=person_id;
        this.movie_id=movie_id;
    }

    @Override
    public String toString(){
        return"directors{"+
                "director_id" +  person_id+
                " ,movie_id" + movie_id + "}" ;
    }

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="movie",referencedColumnName = "movie_id",insertable = false,updatable = false)
    @Fetch(FetchMode.JOIN)
    private movies movie;*/
}


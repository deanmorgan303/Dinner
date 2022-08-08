package movies.example.movies.movies;

import movies.example.movies.directors.directors;
import movies.example.movies.stars.stars;
import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class movies {
    @javax.persistence.Id
    @Column (name="id",nullable = false)
    private Long id;
    private String title ;
    private Long year;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id =id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle( String title){
        this.title=title;


    }

    public Long getYear(){
        return year;
    }

    public void setYear( Long year){
        this.year =year;
    }

    public movies(){

    }

    public movies (Long id,String title,Long year){
        this.id=id;
        this.title=title;
        this.year=year;
    }
    public movies (String title,Long year){
       this.title = title;
       this.year = year;
    }

    @Override
    public String toString(){
        return "movies{" +
                "id=" + id +
                ", title=" +title + '\'' +
                ", year=" + year +  '\'' +
                "}";
    }
    @OneToMany(targetEntity = directors.class ,mappedBy = "movie_id",orphanRemoval = false, fetch = FetchType.LAZY)
    private List<directors> directors;

    public List<directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<directors> directors) {
        this.directors = directors;
    }

    @OneToMany (targetEntity = stars.class,mappedBy = "movie_id",orphanRemoval = false,fetch = FetchType.LAZY)

    private List<stars> stars;

    public List<stars> getStars() {
        return stars;
    }

    public void setStars(List<stars> stars) {
        this.stars = stars;
    }
}

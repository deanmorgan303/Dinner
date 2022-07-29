package movies.example.movies.movies;

import javax.persistence.*;
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
}

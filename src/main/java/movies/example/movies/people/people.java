package movies.example.movies.people;

import javax.persistence.*;
@Entity
@Table
public class people {
    @javax.persistence.Id
    @Column(name="id",nullable = false)
    private Long id;
    private String name;
    private Long birth;

    public Long getId(){
        return id;
    }

    public void setId( Long id){
        this.id =id;
    }

    public String getName(){
        return name;
    }
    public void setName( String name){
        this.name=name;
    }

    public Long getBirth(){
        return birth;
    }

    public void setBirth(Long birth){
        this.birth=birth;
    }

    public people(){

    }

    public people( Long id, String name, Long birth){
        this.id=id;
        this.name=name;
        this.birth=birth;

    }

    public people( String name, Long birth){
        this.name=name;
        this.birth=birth;
    }

    @Override
    public String toString(){
        return "people{" +
                ", id="+ id + '\'' +
                ", name=" + name + '\'' +
                ", birth="+ birth + '\'' +
                "}";
    }


}

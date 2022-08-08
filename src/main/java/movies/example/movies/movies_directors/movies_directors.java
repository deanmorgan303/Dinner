package movies.example.movies.movies_directors;

public class movies_directors {

    private Long director_id;
    private Long id;
    private String title ;
    private Long year;

    public Long getDirector_id() {
        return director_id;
    }

    public void setDirector_id(Long director_id) {
        this.director_id = director_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public movies_directors() {
    }

    public movies_directors(Long director_id, Long id, String title, Long year) {
        this.director_id = director_id;
        this.id = id;
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "movies_directors{" +
                "director_id=" + director_id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

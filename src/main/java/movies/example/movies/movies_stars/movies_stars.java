package movies.example.movies.movies_stars;

public class movies_stars {
    private Long star_id;
    private Long id;
    private String title ;
    private Long year;


    public movies_stars() {
    }

    public movies_stars(Long star_id, Long id, String title, Long year) {
        this.star_id = star_id;
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public Long getStar_id() {
        return star_id;
    }

    public void setStar_id(Long star_id) {
        this.star_id = star_id;
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

    @Override
    public String toString() {
        return "movies_stars{" +
                "star_id=" + star_id +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}

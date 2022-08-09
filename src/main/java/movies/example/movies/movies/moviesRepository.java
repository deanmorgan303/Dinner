package movies.example.movies.movies;

import movies.example.movies.directors.directors;
import movies.example.movies.movies_directors.movies_directors;

import movies.example.movies.movies_stars.movies_stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;
@Repository
public interface moviesRepository extends JpaRepository<movies,Long>{
    @Query("SELECT s FROM movies s where s.id=?1")
    Optional <movies> findMovieById(long id);

    @Query("SELECT s FROM movies s where s.title=?1")
    List <movies> findMovieByTitle(String title);

    @Query("select count(s)>0 from movies s where s.title=?1")
    boolean existByTittle(String Tittle);

    @Query("SELECT new movies.example.movies.movies_directors.movies_directors(d.person_id,m.id,m.title,m.year) FROM  movies m INNER JOIN m.directors d")
    List<movies_directors> getMoviesDirectors();

    @Query("SELECT new movies.example.movies.movies_directors.movies_directors(d.person_id,m.id,m.title,m.year) FROM  movies m INNER JOIN m.directors d WHERE d.person_id=?1")
    List<movies_directors> getMoviesByDirectorsID(Long id);

    @Query("SELECT new movies.example.movies.movies_stars.movies_stars(s.person_id,m.id,m.title,m.year) FROM movies m INNER JOIN m.stars s")
    List<movies_stars> getMovieStars();

    @Query("SELECT new movies.example.movies.movies_stars.movies_stars(s.person_id,m.id,m.title,m.year) FROM movies m INNER JOIN m.stars s WHERE s.person_id=?1")
    List<movies_stars> getMovieByStarsId(Long id);
}



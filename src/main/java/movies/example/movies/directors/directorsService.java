package movies.example.movies.directors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class directorsService {

    private final directorsRepository DirectorsRepository;

    @Autowired
    public directorsService(directorsRepository DirectorsRepository){
        this.DirectorsRepository = DirectorsRepository;
    }

    public List<directors> getDirectors(){
        return DirectorsRepository.findAll();

    }

    @Transactional
    public void updateMovieId (Long personId,Long movieId){
        boolean exists= DirectorsRepository.existsById(personId);

        Optional <directors> optionalDirectors=DirectorsRepository.findDirectorbyId(personId);
        directors Directors= optionalDirectors.get();
        if (!exists){
            throw new IllegalStateException("Director does not exit");
        }
        else{
            Directors.setMovie_id(movieId);
        }


    }

    @Transactional
    public void updatePersonId (Long personId ,Long updatedId){
        boolean exist =DirectorsRepository.existsById(personId);

        Optional <directors> optionalDirectors =DirectorsRepository.findDirectorbyId(personId);
        directors Directors =optionalDirectors.get();

        if (!exist){
            throw new IllegalStateException("Director does not exit");
        }
        else {
            Directors.setPerson_id(updatedId);
        }
    }

    @Transactional
    public directors getDirector(Long personId){
        boolean exist=DirectorsRepository.existsById(personId);
        Optional <directors> optionalDirectors =DirectorsRepository.findDirectorbyId(personId);
        directors Director =optionalDirectors.get();
        if (!exist){
            throw new IllegalStateException("Director does not exit");
        }
        else {
           return Director;
        }
    }


}

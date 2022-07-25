package movies.example.movies.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class peopleService {

    private final peopleRepository PeopleRepository;

    @Autowired
    public peopleService(peopleRepository PeopleRepository){
        this.PeopleRepository =PeopleRepository;
    }

    public List<people> getPeople(){
        return PeopleRepository.findAll();
    }

    @Transactional
    public void updateName(Long id,String name){
        boolean exists = PeopleRepository.existsById(id);
        Optional <people> optionalPeople = PeopleRepository.findByPeopleById(id);
        people People =optionalPeople.get();
        if(!exists){
            throw new IllegalStateException("person does not exists");
        }
        else{
            People.setName(name);
        }
    }

    @Transactional
    public void updateBirth(Long Id,Long Birth){
        boolean exists = PeopleRepository.existsById(Id);
        Optional <people>  optionalPeople =PeopleRepository.findByPeopleById(Id);
        people People = optionalPeople.get();

        if (!exists){
            throw new IllegalStateException("person not found");
        } else{
            People.setBirth(Birth);
        }

    }

    @Transactional
    public void updateId(Long Id, Long updateId){
        boolean exists =PeopleRepository.existsById(Id);
        Optional <people> optionalPeople = PeopleRepository.findByPeopleById(Id);
        people People = optionalPeople.get();

        if (!exists){
            throw new IllegalStateException("person does not exist");
        }
        else{
            People.setId(updateId);
        }
    }
}

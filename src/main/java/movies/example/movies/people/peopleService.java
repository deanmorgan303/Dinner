package movies.example.movies.people;

import movies.example.movies.movies.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        Optional <people> optionalPeople = PeopleRepository.findPeopleById(id);
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
        Optional <people>  optionalPeople =PeopleRepository.findPeopleById(Id);
        System.out.println(optionalPeople);

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
        Optional <people> optionalPeople = PeopleRepository.findPeopleById(Id);
        people People = optionalPeople.get();

        if (!exists){
            throw new IllegalStateException("person does not exist");
        }
        else{
            People.setId(updateId);
        }
    }


    @Transactional
    public people getPeopleById(Long id){
        boolean exist = PeopleRepository.existsById(id);
        Optional <people> optionalPeople = PeopleRepository.findPeopleById(id);
        people Person=optionalPeople.get();

        if (!exist) {
            throw new IllegalStateException("person does not exist");
        }
        else{
            return Person;
        }
    }

    @Transactional
    public List<people> getPeopleByName(String Name){
        boolean exist= PeopleRepository.existByName(Name);
        Optional <people> optionalPeople=PeopleRepository.findPeopleByName(Name);

        List <people> People = optionalPeople.stream().toList();
        if (!exist){
            throw new IllegalStateException("no such Name exit in the database");
        }
        else{
            return People;
        }
    }

    @Transactional
    public Page<people> getPeoplePage(int offset ,int pageSize){
        Page <people> People= PeopleRepository.findAll(PageRequest.of(offset,pageSize));
        return People;
    }

    public people addPerson(people person){
        person.setId(null);
        return PeopleRepository.save(person);
    }






}

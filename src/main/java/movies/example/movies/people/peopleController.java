package movies.example.movies.people;
import movies.example.movies.movies.movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="api/people")
public class peopleController {

    private final peopleService PeopleService;

    @Autowired
    public peopleController (peopleService PeopleService){
        this.PeopleService = PeopleService;
    }

    @GetMapping
    public List<people> getPeople(){
       return PeopleService.getPeople();
    }

    @GetMapping(path="person/{Id}")
    public people getPeopleById(@PathVariable("Id")Long id){
        return PeopleService.getPeopleById(id);
    }

    @GetMapping(path="/{Name}")
    public List<people> getPeopleById(@PathVariable("Name")String Name){
        return PeopleService.getPeopleByName(Name);
    }

    @GetMapping(path="page/{offset}/{pageSize}")
    public Page<people> getPeoplePage (@PathVariable("offset") int offset,@PathVariable("pageSize")int pageSize){
        return PeopleService.getPeoplePage(offset,pageSize);
    }

    @PostMapping(path="/add")
    public void addNewMovie (@RequestBody people person){
        PeopleService.addPerson(person);

    }

    
}

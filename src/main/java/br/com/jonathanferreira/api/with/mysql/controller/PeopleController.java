package br.com.jonathanferreira.api.with.mysql.controller;

import br.com.jonathanferreira.api.with.mysql.controller.dto.PeopleDTO;
import br.com.jonathanferreira.api.with.mysql.controller.dto.PeopleRq;
import br.com.jonathanferreira.api.with.mysql.model.People;
import br.com.jonathanferreira.api.with.mysql.repository.PeopleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/")
    public List<PeopleDTO> findAll() {
        var peoples = peopleRepository.findAll();
        return peoples.stream()
                .map(PeopleDTO::converter)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        var peopleOptional = peopleRepository.findById(id);
        try{
            if(peopleOptional.isPresent()){
                var people = peopleOptional.get();
                return ResponseEntity.ok().body(PeopleDTO.converter(people));
            }else {
                throw new SQLException("name not found");
            }
        }catch (SQLException e){
            return ResponseEntity.of(peopleOptional);
        }
    }

    @PostMapping("/")
    public PeopleDTO savePerson(@RequestBody PeopleRq p){
        var people = new People();
        people.setName(p.getName());
        people.setLastname(p.getName());

        var result = peopleRepository.save(people);

        return PeopleDTO.converter(result);
    }

    @PutMapping("{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody PeopleRq p) throws Exception {
        var people = peopleRepository.findById(id);
        if(people.isPresent()){
            var peopleSave = people.get();
            peopleSave.setName(p.getName());
            peopleSave.setLastname(p.getLastName());

            peopleRepository.save(peopleSave);
        }else {
            throw new Exception("person not found");
        }
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id){
         peopleRepository.deleteById(id);
    }
}

package br.com.jonathanferreira.api.with.mysql.controller;

import br.com.jonathanferreira.api.with.mysql.controller.dto.PeopleDTO;
import br.com.jonathanferreira.api.with.mysql.repository.PeopleRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PeopleController {

    private final PeopleRepository peopleRepository;

    public PeopleController(PeopleRepository peopleRepository){
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleDTO> findAll() {
        var peoples = peopleRepository.findAll();
        return peoples.stream()
                .map(PeopleDTO::converter)
                .collect(Collectors.toList());
    }
}

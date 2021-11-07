package br.com.jonathanferreira.api.with.mysql.controller.dto;

import br.com.jonathanferreira.api.with.mysql.model.People;

public class PeopleDTO {
    private Long id;
    private String name;
    private String lastname;

    public static PeopleDTO converter(People p) {
        var pessoa = new PeopleDTO();
        pessoa.setId(p.getId());
        pessoa.setName(p.getName());
        pessoa.setLastname(p.getLastname());

        return pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}

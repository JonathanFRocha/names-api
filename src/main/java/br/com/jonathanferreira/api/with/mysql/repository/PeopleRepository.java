package br.com.jonathanferreira.api.with.mysql.repository;

import br.com.jonathanferreira.api.with.mysql.model.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
}

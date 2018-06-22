package org.woehlke.neo4j.example.storage.neo4j.service;

import org.woehlke.neo4j.example.storage.neo4j.domain.Person;

import java.util.Optional;

/**
 * @author Thomas Woehlke
 */
public interface PersonService {

    Person findByName(String name);

    Iterable<Person> findAll();

    Optional<Person> findById(Long id);

    Person save(Person entity);

    void deleteAll();
}

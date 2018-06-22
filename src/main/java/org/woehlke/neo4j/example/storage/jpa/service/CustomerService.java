package org.woehlke.neo4j.example.storage.jpa.service;

import org.woehlke.neo4j.example.storage.jpa.domain.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author Thomas Woehlke
 */
public interface CustomerService {

    List<Customer> findByLastName(String lastName);

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer entity);

    void deleteAll();

}

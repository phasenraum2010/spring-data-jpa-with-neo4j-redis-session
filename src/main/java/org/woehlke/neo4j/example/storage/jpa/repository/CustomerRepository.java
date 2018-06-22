package org.woehlke.neo4j.example.storage.jpa.repository;

import java.util.List;

import org.woehlke.neo4j.example.storage.jpa.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mark Angrish
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName);
}

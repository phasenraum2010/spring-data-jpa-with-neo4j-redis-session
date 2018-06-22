package org.woehlke.neo4j.example.process.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.woehlke.neo4j.example.storage.jpa.domain.Customer;
import org.woehlke.neo4j.example.storage.jpa.service.CustomerService;
import org.woehlke.neo4j.example.storage.neo4j.domain.Person;
import org.woehlke.neo4j.example.storage.neo4j.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RunDatabaseExampleImpl implements RunDatabaseExample {

    private static final Log LOGGER = LogFactory.getLog(RunDatabaseExampleImpl.class);

    private final PersonService personService;

    private final CustomerService customerService;

    @Autowired
    public RunDatabaseExampleImpl(PersonService personService, CustomerService customerService) {
        this.personService = personService;
        this.customerService = customerService;
    }

    @Override
    public void start() {
        LOGGER.info("-----------------------------------------");
        LOGGER.info("perform Some Example Database Operations");
        LOGGER.info("-----------------------------------------");
    }

    public void deleteAllPersonsAndCustomers(){
        LOGGER.info("delete all Persons and Customers. ");
        personService.deleteAll();
        customerService.deleteAll();
        LOGGER.info("-----------------------------------------");
    }


    public Long saveACoupleOfCustomers() {
        LOGGER.info("save a couple of customers (JPA):");
        LOGGER.info("-----------------------------------------");
        Customer c1 = customerService.save(new Customer("Jack", "Bauer"));
        Customer c2 = customerService.save(new Customer("Chloe", "O'Brian"));
        Customer c3 = customerService.save(new Customer("Kim", "Bauer"));
        Customer c4 = customerService.save(new Customer("David", "Palmer"));
        Customer c5 = customerService.save(new Customer("Michelle", "Dessler"));

        c1.worksWith(c2);
        c1.worksWith(c3);
        c1.worksWith(c4);
        c1.worksWith(c5);

        c1 = customerService.save(c1);

        LOGGER.info("c1 :"+c1.toString());
        LOGGER.info("c2 :"+c2.toString());
        LOGGER.info("c3 :"+c3.toString());
        LOGGER.info("c4 :"+c4.toString());
        LOGGER.info("c5 :"+c5.toString());
        LOGGER.info("-----------------------------------------");

        return c1.getId();
    }

    public Long alsoSaveThemAsPeople(){
        LOGGER.info("also save them as people (Neo4J):");
        LOGGER.info("-----------------------------------------");
        Person p1 = new Person("Jack Bauer");
        Person p2 = new Person("Chloe O'Brian");
        Person p3 = new Person("Kim Bauer");
        Person p4 = new Person("David Palmer");
        Person p5 = new Person("Michelle Dessler");

        p1 = personService.save(p1);
        p2 = personService.save(p2);
        p3 = personService.save(p3);
        p4 = personService.save(p4);
        p5 = personService.save(p5);

        p1.worksWith(p2);
        p1.worksWith(p3);
        p1.worksWith(p4);
        p1.worksWith(p5);

        p1 = personService.save(p1);

        LOGGER.info("p1 :"+p1.toString());
        LOGGER.info("p2 :"+p2.toString());
        LOGGER.info("p3 :"+p3.toString());
        LOGGER.info("p4 :"+p4.toString());
        LOGGER.info("p5 :"+p5.toString());
        LOGGER.info("-----------------------------------------");

        return p1.getId();
    }

    public void fetchAllCustomers(){
        // fetch all customers
        LOGGER.info("Customers found with findAll(): ");
        LOGGER.info("-----------------------------------------");
        Iterable<Customer> customers = customerService.findAll();
        for (Customer customer : customers) {
            LOGGER.info(customer.toString());
        }
        LOGGER.info("");
    }

    public void fetchAllPeople(){
        // fetch all people
        LOGGER.info("People found with findAll(): ");
        LOGGER.info("-----------------------------------------");
        Iterable<Person> people = personService.findAll();

        for (Person person : people) {
            LOGGER.info(person.toString());
        }
        LOGGER.info("");
    }

    public void fetchAnIndividualCustomerById(Long individualCustomerId){
        // fetch an individual customer by ID
        Optional<Customer> customer = customerService.findById(individualCustomerId);
        LOGGER.info("Customer found with findOne("+individualCustomerId+": ");
        LOGGER.info("-----------------------------------------");
        LOGGER.info(customer.toString());
        LOGGER.info("");
    }

    public void fetchAnIndividualPersonById(Long individualPersonId){
        // fetch an individual person by ID
        Optional<Person> person = personService.findById(individualPersonId);
        LOGGER.info("Person found with findOne("+individualPersonId+"): ");
        LOGGER.info("-----------------------------------------");
        LOGGER.info(person.toString());
        LOGGER.info("");
    }

    public void fetchCustomersByLastName(){
        // fetch customers by last name
        LOGGER.info("Customer found with findByLastName('Bauer'):");
        LOGGER.info("-----------------------------------------");
        for (Customer bauer : customerService.findByLastName("Bauer")) {
            LOGGER.info(bauer.toString());
        }
        LOGGER.info("");
    }

    public void fetchPersonByTheirName(){
        // fetch person by their name
        LOGGER.info("Person found with findByName('Jack Bauer'):");
        LOGGER.info("--------------------------------------------");
        Person jackBauer = personService.findByName("Jack Bauer");
        LOGGER.info(jackBauer.toString());
        LOGGER.info("");
    }

    @Override
    public void done() {
        LOGGER.info("--------------------------------------------");
        LOGGER.info("We are Done Here :)");
        LOGGER.info("--------------------------------------------");
    }
}

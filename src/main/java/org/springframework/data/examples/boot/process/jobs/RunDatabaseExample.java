package org.springframework.data.examples.boot.process.jobs;

public interface RunDatabaseExample {

    void start();
    void deleteAllPersonsAndCustomers();
    Long saveACoupleOfCustomers();
    Long alsoSaveThemAsPeople();
    void fetchAllCustomers();
    void fetchAllPeople();
    void fetchAnIndividualCustomerById(Long individualCustomerId);
    void fetchAnIndividualPersonById(Long individualPersonId);
    void fetchCustomersByLastName();
    void fetchPersonByTheirName();
    void done();
}

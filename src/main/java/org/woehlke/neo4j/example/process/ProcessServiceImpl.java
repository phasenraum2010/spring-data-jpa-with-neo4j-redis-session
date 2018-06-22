package org.woehlke.neo4j.example.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.woehlke.neo4j.example.process.jobs.RunDatabaseExample;
import org.springframework.stereotype.Service;

@Service
public class ProcessServiceImpl implements ProcessService {

    private final RunDatabaseExample runDatabaseExample;

    @Autowired
    public ProcessServiceImpl(RunDatabaseExample runDatabaseExample) {
        this.runDatabaseExample = runDatabaseExample;
    }

    @Override
    public void runDatabaseExample() {
        runDatabaseExample.start();
        runDatabaseExample.deleteAllPersonsAndCustomers();
        Long individualCustomerId = runDatabaseExample.saveACoupleOfCustomers();
        Long individualPersonId = runDatabaseExample.alsoSaveThemAsPeople();
        runDatabaseExample.fetchAllCustomers();
        runDatabaseExample.fetchAllPeople();
        runDatabaseExample.fetchAnIndividualCustomerById(individualCustomerId);
        runDatabaseExample.fetchAnIndividualPersonById(individualPersonId);
        runDatabaseExample.fetchCustomersByLastName();
        runDatabaseExample.fetchPersonByTheirName();
        runDatabaseExample.done();;
    }
}

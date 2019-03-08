package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.QuotesDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.services.PersonService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.PersonServiceException;
import edu.KaylaKornelis.advancedjava.Assignment6.services.ServiceFactory;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment6Test.model.PersonDAOTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the DatabasePersonService
 */
public class DatabasePersonServiceTest {

    /**
     * Declare instance of PersonService 
     * that can be used throughout this test class
     */
    private PersonService personService;

    /** 
     * Initialize database through DatabaseUtils class and 
     * initialize databaseStockService variable to a new instance of PersonService class
     * @throws Exception
     */
    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    /** 
     * Initialize database through DatabaseUtils class and 
     * initialize databaseStockService variable to a new instance of PersonService class
     * @throws Exception
     */
    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        personService = ServiceFactory.getPersonServiceInstance();
    }

    /**
     * clean up after ourselves. (this could also restore db from initial state)
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    /**
     * test that the personService instance is not null
     */
    @Test
    public void testGetInstance() {
        assertNotNull("Make sure personService is available", personService);
    }

    /** 
     * Test that person objects can be retrieved from the database with the 
     * getPerson method
     * @throws PersonServiceException
     */
    @Test
    public void testGetPerson() throws PersonServiceException {
        List<PersonDAO> personList = personService.getPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }

    /** 
     * Test that a person objects can be added or updated 
     * @throws PersonServiceException
     */
    @Test
    public void testAddOrUpdatePerson()throws PersonServiceException {
        PersonDAO newPerson = PersonDAOTest.createPerson();
        personService.addOrUpdatePerson(newPerson);
        List<PersonDAO> personList = personService.getPerson();
        boolean found = false;
        for (PersonDAO person : personList) {
            Timestamp returnedBirthDate = person.getBirthDate();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == PersonDAOTest.birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == PersonDAOTest.birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonDAOTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    person.getLastName().equals(PersonDAOTest.lastName)
                    &&
                    person.getFirstName().equals(PersonDAOTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person we added", found);
    }

     /** 
     * Test that quotes can be correctly returned for a given person
     * verifies addQuotesToPerson and getQuotes methods
     * @throws PersonServiceException
     */
    @Test
    public void testGetQuotesByPerson() throws PersonServiceException {
        PersonDAO person = PersonDAOTest.createPerson();
        List<QuotesDAO> quotes = personService.getQuotes(person);
        // make the person have all the quotes
        for (QuotesDAO quote : quotes) {
            personService.addQuotesToPerson(quote, person);
        }
        List<QuotesDAO> quoteList = personService.getQuotes(person);
        for (QuotesDAO quote : quotes) {
            boolean removed = quoteList.remove(quote);
            assertTrue("Verify that the quote was found on the list", removed);
        }
        // if  hobbyList is empty then we know the lists matched.
        assertTrue("Verify the list of returned quotes match what was expected ", quoteList.isEmpty());

    }


}

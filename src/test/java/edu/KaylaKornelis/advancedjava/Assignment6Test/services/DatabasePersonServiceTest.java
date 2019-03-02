package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

import edu.KaylaKornelis.advancedjava.Assignment6.model.Person;
import edu.KaylaKornelis.advancedjava.Assignment6.model.Quote;
import edu.KaylaKornelis.advancedjava.Assignment6.services.DatabasePersonService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.PersonService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.PersonServiceException;
import edu.KaylaKornelis.advancedjava.Assignment6.services.ServiceFactory;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment6Test.model.PersonTest;
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

    private DatabasePersonService databasePersonService;

    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    // do not assume db is correct
    @Before
    public void setUp() throws Exception {
        // we could also copy db state here for later restore before initializing
        initDb();
        databasePersonService = ServiceFactory.getPersonServiceInstance();
    }

    // clean up after ourselves. (this could also restore db from initial state
    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void testGetInstance() {
        assertNotNull("Make sure activitiesService is available", databasePersonService);
    }

    @Test
    public void testGetPerson() throws PersonServiceException {
        List<Person> personList = databasePersonService.getPerson();
        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
    }

    @Test
    public void testAddOrUpdatePerson()throws PersonServiceException {
        Person newPerson = PersonTest.createPerson();
        databasePersonService.addOrUpdatePerson(newPerson);
        List<Person> personList = databasePersonService.getPerson();
        boolean found = false;
        for (Person person : personList) {
            Timestamp returnedBirthDate = person.getBirthDate();
            Calendar returnCalendar = Calendar.getInstance();
            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
            if (returnCalendar.get(Calendar.MONTH) == PersonTest.birthDayCalendar.get(Calendar.MONTH)
                    &&
                    returnCalendar.get(Calendar.YEAR) == PersonTest.birthDayCalendar.get(Calendar.YEAR)
                    &&
                    returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
                    &&
                    person.getLastName().equals(PersonTest.lastName)
                    &&
                    person.getFirstName().equals(PersonTest.firstName)) {
                found = true;
                break;
            }
        }
        assertTrue("Found the person we added", found);
    }

    @Test
    public void testGetQuotesByPerson() throws PersonServiceException {
        Person person = PersonTest.createPerson();
        List<Quote> quotes = databasePersonService.getQuotes(person);
        // make the person have all the quotes
        for (Quote quote : quotes) {
            databasePersonService.addQuotesToPerson(quote, person);
        }
        List<Quote> quoteList = databasePersonService.getQuotes(person);
        for (Quote quote : quotes) {
            boolean removed = quoteList.remove(quote);
            assertTrue("Verify that the quote was found on the list", removed);
        }
        // if  hobbyList is empty then we know the lists matched.
        assertTrue("Verify the list of returned quotes match what was expected ", quoteList.isEmpty());

    }


}

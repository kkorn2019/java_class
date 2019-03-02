package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

//import com.origamisoftware.teach.advanced.model.Hobby;
//import com.origamisoftware.teach.advanced.model.Person;
//import com.origamisoftware.teach.advanced.model.PersonTest;
//import com.origamisoftware.teach.advanced.service.ActivitiesService;
//import com.origamisoftware.teach.advanced.service.ActivitiesServiceException;
//import com.origamisoftware.teach.advanced.service.ActivitiesServiceFactory;
//import com.origamisoftware.teach.advanced.util.DatabaseUtils;
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
 * Unit tests for the DatabaseActivitiesService
 */
public class DatabaseActivitiesServiceTest {

//    private ActivitiesService activitiesService;
//
//    private void initDb() throws Exception {
//        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
//    }
//
//    // do not assume db is correct
//    @Before
//    public void setUp() throws Exception {
//        // we could also copy db state here for later restore before initializing
//        initDb();
//        activitiesService = ActivitiesServiceFactory.getInstance();
//    }
//
//    // clean up after ourselves. (this could also restore db from initial state
//    @After
//    public void tearDown() throws Exception {
//        initDb();
//    }
//
//    @Test
//    public void testGetInstance() {
//        assertNotNull("Make sure activitiesService is available", activitiesService);
//    }
//
//    @Test
//    public void testGetPerson() throws ActivitiesServiceException {
//        List<Person> personList = activitiesService.getPerson();
//        assertFalse("Make sure we get some Person objects from service", personList.isEmpty());
//    }
//
//    @Test
//    public void testAddOrUpdatePerson()throws ActivitiesServiceException {
//        Person newPerson = PersonTest.createPerson();
//        activitiesService.addOrUpdatePerson(newPerson);
//        List<Person> personList = activitiesService.getPerson();
//        boolean found = false;
//        for (Person person : personList) {
//            Timestamp returnedBirthDate = person.getBirthDate();
//            Calendar returnCalendar = Calendar.getInstance();
//            returnCalendar.setTimeInMillis(returnedBirthDate.getTime());
//            if (returnCalendar.get(Calendar.MONTH) == PersonTest.birthDayCalendar.get(Calendar.MONTH)
//                    &&
//                    returnCalendar.get(Calendar.YEAR) == PersonTest.birthDayCalendar.get(Calendar.YEAR)
//                    &&
//                    returnCalendar.get(Calendar.DAY_OF_MONTH) == PersonTest.birthDayCalendar.get(Calendar.DAY_OF_MONTH)
//                    &&
//                    person.getLastName().equals(PersonTest.lastName)
//                    &&
//                    person.getFirstName().equals(PersonTest.firstName)) {
//                found = true;
//                break;
//            }
//        }
//        assertTrue("Found the person we added", found);
//    }
//
//    @Test
//    public void testGetHobbiesByPerson() throws ActivitiesServiceException {
//        Person person = PersonTest.createPerson();
//        List<Hobby> hobbies = activitiesService.getHobbies(person);
//        // make the person have all the hobbies
//        for (Hobby hobby : hobbies) {
//            activitiesService.addHobbyToPerson(hobby, person);
//        }
//        List<Hobby> hobbyList = activitiesService.getHobbies(person);
//        for (Hobby hobby : hobbies) {
//            boolean removed = hobbyList.remove(hobby);
//            assertTrue("Verify that the hobby was found on the list", removed);
//        }
//        // if  hobbyList is empty then we know the lists matched.
//        assertTrue("Verify the list of returned hobbies match what was expected ", hobbyList.isEmpty());
//
//    }


}

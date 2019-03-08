package edu.KaylaKornelis.advancedjava.Assignment6Test.model.database;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonDAO;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for the PersonDAO class
 */
public class PersonDAOTest {

    public  static final Calendar birthDayCalendar = Calendar.getInstance();

    static {
        birthDayCalendar.set(2004, Calendar.APRIL, 4);
    }

    public static final String firstName = "Joe";
    public  static final String lastName = "Schmo";
    public static final Timestamp birthDate = new Timestamp(birthDayCalendar.getTimeInMillis());

    /**
     * Testing helper method for generating PersonDAO test data
     *
     * @return a PersonDAO object that uses static constants for data.
     */
    public static PersonDAO createPerson() {
        PersonDAO person = new PersonDAO();
        person.setBirthDate(birthDate);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        return person;
    }

    /** 
     * Test that setters and getters in the PersonDAO class are working correctly.
     */
    @Test
    public void testPersonGettersAndSetters() {
        PersonDAO person = createPerson();
        int id = 10;
        person.setId(id);
        assertEquals("first name matches", firstName, person.getFirstName());
        assertEquals("last name matches", lastName, person.getLastName());
        assertEquals("birthday matches", birthDate, person.getBirthDate());
        assertEquals("id matches", id, person.getId());

    }
    
    /** 
     * Test that two separate instances of Quote class can be created and 
     * verify that they are the same.
     */
    @Test
    public void testEquals() {
        PersonDAO person = createPerson();
        assertTrue("Same objects are equal", person.equals(createPerson()));
    }
    
    /**
     * Test that the toString method in PersonDAO returns the expected value
     * @throws Exception 
     */
    @Test
    public void testToString() throws Exception{
        PersonDAO person = createPerson();
        assertEquals("Verify toString works correctly", "Person{id=0, firstName='" + firstName + "', lastName='" + lastName + "', birthDate=" + birthDate + "}", person.toString());
    }

}

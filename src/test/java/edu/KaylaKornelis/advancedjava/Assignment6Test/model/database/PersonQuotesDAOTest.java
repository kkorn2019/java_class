package edu.KaylaKornelis.advancedjava.Assignment6Test.model.database;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.Person;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonQuotes;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.Quotes;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonQuotes class
 */
public class PersonQuotesDAOTest {

    /**
     * Testing helper method for generating PersonQuotes test data
     *
     * @return a PersonQuotes object that uses Person and Quotes
 return from their respective create method.
     */
    public static PersonQuotes createPersonStocks() {
        Person person = PersonDAOTest.createPerson();
        Quotes quote = QuotesDAOTest.createQuote();
        return new PersonQuotes(person, quote);
    }

    /** 
     * Test that setters and getters in the PersonQuotes class are working correctly.
     */
    @Test
    public void testPersonStocksGetterAndSetters() {
        Quotes quote = QuotesDAOTest.createQuote();
        Person person = PersonDAOTest.createPerson();
        PersonQuotes personQuotes = new PersonQuotes();
        int id = 10;
        personQuotes.setId(id);
        personQuotes.setPerson(person);
        personQuotes.setQuote(quote);
        assertEquals("person matches", person, personQuotes.getPerson());
        assertEquals("quote matches", quote, personQuotes.getQuote());
        assertEquals("id matches", id, personQuotes.getId());
    }

    /** 
     * Test that two separate instances of PersonQuotes class can be created and 
 verify that they are different.
     */
    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuotes personQuotes = createPersonStocks();
        personQuotes.setId(10);
        Quotes quote = QuotesDAOTest.createQuote();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonDAOTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonDAOTest.firstName);
        person.setLastName(PersonDAOTest.lastName);
        PersonQuotes personQuotes2 = new PersonQuotes(person, quote);
        assertFalse("Different person", personQuotes.equals(personQuotes2));
    }

    /** 
     * Test that two separate instances of PersonQuotes class can be created and 
 verify that they are the same.
     */
    @Test
    public void testEquals() {
        PersonQuotes personQuotes = createPersonStocks();
        assertTrue("Same objects are equal", personQuotes.equals(createPersonStocks()));
    }

    
    /**
     * Test that the toString method in PersonQuotes returns the expected value
     */

    @Test
    public void testToString() {
        PersonQuotes personQuotes = createPersonStocks();
        assertTrue("toString has lastName", personQuotes.toString().contains(PersonDAOTest.lastName));
        assertTrue("toString has person", personQuotes.toString().contains(PersonDAOTest.firstName));
        assertTrue("toString has symbol", personQuotes.toString().contains(QuotesDAOTest.symbol));
        assertTrue("toString has time", personQuotes.toString().contains(QuotesDAOTest.time.toString()));
        assertTrue("toString has price", personQuotes.toString().contains(QuotesDAOTest.price.toString()));
    }

}

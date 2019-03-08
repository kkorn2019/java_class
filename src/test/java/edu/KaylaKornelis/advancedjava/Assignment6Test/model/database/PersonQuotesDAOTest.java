package edu.KaylaKornelis.advancedjava.Assignment6Test.model.database;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.PersonQuotesDAO;
import edu.KaylaKornelis.advancedjava.Assignment6.model.database.QuotesDAO;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonQuotesDAO class
 */
public class PersonQuotesDAOTest {

    /**
     * Testing helper method for generating PersonQuotesDAO test data
     *
     * @return a PersonQuotesDAO object that uses PersonDAO and QuotesDAO
 return from their respective create method.
     */
    public static PersonQuotesDAO createPersonStocks() {
        PersonDAO person = PersonDAOTest.createPerson();
        QuotesDAO quote = QuotesDAOTest.createQuote();
        return new PersonQuotesDAO(person, quote);
    }

    /** 
     * Test that setters and getters in the PersonQuotesDAO class are working correctly.
     */
    @Test
    public void testPersonStocksGetterAndSetters() {
        QuotesDAO quote = QuotesDAOTest.createQuote();
        PersonDAO person = PersonDAOTest.createPerson();
        PersonQuotesDAO personQuotes = new PersonQuotesDAO();
        int id = 10;
        personQuotes.setId(id);
        personQuotes.setPerson(person);
        personQuotes.setQuote(quote);
        assertEquals("person matches", person, personQuotes.getPerson());
        assertEquals("quote matches", quote, personQuotes.getQuote());
        assertEquals("id matches", id, personQuotes.getId());
    }

    /** 
     * Test that two separate instances of PersonQuotesDAO class can be created and 
 verify that they are different.
     */
    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuotesDAO personQuotes = createPersonStocks();
        personQuotes.setId(10);
        QuotesDAO quote = QuotesDAOTest.createQuote();
        PersonDAO person = new PersonDAO();
        Timestamp birthDate = new Timestamp(PersonDAOTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonDAOTest.firstName);
        person.setLastName(PersonDAOTest.lastName);
        PersonQuotesDAO personQuotes2 = new PersonQuotesDAO(person, quote);
        assertFalse("Different person", personQuotes.equals(personQuotes2));
    }

    /** 
     * Test that two separate instances of PersonQuotesDAO class can be created and 
 verify that they are the same.
     */
    @Test
    public void testEquals() {
        PersonQuotesDAO personQuotes = createPersonStocks();
        assertTrue("Same objects are equal", personQuotes.equals(createPersonStocks()));
    }

    
    /**
     * Test that the toString method in PersonQuotesDAO returns the expected value
     */

    @Test
    public void testToString() {
        PersonQuotesDAO personQuotes = createPersonStocks();
        assertTrue("toString has lastName", personQuotes.toString().contains(PersonDAOTest.lastName));
        assertTrue("toString has person", personQuotes.toString().contains(PersonDAOTest.firstName));
        assertTrue("toString has symbol", personQuotes.toString().contains(QuotesDAOTest.symbol));
        assertTrue("toString has time", personQuotes.toString().contains(QuotesDAOTest.time.toString()));
        assertTrue("toString has price", personQuotes.toString().contains(QuotesDAOTest.price.toString()));
    }

}

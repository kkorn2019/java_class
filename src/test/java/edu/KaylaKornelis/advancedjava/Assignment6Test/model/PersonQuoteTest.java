package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.Person;
import edu.KaylaKornelis.advancedjava.Assignment6.model.PersonQuote;
import edu.KaylaKornelis.advancedjava.Assignment6.model.Quote;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for PersonHobby class
 */
public class PersonQuoteTest {

    /**
     * Testing helper method for generating PersonHobby test data
     *
     * @return a PersonHobby object that uses Person and Hobby
     * return from their respective create method.
     */
    public static PersonQuote createPersonQuote() {
        Person person = PersonTest.createPerson();
        Quote quote = QuoteTest.createQuote();
        return new PersonQuote(person, quote);
    }

    /** 
     * Test that setters and getters in the PersonQuote class are working correctly.
     */
    @Test
    public void testPersonQuoteGetterAndSetters() {
        Quote quote = QuoteTest.createQuote();
        Person person = PersonTest.createPerson();
        PersonQuote personQuote = new PersonQuote();
        int id = 10;
        personQuote.setId(id);
        personQuote.setPerson(person);
        personQuote.setQuote(quote);
        assertEquals("person matches", person, personQuote.getPerson());
        assertEquals("quote matches", quote, personQuote.getQuote());
        assertEquals("id matches", id, personQuote.getId());
    }

    /** 
     * Test that two separate instances of PersonQuote class can be created and 
     * verify that they are different.
     */
    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuote personQuote = createPersonQuote();
        personQuote.setId(10);
        Quote quote = QuoteTest.createQuote();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonQuote personQuote2 = new PersonQuote(person, quote);
        assertFalse("Different person", personQuote.equals(personQuote2));
    }

    /** 
     * Test that two separate instances of PersonQuote class can be created and 
     * verify that they are the same.
     */
    @Test
    public void testEquals() {
        PersonQuote personQuote = createPersonQuote();
        assertTrue("Same objects are equal", personQuote.equals(createPersonQuote()));
    }

    
    /**
     * Test that the toString method in PersonQuote returns the expected value
     */

    @Test
    public void testToString() {
        PersonQuote personQuote = createPersonQuote();
        assertTrue("toString has lastName", personQuote.toString().contains(PersonTest.lastName));
        assertTrue("toString has person", personQuote.toString().contains(PersonTest.firstName));
        assertTrue("toString has symbol", personQuote.toString().contains(QuoteTest.symbol));
        assertTrue("toString has time", personQuote.toString().contains(QuoteTest.time.toString()));
        assertTrue("toString has price", personQuote.toString().contains(QuoteTest.price.toString()));
    }

}

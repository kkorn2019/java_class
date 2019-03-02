package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.Person;
import edu.KaylaKornelis.advancedjava.Assignment6.model.PersonQuotes;
import edu.KaylaKornelis.advancedjava.Assignment6.model.Quotes;
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
    public static PersonQuotes createPersonQuote() {
        Person person = PersonTest.createPerson();
        Quotes quote = QuoteTest.createQuote();
        return new PersonQuotes(person, quote);
    }

    /** 
     * Test that setters and getters in the PersonQuotes class are working correctly.
     */
    @Test
    public void testPersonQuoteGetterAndSetters() {
        Quotes quote = QuoteTest.createQuote();
        Person person = PersonTest.createPerson();
        PersonQuotes personQuote = new PersonQuotes();
        int id = 10;
        personQuote.setId(id);
        personQuote.setPerson(person);
        personQuote.setQuote(quote);
        assertEquals("person matches", person, personQuote.getPerson());
        assertEquals("quote matches", quote, personQuote.getQuote());
        assertEquals("id matches", id, personQuote.getId());
    }

    /** 
     * Test that two separate instances of PersonQuotes class can be created and 
 verify that they are different.
     */
    @Test
    public void testEqualsNegativeDifferentPerson() {
        PersonQuotes personQuote = createPersonQuote();
        personQuote.setId(10);
        Quotes quote = QuoteTest.createQuote();
        Person person = new Person();
        Timestamp birthDate = new Timestamp(PersonTest.birthDayCalendar.getTimeInMillis() + 10000);
        person.setBirthDate(birthDate);
        person.setFirstName(PersonTest.firstName);
        person.setLastName(PersonTest.lastName);
        PersonQuotes personQuote2 = new PersonQuotes(person, quote);
        assertFalse("Different person", personQuote.equals(personQuote2));
    }

    /** 
     * Test that two separate instances of PersonQuotes class can be created and 
 verify that they are the same.
     */
    @Test
    public void testEquals() {
        PersonQuotes personQuote = createPersonQuote();
        assertTrue("Same objects are equal", personQuote.equals(createPersonQuote()));
    }

    
    /**
     * Test that the toString method in PersonQuotes returns the expected value
     */

    @Test
    public void testToString() {
        PersonQuotes personQuote = createPersonQuote();
        assertTrue("toString has lastName", personQuote.toString().contains(PersonTest.lastName));
        assertTrue("toString has person", personQuote.toString().contains(PersonTest.firstName));
        assertTrue("toString has symbol", personQuote.toString().contains(QuoteTest.symbol));
        assertTrue("toString has time", personQuote.toString().contains(QuoteTest.time.toString()));
        assertTrue("toString has price", personQuote.toString().contains(QuoteTest.price.toString()));
    }

}

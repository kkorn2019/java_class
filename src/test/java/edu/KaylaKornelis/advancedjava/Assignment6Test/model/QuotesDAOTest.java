package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.QuotesDAO;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for QuotesDAO class
 */
public class QuotesDAOTest {
    
    public  static final Calendar timeStampCalendar = Calendar.getInstance();

    static {
        timeStampCalendar.set(2014, Calendar.MAY, 15);
    }

    final static String symbol = "APPL";
    final static Timestamp time = new Timestamp(timeStampCalendar.getTimeInMillis() + 10000);
    final static BigDecimal price = new BigDecimal(100);

    /**
     * Testing helper method for generating QuotesDAO test data
     *
     * @return a QuotesDAO object that uses static constants for data.
     */
    public static QuotesDAO createQuote() {
        QuotesDAO quote = new QuotesDAO();
        quote.setSymbol(symbol);
        quote.setTime(time);
        quote.setPrice(price);
        return quote;
    }

    /** 
     * Test that setters and getters in the QuotesDAO class are working correctly.
     */
    @Test
    public void testQuoteSettersAndGetters() {
        QuotesDAO quote = createQuote();
        int id = 10;
        quote.setId(id);
        assertEquals("Symbol", symbol, quote.getSymbol());
        assertEquals("Time", time, quote.getTime());
        assertEquals("Price", price, quote.getPrice());
        assertEquals("id", id, quote.getId());

    }
    
    /** 
     * Test that two separate instances of QuotesDAO class can be created and 
 verify that they are the same.
     */
    @Test
    public void testEquals() {
        QuotesDAO quote = createQuote();
        assertTrue("Same objects are equal", quote.equals(createQuote()));
    }
    
    /**
     * Test that the toString method in QuotesDAO returns the expected value
     * @throws Exception 
     */
    @Test
    public void testToString() throws Exception{
        QuotesDAO quote = createQuote();
        System.out.println(quote.toString());
        assertEquals("Verify toString works correctly", "Quote{id=0, symbol='" + symbol + "', time='" + time + "', price=" + price + "}", quote.toString());
        
    }

}

package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.Quote;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for Quote class
 */
public class QuoteTest {
    
    public  static final Calendar timeStampCalendar = Calendar.getInstance();

    static {
        timeStampCalendar.set(2014, Calendar.MAY, 15);
    }

    final static String symbol = "APPL";
    final static Timestamp time = new Timestamp(timeStampCalendar.getTimeInMillis() + 10000);
    final static BigDecimal price = new BigDecimal(100);

    /**
     * Testing helper method for generating Quote test data
     *
     * @return a Quote object that uses static constants for data.
     */
    public static Quote createQuote() {
        Quote quote = new Quote();
        quote.setSymbol(symbol);
        quote.setTime(time);
        quote.setPrice(price);
        return quote;
    }

    /** 
     * Test that setters and getters in the Quote class are working correctly.
     */
    @Test
    public void testQuoteSettersAndGetters() {
        Quote quote = createQuote();
        int id = 10;
        quote.setId(id);
        assertEquals("Symbol", symbol, quote.getSymbol());
        assertEquals("Time", time, quote.getTime());
        assertEquals("Price", price, quote.getPrice());
        assertEquals("id", id, quote.getId());

    }
    
    /** 
     * Test that two separate instances of Quote class can be created and 
     * verify that they are the same.
     */
    @Test
    public void testEquals() {
        Quote quote = createQuote();
        assertTrue("Same objects are equal", quote.equals(createQuote()));
    }
    
    /**
     * Test that the toString method in Quote returns the expected value
     * @throws Exception 
     */
    @Test
    public void testToString() throws Exception{
        Quote quote = createQuote();
        System.out.println(quote.toString());
        assertEquals("Verify toString works correctly", "Quote{id=0, symbol='" + symbol + "', time='" + time + "', price=" + price + "}", quote.toString());
        
    }

}

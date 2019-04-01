package edu.KaylaKornelis.advancedjava.Assignment5Test.model;

import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuote;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test for StockQuote class
 */
public class StockQuoteTest {

    private BigDecimal price;
    private Date date;
    private String symbol;
    private StockQuote stockQuote;

    /**
     * Set up for StockQuote class before each test by initializing 
     * all variables 
     */
    @Before
    public void setUp() {
        price = new BigDecimal(100);
        date = Calendar.getInstance().getTime();
        symbol = "APPL";
        stockQuote = new StockQuote(price, date, symbol);
    }

    /**
     * Test that the getPrice method in StockQuote returns the expected value
     */
    @Test
    public void testGetPrice() {
        assertEquals("Share price is correct", price, stockQuote.getPrice());
    }

    /**
     * Test that the getDate method in StockQuote returns the expected value
     */
    @Test
    public void testGetDate() {
        assertEquals("Share date is correct", date, stockQuote.getDate());
    }

    /**
     * Test that the getSymbol method in StockQuote returns the expected value
     */
    @Test
    public void testGetSymbol() {
        assertEquals("Symbol  is correct", symbol, stockQuote.getSymbol());
    }
}

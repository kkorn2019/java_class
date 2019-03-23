package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.StockData;
import edu.KaylaKornelis.advancedjava.Assignment6.model.StockQuery;
import edu.KaylaKornelis.advancedjava.Assignment6.model.StockQuote;
import edu.KaylaKornelis.advancedjava.Assignment6.util.IntervalEnum;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;

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
     * Test that a simple StockQuote object can be constructed correctly by verifying 
     * symbol is set and returned correctly.
     * @throws Exception 
     */
    @Test
    public void testBasicConstruction() throws Exception{
        StockQuote newStockQuote = new StockQuote(new BigDecimal(100),new Date(),"APPL");
        assertEquals("Verify construction", symbol, newStockQuote.getSymbol());
    }

    /**
     * Test that the getPrice method in StockQuote returns the expected value
     */
    @Test
    public void testGetPriceSuccessful() {
        assertEquals("Share price is correct", price, stockQuote.getPrice());
    }
    
     /**
     * Test that the getPrice method in StockQuote does not return the expected value
     */
    @Test
    public void testGetPriceNegative() {
        assertFalse("Share price is incorrect", new BigDecimal(200).equals(stockQuote.getPrice()));
    }

    /**
     * Test that the getDate method in StockQuote returns the expected value
     */
    @Test
    public void testGetDateSuccessful() {
        assertEquals("Share date is correct", date, stockQuote.getDate());
    }
    
    /**
     * Test that the getDate method in StockQuote does not return the expected value
     * @throws ParseException
     */
    @Test
    public void testGetDateNegative()throws ParseException {
        DateFormat dateFormatter = new SimpleDateFormat(StockData.dateFormat);
        Date testDate = dateFormatter.parse("2011-10-29 12:12:12");
        Calendar convertedDate = Calendar.getInstance();
        convertedDate.setTime(testDate);
        assertNotEquals("Share date is incorrect", testDate, stockQuote.getDate());
    }

    /**
     * Test that the getSymbol method in StockQuote returns the expected value
     */
    @Test
    public void testGetSymbolSuccessful() {
        assertEquals("Symbol  is correct", symbol, stockQuote.getSymbol());
    }
    
    /**
     * Test that the getSymbol method in StockQuote does not return the expected value
     */
    @Test
    public void testGetSymbolNegative() {
        String testSymbol = "GOOG";
        assertFalse("Verify symbol is incorrect", testSymbol.equals(stockQuote.getSymbol()));
    }
    
    /**
     * Test that the toString method in StockQuote returns the expected value
     * @throws Exception 
     */
    @Test
    public void testToString() throws Exception{
        String symbol = "APPL";
        String from = "2011-10-29 12:12:12";
        String until = "2014-11-29 12:12:12";
        StockQuery stockQuery = new StockQuery(symbol, from, until, IntervalEnum.HOUR);
        StockQuote stockQuoteFromDate = new StockQuote(new BigDecimal(100), stockQuery.getFrom().getTime(), stockQuery.getSymbol());
        assertEquals("Verify toString works correctly", "StockQuote{price=100, date=2011-10-29 12:12:12, symbol='APPL'}", stockQuoteFromDate.toString());
    }
    
}

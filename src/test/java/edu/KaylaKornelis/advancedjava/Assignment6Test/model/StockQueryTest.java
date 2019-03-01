package edu.KaylaKornelis.advancedjava.Assignment6Test.model;

import edu.KaylaKornelis.advancedjava.Assignment6.model.StockData;
import edu.KaylaKornelis.advancedjava.Assignment6.model.StockQuery;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {
    private static final String symbol = "APPL";
    private static final String inputDate = "2011-10-29 12:12:1";
    private Calendar date;
    private StockQuery stockQuery;
    public static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat simpleDateFormat;
    
    
    /**
     * Test that a simple StockQuery object can be constructed correctly by verifying 
     * symbol is set and returned correctly.
     * @throws Exception 
     */
    @Test
    public void testBasicConstruction() throws Exception{
        stockQuery = new StockQuery(symbol,"2011-10-29 12:12:1","2014-10-29 12:12:1");
        assertEquals("Verify construction", symbol, stockQuery.getSymbol());
    }
    
    /**
     * Test that the getSymbol method in StockQuery returns the expected value
     * @throws ParseException
     */
    @Test
    public void testGetSymbolSuccessful() throws ParseException{
        stockQuery = new StockQuery(symbol, "2014-10-29 12:12:1", "2014-10-29 12:12:1");
        assertEquals("Verify symbol is correct", symbol, stockQuery.getSymbol());
    }
    
    /**
     * Test that the getSymbol method in StockQuery does not return the expected value
     * @throws ParseException
     */
    @Test
    public void testGetSymbolNegative() throws ParseException{
        String testSymbol = "GOOG";
        stockQuery = new StockQuery(symbol, "2014-10-29 12:12:1", "2014-10-29 12:12:1");
        assertNotEquals("Verify symbol is not correct", testSymbol, stockQuery.getSymbol());
    }
    
    /**
     * Test that the getFrom method in StockQuery returns the expected value
     * @throws ParseException
     */
    @Test
    public void testGetFromSuccessful() throws ParseException{
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        date = Calendar.getInstance();
        date.setTime(simpleDateFormat.parse(inputDate));
        stockQuery = new StockQuery(symbol, inputDate, "2014-10-29 12:12:1");
        assertEquals("Verify from date is correct", date, stockQuery.getFrom());
    }
    
    /**
     * Test that the getFrom method in StockQuery does not return the expected value
     * @throws ParseException
     */
    @Test
    public void testGetFromNegative() throws ParseException{
        DateFormat dateFormatter = new SimpleDateFormat(StockData.dateFormat);
        Date testDate = dateFormatter.parse("2011-10-29 12:12:12");
        Calendar convertedDate = Calendar.getInstance();
        convertedDate.setTime(testDate);
        stockQuery = new StockQuery(symbol, inputDate, "2014-10-29 12:12:1");
        assertNotEquals("Verify from date is incorrect", date, stockQuery.getFrom());
    }
    
    /**
     * Test that the getUntil method in StockQuery returns the expected value
     * @throws ParseException
     */
    @Test
    public void testGetUntilSuccessful() throws ParseException{
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        date = Calendar.getInstance();
        date.setTime(simpleDateFormat.parse(inputDate));
        stockQuery = new StockQuery(symbol, "2014-10-29 12:12:1", inputDate);
        assertEquals("Verify from date is correct", date, stockQuery.getUntil());
    }
    
    /**
     * Test that the getUntil method in StockQuery does not return the expected value
     * @throws ParseException
     */
    @Test
    public void testGetUntilNegative() throws ParseException{
        DateFormat dateFormatter = new SimpleDateFormat(StockData.dateFormat);
        Date testDate = dateFormatter.parse("2011-10-29 12:12:12");
        Calendar convertedDate = Calendar.getInstance();
        convertedDate.setTime(testDate);
        stockQuery = new StockQuery(symbol, inputDate, "2014-10-29 12:12:1");
        assertNotEquals("Verify from date is incorrect", date, stockQuery.getUntil());
    }

}

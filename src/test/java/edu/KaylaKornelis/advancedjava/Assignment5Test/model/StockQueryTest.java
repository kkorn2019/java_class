package edu.KaylaKornelis.advancedjava.Assignment5Test.model;

import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuery;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
     * Test that the getFrom method in StockQuery returns the expected value
     * @throws ParseException
     */
    @Test
    public void testGetFrom() throws ParseException{
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        date = Calendar.getInstance();
        date.setTime(simpleDateFormat.parse(inputDate));
        stockQuery = new StockQuery(symbol, inputDate, "2014-10-29 12:12:1");
        assertEquals("Verify from date is correct", date, stockQuery.getFrom());
    }
    
    /**
     * Test that the getUntil method in StockQuery returns the expected value
     * @throws ParseException
     */
    @Test
    public void testGetUntil() throws ParseException{
        simpleDateFormat = new SimpleDateFormat(dateFormat);
        date = Calendar.getInstance();
        date.setTime(simpleDateFormat.parse(inputDate));
        stockQuery = new StockQuery(symbol, "2014-10-29 12:12:1", inputDate);
        assertEquals("Verify from date is correct", date, stockQuery.getUntil());
    }

}

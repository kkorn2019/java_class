package edu.KaylaKornelis.advancedjava.Assignment5Test.services;

import edu.KaylaKornelis.advancedjava.Assignment5.model.StockData;
import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuote;
import edu.KaylaKornelis.advancedjava.Assignment5.services.DatabaseStockService;
import edu.KaylaKornelis.advancedjava.Assignment5.services.StockServiceException;
import edu.KaylaKornelis.advancedjava.Assignment5.util.DatabaseInitializationException;
import edu.KaylaKornelis.advancedjava.Assignment5.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment5.util.IntervalEnum;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    /**
     * Declare instance of DatabaseStockService 
     * that can be used throughout this test class
     */
    private DatabaseStockService databaseStockService;
    
    /** 
     * Initialize database through DatabaseUtils class and 
     * initialize databaseStockService variable to a new instance of DatabaseStockService class
     * @throws DatabaseInitializationException
     */
    @Before
    public void setUp() throws DatabaseInitializationException{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
        databaseStockService = new DatabaseStockService();
    }
    
    /** 
     * Test that single quote can be retrieved from the database with the 
     * getQuote method
     * @throws StockServiceException
     */
    @Test
    public void testGetQuote() throws StockServiceException {
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }
    
    /** 
     * Test that no records are retrieved from the database with a symbol 
     * that is known to not be present
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteNegative() throws Exception{
        String symbol = "MSFT";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertTrue("Ensure no records for the given symbol", stockQuote.getSymbol().isEmpty());
    }
    
    /** 
     * Test that a list of stock quotes is able to be retrieved from the database
     * with the getQuote method  when passing in a symbol, and from and until dates.
     * @throws Exception (StockServiceException or ParseException)
     */
    @Test
    public void testGetQuoteList() throws Exception{
        String symbol = "APPL";
        String fromDate = "2000-01-01 00:00:00";
        String untilDate = "2014-04-05 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar);
        assertNotNull("Verify we can get a stock quote from the db", stockQuotes);
        assertFalse("Ensure list of stockQuotes is not empty", stockQuotes.isEmpty());
    }
    
    /** 
     * Test that list of stock quotes retrieved from the database is empty when 
     * give symbol/dates that are known to not be present in the database
     * with the getQuote method  when passing in a symbol, and from and until dates.
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListNegative() throws Exception{
        String symbol = "APPL";
        String fromDate = "2019-01-01 00:00:00";
        String untilDate = "2019-02-05 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar);
        assertTrue("Ensure list of stockQuotes is empty", stockQuotes.isEmpty());
    }  
    
    /** 
     * Test that a list of stock quotes is able to be retrieved from the database
     * with the getQuote method  when passing in a symbol, from and until dates, and interval.
     * @throws Exception (StockServiceException or ParseException)
     */
    @Test
    public void testGetQuoteListWithInterval() throws Exception{
        String symbol = "GOOG";
        String fromDate = "2004-08-02 00:00:01";
        String untilDate = "2015-02-03 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify we can get a stock quote from the db", stockQuotes);
        assertFalse("Ensure list of stockQuotes is NOT empty", stockQuotes.isEmpty());
    }
    
    /** 
     * Test that list of stock quotes retrieved from the database is empty when 
     * given symbol/dates that are known to not be present in the database
     * with the getQuote method  when passing in a symbol, from and until dates, and interval.
     * @throws Exception (StockServiceException or ParseException)
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListWithIntervalNegative() throws Exception{
        String symbol = "GOOG";
        String fromDate = "2004-08-02 00:00:01";
        String untilDate = "2015-02-03 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify we can get a stock quote from the db", stockQuotes);
        assertTrue("Ensure list of stockQuotes is empty", stockQuotes.isEmpty());
    }
    
    /**
     * This method converts a date of type String to a date of type Calendar
     * @param dateEntered the date needed to convert
     * @return converted date of type Calendar
     * @throws ParseException 
     */
    public static Calendar convertStringToDate(String dateEntered)throws ParseException{
        /**
         * Create a new instance of SimpleDateFormat that will be used to 
         * parse the string arguments to obtain desired start and end dates
         */
        DateFormat dateFormatter = new SimpleDateFormat(StockData.dateFormat);
        Date date = dateFormatter.parse(dateEntered);
        Calendar convertedDate = Calendar.getInstance();
        convertedDate.setTime(date);
        
        return convertedDate;
    }
}

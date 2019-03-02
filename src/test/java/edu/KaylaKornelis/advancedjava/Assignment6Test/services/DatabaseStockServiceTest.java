package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

import edu.KaylaKornelis.advancedjava.Assignment6.model.StockData;
import edu.KaylaKornelis.advancedjava.Assignment6.model.StockQuote;
import edu.KaylaKornelis.advancedjava.Assignment6.services.DatabaseStockService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.ServiceFactory;
import edu.KaylaKornelis.advancedjava.Assignment6.services.StockService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.StockServiceException;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseInitializationException;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment6.util.IntervalEnum;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.After;
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
    
    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }
    
    /** 
     * Initialize database through DatabaseUtils class and 
     * initialize databaseStockService variable to a new instance of DatabaseStockService class
     * @throws DatabaseInitializationException
     */
    @Before
    public void setUp() throws Exception{
        initDb();
        //stockService = ServiceFactory.getStockServiceInstance();
        databaseStockService = new DatabaseStockService();
    }
    
    /**
     * clean up after ourselves. (this could also restore db from initial state)
     */
    @After
    public void tearDown() throws Exception {
        initDb();
    }
    
    @Test
    public void testGetInstance() {
        assertNotNull("Make sure databaseStockService is available", databaseStockService);
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
    public void testGetQuoteNegative() throws StockServiceException{
        String symbol = "MSFT";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertTrue("Ensure no records for the given symbol", stockQuote.getSymbol().isEmpty());
    }
    
    /** 
     * Test that a list of stock quotes is able to be retrieved from the database
     * with the getQuote method  when passing in a symbol, and from and until dates.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test
    public void testGetQuoteList() throws ParseException, StockServiceException{
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
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListNegative() throws ParseException, StockServiceException{
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
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test
    public void testGetQuoteListWithInterval() throws ParseException, StockServiceException{
        String symbol = "GOOG";
        String fromDate = "2004-08-02 00:00:01";
        String untilDate = "2015-02-03 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify we can get a list of stock quotes from the db", stockQuotes);
        assertFalse("Ensure list of stockQuotes is NOT empty", stockQuotes.isEmpty());
    }
    
    /** 
     * Test that list of stock quotes retrieved from the database is empty when 
     * given symbol/dates that are known to not be present in the database
     * with the getQuote method  when passing in a symbol, from and until dates, and interval.
     * @throws ParseException
     * @throws StockServiceException
     */
    @Test (expected = StockServiceException.class)
    public void testGetQuoteListWithIntervalNegative() throws ParseException, StockServiceException{
        String symbol = "GOOG";
        String fromDate = "2015-08-02 00:00:01";
        String untilDate = "2016-02-03 23:59:59";
        
        Calendar fromCalendar = convertStringToDate(fromDate);
        Calendar untilCalendar = convertStringToDate(untilDate);
        
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, fromCalendar, untilCalendar, IntervalEnum.HOUR);
        assertNotNull("Verify we can get a list of stock quotes from the db", stockQuotes);
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
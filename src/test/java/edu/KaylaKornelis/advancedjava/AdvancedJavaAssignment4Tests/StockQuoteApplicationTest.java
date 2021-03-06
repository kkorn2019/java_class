package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4Tests;

import edu.KaylaKornelis.advancedjava.Assignment4.StockQuoteApplication;
import edu.KaylaKornelis.advancedjava.Assignment4.model.Interval;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * This class tests the public methods found in the 
 * StockQuoteApplication class.
 */
public class StockQuoteApplicationTest {
    
    /** 
     * This method verifies that a valid Object
     * is returned by the createListOfStockQuotes method. 
     */
    @Test
    public void listOfStockQuotesReturned(){
        //verify that the object returned by the createListOfStockquotes method is not null.
        assertNotNull("List of stock quotes returned should not be null", StockQuoteApplication.createListOfStockQuotes("APPL", "1/1/2014", "2/1/2014"));
    }  
     
    /** 
     * This method verifies that a valid Object
     * is returned by the createListOfStockQuotesWithInterval method. 
     */
    @Test
    public void listOfStockQuotesWithIntervalReturned(){
        //verify that the object returned by the createListOfStockquotes method is not null.
        assertNotNull("List of stock quotes (with interval) returned should not be null",StockQuoteApplication.createListOfStockQuotesWithInterval("APPL", "1/1/2014", "2/1/2014", Interval.WEEKLY));
    }
    
    /** 
     * This method verifies that an invalid Object
     * is returned by the createListOfStockQuotes method. 
     */
    @Test (expected = NullPointerException.class)
    public void listOfStockQuotesReturnedNull(){
        //verify that the object returned by the createListOfStockquotes method is null.
        StockQuoteApplication.createListOfStockQuotes(null, null, null);
    }  
    
    /** 
     * This method verifies that a valid Object
     * is returned by the createListOfStockQuotesWithInterval method. 
     */
    @Test (expected = NullPointerException.class)
    public void listOfStockQuotesWithIntervalReturnedNull(){
        //verify that the object returned by the createListOfStockquotes method is not null.
        StockQuoteApplication.createListOfStockQuotesWithInterval(null, null, null, null);
    }
    
    /** 
     * This method verifies that a valid Object
     * is returned by the createBasicStock method. 
     */
    @Test
    public void basicStockReturned(){
        //verify that the object returned by the createListOfStockquotes method is not null.
        assertNotNull("Basic stock returned should not be null", StockQuoteApplication.createBasicStock("APPL"));
    }    
}
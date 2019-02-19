package edu.KaylaKornelis.advancedjava.Assignment3;

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
        assertNotNull("Ensure list of stock quotes returned is not null", StockQuoteApplication.createListOfStockquotes("APPL", "1/1/2014", "2/1/2014"));
    }  
     
    /** 
     * This method verifies that an invalid Object
     * is returned by the createListOfStockQuotes method. 
     */
    @Test (expected = NullPointerException.class)
    public void listOfStockQuotesReturnedNull(){
        //verify that the object returned by the createListOfStockquotes method is null.
        StockQuoteApplication.createListOfStockquotes(null, null, null);
    }  
    
    /** 
     * This method verifies that a valid Object
     * is returned by the createBasicStock method. 
     */
    @Test
    public void basicStockReturned(){
        //verify that the object returned by the createListOfStockquotes method is not null.
        assertNotNull("Ensure basic stock returned is not null", StockQuoteApplication.createBasicStock("APPL"));
    }  
 
}

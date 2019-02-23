package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignmentsTests;

import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignments.StockQuote;
import java.math.BigDecimal;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * This class tests the public methods found in the 
 * StockQuote class.
 */
public class StockQuoteTest {
 
    /** 
     * This method verifies that the correct company symbol
     * is returned by the StockQuote getStockSymbol method. 
     */
    @Test
    public void getStockSymbolReturnsCorrectValue(){
        //creating the new instance of StockQuote
        StockQuote stockQuote = new StockQuote(new Date(), new BigDecimal(100), "APPL");
        //creating a new String variable called stockSymbol and setting it's value to the value obtained through the getStockSymbol method.
        String stockSymbol = stockQuote.getStockSymbol();
        //verify that the getStockSymbol method returned the correct value
        
        //stockSymbol should hold the value of "APPL"
        assertTrue("stockSymbol should be APPL", stockSymbol.equals("APPL"));
    }
    
    /** 
     * This method verifies that the correct price of one
     * share of stock returned by the StockQuote             
     * getStockPrice method   
     */
    @Test 
    public void getStockPriceReturnsCorrectValue(){
        //creating the new instance of StockQuote
        StockQuote stockQuote = new StockQuote(new Date(), new BigDecimal(100), "APPL");
        //creating a new BigDecimal variable called stockPrice and setting it's value to the value obtained through the getStockPrice method.
        BigDecimal stockPrice = stockQuote.getStockPrice();
        
        //create new BigDecimal instance to serve as the known value for comparison
        BigDecimal bigDecimalTest = new BigDecimal(100);
        //verify that the getStockSymbol method returned the correct value

        //stockSymbol should hold the value of 100
        assertEquals("stockPrice should be 100", stockPrice, bigDecimalTest);
    }

    
    /**
     * This method verifies that the correct date is returned     * by the StockQuote getDateRecorded method.
     */
    @Test
    public void getDateRecordedReturnedCorrectly() {
        //creating the new instance of StockQuote
        StockQuote stockQuote = new StockQuote(new Date(2019, 2, 2), new BigDecimal("12.99"), "APPL");
        //creating a new BigDecimal variable called stockPrice and setting it's value to the value obtained through the getStockPrice method.
        Date dateRecorded = stockQuote.getDateRecorded();
        
        //create new BigDecimal instance to serve as the known value for comparison
        Date dateTest = new Date(2019, 2, 2);
        //verify that the getStockSymbol method returned the correct value

        //stockSymbol should hold the value of 12.99
        assertEquals("dateRecorded should be 2019, 2, 2", dateRecorded, dateTest);
    }
}
package edu.KaylaKornelis.advancedjava.Assignment2;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * This class tests the public methods found in the 
 * StockServiceFactory class.
 */
public class StockServiceFactoryTest {
    
    /** 
     * This method verifies that the correct type of Object
     * is returned by the getStockService method. 
     */
    @Test
    public void stockServiceReturnedCorrectly(){
        //creating new instance of the StockServiceFactory
        StockServiceFactory factory = new StockServiceFactory();
        //verify that the object returned by the getStockService method is an instance of BasicStockService class.
        assertTrue(factory.getStockService() instanceof BasicStockService);
    }  
}
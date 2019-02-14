package edu.KaylaKornelis.advancedjava.Assignment3;


import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 * This class tests the public methods found in the 
 * StockServiceFactory class.
 */
public class StockServiceFactoryTest {
    
    /** 
     * This method verifies that a valid Object
     * is returned by the getStockService method. 
     */
    @Test
    public void stockServiceReturnedNotNull(){
        //creating new instance of the StockServiceFactory
        StockServiceFactory factory = new StockServiceFactory();
        //verify that the object returned by the getStockService method is not null.
        assertNotNull(factory.getStockService());
    }  
}
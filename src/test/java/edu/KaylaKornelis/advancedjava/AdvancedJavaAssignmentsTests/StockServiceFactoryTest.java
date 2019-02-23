package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignmentsTests;


import edu.KaylaKornelis.advancedjava.AdvancedJavaAssignments.StockServiceFactory;
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
        assertNotNull("StockService returned should not be null", factory.getStockService());
    }  
}
package edu.KaylaKornelis.advancedjava.Assignment5Test.services;

import edu.KaylaKornelis.advancedjava.Assignment5.services.StockService;
import edu.KaylaKornelis.advancedjava.Assignment5.services.StockServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {
    /** 
     * This method verifies that a valid Object
     * is returned by the getStockService method. 
     */
    @Test
    public void testGetInstance() {
        StockService stockService = StockServiceFactory.getInstance();
        assertNotNull(stockService);
    }
}

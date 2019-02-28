package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

import edu.KaylaKornelis.advancedjava.Assignment6.services.StockService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class ServiceFactoryTest {
    /** 
     * This method verifies that a valid Object
     * is returned by the getStockService method. 
     */
    @Test
    public void testGetInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }
}

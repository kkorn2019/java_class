package edu.KaylaKornelis.advancedjava.Assignment6Test.services;

import edu.KaylaKornelis.advancedjava.Assignment6.services.PersonService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.StockService;
import edu.KaylaKornelis.advancedjava.Assignment6.services.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class ServiceFactoryTest {
    /** 
     * This method verifies that a valid StockService Object
     * is returned by the getStockServiceInstance method. 
     */
    @Test
    public void testGetStockServiceInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }
    
    /** 
     * This method verifies that a valid PersonService Object
     * is returned by the getPersonServiceInstance method. 
     */
    @Test
    public void testGetPersonServiceInstance() {
        PersonService personService = ServiceFactory.getPersonServiceInstance();
        assertNotNull(personService);
    }
}

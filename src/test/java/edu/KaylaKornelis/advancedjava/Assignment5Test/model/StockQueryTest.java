package edu.KaylaKornelis.advancedjava.Assignment5Test.model;

import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuery;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for StockQuery Class
 */
public class StockQueryTest {

    @Test
    public void testBasicConstruction() throws Exception{
        String symbol = "APPL";
        StockQuery stockQuery = new StockQuery(symbol,"2010-11-11 06:06:06","2011-11-11 06:06:06");
        assertEquals("Verify construction", symbol, stockQuery.getSymbol());
    }

}

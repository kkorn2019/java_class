package edu.KaylaKornelis.advancedjava.Assignment5Test.apps.stockquote;

import edu.KaylaKornelis.advancedjava.Assignment5.apps.stockquote.BasicStockQuoteApplication;
import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuery;
import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuote;
import edu.KaylaKornelis.advancedjava.Assignment5.services.StockService;
import edu.KaylaKornelis.advancedjava.Assignment5.services.StockServiceException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for BasicStockQuoteApplication
 */
public class BasicStockQuoteApplicationTest {

    private BasicStockQuoteApplication basicStockQuoteApplication;
    private StockService stockServiceMock;

    @Before
    public void setUp() {
        stockServiceMock = mock(StockService.class);
    }

    @Test
    public void testValidConstruction() {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        assertNotNull("Basic construction works");
    }

    @Test
    public void testDisplayResults() throws ParseException, StockServiceException {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        String symbol = "APPL";
        String from = "2011-10-29 01:01:01";
        String until = "2011-11-29 23:59:59";
        StockQuery stockQuery = new StockQuery(symbol, from, until);

        List<StockQuote> stockQuotes = new ArrayList<>();
        StockQuote stockQuoteFromDate = new StockQuote(new BigDecimal(100), stockQuery.getFrom().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteFromDate);
        StockQuote stockQuoteUntilDate = new StockQuote(new BigDecimal(100), stockQuery.getUntil().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteUntilDate);

        when(stockServiceMock.getQuote(any(String.class), any(Calendar.class), any(Calendar.class))).thenReturn(stockQuotes);

        String output = basicStockQuoteApplication.displayStockQuotes(stockQuery);
        assertTrue("make sure symbol appears in output", output.contains(symbol));
        assertTrue("make sure from date appears in output", output.contains(from));
        assertTrue("make sure until date in output", output.contains(until));

    }

    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        BasicStockQuoteApplication.main(null);
    }
}

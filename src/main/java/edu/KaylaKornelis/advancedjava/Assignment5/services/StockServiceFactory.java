package edu.KaylaKornelis.advancedjava.Assignment5.services;

import edu.KaylaKornelis.advancedjava.Assignment5.model.StockQuote;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
@Immutable
public class StockServiceFactory {

    /**
     * Prevent instantiations
     */
    private StockServiceFactory() {}

    /**
     *
     * @return get a <CODE>StockService</CODE> instance
     */
    public static StockService getInstance() {
        return new DatabaseStockService() {
            @NotNull
            @Override
            public StockQuote getQuote(String symbol) throws StockServiceException {
                return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), symbol);
            }

            @NotNull
            @Override
            public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
                List<StockQuote> stockQuotes = new ArrayList<>();
                Date aDay = from.getTime();
                while (until.after(aDay))  {
                    stockQuotes.add(new StockQuote(new BigDecimal(100),aDay,symbol));
                    from.add(Calendar.DAY_OF_YEAR, 1);
                    aDay = from.getTime();
                }
                return stockQuotes;            }
        };
    }

}

package edu.KaylaKornelis.advancedjava.Assignment4;

import edu.KaylaKornelis.advancedjava.Assignment4.Interval.IntervalEnum;
import java.util.Calendar;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 *  This interface describes an API for getting stock data.
 */
@Immutable
public interface StockService {

    /**
     * Return the current price for a share of stock
     * for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *      e.g. APPL for APPLE
     *
     * @return a  <CODE>BigDecimal</CODE> instance
     */
    @NotNull
    StockQuote getQuote(String symbol);
    
    /**
     * Get a historical list of stock quotes for the provided symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances
     * One for each day in the range specified
     */
    
    @NotNull
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until);
    
    /**
     * Get a historical list of stock quotes for the provided symbol
     * This method will return one StockQuote per interval specified
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @param interval the number of StockQuotes to get 
     *  Eg. daily = one StockQuote per day will be returned
     * @return a list of StockQuote instances
     * One for each day in the range specified
     */
    
    @NotNull
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval);

}
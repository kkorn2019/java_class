package edu.KaylaKornelis.advancedjava.Assignment4;

import edu.KaylaKornelis.advancedjava.Assignment4.Interval.IntervalEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 *  This class implements the StockService interface for getting stock data.
 */
@Immutable
public class BasicStockService implements StockService {
  
    private Date dateRecorded;
    private BigDecimal stockPrice;
    private String stockSymbol;
    
    /**
     * Return the current price for a share of stock
     * for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *      e.g. APPL for APPLE
     *
     * @return a  <CODE>StockQuote</CODE> instance
     */
    
    @NotNull
    @Override
    public StockQuote getQuote(String symbol){
        
        StockQuote stockQuote = new StockQuote(dateRecorded, stockPrice, symbol);
    
        return stockQuote;
        
    }

    /**
     * Get a historical list of stock quotes for the provided symbol
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return a list of StockQuote instances
     * One for each day in the range specified
     */
    
    @NotNull
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until){
        
        List<StockQuote> listOfStockQuotes = new ArrayList<>();
        /**Create new instance of StockQuote.
        * 
        * @param dateRecorded  the date the stock info was recorded.
        * @param stockPrice the price of the stock for the provided date
        * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
        *
        * @return the StockData instance 
         */
         StockQuote stockQuote = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        
         listOfStockQuotes.add(stockQuote);
         
         return listOfStockQuotes;
    }
    
    /**
     * Get a historical list of stock quotes for the provided symbol
     * This method will return one StockQuote per interval specified
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @param interval the number of StockQuotes to get 
     *  Eg. daily = one StockQuote per day will be returned
     * @return a list of StockQuote instances
     */
    
    @NotNull
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval){
        
        List<StockQuote> listOfStockQuotes = new ArrayList<>();
        /**Create new instance of StockQuote.
        * 
        * @param dateRecorded  the date the stock info was recorded.
        * @param stockPrice the price of the stock for the provided date
        * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
        *
        * @return the StockData instance 
         */
         StockQuote stockQuote = new StockQuote(dateRecorded, stockPrice, stockSymbol);
        
         listOfStockQuotes.add(stockQuote);
         
         return listOfStockQuotes;
    }
      
}
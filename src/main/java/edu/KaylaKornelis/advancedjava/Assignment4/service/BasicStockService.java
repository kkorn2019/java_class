package edu.KaylaKornelis.advancedjava.Assignment4.service;

import edu.KaylaKornelis.advancedjava.Assignment4.model.Interval;
import edu.KaylaKornelis.advancedjava.Assignment4.model.StockQuote;
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
class BasicStockService implements StockService {
  
    private Date dateRecorded = new Date();
    private BigDecimal stockPrice = new BigDecimal(100);
    private String stockSymbol = "APPL";
    
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
        /**
         * Create and return new StockQuote instance
         */
        return new StockQuote(dateRecorded, stockPrice, stockSymbol);        
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
        /**
         * Create new array list to hold list of stock quotes
         */
        List<StockQuote> listOfStockQuotes = new ArrayList<>();

         listOfStockQuotes.add(getQuote(stockSymbol));
         
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
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval){
        /**
         * Create new array list to hold list of stock quotes
         */
        List<StockQuote> listOfStockQuotes = new ArrayList<>();
        
        /**
         * Create new stockQuote for the given symbol and add it to the array list
         */
         listOfStockQuotes.add(getQuote(stockSymbol));
         
         return listOfStockQuotes;
    }
      
}
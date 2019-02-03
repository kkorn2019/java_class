package edu.KaylaKornelis.advancedjava.Assignment2;

import java.math.BigDecimal;
import java.util.Date;

/**
 *  This class implements the StockService interface for getting stock data.
 */

public class BasicStockService implements StockService {
    
    private String stockSymbol;
    private BigDecimal stockPrice;
    private Date dateRecorded;
    
    /**
     * Return the <CODE>StockData</CODE> for the given symbol for the given date.
     * Used to get history data for the stock.
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *      e.g. APPL for APPLE
     * @param date specifies what date to get the stock quote for.
     */
    
    @Override
    public StockQuote getQuote(String symbol, Date date){
        /**Create new instance of StockQuote.
        * 
        * @param dateRecorded  the date the stock info was recorded.
        * @param stockPrice the price of the stock for the provided date
        * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
        *
        * @return the StockData instance 
         */
         StockQuote stockQuote = new StockQuote(dateRecorded, stockPrice, stockSymbol);
         
         return stockQuote;
    }
      
}

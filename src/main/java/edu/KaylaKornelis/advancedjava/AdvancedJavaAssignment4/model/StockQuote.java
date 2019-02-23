package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignment4.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;


/**
 * This class contains information about a stock.
 * This class is immutable. It holds stock info for a given point time.
 */
@Immutable
public class StockQuote {

    private final Date dateRecorded;
    private final BigDecimal stockPrice;
    private final String stockSymbol;


    /**
     *  Create a new  StockData instance
     * @param dateRecorded  the date the stock info was recorded.
     * @param stockPrice the price of the stock for the provided date
     * @param stockSymbol the stock symbol e.g. APPL (for APPLE)
     */
    @NotNull
    public StockQuote(Date dateRecorded, BigDecimal stockPrice, String stockSymbol) {
        this.dateRecorded = dateRecorded;
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
    }


    /**
     *
     * @return the date of the stock price.
     */
    public Date getDateRecorded() {
        return dateRecorded;
    }
    
        /**
     *
     * @return The price of one share of stock.
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }
    
        /**
     *
     * @return the symbol that represents the company whose stock this is.
     * e.g. APPL for APPLE
     */
    public String getStockSymbol() {
        return stockSymbol;
    }
}
package edu.KaylaKornelis.advancedjava.Assignment6.services;

import edu.KaylaKornelis.advancedjava.Assignment6.util.IntervalEnum;
import edu.KaylaKornelis.advancedjava.Assignment6.model.StockQuote;

import java.util.Calendar;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 * This API describes how to get stock data from an external resource.
 */
@Immutable
public interface StockService {


    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    StockQuote getQuote(@NotNull String symbol) throws StockServiceException;

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until) throws StockServiceException;

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @param interval the time frame for which to get a single quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until, @NotNull IntervalEnum interval) throws StockServiceException;
}


package edu.KaylaKornelis.advancedjava.Assignment5.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 * A container class that contains stock data.
 * This class is immutable. It holds stock info for a given point time.

 */
@Immutable
public class StockQuote extends StockData {

    private final BigDecimal price;
    private final Date date;
    private final String symbol;

    /**
     * Create a new instance of a StockQuote.
     *
     * @param price  the share price for the given date
     * @param date   the date of the share price
     * @param symbol the stock symbol.
     */

    public StockQuote(@NotNull BigDecimal price, @NotNull Date date, @NotNull String symbol) {
        super();
        this.price = price;
        this.date = date;
        this.symbol = symbol;
    }

    /**
     * @return Get the share price for the given date.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @return The date of the share price
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return The stock symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        String dateString = simpleDateFormat.format(date);
        return "StockQuote{" +
                "price=" + price +
                ", date=" + dateString +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

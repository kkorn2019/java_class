package edu.KaylaKornelis.advancedjava.Assignment6.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Models the Quotes table
 */
@Entity
public class Quotes {

    private int id;
    private String symbol;
    private Timestamp time;
    private BigDecimal price;

    /**
     * Primary Key - Unique ID for a particular row in the quotes table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the quotes table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the symbol column as a String
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the quote's symbol
     *
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return the value of the time column as a Timestamp
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Timestamp getTime() {
        return time;
    }

    /**
     * Specify the quote's time
     *
     * @param time a Timestamp value
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * The price of the stock
     * @return the value of the price column as a BigDecimal value
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Specify the price of the stock
     * @param price a BigDecimal value
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method compares two objects to ensure they are equal
     */
    @Override
    public boolean equals(Object o) {
        //if the object is equal to itself, return true
        if (this == o) return true;
        
        //check if o is null or is not an instance of this class
        // if so, return false
        if (o == null || getClass() != o.getClass()) return false;
        
        //cast o to be of type person
        Quotes quote = (Quotes) o;

        //compare each attribute and return true or false result
        if (id != quote.id) return false;
        if (price != quote.price) return false;
        if (time != null ? !time.equals(quote.time) : quote.time != null)
            return false;
        if (symbol != null ? !symbol.equals(quote.symbol) : quote.symbol != null) return false;

        return true;
    }

    /**
     * This method constructs and returns a hashcode value for the quotes object
     * @return a hashcode value for the quotes object 
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + price.intValue();
        return result;
    }

    /**
     * This method overrides the toString method to display the attributes of the
     * Quote object as a String
     * @return String containing attributes of Quote object
     */
    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", time='" + time + '\'' +
                ", price=" + price +
                '}';
    }
}

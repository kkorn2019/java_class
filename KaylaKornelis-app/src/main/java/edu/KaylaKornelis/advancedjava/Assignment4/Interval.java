package edu.KaylaKornelis.advancedjava.Assignment4;

import javax.validation.constraints.NotNull;
import org.apache.http.annotation.Immutable;

/**
 *  This class provides access to the available interval values through the IntervalEnum.
 */
@Immutable
public class Interval {
    
    /**
    *  This enum defines the intervals of time a user can request quotes for.
    */
    public enum IntervalEnum {
        /**
         * The last hour
         */
        HOURLY, 
    
        /**
         * The last 24 hours
         */
        DAILY, 
    
        /**
         * The last 7 days
         */
        WEEKLY, 
    
        /**
        * The last 30 days
        */
        MONTHLY;
    }
    
    private final Interval interval;
    
    /**
     *  Create a new  Interval instance
     * @param interval the number of StockQuotes to get 
     */
    @NotNull
    public Interval(Interval interval){
        this.interval = interval;
    }
}

package edu.KaylaKornelis.advancedjava.Assignment5.util;

import javax.validation.constraints.NotNull;

/**
*  This enum defines the intervals of time a user can request quotes for.
*/
public enum IntervalEnum {
    
    /**
     * one(1) hour
     */
    HOUR("hour"), 
    /**
     * twenty-four(24) hours
     */
    DAY("day"), 
    /**
     * seven(7) days
     */
    WEEK("week"),
    /**
     * thirty(30) days
     */
    MONTH("month");
    
    private final String interval;
    
    /**
     *  Create a new  Interval instance
     * @param requestedInterval the time frame to obtain quotes for 
     */
    @NotNull
    private IntervalEnum(String requestedInterval){
        this.interval = requestedInterval;
    }
    
    /**
     *
     * @return The time frame/interval selected
     */
    public String getInterval(){
        return interval;
    }
    
}

package edu.KaylaKornelis.advancedjava.Assignment5.model;

import javax.validation.constraints.NotNull;

/**
*  This enum defines the intervals of time a user can request quotes for.
*/
public enum IntervalEnum {
    HOURLY("one(1) hour"), 
    DAILY("twenty-four(24) hours"), 
    WEEKLY("seven(7) days"), 
    MONTHLY("thirty(30) days");
    
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

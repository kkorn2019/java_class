package edu.KaylaKornelis.advancedjava.AdvancedJavaAssignments;

import javax.validation.constraints.NotNull;

/**
*  This enum defines the intervals of time a user can request quotes for.
*/
public enum Interval {
    /**
     * The last hour
     */
    HOURLY("Last one(1) hour"), 

    /**
     * The last 24 hours
     */
    DAILY("Last twenty-four(24) hours"), 

    /**
     * The last 7 days
     */
    WEEKLY("Last seven(7) days"), 
  
    /**
     * The last 30 days
     */
    MONTHLY("Last thirty(30) days");
    
    private final String interval;
    
    /**
     *  Create a new  Interval instance
     * @param requestedInterval the time frame to obtain quotes for 
     */
    @NotNull
    private Interval(String requestedInterval){
        this.interval = requestedInterval;
    }
    
    public String getInterval(){
        return interval;
    }
    
}

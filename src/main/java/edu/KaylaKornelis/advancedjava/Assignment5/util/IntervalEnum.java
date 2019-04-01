package edu.KaylaKornelis.advancedjava.Assignment5.util;

/**
*  This enum defines the intervals of time a user can request quotes for.
*/
public enum IntervalEnum {

    HOUR(1), 
    DAY(24 * 1), 
    WEEK(24 * 7),
    MONTH(24 * 30);
    
    private final int interval;
    
    /**
     *  Create a new  Interval instance
     * @param requestedInterval the time frame to obtain quotes for
     * @param intervalMinutes the total minutes for each defined interval
     */
    private IntervalEnum(int requestedInterval){
        this.interval = requestedInterval;
    }
    
    /**
     *
     * @return The time frame/interval selected
     */
    public int getInterval(){
        return interval;
    }
    
}

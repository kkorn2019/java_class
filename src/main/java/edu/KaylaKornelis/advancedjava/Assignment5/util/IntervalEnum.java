package edu.KaylaKornelis.advancedjava.Assignment5.util;

import javax.validation.constraints.NotNull;

/**
*  This enum defines the intervals of time a user can request quotes for.
*/
public enum IntervalEnum {
    
    /**
     * one(1) hour
     */
    HOUR("hour", 1), 
    /**
     * twenty-four(24) hours
     */
    DAY("day", 24 * 1), 
    /**
     * seven(7) days
     */
    WEEK("week", 24 * 7),
    /**
     * thirty(30) days
     */
    MONTH("month", 24 * 30);
    
    private final String interval;
    private final int intervalTime;
    
    /**
     *  Create a new  Interval instance
     * @param requestedInterval the time frame to obtain quotes for
     * @param intervalMinutes the total minutes for each defined interval
     */
    private IntervalEnum(@NotNull String requestedInterval, int requestedIntervalHours){
        this.interval = requestedInterval;
        this.intervalTime = requestedIntervalHours;
    }
    
    /**
     *
     * @return The time frame/interval selected
     */
    public String getInterval(){
        return interval;
    }
    
    /**
     * @return the number of minutes quotes were requested for
     */
    public int getIntervalTime(){
        return intervalTime;
    }
    
}

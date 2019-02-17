package edu.KaylaKornelis.advancedjava.Assignment1;

/** 
 * This interface describes an API for book title data.
 */

public interface Title {
    
    /**
     * Set the title for a given book
     * @param title the name of the book
    */
    public void setTitle(String title);
    
    /**
     * Retrieve the title for a given book
     * @return a String
    */
    public String getTitle();
}

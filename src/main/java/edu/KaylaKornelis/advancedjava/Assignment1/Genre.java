package edu.KaylaKornelis.advancedjava.Assignment1;

/** 
 * This interface describes an API for book genre data.
 */

public interface Genre {
    
    /**
     * Set the genre for a given book
     * @param genre the genre by which the book is categorized
    */
    public void setGenre(String genre);
    
    /**
     * Retrieve the genre for a given book
     * @return a String
    */
    public String getGenre();
}

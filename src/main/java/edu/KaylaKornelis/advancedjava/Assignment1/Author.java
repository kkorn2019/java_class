package edu.KaylaKornelis.advancedjava.Assignment1;

/** 
 * This interface describes an API for book author data.
 */

public interface Author {
    
    /**
     * Set the author for a given book
     * @param author the author who wrote the book
    */
    public void setAuthor(String author);
    
    /**
     * Retrieve the author for a given book
     * @return a String
    */
    public String getAuthor();
}

package edu.KaylaKornelis.advancedjava.Assignment1;

/**
 * This class implements the Genre interface for book genre data.
 */
public class BookGenre implements Genre {
    String genre;
    
    /**
     * Create a new instance of BookGenre
     * @param genre the genre by which the book is categorized
    */
    public BookGenre(String genre){
        this.genre = genre;
    }
    
    /**
     * Set the value of genre to the value given 
     * @param genre the desired category for the book
     */
    @Override
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    /**
     * retrieve the genre by which the book is categorized
     * @return a String
    */
    @Override
    public String getGenre(){
        return genre;
    }
}

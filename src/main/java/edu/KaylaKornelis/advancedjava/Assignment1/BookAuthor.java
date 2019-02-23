package edu.KaylaKornelis.advancedjava.Assignment1;

/**
 * This class implements the Author interface for book author data.
 */
public class BookAuthor implements Author {
    //components for creating a new BookAuthor
    String author;
    
    /**
     * Create a new instance of BookAuthor
     * @param author the name of the author of a book
    */
    public BookAuthor(String author){
        this.author = author;
    }
    
    /**
     * Set the value of author to the value given 
     * @param author the desired name of the author of a book
     */
    @Override
    public void setAuthor(String author){
        this.author = author;
    }
    
    /**
     * retrieve the name of the author
     * @return a String
    */
    @Override
    public String getAuthor(){
        return author;
    } 
    
}

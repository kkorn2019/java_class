package edu.KaylaKornelis.advancedjava.Assignment1;

/**
 * This class implements the Title interface for book title data.
 */
public class BookTitle implements Title {
    //components for creating a new BookTitle
    String title;
    
    /**
     * Create a new instance of BookTitle
     * @param title the name of a given book
    */
    public BookTitle(String title){
        this.title = title;
    }
    
    /**
     * Set the value of title to the value given 
     * @param title the desired name of the book
     */
    @Override
    public void setTitle(String title){
        this.title = title;
    }    
    
    /**
     * retrieve the name of the book
     * @return a String
    */
    @Override
    public String getTitle(){
        return title;
     }
}

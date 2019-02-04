package edu.KaylaKornelis.advancedjava.Assignment1;

/**
 * This class contains information about a book.
 * 
 * It contains methods to set and retrieve the title, author, 
 * and genre attributes of a give book. 
 */
public class Book {

    //Attributes of a Book
    BookTitle title = new BookTitle(new String());
    BookAuthor author = new BookAuthor(new String());
    BookGenre genre = new BookGenre(new String());

    /**
     * Create a new Book using the following attributes
     *
     * @param title - the title of the chosen book
     * @param author - the Author who wrote the book
     * @param genre - the genre by which the book is categorized
     *
     */
    public Book(BookTitle title, BookAuthor author, BookGenre genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
    
    /**
     * Set the title for the book
     * @param title the name of the book
    */
    public void setTitle(BookTitle title){
        this.title = title;
    }
    
    /**
     * Set the value of author to the value given 
     * @param author the desired name of the author of the book
     */
    public void setAuthor(BookAuthor author){
        this.author = author;
    }
    
    /**
     * Set the value of genre to the value given 
     * @param genre the desired category for the book
     */
    public void setGenre(BookGenre genre){
        this.genre = genre;
    }
    
     /**
     * retrieve the name of the book
     * @return a String
    */
    public String getTitle(){
        return title.getTitle();
    }
    
    /**
     * retrieve the name of the author
     * @return a String
    */
    public String getAuthor(){
        return author.getAuthor();
    }
    
    /**
     * retrieve the genre by which the book is categorized
     * @return a String
    */
    public String getGenre(){
        return genre.getGenre();
    }
}

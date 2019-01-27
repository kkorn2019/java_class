package edu.KaylaKornelis.advancedjava.Assignment1;

public class Book{

    public static void main(String[] args){
        Book book = new Book("Effective Java", "Joshua Bloch", "Textbook");
        System.out.println("Your book is \"" + book.getTitle() + "\" by " + book.getAuthor() + ". The genre is \"" + book.getGenre() + "\".");
    }

    //Attributes of a Book
    private String title;
    private String author;
    private String genre;

    /**
     * Create a new Book using the following attributes
     *
     * @param title - the title of the chosen book
     * @param author - the name of the Author who wrote the book
     * @param genre - the genre the book is categorized by
     *
     */
    public Book(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getGenre(){
        return genre;
    }
}

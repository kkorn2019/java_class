package Assignment1;

public class Book{

    //Attributes of a Book
    private String title;
    private String author;
    private String genre;

    /**
     * Create a new Book using the following attributes
     *
     * @param Title - the title of the chosen book
     * @param Author - the name of the Author who wrote the book
     * @param Genre - the genre the book is categorized by
     *
     */
    Book(String title, String author, String genre){
        this.title = title;
        this.author = author;
        this.genre = genre;
    }
}

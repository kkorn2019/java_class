package edu.KaylaKornelis.advancedjava.Assignment1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit tests for the Book class
 *
 * @author Kayla Kornelis
 */
public class BookTest {
    private Book book;
    private String title;
    private String author;
    private String genre;


    @Before
    public void setup() {
        book = new Book("Effective Java", "Joshua Bloch", "Textbook");
    }

    @Test
    public void bookTitleSetCorrectly(){
        title = book.getTitle();
        assertEquals(title, "Effective Java");
    }

    @Test
    public void bookAuthorSetCorrectly(){
        author = book.getAuthor();
        assertEquals(author, "Joshua Bloch");
    }

    @Test
    public void bookGenreSetCorrectly(){
        genre = book.getGenre();
        assertEquals(genre, "Textbook");
    }

    @Test
    public void setBookTitleManually(){
        book.setTitle("Introduction to Java");
        title = book.getTitle();
        assertEquals(title, "Introduction to Java");
    }

    @Test
    public void setBookAuthorManually(){
        book.setAuthor("Spencer Marks");
        author = book.getAuthor();
        assertEquals(author, "Spencer Marks");
    }

    @Test
    public void setBookGenreManually(){
        book.setGenre("Reference");
        genre = book.getGenre();
        assertEquals(genre, "Reference");
    }
}

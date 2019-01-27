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
        Book book = new Book("Introduction to Java", "Spencer Marks", "Textbook");
    }

    @Test
    public void bookTitleSetCorrectly(){
        String title = book.getTitle();
        assertEquals(title, "Introduction to Java");
    }

    @Test
    public void bookAuthorSetCorrectly(){
        author = book.getAuthor();
        assertEquals(author, "Spencer Marks");
    }

    @Test
    public void bookGenreSetCorrectly(){
        genre = book.getGenre();
        assertEquals(genre, "Textbook");
    }

    @Test
    public void setBookTitleManually(){
        book.setTitle("Advanced Java");
        assertEquals(title, "Advanced Java");
    }

    @Test
    public void setBookAuthorManually(){
        book.setAuthor("Joshua Bloch");
        assertEquals(author, "Joshua Bloch");
    }

    @Test
    public void setBookGenreManually(){
        book.setGenre("Reference");
        assertEquals(genre, "Reference");
    }
}

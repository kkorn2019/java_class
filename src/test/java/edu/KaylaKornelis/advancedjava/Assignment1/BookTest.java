package edu.KaylaKornelis.advancedjava.Assignment1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * JUnit tests for the Book class
 */
public class BookTest {
    Book book;
    BookTitle title = new BookTitle("Effective Java");
    BookAuthor author = new BookAuthor("Joshua Bloch");
    BookGenre genre = new BookGenre("Textbook");
  
    @Before
    public void setup() { 
        book = new Book(title, author, genre);
    }

    @Test
    public void bookTitleSetCorrectly(){
        String stringTitle = book.getTitle();
        assertEquals("The book title was set correctly through constructor", stringTitle, "Effective Java");
    }
    
    @Test
    public void bookTitleNotAsExpected(){
        String stringTitle = book.getTitle();
        assertFalse("The book title does not match what was expected", stringTitle.equals("Introduction to Java"));
    }

    @Test
    public void bookAuthorSetCorrectly(){
        String stringAuthor = book.getAuthor();
        assertEquals("The book author was set correctly through constructor", stringAuthor, "Joshua Bloch");
    }
    
    @Test
    public void bookAuthorNotAsExpected(){
        String stringAuthor = book.getAuthor();
        assertFalse("The book author does not match what was expected", stringAuthor.equals("John Doe"));
    }

    @Test
    public void bookGenreSetCorrectly(){
        String stringGenre = book.getGenre();
        assertEquals("The book genre was set correctly through constructor", stringGenre, "Textbook");
    }
    
    @Test
    public void bookGenreNotAsExpected(){
        String stringGenre = book.getGenre();
        assertFalse("The book genre does not match what was exected", stringGenre.equals("Reference"));
    }

    @Test
    public void setBookTitleManually(){
        title.setTitle("Introduction to Java");
        String titleTest = book.getTitle();
        assertEquals("The book title was set correctly through setTitle method", titleTest, "Introduction to Java");
    }

    @Test
    public void setBookAuthorManually(){
        author.setAuthor("John Doe");
        String authorTest = book.getAuthor();
        assertEquals("The book author was set correctly through setAuthor method", authorTest, "John Doe");
    }

    @Test
    public void setBookGenreManually(){
        genre.setGenre("Reference");
        String genreTest = book.getGenre();
        assertEquals("The book genre was set correctly through setGenre method", genreTest, "Reference");
    }
    
}

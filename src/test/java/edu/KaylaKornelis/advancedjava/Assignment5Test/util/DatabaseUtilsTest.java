package edu.KaylaKornelis.advancedjava.Assignment5Test.util;

import edu.KaylaKornelis.advancedjava.Assignment5.util.DatabaseInitializationException;
import edu.KaylaKornelis.advancedjava.Assignment5.util.DatabaseUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 *  Tests for the DatabaseUtils class
 */
public class DatabaseUtilsTest {

    /**
     * Test that can successfully create a connection to the database
     * @throws Exception 
     */
    @Test
    public void testGetConnection() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection", connection);
    }

    /**
     * Test that can successfully create a connection to the database and retrieve 
     * stock quotes through execution of a statement
     * @throws Exception 
     */
    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from quotes");
        assertTrue("verify that we can execute a statement",execute);
    }
    
    /**
     * Test that we can successfully initialize the database with given data file
     * @throws Exception 
     */
    @Test
    public void testDatabaseInitializationSuccess() throws Exception{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }
    
    /**
     * Test that we receive a DatabaseInitializationException  when a known invalid
     * file name is passed to the initializeDatabase method
     * @throws Exception 
     */
    @Test (expected = DatabaseInitializationException.class)
    public void testDatabaseInitializationFailure() throws Exception{
        DatabaseUtils.initializeDatabase("some string");
    }
}

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

    @Test
    public void testGetConnection() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        assertNotNull("verify that we can get a connection", connection);
    }

    @Test
    public void testGetConnectionWorks() throws Exception{
        Connection connection = DatabaseUtils.getConnection();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("select * from quotes");
        assertTrue("verify that we can execute a statement",execute);
    }
    
    @Test
    public void testDatabaseInitializationSuccess() throws Exception{
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }
    
    @Test (expected = DatabaseInitializationException.class)
    public void testDatabaseInitializationFailure() throws Exception{
        DatabaseUtils.initializeDatabase("some string");
    }
}

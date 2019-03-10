package edu.KaylaKornelis.advancedjava.Assignment7Test.App;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.Quotes;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseConnectionException;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment7.App.JAXBApp;
import static edu.KaylaKornelis.advancedjava.Assignment7.App.JAXBApp.convertBigDecimalToString;
import static edu.KaylaKornelis.advancedjava.Assignment7.App.JAXBApp.convertTimestampToString;
import edu.KaylaKornelis.advancedjava.Assignment7.Xml.Stocks;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * Tests for JAXBApp
 */

public class JAXBAppTest {
    
    private JAXBApp jaxbApp;
    private DatabaseUtils databaseUtilsMock;
    
    private static final String xmlStocksTest =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<stocks>\n" +
            "    <stock symbol=\"TST1\" price=\"101.10\" time=\"2001-01-01 01:01:01\"></stock>\n" +
            "    <stock symbol=\"TST2\" price=\"202.20\" time=\"2002-02-02 02:02:02\"></stock>\n" +
            "    <stock symbol=\"TST3\" price=\"303.30\" time=\"2003-03-03 03:03:03\"></stock>\n" +
            "    <stock symbol=\"TST4\" price=\"404.40\" time=\"2004-04-04 04:04:04\"></stock>\n" +
            "    <stock symbol=\"TST5\" price=\"505.50\" time=\"2005-05-05 05:05:05\"></stock>\n" +
            "</stocks>";
    

    @Before
    public void setUp() {
        databaseUtilsMock = mock(DatabaseUtils.class);
    }
    
    /**
     * This method tests that the JAXBApp constructor works correctly
     */
    @Test
    public void testValidConstruction() {
        jaxbApp = new JAXBApp(databaseUtilsMock);
        assertNotNull("Basic construction works", jaxbApp);
    }
    
    /**
     * This method tests that a database connection can be created with a 
     * mocked DatabaseUtils instance
     * @throws DatabaseConnectionException 
     */
    @Test
    public void testDatabaseConnectionCreated() throws DatabaseConnectionException{
        Connection connection = databaseUtilsMock.getConnection();
        assertNotNull(connection);
    }
    
    /**
     * This method tests that stocks can successfully be added to the mocked database
     * @throws JAXBException
     * @throws DatabaseConnectionException 
     */
    @Test
    public void testAddStocksToDatabase() throws JAXBException, DatabaseConnectionException{
        String queryTest = "";
        String queryExpected = "INSERT INTO quotes (symbol,time,price) VALUES ('TST1','2001-01-01 01:01:01','101.10');";
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlStocksTest));
        
        Connection connection = null;
        try {
            connection = databaseUtilsMock.getConnection();
        
            Statement statement = connection.createStatement();
            StringBuilder stringBuilder = new StringBuilder();
            
            Quotes quotes = new Quotes(stocks.getStock().get(0));
            stringBuilder.append("INSERT INTO quotes (symbol,time,price) VALUES ('")
                        .append(quotes.getSymbol())
                        .append("','")
                        .append(convertTimestampToString(quotes.getTime()))
                        .append("','")
                        .append(convertBigDecimalToString(quotes.getPrice()))
                        .append("');");
            
            //insert each quote into the database
            statement.executeUpdate(stringBuilder.toString());   
            queryTest = stringBuilder.toString();
            
        }catch (Exception ex) {
            throw new  DatabaseConnectionException("Could not connect to database." + ex.getMessage(), ex);
        }
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, byteArrayOutputStream);
        String xmlResult = byteArrayOutputStream.toString();
        
        assertEquals("XML out is correct", xmlResult.trim(), xmlStocksTest.trim());
        assertEquals("Query is correct", queryExpected, queryTest);
    }
    
    /**
     * This method tests that a value of type Timestamp can be converted to a String
     * with the convertTimestampToString in the JAXBApp class
     * @throws JAXBException 
     */
    @Test 
    public void testConvertTimestampToString() throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlStocksTest));
        Quotes quotes = new Quotes(stocks.getStock().get(0));
        
        Timestamp timestampTest = quotes.getTime();
        
        String convertedTime = JAXBApp.convertTimestampToString(timestampTest);
        String expectedTime = "2001-01-01 01:01:01";
       
        assertEquals("Verify Timestamp to String conversion", convertedTime, expectedTime);
    }
    
    /**
     * This method tests that a value of type BigDecimal can be converted to a String
     * with the convertBigDecimalToString in the JAXBApp class
     * @throws JAXBException 
     */
    @Test
    public void TestConvertBigDecimalToString() throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlStocksTest));
        Quotes quotes = new Quotes(stocks.getStock().get(0));
        
        BigDecimal bigDecimalTest = quotes.getPrice();
        
        String convertedPrice = JAXBApp.convertBigDecimalToString(bigDecimalTest);
        String expectedPrice = "101.10";
       
        assertEquals("Verify BigDecimal to String conversion", convertedPrice, expectedPrice);
    }

}

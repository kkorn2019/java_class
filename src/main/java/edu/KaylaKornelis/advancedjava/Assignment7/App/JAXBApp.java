package edu.KaylaKornelis.advancedjava.Assignment7.App;

import edu.KaylaKornelis.advancedjava.Assignment6.model.database.Quotes;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseConnectionException;
import edu.KaylaKornelis.advancedjava.Assignment6.util.DatabaseUtils;
import edu.KaylaKornelis.advancedjava.Assignment7.Xml.Stocks;
import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * A basic app that shows how to marshall and unmarshall XML instances.
 */
public class JAXBApp {
    
    private final DatabaseUtils databaseUtils;
    
    /**
     * Create a new Application.
     *
     * @param databaseUtils the database instance to be used 
     */
    public JAXBApp(DatabaseUtils databaseUtils){
        this.databaseUtils = databaseUtils;
    }

    private static String xmlFilePath = "./src/main/resources/xml/stock_info.xml";
    private static String xmlStocks =
            "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<stocks>\n" +
            "    <stock symbol=\"VNET\" price=\"110.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"AGTK\" price=\"120.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"AKAM\" price=\"3.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"AOL\" price=\"30.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"BCOM\" price=\"10.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"BIDU\" price=\"10.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"BCOR\" price=\"12.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"WIFI\" price=\"16.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"BRNW\" price=\"0.70\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CARB\" price=\"9.80\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"JRJC\" price=\"111.11\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CCIH\" price=\"22.20\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CHIC\" price=\"4.30\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CNV\" price=\"13.43\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CCOI\" price=\"1.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CNCG\" price=\".10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CXDO\" price=\"90.00\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"CRWG\" price=\"52.99\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"ELNK\" price=\"45.40\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"EATR\" price=\"15.60\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"EDXC\" price=\"18.40\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"ENV\" price=\"220.61\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"EPAZ\" price=\"101.11\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"FB\" price=\"500.17\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"FDIT\" price=\"160.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"FLPC\" price=\"177.70\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"GCLT\" price=\"8.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"GOOG\" price=\"700.10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"GOOG\" price=\".10\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"GREZ\" price=\"77.91\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"IACI\" price=\"40.52\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"ICOA\" price=\"48.30\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"IIJI\" price=\"32.80\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"ILIA\" price=\"188.22\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"INAP\" price=\"2.12\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"IPAS\" price=\"1.02\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"JCOM\" price=\"19.99\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"LOGL\" price=\"18.21\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"LLNW\" price=\"45.55\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"LOOK\" price=\"38.90\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"MEET\" price=\"21.27\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"MEET\" price=\"310.31\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"VOIS\" price=\"440.51\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"MOMO\" price=\"8.51\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"NETE\" price=\"13.16\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"NTES\" price=\"14.23\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"EGOV\" price=\"17.35\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"NQ\" price=\"110.77\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "    <stock symbol=\"OTOW\" price=\"60.41\" time=\"2015-02-10 00:00:01\"></stock>\n" +
            "</stocks>";


    /**
     * Run the JAXB application.
     * <p/>
     *
     * @param args potentially contains a list of arguments to be used in the application
     * -- empty for this particular application
     */
    public static void main(String[] args) throws JAXBException, SQLException, Exception {

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new File(xmlFilePath));
        
        //Create database connection
        Connection connection = null;
        try {
            connection = DatabaseUtils.getConnection();
        
        Statement statement = connection.createStatement();
            
        //loop through each stock in the list of stocks returned from the unmarshaller

        for (int i = 0; i < stocks.getStock().size(); i++){
            Quotes quotes = new Quotes(stocks.getStock().get(i));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO quotes (symbol,time,price) VALUES ('")
                       .append(quotes.getSymbol())
                       .append("','")
                       .append(convertTimestampToString(quotes.getTime()))
                       .append("','")
                       .append(convertBigDecimalToString(quotes.getPrice()))
                       .append("');");
            
            //insert each quote into the database
            statement.executeUpdate(stringBuilder.toString());    
        }
        
        } catch (Exception ex) {
            throw new  DatabaseConnectionException("Could not connect to database." + ex.getMessage(), ex);
        }
        
        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);

    }
    
    /**
     * Helper method to convert dates of type Timestamp into String
     * @param dateEntered
     * @return  convertedDate
     */
    public static String convertTimestampToString(Timestamp dateEntered){
        /**
         * Create a new instance of SimpleDateFormat that will be used to 
         * parse the string arguments to obtain desired start and end dates
         */
        Date inputDate = dateEntered;
        SimpleDateFormat simpleDateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String convertedDate = simpleDateFormatter.format(inputDate);
            
        return convertedDate;
    }
    
    /**
     * Helper method to convert prices of type Big Decimal into String
     * @param priceEntered
     * @return convertedPrice
     */
    public static String convertBigDecimalToString(BigDecimal priceEntered){
        
        String convertedPrice = priceEntered.toString();
        
        return convertedPrice;
    }
}

package edu.KaylaKornelis.advancedjava.Assignment7.App;

import edu.KaylaKornelis.advancedjava.Assignment7.Xml.Stocks;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * A basic app that shows how to marshall and unmarshall XML instances.
 */
public class JAXBApp {

    private static String xmlInstance =
            "<stocks>\n" +
            "    <stock symbol=\"WIFI\" price=\"16.10\" time=\"2015-02-10 00:00:01\">stock1</stock>\n" +
            "</stocks>";


    public static void main(String[] args) throws JAXBException {

        // here is how to go from XML to Java
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(xmlInstance));
        System.out.println(stocks.toString());

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);

    }
}

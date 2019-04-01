package hello;

import edu.KaylaKornelis.advancedjava.Assignment9.model.StockQuote;
import java.math.BigDecimal;
import java.util.Calendar;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public StockQuote getStockQuote() {
        return new StockQuote(new BigDecimal(100), Calendar.getInstance().getTime(), "GOOG");
    }
    
}

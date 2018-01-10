package chap12.stock;

import org.junit.Test;

public class StockInfoServiceTest {
    @Test
    public void testReadFeedFile(){

        StockInfoService service = new StockInfoService();

        service.readFeedFile("stockfeed.csv");
    }
}

package chap12.stock;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StockInfoService {

    private Map<String,Map<Date,StockInfo>> companyStockInfo;

    public void readFeedFile(String csvFile) {

        SimpleDateFormat datetimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try (Stream<String> stream = Files.lines(Paths.get(csvFile))) {

            Object o = stream.map(line -> {

                try {

                    String[] fields = line.split(",");

                    String symbol = fields[0];
                    Date timestamp = datetimeFormat.parse(fields[1]);
                    Double price = Double.parseDouble(fields[2]);

                    Date day = dateFormat.parse(dateFormat.format(timestamp));

                    if(companyStockInfo.containsKey(symbol)){

                        Map<Date,StockInfo> dailyStockInfo = companyStockInfo.get(symbol);

                        if(dailyStockInfo.containsKey(day)){

                            StockInfo stockInfo = dailyStockInfo.get(day);
                            //update stockInfo
                            if(price > stockInfo.getHigh()){
                                stockInfo.setHigh(price);
                            }
                            if(price < stockInfo.getLow()){
                                stockInfo.setLow(price);
                            }
                            stockInfo.setClose(price);

                        } else {

                            double open = price;
                            double high = price;
                            double low = price;
                            double close = price;

                            StockInfo stockInfo = new StockInfo(open,high,low,close);
                            dailyStockInfo.put(day, stockInfo);
                        }
                    } else {
                        Map<Date,StockInfo> dailyStockInfo = new HashMap<Date, StockInfo>();
                        companyStockInfo.put(symbol, dailyStockInfo);

                        double open = price;
                        double high = price;
                        double low = price;
                        double close = price;

                        StockInfo stockInfo = new StockInfo(open,high,low,close);
                        dailyStockInfo.put(day, stockInfo);
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return companyStockInfo;

            });

            System.out.println(o);
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}

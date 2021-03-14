package org.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Utilities method for Stock info such as price, etc.
 */

public class StockUtility {

    /**
     * Returns price of a Stock given a ticker
     * @param ticker string value of ticker
     * @return current price of Stock
     */

    public static double getCurrentPriceOfStock(String ticker) {

        double price = 0;
        try {
            Stock stock = YahooFinance.get(ticker);
            price = stock.getQuote().getPrice().doubleValue();
        } catch(IOException e) {
            throw new RuntimeException("Stock data could not be retrieved.");
        } catch(NullPointerException e){
            return 0; // indicates that the stock does not exist
        }
        return price;


    }

}

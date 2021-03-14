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

    public static BigDecimal getCurrentPriceOfStock(String ticker) {
        Stock stock = null;
        try {
            stock = YahooFinance.get(ticker);
        } catch(IOException e) {
            throw new RuntimeException("Stock could not be retrieved.");
        }
        return stock.getQuote().getPrice();

    }

}

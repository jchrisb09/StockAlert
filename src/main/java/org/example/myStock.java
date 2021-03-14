package org.example;

import java.math.BigDecimal;

public class myStock {
    private String ticker;
    private BigDecimal price;

    /**
     * Create myStock object with ticker, price and number of shares
     * @param ticker string for myStock
     * @param price represents price of myStock
     * @param shares number of shares
     */

    public myStock(String ticker, BigDecimal price, int shares) {
        this.ticker = ticker;
        this.price = price;
        this.shares = shares;
    }

    private int shares;


    public myStock(String gme) {
    }

    /**
     * Construct a Stock object with a ticker
     * @param ticker ticker as a string
     */
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }
}

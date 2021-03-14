package org.example;

import java.math.BigDecimal;
import java.util.Objects;

public class myStock {
    private String ticker;
    private double price;
    private int shares;

    public myStock() {
    }
    /**
     * Create myStock object with ticker, price and number of shares
     * @param ticker string for myStock
     * @param price represents price of myStock
     * @param shares number of shares
     */

    public myStock(String ticker, double price, int shares) {
        this.ticker = ticker;
        this.price = price;
        this.shares = shares;
    }

    /**
     * Construct a Stock object with a ticker
     */
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    /**
     * Return the current value (price * shares) of the stock
     * @return value of investment
     */

    public double getTotalValue() {
        return shares * price;
    }

    /**
     * Return string representation of stock which is "price:shares"
     * @return string representation of stock
     */

    @Override
    public String toString() {
        return ticker + ":" + shares;
    }

    /**
     * Equality is based on ticker
     * @param o any object
     * @return true if ticker is equal
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myStock mystock = (myStock) o;
        return ticker.equals(mystock.ticker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticker);
    }
}

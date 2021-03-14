package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Represents the user of the app
 * The user will be able to
 * 1. View current price of a Stock
 * 2. View portfolio.txt and get current value
 * 3. Add to portfolio.txt
 * 4. Remove from portfolio.txt
 * 5. Save portfolio.txt
 */
public class User {
    // design error! multiple users should not share same text file!!!
    private static String PORTFOLIO_FILE = "portfolio.txt";
    private Portfolio portfolio = new Portfolio();

    /**
     * When a User is instantiated, the portfolio.txt is loaded from a text file
     */
    public User() {
        if(!isPortfolioEmpty()) loadPortfolio();
    }

    /**
     * Returns true if the "portfolio.txt.txt" file is empty
     *
     * @return true if empty, false otherwise
     */
    public boolean isPortfolioEmpty() {
        String str = "";
        try {
            str = FileUtils.readFileToString(new File(PORTFOLIO_FILE), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("can't read portfolio.txt file");
        }
        return str.equals("") ? true : false;
    }

    /**
     * Loads stocks from the "portfolio.txt.txt" file
     * The file "portfolio.txt.txt" simply displays the ticker the number of shares in
     * this format
     * <p>
     * TICKER:NUM_SHARES,TICKER:NUM_SHARES,TICKER:NUM_SHARES
     * <p>
     * TODO: probably update to use JSON or XML
     */
    public void loadPortfolio() {
        String line = "";
        try {
            line = FileUtils.readFileToString(new File(PORTFOLIO_FILE), "UTF-8");
        } catch (IOException e) {
            throw new RuntimeException("unable to read portfolio.txt read");
        }
        String[] array = line.split(",");
        for (int i = 0; i < array.length; i++) {
            String ticker = array[i].split(":")[0];
            int shares = Integer.parseInt(array[i].split(":")[1]);
            double price = StockUtility.getCurrentPriceOfStock(ticker);
            myStock mystock = new myStock(ticker, price, shares);
            portfolio.add(mystock);
        }
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    /**
     * THIS METHOD WILL BE TESTED MANUALLY
     * Given a ticker, print out the price of the Stonk
     * @param ticker Ticker of the Stonk
     */
    public void printStockPrice(String ticker) {
        double price = StockUtility.getCurrentPriceOfStock(ticker);
        System.out.println(price);
    }

    /**
     * print out instructions for the user
     */
    public void showMenu() {
        System.out.println("1. Get price of individual stock");
        System.out.println("2. Get price of portfolio.txt");
        System.out.println("3. Add stock to portfolio.txt");
        System.out.println("4. Remove stock from portfolio.txt");
    }

    /**
     * Save the portfolio.txt of the user to the text file "portfolio.txt.txt"
     * in the following format:  GME:100,AMC:100,NOK:100
     */
    public void savePortfolio() {
        try {
            this.getPortfolio().saveToDisk(User.PORTFOLIO_FILE);
        } catch(IOException e) {
            throw new RuntimeException("sorry can't save to file");
        }
    }

    /**
     * Adds a stock to the portfolio.txt
     */
    public void addStockToPortfolio() {



    }
}

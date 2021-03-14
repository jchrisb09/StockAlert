package org.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of myStocks. You can retrieve the total value of the portfolio.txt and save to disk
 */


public class Portfolio {
    /**
     * Class that represents the portfolio.txt of stocks
     */
    private List<myStock> myStocks;
    /**
     * Need default constructor for serialization
     */
    public Portfolio() {
        this.myStocks = new ArrayList<myStock>();
    }

    /**
     * Add a myStock to portfolio.txt
     * @param mystock myStock to be added
     */

    public void add(myStock mystock) {
        myStocks.add(mystock);
    }

    public double getTotalValue() {
        double total = 0;
        for (int i = 0; i < myStocks.size(); i++) {
            total+= myStocks.get(i).getPrice() * myStocks.get(i).getShares();
        }
        return total;
    }
    /**
     * Returns the size of the portfolio.txt inventory
     * @Return size of portfolio.txt inventory
     */
    public int getSize() {
        return myStocks.size();
    }

    /**
     * Updates the portfolio.txt with the latest price of each stock
     */
    public void update() {
        for (int i = 0; i < myStocks.size(); i++) {
            myStock current = myStocks.get(i);
            current.setPrice(StockUtility.getCurrentPriceOfStock(current.getTicker()));
        }
    }

    /**
     * Removes stock from portfolio.txt
     * @param mystock mystock to be removed
     * @throws IOException
     */

    public void remove(myStock mystock) {
        myStocks.remove(mystock);
    }

    /**
     * Wries the portfolio.txt as a string to file
     * @param filename file to write to the portfolio.txt
     * @throws IOException
     */

    public void saveToDisk(String filename) throws IOException {
        FileUtils.writeStringToFile(new File(filename), this.toString(), "UTF-8");
    }

    @Override
    public String toString() {
        String line = "";
        for (int i = 0; i < myStocks.size(); i++) {
            if (i == myStocks.size() -1) {
                String entry = myStocks.get(i).getTicker() + ":" + myStocks.get(i).getShares();
                line += entry;
            } else {
                String entry = myStocks.get(i).getTicker() + ":" + myStocks.get(i).getShares() + ",";
                line += entry;
            }
        }
        return line;
    }
}

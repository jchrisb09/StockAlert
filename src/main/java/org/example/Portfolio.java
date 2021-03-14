package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of myStocks. You can retrieve the total value of the portfolio and save to disk
 */


public class Portfolio {

    private List<myStock> myStocks;

    public Portfolio() {
        this.myStocks = new ArrayList<myStock>();
    }

    /**
     * Add a myStock to portfolio
     * @param mystock myStock to be added
     */

    public void add(myStock mystock) {
        myStocks.add(mystock);
    }

    public BigDecimal getTotalValue() {
        BigDecimal total = new BigDecimal("0");
        for (int i = 0; i < myStocks.size(); i++) {
         //   total = total.add(myStocks.get(i).getPrice().multiply(myStocks.get(i).getShares()));
        }
        return null;
    }
    /**
     * Returns the size of the portfolio inventory
     * @Return size of portfolio inventory
     */
    public int getSize() {
        return myStocks.size();
    }
}

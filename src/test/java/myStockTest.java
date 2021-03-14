package org.example;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class myStockTest {

    @Test
    public void testStock() {
        myStock gamespot = new myStock();
        Assert.assertNotNull(gamespot);
        myStock gme = new myStock("GME", 49.99, 20);
        Assert.assertEquals("GME", gme.getTicker());
        Assert.assertEquals(49.99, gme.getPrice(), 0);
        Assert.assertEquals(20, gme.getShares());
    }

    @Test
    public void testStockPrice() {
        String ticker = "GME";
        double price = StockUtility.getCurrentPriceOfStock(ticker);
        Assert.assertTrue(price > 0);
        System.out.println(price);
    }

    @Test
    public void testStockValue() {
        myStock gme = new myStock("GME", 800, 20);   // arrange
        double total = gme.getTotalValue();   //  act
        Assert.assertEquals(16000, total, 0.1);  // assert
    }

    @Test
    public void testStockWriting() throws IOException {
        myStock gme = new myStock("GME", 49.99, 20);
        String str = gme.toString();  // should be "GME:20"
        FileUtils.writeStringToFile(new File("gme.txt"), str, "UTF-8");
        String str2 = FileUtils.readFileToString(new File("gme.txt"),"UTF-8");
        Assert.assertEquals(str,str2);
    }


}

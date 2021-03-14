package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class StockUtilityTest {
    /**
     * Test stock retrieval based on ticket
     */
    @Test
    public void testStockPrice() throws IOException {
        myStock s = new myStock("GME");
        BigDecimal currentPrice = StockUtility.getCurrentPriceOfStock(s.getTicker());
        Assert.assertTrue(currentPrice.floatValue() > 0);
    }
}

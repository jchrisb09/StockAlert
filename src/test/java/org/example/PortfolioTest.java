package org.example;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PortfolioTest {

    private Portfolio p;
    private myStock gme;
    private myStock nok;

    @Before
    public void setUp() {
        p = new Portfolio();
        gme = new myStock("GME", 50, 20);
        nok = new myStock("NOK", 5, 100);
        p.add(gme);
        p.add(nok);
    }

    @Test
    public void testSaveToDisk() throws IOException {
        p.add(new myStock("TSLA",100,2));
        p.add(new myStock("BB",10,200));
        p.saveToDisk("temp.txt");
        String str = FileUtils.readFileToString(new File("temp.txt"),"UTF-8");
        Assert.assertTrue(str.equals(p.toString()));
    }

    @Test
    public void testEmptyPortfolio() {
        Portfolio portfolio = new Portfolio();
        Assert.assertNotNull(portfolio);
    }

    @Test
    public void testAddStonk() {
        Assert.assertEquals(2, p.getSize());
    }

    @Test
    public void testRemoveStonk() {
        p.remove(new myStock("GME", 200, 1));
        p.remove(new myStock("NOK", 10, 2));
        Assert.assertEquals(0, p.getSize());
    }

    @Test
    public void testUpdatePortfolio() {
        p.update();
        double totalValue = p.getTotalValue();
        Assert.assertTrue( totalValue > 0 );
    }

    /**
     * Test portfolio.txt value with fixed amount
     */
    @Test
    public void testTotalValue() {
        gme.setPrice(150);
        nok.setPrice(15);
        myStock tesla = new myStock("TSLA",800, 2);
        p.add(tesla);
        double total = (150 * 20) + (15 * 100) + (800 * 2);
        Assert.assertEquals(total, p.getTotalValue(), 0.1);
    }


}

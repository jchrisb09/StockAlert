package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Unit test for a simple stock market alert app.
 */
public class PortfolioTest
{
    private Portfolio portfolio;

    /**
     * Test to calculate value of portfolio
     */
    @Before
    public void portfolioSetup() {
        // tracking BB, NOK, GME, AMC
        // budget of about $1000, purchased March 10th

        myStock bb = new myStock("BB", new BigDecimal("13.10"), 15);
        myStock nok = new myStock("NOK", new BigDecimal("4.17"), 35);
        myStock gme = new myStock("GME", new BigDecimal("51.20"), 10);
        myStock amc = new myStock("AMC", new BigDecimal("5.80"), 30);
        Portfolio portfolio = new Portfolio();
        portfolio.add(bb);
        portfolio.add(nok);
        portfolio.add(gme);
        portfolio.add(amc);
        // (13.1 * 15) + (4.17 * 35) + (51.2 * 10) + (5.8 * 30) = 1028.45
    }
    @Test
    public void testSizeOfPortfolio() {
        Assert.assertEquals(4, portfolio.getSize());
    }

    /**
     * Test to calculate the value of the portfolio
     */
    @Test
    public void testValueOfPortfolio() {

    }
}

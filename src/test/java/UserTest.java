package org.example;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void testUserPortfolio() {
        User user = new User();
        Assert.assertNotNull(user);
        boolean isEmpty = user.isPortfolioEmpty();
        Assert.assertEquals(false, isEmpty);
        user.loadPortfolio();
        Assert.assertEquals(3, user.getPortfolio().getSize());
    }

    @Test
    public void testSavePortfolio() {
        User user = new User();
        Portfolio p = user.getPortfolio();
        p.add(new myStock("GME",50,100));
        p.add(new myStock("AMC",10,100));
        p.add(new myStock("NOK",5,100));
        user.savePortfolio();

    }
}

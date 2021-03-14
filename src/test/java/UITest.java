package org.example;

import org.junit.*;

public class UITest {

    private myStock gme = null;

    @BeforeClass
    public static void createUI() {
        System.out.println("Creating UI");
    }

    @Before
    public void setUp() {
        gme = new myStock("GME", 49.99, 20);
    }

    @Test
    public void test1() {
        gme.setPrice(200);
        System.out.println(gme.getPrice());
    }

    @Test
    public void test2() {
        System.out.println(gme.getPrice());
    }

    @After
    public void cleanUp() {
        System.out.println("Cleaning Up!");
    }

    @AfterClass
    public static void disposeUI() {
        System.out.println("Disposing UI");
    }
}


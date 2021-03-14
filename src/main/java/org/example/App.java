package org.example;

import java.util.Scanner;

/**
 * Stock Project - a simple app to keep track of your stock portfolio and receive email alerts
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println("Welcome to the Stock Portfolio Tracker!");
        System.out.println("What would you like to do?");
        System.out.println("1. Check price of a stock");

        Scanner keyboard = new Scanner(System.in);
        String choice = keyboard.nextLine();

        if(choice.equals("1"))  {
            System.out.println("Enter ticker");
            String ticker = keyboard.nextLine();
            System.out.println(StockUtility.getCurrentPriceOfStock(ticker));
        }
    }
}

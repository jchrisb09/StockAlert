package org.example;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Stock Project - a simple app to keep track of your stock portfolio.txt and receive email alerts
 *
 */
public class App {
    public static void main(String[] args) throws Exception {

        // ask for user for a ticker and print out the price
        User Person = new User();
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            Person.showMenu();
            String answer = keyboard.nextLine();
            if (answer.equals("1")) {
                System.out.println("Please enter ticker: ");
                String ticker = keyboard.nextLine();
                Person.printStockPrice(ticker);
            }
            if (answer.equals("2")) {
                // print out portfolio.txt's total value
                double totalValue = Person.getPortfolio().getTotalValue();
                System.out.println(Person.getPortfolio());
                System.out.println("The value of your portfolio.txt is: " + totalValue);
            }

        }
    }
}
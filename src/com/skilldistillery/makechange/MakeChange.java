package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChange {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		double price = 0.0;
		double tender = 0.0;

		System.out.println("Welcome to the Money Sink! " 
					  + "Where we don't judge you for blowing all that moola, Baby!");

		// gets price of goods from user
		price = getMoneyInput("Enter the total price of the goods being purchased: ");

		// gets amount user is paying with
		tender = getMoneyInput("Enter the total amount you are paying with: ");

		// loops until the tender amount is greater or equal to the amount due
		while (!(tender >= price)) {

			System.out.println("Sorry, thats not enough money. Please try again");
			tender = getMoneyInput("Enter the total amount you are paying with: ");

		}
		// prints change
		printChange(price, tender);
		return;

	}

	// methods

	// gets user input for currency values and error checks
	public static double getMoneyInput(String prompt) {
		System.out.println(prompt);
		double cheddar = -1.0;

		// loops until a numeric value is entered
		while (true) {

			try {

				cheddar = kb.nextDouble();

				// checks if values entered are negative
				// if true, restarts loop
				if (cheddar < 0) {

					System.out.println("Not a Positive value. Please try again: ");

					kb.nextLine(); // refreshes the scanner
					continue; // restarts loop

				}

				break; // should only execute if input is valid. breaks loop

			} catch (InputMismatchException e) {

				System.out.println("Not a numeric value. Please try again: ");
				kb.nextLine(); // refreshes the scanner
				continue; // restarts loop
			}

		}

		return cheddar;

	}

	public static void printChange(double price, double tender) {

		double change = tender - price; // gets change
		int bills = (int) change; // gets change in dollars

		double tempCoins = change - bills; // gets change in coins
		int coins = (int) Math.round((tempCoins * 100));// rounds coins for precision and makes them ints

		System.out.println("****************************************");
		System.out.println("*                                      *");
		System.out.printf("*   paying with:    $ %6.2f%11s*%n", tender, "");
		System.out.println("*                                      *");
		System.out.printf("*   Total due:      $ %6.2f%11s*%n", price, "");
		System.out.println("*                 ___________          *");
		System.out.println("*                                      *");
		System.out.printf("*   Change back:    $ %6.2f%11s*%n", change, "");
		System.out.println("*                                      *");
		bills = printChangeString("$20 bills :", bills, 20);
		bills = printChangeString("$10 bills :", bills, 10);
		bills = printChangeString("$5 bills :", bills, 5);
		bills = printChangeString("$1 bills :", bills, 1);
		coins = printChangeString("Quarters :", coins, 25);
		coins = printChangeString("Dimes :", coins, 10);
		coins = printChangeString("Nickels :", coins, 5);
		coins = printChangeString("Pennies :", coins, 1);
		System.out.println("*                                      *");
		System.out.println("*     Thank you, Have a great Day!     *");
		System.out.println("*                                      *");
		System.out.println("****************************************");

	}

	// takes in change, finds number of multiples of a specific bill or coin
	// if there are multiples, prints out how many. then returns the remaining
	// change.
	public static int printChangeString(String changeType, int change, int multiple) {

		int numOfMultiple = change / multiple;

		if (numOfMultiple > 0) {
			System.out.printf("*   Number of %-16s%3d      *%n", changeType, numOfMultiple);
		}
		return change % multiple;
	}

}

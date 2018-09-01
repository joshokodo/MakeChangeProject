package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChange {

	static Scanner kb = new Scanner(System.in);

	
	
	public static void main(String[] args) {

		double price = 0.0;
		double tender = 0.0;

		double a = .25;
		double b = 100;
		System.out.println(a * b);

		System.out
				.println("Welcome to the Money Sink! " + "Where we don't judge you for blowing all that moola, Baby!");

		price = getMoneyInput("Enter the total price of the goods being purchased: ");

		tender = getMoneyInput("Enter the total amount you are paying with: ");

		while (tender < price) {

			System.out.println("Sorry, thats not enough money. Please try again");
			tender = getMoneyInput("Enter the total amount you are paying with: ");

		}
		printChange(price, tender);

	}

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

		int changeDollars = (int) change;

		double changeCoins = change - (double) ((int) change);

		System.out.println("****************************************");
		System.out.println("*                                      *");
		System.out.printf("*   paying with:    $ %6.2f%11s*%n", tender, "");
		System.out.println("*                                      *");
		System.out.printf("*   Total due:      $ %6.2f%11s*%n", price, "");
		System.out.println("*                 ___________          *");
		System.out.println("*                                      *");
		System.out.printf("*   Change back:    $ %6.2f%11s*%n", change, "");
		System.out.println("*                                      *");
		// loop to add specific change values
		System.out.println("*                                      *");
		System.out.println("****************************************");
		getDollarChangeStrings(changeDollars);
		System.out.println();
		getCoinChangeString(changeCoins);
	}

	
	
	
	
	//TODO refactor to not need to split change and to do it as effectively as possible
	
	public static String getDollarChangeStrings(int dollars) {
		String changeString = "";

		int remainingDollars = dollars;

		int numOf20s = remainingDollars / 20;
		remainingDollars %= 20;

		int numOf10s = remainingDollars / 10;
		remainingDollars %= 10;

		int numOf5s = remainingDollars / 5;
		remainingDollars %= 5;

		int numOf1s = remainingDollars / 1;
		remainingDollars %= 1;

		System.out.println(numOf20s);
		System.out.println(numOf10s);
		System.out.println(numOf5s);
		System.out.println(numOf1s);
		return null;
	}

	public static String getCoinChangeString(double coins) {

		int remainingCoins = (int) (coins * 100);

		int numOfQuarters = remainingCoins / 25;
		remainingCoins %= 25;

		int numOfDimes = remainingCoins / 10;
		remainingCoins %= 10;

		int numOfNickels = remainingCoins / 05;
		remainingCoins %= 05;

		int numOfPennies = remainingCoins / 01;
		remainingCoins %= 01;

		System.out.println(numOfQuarters);
		System.out.println(numOfDimes);
		System.out.println(numOfNickels);
		System.out.println(numOfPennies);

		return null;
	}

	// ****************************************

	// * Number of $20 bills: *
	// * Number of $10 bills: *
	// * Number of $5 bills: *
	// * Number of $1 bills: *
	// * Number of quarters: *
	// * Number of dimes: *
	// * Number of nickels: *
	// * Number of dimes: *

}

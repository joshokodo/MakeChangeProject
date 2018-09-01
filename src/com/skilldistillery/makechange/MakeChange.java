package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChange {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		double price = 0.0;
		double tender = 0.0;

		System.out.println("Welcome to the Money Sink! " + "Where we don't judge you for blowing all that moola, Baby!");

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
		System.out.print(getDollarChangeStrings(changeDollars));
		System.out.print(getCoinChangeString(changeCoins));
		System.out.println("*                                      *");
		System.out.println("****************************************");
	}

	public static String getDollarChangeStrings(int dollars) {
		String change = "";

		int remainingDollars = dollars;

		int numOf20s = remainingDollars / 20;
		remainingDollars %= 20;

		int numOf10s = remainingDollars / 10;
		remainingDollars %= 10;

		int numOf5s = remainingDollars / 5;
		remainingDollars %= 5;

		int numOf1s = remainingDollars / 1;
		remainingDollars %= 1;

		if (numOf20s > 0) {
			change += String.format("*   Number of $20 bills:      %3d      *%n", numOf20s);
		}
		if (numOf10s > 0) {
			change += String.format("*   Number of $10 bills:      %3d      *%n", numOf10s);
		}
		if (numOf5s > 0) {
			change += String.format("*   Number of $5 bills:       %3d      *%n", numOf5s);
		}
		if (numOf1s > 0) {
			change += String.format("*   Number of $1 bills:       %3d      *%n", numOf1s);
		}

		return change;
	}

	public static String getCoinChangeString(double coins) {
		String change = "";

		int remainingCoins = (int) (coins * 100);

		int numOfQuarters = remainingCoins / 25;
		remainingCoins %= 25;

		int numOfDimes = remainingCoins / 10;
		remainingCoins %= 10;

		int numOfNickels = remainingCoins / 05;
		remainingCoins %= 05;

		int numOfPennies = remainingCoins / 01;
		remainingCoins %= 01;

		if (numOfQuarters > 0) {
			change += String.format("*   Number of Quarters:       %3d      *%n", numOfQuarters);
		}
		if (numOfDimes > 0) {
			change += String.format("*   Number of Dimes:          %3d      *%n", numOfDimes);
		}
		if (numOfNickels > 0) {
			change += String.format("*   Number of Nickels:        %3d      *%n", numOfNickels);
		}
		if (numOfPennies > 0) {
			change += String.format("*   Number of Pennies:        %3d      *%n", numOfPennies);
		}

		return change;
	}

}

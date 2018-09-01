package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChange {

	static Scanner kb = new Scanner(System.in);

	//
	static final String PROMPT_PRICE = "Enter the total price of the goods being purchased: ";

	static final String PROMPT_TENDER = "Enter the total amount you are paying with: ";

	static final String WELCOME_MESSAGE = "Welcome to the Money Sink! Where we don't judge you for blowing all that moola, Baby!";
	static final String PROMPT_REDO_TENDER = "Sorry, thats not enough money. Please try again";

	public static void main(String[] args) {

		double price = 0.0;
		double tender = 0.0;
		int changeDollars = 0;
		double changeCoins = 0.0;

		price = getMoneyInput(PROMPT_PRICE);
		System.out.printf("%.2f", price);
		tender = getMoneyInput(PROMPT_TENDER);

		while (!enoughTender(price, tender)) {

			System.out.println(PROMPT_REDO_TENDER);
			tender = getMoneyInput(PROMPT_TENDER);

		}

		changeDollars = getDollarChange(price, tender);
		changeCoins = getCoinChange(price, tender);

		System.out.println(changeDollars);
		System.out.println(changeCoins);

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

	// makes sure user has enough money to pay
	public static boolean enoughTender(double price, double tender) {

		return tender >= price;
	}

	public static int getDollarChange(double price, double tender) {

		double paper = tender - price; // gets change
		return (int) paper; // cast as int to truncate and only get dollar values
	}

	public static double getCoinChange(double price, double tender) {

		double skrilla = tender - price; // gets change
		int guap = (int) skrilla; // cast as int to truncate and get dollar value
		return skrilla - (double) guap;

	}

}

package com.skilldistillery.makechange;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MakeChange {

	static Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {

		double price = 0.0;
		double tender = 0.0;

		System.out
				.println("Welcome to the Money Sink! " + "Where we don't judge you for blowing all that moola, Baby!");

		price = getMoneyInput("Enter the total price of the goods being purchased: ");

		tender = getMoneyInput("Enter the total amount you are paying with: ");

		while (tender < price) {

			System.out.println("Sorry, thats not enough money. Please try again");
			tender = getMoneyInput("Enter the total amount you are paying with: ");

		}

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

		double paper = tender - price; // gets change

		int changeDollars = (int) paper;

		double changeCoins = paper - (double) ((int) paper);

	}

}

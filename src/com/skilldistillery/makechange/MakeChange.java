package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	//super unnecessary static variables. doing for fun
	static Scanner kb = new Scanner(System.in);
	static double price = 0.0;
	static double tender = 0.0;
	static int changeDollars = 0;
	static double changeCoins = 0.0;

	// super unnecessary constants. doing for fun
	static final String PROMPT_PRICE = "Enter the total price of the goods being purchased: ";
	static final String PROMPT_TENDER = "Enter the total amount you are paying with: ";
	static final String WELCOME_MESSAGE = "";
	static final String PROMPT_REDO_TENDER = "Sorry, thats not enough money. Please try again";

	
	
	public static void main(String[] args) {

		price = getDoubleInput(PROMPT_PRICE);

		tender = getDoubleInput(PROMPT_TENDER);

		while (!enoughTender()) {
			
			System.out.println(PROMPT_REDO_TENDER);
			tender = getDoubleInput(PROMPT_TENDER);

		}

	}

	public static double getDoubleInput(String prompt) {
		System.out.print(prompt);
		return kb.nextDouble();
	}

	public static boolean enoughTender() {

		return tender >= price;
	}
	public static boolean isRealMoneyValue() {
		//finish later
	}

	public static void setChangeAmount() {
		changeDollars = (int)(tender - price);

	}
	

}

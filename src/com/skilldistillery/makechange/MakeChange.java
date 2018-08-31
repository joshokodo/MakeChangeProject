package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {
	
	
	
	static Scanner kb = new Scanner(System.in);
	//super unnecessary constants. doing for the lols
	static final String PROMPT_PRICE = "Enter the total price of the goods being purchased: ";
	static final String PROMPT_TENDER = "Enter the total amount you are paying with: ";
	static final String WELCOME_MESSAGE = "";
	static final String PROMPT_REDO_TENDER = "Sorry, thats not enough money. Please try again";

	public static void main(String[] args) {
		
		double price = 0.0;
		double tender = 0.0;
		
		price = getDoubleInput(PROMPT_PRICE);
		
		tender = getDoubleInput(PROMPT_TENDER);
		
		while(!enoughTender(tender, price)) {
			System.out.println(PROMPT_REDO_TENDER);
			tender = getDoubleInput(PROMPT_TENDER);
			
		}
		
		
		
		
		
	}
	
	public static double getDoubleInput(String prompt) {
		System.out.print(prompt);
		return kb.nextDouble();
	}
	
	public static boolean enoughTender(double tender, double price) {
		
		return tender >= price;
	}
	public static double getChangeAmount(double tender, double price) {
		return tender - price;
		
	}

}

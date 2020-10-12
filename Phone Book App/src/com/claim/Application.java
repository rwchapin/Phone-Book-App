package com.claim;

import java.util.Scanner;


/**
 * This Class provides the main method and the method to display the main menu and options to use the application
 * 
 * @author Ryan Chapin
 *
 */
public class Application {
	
	public static void main(String[]args) {
		System.out.println(" -------------------");
		System.out.println(" ----PHONE BOOK-----");
		System.out.println(" -------------------");
		displayMainMenu();
		
//		test cases - 
//		John Doe, 114 Market St, St Louis, MO, 63403, 1112223456
//		John E Doe, 324 Main St, St Charles, MO,63303, 2223334567
//		John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 3334445678
		
	}
	
	/**
	 * The method to display the main menu that lets you choose from 
	 * a list of options to control the actions of the phone book program
	 * 
	 */
	public static void displayMainMenu() {
		PhoneBook book = new PhoneBook();
		boolean exit = false;
		do {
		Scanner input = new Scanner(System.in);
		System.out.println("\n----> MAIN MENU <----");
		System.out.println(" (1) Add Contact Menu ");
		System.out.println(" (2) Search Menu ");
		System.out.println(" (3) Update Contact Menu ");
		System.out.println(" (4) Show all Records in Alphabetical Order by First Name ");
		System.out.println(" (5) Delete a Record by Telephone Number ");
		System.out.println(" (6) EXIT ");
		System.out.print("---> Please enter a selection: ");
		int choice = input.nextInt();
		if (choice > 10||choice <=0) {
			System.out.println("\nSelection Not Valid - Please enter number from Menu\n");
		}
			switch(choice) {
			case 1: //adding a new entry
				book.addRecordMenu();
				break;
			case 2: //search city or state
				book.searchMenu();
				break;
			case 3: //update a record
				book.updateRecord();
				break;
			case 4: // sort records by first name
				System.out.print("\n--Show all Records in Alphabetical Order by First Name--\n");
				book.sortPhoneBook();
				break;
			case 5: //delete a record
				Scanner case7 = new Scanner(System.in);
				System.out.print("\nPlease Enter Telephone Number to be Deleted: ");
				String c7Input = case7.nextLine();
				book.deleteRecord(c7Input);
				break;
			case 6: //EXIT option
				exit = true;
				System.out.println("\n---> EXIT - Have a Nice Day! <---");
				break;
			}	
			
		
		}while (!exit);
		
	}

}

package com.claim;

import java.util.Arrays;
import java.util.Scanner;
/**
 * This class provides the methods that add, subtract, search and modify the contents of the phoneBook array
 * 
 * @author Ryan Chapin
 *
 */
public class PhoneBook {
	//Initializing main phone book array 
	Person[] phoneBook = new Person[0];
	// default constructor
	public PhoneBook() {}
	
	/**
	 * This method is used to add a new record by having the user select which method they prefer to enter the contact data
	 * into the system
	 */
	public void addRecordMenu() {
		boolean exit = false;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("\n---> ADD NEW CONTACT <---");
			System.out.println(" (1) Enter Contact Info as -> Name, Street, City, State, Zipcode, Telephone number(No Spaces)");
			System.out.println(" (2) Enter Contact Info by Type");
			System.out.println(" (3) Return to MAIN MENU");
			System.out.print("---> Please enter a selection: ");
			int choice = sc.nextInt();
			if (choice > 3||choice <=0) {
				System.out.println("\nSelection Not Valid - Please enter number from Menu\n");
			}
			switch(choice) {
			case 1:
				Scanner case1 = new Scanner(System.in);
				System.out.print("\nPlease enter contact info(Name, Street, City, State, Zipcode, Telephone number(No Spaces): ");
				String c1Input = case1.nextLine();
				addContact(c1Input);
				break;
			case 2:
				addNewContact();
				break;
			case 3:
				exit = true;
				System.out.println("\nReturn to MAIN MENU");
				break;
			}		
		}while(!exit);
		
	}
	
	/**
	 * This method will add a new phoneBook record by requiring the user to input each data type
	 * one by one until the record is created
	 */
	public void addNewContact() {
		Person p = new Person();
		Address a = new Address();
		Scanner scan = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("--- ADD NEW CONTACT ---");
		
		System.out.print("Enter First Name: ");
		String fname = scan.next();
		p.setFirstName(fname);
		
		System.out.print("Enter Middle Name: ");
		String mName = scan.next();
		p.setMiddleName(mName);
		
		System.out.print("Enter Last Name: ");
		String lName = scan.next();
		p.setlastName(lName);
		
		System.out.print("Enter Street: ");
		String street = sc.nextLine();
		a.setStreetAddress(street);
		
		System.out.print("Enter City: ");
		String city = sc.nextLine();
		a.setCity(city);
		
		System.out.print("Enter State: ");
		String state = scan.next();
		a.setState(state);
		
		System.out.print("Enter Zipcode: ");
		String zipcode = scan.next();
		a.setZipcode(zipcode);
		
		System.out.print("Enter Telephone Number(No Spaces): ");
		String tNum = scan.next();
		p.setTelephoneNumber(tNum);
		
		p.setAddress(a);
		Person[] pBook;
		pBook = expandArray(phoneBook,p);
		phoneBook = pBook;
		
		//scan.close();
		//sc.close();
		
		System.out.println("\nYou added: "+p+"\n");
	}
	
	/**
	 * method to add contact to phoneBook array using a formatted string
	 * 
	 * @param input 
	 *        takes a string from the scanner and converts it in to the various pieces needed to complete a new record
	 * 
	 * expandArray() method used to add new person to phoneBook array
	 */
	public void addContact(String input) {
		String[] inputSplit = input.split(",");
		String name = inputSplit[0];
		String[] nameSplit = name.split(" ");
		String midName = "";
		for(int i = 1;i<nameSplit.length -1;i++) {
			midName = midName + " " + nameSplit[i];	
		}
		Address address1 = new Address(inputSplit[1].trim(),inputSplit[2].trim(), inputSplit[3].trim(),inputSplit[4].trim());
		Person person1 = new Person(nameSplit[0].trim(), midName.trim(), nameSplit[nameSplit.length-1].trim(), address1, inputSplit[5].trim());
		Person[] pBook;
		pBook = expandArray(phoneBook,person1);
		phoneBook = pBook;
		
		System.out.println("\nYou added: "+person1);
	}
	
	/**
	 * method used to expand any array by 1 using the original array and an object as an argument
	 * 
	 * @param source[] 
	 *        source array to be expanded by 1
	 *        
	 * @param a 
	 *        is an object used to add to array
	 *        
	 * @return tempArray[] 
	 *         is used to replace the original array
	 */
	public Person[] expandArray(Person[]source, Person a) {
		Person[] tempArray = new Person[source.length + 1];
		for(int i=0;i<source.length;i++) {
			tempArray[i] = source[i];	
		}
		tempArray[source.length] = a;
		return tempArray;
	}
	
	/**
	 * Method used to search phoneBook[] by a persons first name
	 * 
	 * @param input 
	 *        takes a string and compares it to the first name of all the persons in the phoneBook[]
	 */
	public void searchFirstName(String input) {
		boolean found = true;
		for(int i=0;i<phoneBook.length;i++) {
			if(input.equals(phoneBook[i].getFirstName())) {
				System.out.println("\n"+phoneBook[i]+"\n");
				found = false;
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}

	/**
	 * Method used to search phoneBook[] by a persons last name
	 * 
	 * @param input 
	 *        takes a string and compares it to the last name of all the persons in the phoneBook[]
	 */
	public void searchLastName(String input) {
		boolean found = true;
		for(int i=0;i<phoneBook.length;i++) {
			if(input.equals(phoneBook[i].getLastName())) {
				System.out.println("\n"+phoneBook[i]+"\n");
				found = false;
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}
	
	/**
	 * Method used to search phoneBook[] by a persons first & last name
	 * 
	 * @param input 
	 *        takes a string and compares it to the first & Last name of all the persons in the phoneBook[]
	 */
	public void searchFullName(String input) {
		boolean found = true;
		for(int i=0;i<phoneBook.length;i++) {
			String fullName = phoneBook[i].getFirstName() +" "+ phoneBook[i].getLastName();
			if(input.equals(fullName)) {
				System.out.println("\n"+phoneBook[i]+"\n");
				found = false;
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}
	
	/**
	 * Method used to search phoneBook[] by a persons telephone number
	 * 
	 * @param input 
	 *        takes a string and compares it to the telephone number of all the persons in the phoneBook[]
	 */
	public void searchTelephoneNumber(String input) {
		boolean found = true;
		String formatInput = "(" + input.substring(0, 3)+")" +"-"+input.substring(3, 6)+"-"+input.substring(6, 10);
		for(int i=0;i<phoneBook.length;i++) {
			if(formatInput.equals(phoneBook[i].getTelephoneNumber())) {
				System.out.println("\n"+phoneBook[i]+"\n");
				found = false;
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}
	
	/**
	 * Method used to search phoneBook[] by a persons city or state
	 * 
	 * @param input 
	 *        takes a string and compares it to the city or state of all the persons in the phoneBook[]
	 */
	public void searchCityStates(String input) {
		boolean found = true;
		for(int i=0;i<phoneBook.length;i++) {
			if(input.equals(phoneBook[i].getAddress().getCity())||input.equals(phoneBook[i].getAddress().getState())) {
				System.out.println("\n"+phoneBook[i]+"\n");
				found = false;
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}
	
	/**
	 * Method used to sort the phoneBook[] in ascending order alphabetically by first name
	 */
	public void sortPhoneBook() {
		Arrays.sort(phoneBook);
		for(int i = 0;i<phoneBook.length;i++) {
			System.out.println("\n"+phoneBook[i]+"\n");
		}
	}
	
	/**
	 * The method uses a telephone number as the unique identifier to find a specific phoneBook record to remove
	 * and then prompts the user with a second yes or no question to confirm the deletion before the action is permanent
	 * 
	 * @param input
	 *        takes a string telephone number and use it to find a record 
	 *        
	 * @param yn
	 * 		  this string ask the user to input y or n before committing to deleting the record
	 */
	public void deleteRecord(String input) {
		boolean found = true;
		int index;
		Person[] tempArray = new Person[phoneBook.length-1];
		String y = "y";
		String formatInput = "(" + input.substring(0, 3)+")" +"-"+input.substring(3, 6)+"-"+input.substring(6, 10);
		for(int i=0;i<phoneBook.length;i++) {
			if(formatInput.equals(phoneBook[i].getTelephoneNumber())) {
				System.out.println("\n"+phoneBook[i]+"\n");
				index = i;
				found = false;
				
				Scanner yesno = new Scanner(System.in);
				System.out.print("(Are you sure - Y or N): ");
				String yn = yesno.next().toLowerCase();
				if (yn.equals(y)) {
					for(int j = 0, k = 0;j<phoneBook.length;j++) {
						if(j == index) {
							continue;
						}
						tempArray[k++] = phoneBook[j];
					}
					System.out.println("\nRecord Deleted - Returning to MAIN MENU\n");
				} else {
					tempArray = phoneBook;
					System.out.println("\nNo Changes Made - Returning to MAIN MENU");
					break;
				}
				//yesno.close();
			  }			
			}
				phoneBook = tempArray;
            if(found) {
			System.out.println("\nNo Records Found\n");
		    }
	}
	
	/**
	 * The method uses a telephone number as the unique identifier to find a specific phoneBook record to update,
	 * through a menu the user can choose which data field they would like to update
	 * 
	 * @param input 
	 * 		  takes a string telephone number and use it to find a record
	 */
	public void updateRecord() {
		boolean found = true;
		int index;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\n--Update a Record by Telephone Number--");
		System.out.print("--> Please Enter Telephone Number of Record to be Updated: ");
		String tnumInput = sc.nextLine();
		String formatInput = "(" + tnumInput.substring(0, 3)+")" +"-"+tnumInput.substring(3, 6)+"-"+tnumInput.substring(6, 10);
		for(int i=0;i<phoneBook.length;i++) {
			if(formatInput.equals(phoneBook[i].getTelephoneNumber())) {
				System.out.println("\n"+phoneBook[i]);
				index = i;
				found = false;
				boolean exit = false;
				do {
				Scanner option = new Scanner(System.in);
				System.out.println("\n---> UPDATE MENU <---");
				System.out.println(" (1) Update First Name ");
				System.out.println(" (2) Update Middle Name ");
				System.out.println(" (3) Update Last Name ");
				System.out.println(" (4) Update Telephone Number ");
				System.out.println(" (5) Update Street ");
				System.out.println(" (6) Update City ");
				System.out.println(" (7) Update State ");
				System.out.println(" (8) Update Zipcode ");
				System.out.println(" (9) Return to MAIN MENU ");
				System.out.print("---> Please enter a selection: ");
				int choice = option.nextInt();
				if (choice > 8||choice <=0) {
					System.out.println("\nSelection Not Valid - Please enter number from Menu\n");
				}
					switch(choice) {
					case 1: 
						Scanner case1 = new Scanner(System.in);
						System.out.print("\nEnter New First Name:");
						String c1Input = case1.nextLine();
						phoneBook[index].setFirstName(c1Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 2: 
						Scanner case2 = new Scanner(System.in);
						System.out.print("\nEnter New Middle Name:");
						String c2Input = case2.nextLine();
						phoneBook[index].setMiddleName(c2Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 3: 
						Scanner case3 = new Scanner(System.in);
						System.out.print("\nEnter New Last Name: ");
						String c3Input = case3.nextLine();
						phoneBook[index].setlastName(c3Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 4: 
						Scanner case4 = new Scanner(System.in);
						System.out.print("\nEnter New Telephone number: ");
						String c4Input = case4.nextLine();
						phoneBook[index].setTelephoneNumber(c4Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 5: 
						Scanner case5 = new Scanner(System.in);
						System.out.print("\nEnter New Street Address: ");
						String c5Input = case5.nextLine();
						phoneBook[index].getAddress().setStreetAddress(c5Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 6:
						Scanner case6 = new Scanner(System.in);
						System.out.print("\nEnter New City: ");
						String c6Input = case6.nextLine();
						phoneBook[index].getAddress().setCity(c6Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 7:
						Scanner case7 = new Scanner(System.in);
						System.out.print("\nEnter New State: ");
						String c7Input = case7.nextLine();
						phoneBook[index].getAddress().setState(c7Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 8:
						Scanner case8 = new Scanner(System.in);
						System.out.print("\nEnter New Zipcode: ");
						String c8Input = case8.nextLine();
						phoneBook[index].getAddress().setZipcode(c8Input);
						System.out.println("\n"+phoneBook[index]);
						break;
					case 9: 
						exit = true;
						System.out.println("\nReturn to MAIN MENU");
						break;
					}
					
					
				}while (!exit);
			}
		}
		if(found) {
			System.out.println("\nNo Records Found\n");
		}
	}
	
	/**
	 * This method is a search menu to call the different search methods
	 */
	public void searchMenu() {
		boolean exit = false;
		do {
			Scanner scan = new Scanner(System.in);
			System.out.println("\n ---> SEARCH MENU <---");
			System.out.println(" (1) Search by First Name");
			System.out.println(" (2) Search by Last Name");
			System.out.println(" (3) Search by Full Name");
			System.out.println(" (4) Search by Telephone Number");
			System.out.println(" (5) Search by City or State");
			System.out.println(" (6) Return to MAIN MENU ");
			System.out.print("---> Please enter a selection: ");
			int choice = scan.nextInt();
			if (choice > 6||choice <=0) {
				System.out.println("\nSelection Not Valid - Please enter number from Menu\n");
			}
			switch(choice) {
			case 1:
				System.out.println("\n------SEARCH------");
				Scanner case1 = new Scanner(System.in);
				System.out.print("Search by a first name: ");
				String c1Input = case1.nextLine();
				searchFirstName(c1Input);
				break;
			case 2:
				System.out.println("\n------SEARCH------");
				Scanner case2 = new Scanner(System.in);
				System.out.print("Search by a last name: ");
				String c2Input = case2.nextLine();
				searchLastName(c2Input);
				break;
			case 3:
				System.out.println("\n------SEARCH------");
				Scanner case3 = new Scanner(System.in);
				System.out.print("Search by first & last name: ");
				String c3Input = case3.nextLine();
				searchFullName(c3Input);
				break;
			case 4:
				System.out.println("\n------SEARCH------");
				Scanner case4 = new Scanner(System.in);
				System.out.print("Search by a Telephone Number(no spaces): ");
				String c4Input = case4.nextLine();
				searchTelephoneNumber(c4Input);
				break;
			case 5:
				System.out.println("\n------SEARCH------");
				Scanner case5 = new Scanner(System.in);
				System.out.print("\nSearch by City or State: ");
				String c5Input = case5.nextLine();
				searchCityStates(c5Input);
				break;
			case 6:
				exit = true;
				System.out.println("\nReturn to MAIN MENU");
				break;
			
			}
			
		}while(!exit);
		
	}
	
}


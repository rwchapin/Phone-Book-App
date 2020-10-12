package com.claim;

/**
 * This Class provides the construction and helper methods to build and maintain a Person object
 * 
 * @author Ryan Chapin
 *
 */
public class Person implements Comparable<Person> {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;
	private String telephoneNumber;

	public Person() {}
	
	public Person(String firstName,String middleName, String lastName,Address address,String telephoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.telephoneNumber = "(" + telephoneNumber.substring(0, 3)+")" +"-"+telephoneNumber.substring(3, 6)+"-"+telephoneNumber.substring(6, 10);	
	}
	public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public Address getAddress() {
		return this.address;
	}
	public void setAddress(Address address) {
		this.address =address;
	}
	public String getTelephoneNumber() {
		return this.telephoneNumber;	
	}
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber= "(" + telephoneNumber.substring(0, 3)+")" +"-"+telephoneNumber.substring(3, 6)+"-"+telephoneNumber.substring(6, 10);
	}
	
	/**
	 * this method compares 2 first names to see if the are equal to each other
	 * 
	 * @param p
	 * 	      This object is used to compare one first name to another
	 * 
	 * @return true or false depending on the outcome of the comparison
	 */
	public boolean equals(Person p) {
		return this.firstName == p.firstName;
	}
	
	/**
	 * This method overrides the main toString method and returns a string in our desired format
	 */
	public String toString() {
		return "[Name]: "+this.firstName +" " +this.middleName + " "+this.lastName + " [Telephone number]: "+this.telephoneNumber + " "+this.address;
	}
	
	/**
	 *This method overrides the main compareTo method to return a value depending on the outcome of the comparison
	 *
	 * @return an int value based to the comparison
	 */
	public int compareTo(Person p) {
		return this.firstName.compareTo(p.firstName);
	}

	

}

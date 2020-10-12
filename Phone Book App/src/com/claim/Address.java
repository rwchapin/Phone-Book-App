package com.claim;

/**
 * This Class provides the construction and helper methods to build and maintain an address object
 * which is used in the person object to construct our phonebook records
 * 
 * @author Ryan Chapin
 *
 */
public class Address{
	
	private String streetAddress;
	private String city;
	private String state;
	private String zipcode;
	
	public Address() {}
	
	public Address(String streetAddress,String city,String state,String zipcode) {
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public String getStreetAddress() {
		return this.streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return this.state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return this.zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 *This method overrides the main toString method and returns a string in our desired format
	 */
	public String toString() {
		return "[Street]: " + this.streetAddress + " [City]: "+this.city+" [State]: "+this.state+" [Zipcode]: "+this.zipcode;
	}
	

}

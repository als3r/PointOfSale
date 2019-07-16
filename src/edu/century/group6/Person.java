package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of person class
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming
 * Instructor: Matthew Sanders
 * Assignment: Group Assignment
 * Date: July 02, 2019
 * Due:  Jule 16, 2019
 * 
 * Group 6
 * @author Anan Gedefa <pv2824bf@my.century.edu>
 * @author Evelline Samson <cj5673li@my.century.edu> 
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class Person {
	
	/**
	 * First name
	 */
	private String firstName;
	
	/**
	 * Last name
	 */
	private String lastName;
	
	/**
	 * Address
	 */
	private String address;
	
	/**
	 * City
	 */
	private String city;
	
	/**
	 * State
	 */
	private String state;
	
	/**
	 * Zip code 
	 */
	private String zip;
	
	/**
	 * Phone number
	 */
	private String phone;
	
	
	/**
	 * Default constructor creates an empty instance of Person
	 */
	Person() {

	}
	
	
	/**
	 * Constructor creates an instance of Person
	 * with provided:
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	Person(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhone(phone);
	}
	
	
	/**
	 * Get First name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Modify first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Modify last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get address
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Modify address
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Get city
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Modify city
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * Get state
	 * 
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Modify State
	 * 
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get ZIP code
	 * 
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Modify ZIP code
	 * 
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Get phone number
	 * 
	 * @return
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Modify phone number
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		message += "Phone#: "     + getPhone()     + "\n";
		message += "First Name: " + getFirstName() + "\n";
		message += "Last Name: "  + getLastName()  + "\n";
		message += "Address: "    + getAddress()   + "\n";
		message += "City: "       + getCity()      + "\n";
		message += "State: "      + getState()     + "\n";
		message += "Zip: "        + getZip()       + "\n";
		
		return message;
	}
}

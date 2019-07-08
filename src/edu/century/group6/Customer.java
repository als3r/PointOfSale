package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of a customer class
 * Stores information about customer
 * Extends Person class
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
public class Customer extends Person {
	
	/**
	 * Customer identification number
	 */
	private String customerNumber;
	
	
	/**
	 * Get customer identification number
	 * 
	 * @return customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	
	/**
	 * Modify customer identification number
	 * 
	 * @param customerNumber
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	
	/**
	 * Default Constructor
	 */
	Customer(){
		super();
	}

	
	/**
	 * Constructor creates an instance of Customer
	 * with provided:
	 * 
	 * @param customerNumber
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	Customer(String customerNumber, String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		super(firstName, lastName, address, city, state, zip, phone);
		this.customerNumber = customerNumber;
	}
	
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		message += "Customer#: " + getCustomerNumber() + "\n";
		message += super.toString();
		return message;
	}
}

package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of employee class
 * Stores information about employee
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
public class Employee extends Person {
	
	/**
	 * Employee identification number
	 */
	private String employeeNumber;
	
	
	/**
	 * Get employee identification number
	 * 
	 * @return
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	
	/**
	 * Modify employee identification number
	 * 
	 * @param employeeNumber
	 */
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	
	/**
	 * Default Constructor
	 */
	Employee(){
		super();
	}
	
	
	/**
	 * Constructor creates an instance of Employee
	 * with provided:
	 * 
	 * @param employeeNumber
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	Employee(String employeeNumber, String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		super(firstName, lastName, address, city, state, zip, phone);
		setEmployeeNumber(employeeNumber);
	}
	
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		message += "Employee#: " + getEmployeeNumber();
		message += super.toString();
		return message;
	}

	
	
	
}

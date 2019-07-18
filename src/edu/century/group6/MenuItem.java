package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of menu item class
 * Stores information about menu item
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
public class MenuItem {
	
	/**
	 * Name of the item
	 */
	String name;
	
	/**
	 * Price for 1 item
	 */
	double price;
	
	/**
	 * Minimum Cook time in seconds
	 * Default 5 minutes = 5*60 = 300 seconds (DEFAULT_COOK_TIME)
	 */
	int cookTime;
	
	/**
	 * Default cook time
	 */
	public static final int DEFAULT_COOK_TIME = 5 * 60; 
	
	
	
	/**
	 * Construct instance of MenuItem 
	 * with provided:
	 * @param name
	 */
	MenuItem(String name){
		setName(name);
		setCookTime(DEFAULT_COOK_TIME);
	}
	
	/**
	 * Construct instance of MenuItem 
	 * with provided:
	 * @param name
	 * @param price
	 * @param cookTime
	 */
	MenuItem(String name, int cookTime){
		setName(name);
		setCookTime(cookTime);
	}
	
	
	/**
	 * Get item name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Modify item name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	 * Get item price
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	
	/**
	 * Modify item price
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}


	/**
	 * Get cook time in seconds
	 * 
	 * @return cookTime
	 */
	public int getCookTime() {
		return cookTime;
	}


	/**
	 * Modify cookTime in seconds
	 * @param cookTime
	 */
	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	
	/**
	 * Get description for kitchen
	 * 
	 * @return name
	 */
	public String toKitchenString() {
		return name;
	}


	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of menu item
	 */
	@Override
	public String toString() {
		return name + "(cook time: " + cookTime+ ")";
	}	
}

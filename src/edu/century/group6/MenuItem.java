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
	 * Quantity 
	 */
	int quantity;
	
	/**
	 * Price for 1 item
	 */
	double totalPrice;
	
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
	 * Default quantity
	 */
	public static final int DEFAULT_QUANTITY = 1; 
	
	
	/**
	 * Default Constructor
	 * @TODO need to add errors and input validation
	 */
	MenuItem(){
		setName("Test");
		setPrice(1.00);
		setQuantity(DEFAULT_QUANTITY);
		setCookTime(DEFAULT_COOK_TIME);
		setTotalPrice(calcTotalPrice());
	}
	
	/**
	 * Construct instance of MenuItem 
	 * with provided:
	 * @param name
	 * @param price
	 */
	MenuItem(String name, double price){
		setName(name);
		setPrice(price);
		setQuantity(DEFAULT_QUANTITY);
		setCookTime(DEFAULT_COOK_TIME);
		setTotalPrice(calcTotalPrice());
	}
	
	/**
	 * Construct instance of MenuItem 
	 * with provided:
	 * @param name
	 * @param price
	 * @param quantity
	 */
	MenuItem(String name, double price, int quantity){
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setCookTime(DEFAULT_COOK_TIME);
		setTotalPrice(calcTotalPrice());
	}
	
	/**
	 * Construct instance of MenuItem 
	 * with provided:
	 * @param name
	 * @param price
	 * @param quantity
	 * @param cookTime
	 */
	MenuItem(String name, double price, int quantity, int cookTime){
		setName(name);
		setPrice(price);
		setQuantity(quantity);
		setCookTime(cookTime);
		setTotalPrice(calcTotalPrice());
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
	 * Get item quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}


	/**
	 * Modify item quantity
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	 * Get Total Price
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Modify Total Price
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * Calculate total price by multiplying quantity and unit price (price)
	 * @return double total price
	 */
	public double calcTotalPrice() {
		return price * quantity;
	}


	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		return "MenuItem [name=" + name + ", price=" + price + ", quantity=" + quantity + ", cookTime=" + cookTime
				+ "]";
	}
	
	
	
}

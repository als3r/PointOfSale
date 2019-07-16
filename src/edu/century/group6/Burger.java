package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of pizza class
 * Stores information about pizza menu item with prices
 * Extends OrderItem class
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming
 * Instructor: Matthew Sanders
 * Assignment: Group Assignment
 * Date: July 02, 2019
 * Due:  Jule 16, 2019
 * 
 * Group 6
 * 
 * @author Anan Gedefa <pv2824bf@my.century.edu>
 * @author Evelline Samson <cj5673li@my.century.edu>
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class Burger extends MenuItem {

	/**
	 * Burger type (name)
	 */
	private String burgerType;

	/**
	 * To store burger types
	 */
	public static final String[] TYPE_ARRAY = { "HamBurger", "CheeseBurger", "TurkeyBurger", "VeggieBurger" };
	
	/**
	 * Price list for burgers
	 */
	public static final double COST_HAMBURGER    = 4.99;
	public static final double COST_CHEESEBURGER = 5.99;
	public static final double COST_TURKEYBURGER = 5.99;
	public static final double COST_VEGGIEBURGER = 6.99;
	

	/**
	 * Constructor Create an instance of Burger sets item price and calculate total
	 * price based on quantity with provided:
	 * 
	 * @param sideType
	 * @param sideSize
	 * @param sideQuantity
	 */
	public Burger(String burgerType) {
		// using parent constructor
		super(burgerType);
		// set type and size
		setBurgerType(burgerType);
		// set cost
		setPrice(calcCost());
	}

	/**
	 * Get burger type (name)
	 * 
	 * @return burgerType
	 */
	public String getBurgerType() {
		return burgerType;
	}

	/**
	 * Modify burger type
	 * 
	 * @param burgerType
	 */
	public void setBurgerType(String burgerType) {
		this.burgerType = burgerType;
	}

	/**
	 * Price calculation for burgers
	 */
	public double calcCost() {
		if (burgerType.equalsIgnoreCase("hamburger")) {
			return COST_HAMBURGER;
		} else if (burgerType.equalsIgnoreCase("cheeseburger")) {
			return COST_CHEESEBURGER;
		} else if (burgerType.equalsIgnoreCase("turkeyburger")) {
			return COST_TURKEYBURGER;
		} else if (burgerType.equalsIgnoreCase("veggieburger")) {
			return COST_VEGGIEBURGER;
		} else {
			return 1000000.0;
		}
	}

	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		return "Burger: " + getName() + ". " + "\n" + String.format("$%.2f", getPrice())
				+ "\n";
	}
}

package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of drink menu item class
 * Stores information about drink menu item
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
public class Drink extends MenuItem{
	
	/**
	 * Drink type (name) 
	 * used to calculate cost of the drink
	 */
	String drinkType;
	
	/**
	 * Drink size 
	 * used to calculate cost of the drink
	 */
	String drinkSize;
	
	/**
	 * To store prices for drinks
	 */
	public static final double COST_BEER      = 3.00;
	public static final double COST_COKE      = 1.00;
	public static final double COST_DIET_COKE = 1.00;
	public static final double COST_WATER     = 2.00;
	
	public static final double COST_SIZE_SMALL_MODIFIER  = 1.00;
	public static final double COST_SIZE_MEDIUM_MODIFIER = 1.25;
	public static final double COST_SIZE_LARGE_MODIFIER  = 1.60;
	
	/**
	 * To store drink types
	 */
	public static final String[] TYPE_ARRAY = {
	  "Coke", "Diet Coke", "Beer", "Water"	  
	};
	
	
	/**
	 * To store drink sizes
	 */
	public static final String[] SIZE_ARRAY = {
	  "12oz", "16oz", "24oz"	  
	};
	
	
	/**
	 * Recommended constructor
	 * Create an instance of Drink
	 * sets item price and calculate total price based on quantity
	 * with provided:
	 * 
	 * @param drinkType
	 * @param drinkSize
	 * @param drinkQuantity
	 */
	public Drink(String drinkType, String drinkSize) {
		// using parent constructor
		super(drinkType);
		// set type and size
		setDrinkType(drinkType);
		setDrinkSize(drinkSize);
		// set cost
		setPrice(calcCost());
	}


	/**
	 * Get drink type
	 * 
	 * @return drinkType
	 */
	public String getDrinkType() {
		return drinkType;
	}


	/**
	 * Modify drink type
	 * 
	 * @param drinkType
	 */
	public void setDrinkType(String type) {
		this.drinkType = type;
	}


	/**
	 * Get drink size
	 * 
	 * @return drinkSize
	 */
	public String getDrinkSize() {
		return drinkSize;
	}


	/**
	 * Modify drink size
	 * 
	 * @param drinkSize
	 */
	public void setDrinkSize(String size) {
		this.drinkSize = size;
	}
	
	/**
	 * Calculate cost of the drink
	 * 
	 * @return price
	 */
	public double calcCost() {
		double price;
		switch(this.drinkType.toLowerCase()) {
			case "coke":      price = applySizeModifier(COST_COKE); break;
			case "diet coke": price = applySizeModifier(COST_DIET_COKE); break;
			case "beer":      price = applySizeModifier(COST_BEER); break;
			case "water":     price = applySizeModifier(COST_WATER); break;
			default: price = 0;
		}
		return price;
	}
	
	/**
	 * Apply size modifier to item price
	 * Bigger the size higher the price
	 * 
	 * @param basePrice
	 * @return price
	 */
	public double applySizeModifier(double basePrice) {
		double price;
		switch(this.drinkSize.toLowerCase()) {
			case "12oz": price = basePrice * COST_SIZE_SMALL_MODIFIER; break;
			case "16oz": price = basePrice * COST_SIZE_MEDIUM_MODIFIER; break;
			case "24oz": price = basePrice * COST_SIZE_LARGE_MODIFIER; break;	
			default: price = 0;
		}
		
		return price;
	}
	


	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservatio
	 * n data
	 * 
	 */
	@Override
	public String toString() {
		return "Drink: " + getName() + ". Size: " + getDrinkSize() + ". " 
				+ String.format("$%.2f", getPrice()) + "\n";
	}	
}

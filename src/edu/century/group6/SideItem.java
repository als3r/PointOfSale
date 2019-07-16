package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of side class 
 * Stores information about general side menu item with prices
 * Extends MenuItem class
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming Instructor: Matthew Sanders
 * Assignment: Group Assignment Date: July 02, 2019 Due: Jule 16, 2019
 * 
 * Group 6
 * 
 * @author Anan Gedefa <pv2824bf@my.century.edu>
 * @author Evelline Samson <cj5673li@my.century.edu>
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class SideItem extends MenuItem {

	/**
	 * Side type (name) used to calculate cost of the side item
	 */
	String sideType;

	/**
	 * Side size used to calculate cost of the side item
	 */
	String sideSize;

	/**
	 * To store prices for sides
	 */
	public static final double COST_FRENCH_FRIES = 2.00;
	public static final double COST_ONION_RINGS = 3.00;

	public static final double COST_SIZE_SMALL_MODIFIER = 1.00;
	public static final double COST_SIZE_MEDIUM_MODIFIER = 1.25;
	public static final double COST_SIZE_LARGE_MODIFIER = 1.60;

	/**
	 * To store side types
	 */
	public static final String[] TYPE_ARRAY = { "French Fries", "Onion Rings" };

	/**
	 * To store side sizes
	 */
	public static final String[] SIZE_ARRAY = { "Small", "Medium", "Large" };

	/**
	 * Constructor Create an instance of SideItem sets item price and calculate
	 * total price based on quantity with provided:
	 * 
	 * @param sideType
	 * @param sideSize
	 * @param sideQuantity
	 */
	public SideItem(String sideType, String sideSize) {
		// using parent constructor
		super(sideType);
		// set type and size
		setSideType(sideType);
		setSideSize(sideSize);
		// set cost
		setPrice(calcCost());
	}

	/**
	 * Get side type
	 * 
	 * @return sideType
	 */
	public String getSideType() {
		return sideType;
	}

	/**
	 * Modify side type
	 * 
	 * @param sideType
	 */
	public void setSideType(String type) {
		this.sideType = type;
	}

	/**
	 * Get side size
	 * 
	 * @return sideSize
	 */
	public String getSideSize() {
		return sideSize;
	}

	/**
	 * Modify side size
	 * 
	 * @param sideSize
	 */
	public void setSideSize(String size) {
		this.sideSize = size;
	}

	/**
	 * Calculate cost of the side
	 * 
	 * @return price
	 */
	public double calcCost() {
		double price;
		switch (this.sideType.toLowerCase()) {
		case "french fries":
			price = applySizeModifier(COST_FRENCH_FRIES);
			break;
		case "onion rings":
			price = applySizeModifier(COST_ONION_RINGS);
			break;
		default:
			price = 0;
		}
		return price;
	}

	/**
	 * Apply size modifier to item price Bigger the size higher the price
	 * 
	 * @param basePrice
	 * @return price
	 */
	public double applySizeModifier(double basePrice) {
		double price;
		switch (this.sideSize.toLowerCase()) {
		case "small":
			price = basePrice * COST_SIZE_SMALL_MODIFIER;
			break;
		case "medium":
			price = basePrice * COST_SIZE_MEDIUM_MODIFIER;
			break;
		case "large":
			price = basePrice * COST_SIZE_LARGE_MODIFIER;
			break;
		default:
			price = 0;
		}
		return price;
	}

	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		return "Side: " + getName() + ". Size: " + getSideSize() + "."
				+ String.format("$%.2f", getPrice()) + "\n";
	}
}

package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of pizza class Stores information about pizza menu item Extends
 * OrderItem class
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
public class Pizza extends MenuItem {

	private String pizzaSize;
	private int cheeseCount;
	private int pepperoniCount;
	private int hamCount;

	/**
	 * Array of quantity toppings
	 */
	public static final String[] QUANTITY_TOPPINGS_CHEESE = { "1", "2", "3", "4", "5" };

	/**
	 * Array of quantity other toppings
	 */
	public static final String[] QUANTITY_TOPPINGS_OTHER = { "0", "1", "2", "3", "4", "5" };


	/**
	 * Constructor Create an instance of Pizza sets item price and calculate total
	 * price based on quantity with provided:
	 * 
	 * @param sideType
	 * @param sideSize
	 * @param sideQuantity
	 */
	public Pizza(String pizzaSize, int cheeseCount, int pepperoniCount, int hamCount) {
		// using parent constructor
		super(pizzaSize);
		// set type and size
		setPizzaSize(pizzaSize);
		this.cheeseCount = cheeseCount;
		this.pepperoniCount = pepperoniCount;
		this.hamCount = hamCount;
		// set cost
		setPrice(calcCost());
	}

	/**
	 * mutator and accessor methods to get and set Pizza size and toppings
	 *
	 */

	public String getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public int getNumCheeseToppings() {
		return cheeseCount;
	}

	public void setNumCheeseToppings(int cheeseCount) {
		this.cheeseCount = cheeseCount;
	}

	public int getNumPepperoniToppings() {
		return pepperoniCount;
	}

	public void setNumPepperoniToppings(int pepperoniCount) {
		this.pepperoniCount = pepperoniCount;
	}

	public int getNumHmaToppings() {
		return hamCount;
	}

	public void setNumHmaToppings(int hamCount) {
		this.hamCount = hamCount;
	}

	/**
	 * price calculation
	 *
	 *
	 *
	 */

	public double calcCost() {
		if (pizzaSize.equalsIgnoreCase("small")) {
			return 10 + (cheeseCount + pepperoniCount + hamCount) * 2;
		} else if (pizzaSize.equalsIgnoreCase("medium")) {
			return 12 + (cheeseCount + pepperoniCount + hamCount) * 2;
		} else if (pizzaSize.equalsIgnoreCase("large")) {
			return 14 + (cheeseCount + pepperoniCount + hamCount) * 2;
		} else {
			return 0.0;
		}
	}

	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		return "Pizza: " + getName() + ". " + "\n" + "Cheese toppings: " + cheeseCount + "\n"
				+ "Pepperoni toppings: " + pepperoniCount + "\n" + "Ham toppings: " + hamCount + "\n"
				+ String.format("$%.2f", getPrice()) + "\n";
	}
}

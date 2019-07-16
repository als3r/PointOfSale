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
	
	/**
	 * Array of quantity toppings
	 */
	public static final String[] QUANTITY_TOPPINGS_CHEESE = { "1", "2", "3" };

	/**
	 * Array of quantity other toppings
	 */
	public static final String[] QUANTITY_TOPPINGS_OTHER = { "0", "1", "2" };
	
	/**
	 * Price list for pizza
	 */
	public static final double COST_SIZE_SMALL  = 10;
	public static final double COST_SIZE_MEDIUM = 12;
	public static final double COST_SIZE_LARGE  = 14;
	
	public static final double COST_TOPPING_CHEESE    = 2;
	public static final double COST_TOPPING_PEPPERONI = 2;
	public static final double COST_TOPPING_HAM       = 2;

	/**
	 * Size of the pizza
	 */
	private String pizzaSize;
	
	/**
	 * Number of cheese toppings
	 */
	private int cheeseCount;
	
	/**
	 * Number of pepperoni toppings
	 */
	private int pepperoniCount;
	
	/**
	 * Number of ham toppings
	 */
	private int hamCount;


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
	 * Mutator and accessor methods to get and set Pizza size and toppings
	 *
	 */

	/**
	 * Get pizza size
	 * 
	 * @return pizzaSize
	 */
	public String getPizzaSize() {
		return pizzaSize;
	}

	/**
	 * @param pizzaSize
	 */
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	/**
	 * Get number of cheese toppings
	 * 
	 * @return
	 */
	public int getNumCheeseToppings() {
		return cheeseCount;
	}

	/**
	 * Modify number of cheese toppings
	 * 
	 * @param cheeseCount
	 */
	public void setNumCheeseToppings(int cheeseCount) {
		this.cheeseCount = cheeseCount;
	}

	/**
	 * Get number of pepperoni toppings
	 * 
	 * @return
	 */
	public int getNumPepperoniToppings() {
		return pepperoniCount;
	}

	/**
	 * Modify number of pepperoni toppings
	 * 
	 * @param pepperoniCount
	 */
	public void setNumPepperoniToppings(int pepperoniCount) {
		this.pepperoniCount = pepperoniCount;
	}

	/**
	 * Get number of ham toppings
	 * 
	 * @return
	 */
	public int getNumHamToppings() {
		return hamCount;
	}

	/**
	 * Modify number of ham toppings
	 * 
	 * @param hamCount
	 */
	public void setNumHamToppings(int hamCount) {
		this.hamCount = hamCount;
	}

	/**
	 * Price calculation
	 */
	public double calcCost() {
		
		double price = 0;
		
		// get base cost based on size
		if (pizzaSize.equalsIgnoreCase("small")) {
			price = COST_SIZE_SMALL;
		} else if (pizzaSize.equalsIgnoreCase("medium")) {
			price = COST_SIZE_MEDIUM;
		} else if (pizzaSize.equalsIgnoreCase("large")) {
			price = COST_SIZE_LARGE;
		}
		
		// add price for pizza toppings
		price += cheeseCount    * COST_TOPPING_CHEESE;
		price += pepperoniCount * COST_TOPPING_PEPPERONI;
		price += hamCount       * COST_TOPPING_HAM;
		
		return price;
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

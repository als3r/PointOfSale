package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of pizza class
 * Stores information about pizza menu item
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

	private String burgerType;
	private int cheese;
	private int tomato;
	private int bacon;
	private int onions;
	private int pickel;
	private int lettuce;

	/**
	 * To store burger types
	 */
	public static final String[] TYPE_ARRAY = { "HamBurger", "CheeseBurger", "TurkeyBurger", "VeggieBurger" };

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
	 * mutator and accessor methods to get and set burger type and toppings
	 *
	 */

	public String getBurgerType() {
		return burgerType;
	}

	public void setBurgerType(String burgerType) {
		this.burgerType = burgerType;
	}

	public int getCheese() {
		return cheese;
	}

	public void setCheese(int cheese) {
		this.cheese = cheese;
	}

	public int getTomato() {
		return tomato;
	}

	public void setTomato(int tomato) {
		this.tomato = tomato;
	}

	public int getOnion() {
		return onions;
	}

	public void setOnion(int onion) {
		this.onions = onion;
	}

	public int getLettus() {
		return lettuce;
	}

	public void setLettus(int lettuce) {
		this.lettuce = lettuce;
	}

	/**
	 * price calculation
	 *
	 *
	 *
	 */
	public double calcCost() {
		if (burgerType.equalsIgnoreCase("hamburger")) {
			return 4.99 + (bacon + pickel + tomato + onions + lettuce);
		} else if (burgerType.equalsIgnoreCase("cheeseburger")) {
			return 5.99 + (bacon + pickel + tomato + onions + lettuce);
		} else if (burgerType.equalsIgnoreCase("turkeyburger")) {
			return 5.99 + (bacon + pickel + tomato + onions + lettuce);
		} else if (burgerType.equalsIgnoreCase("veggieburger")) {
			return 6.99 + (bacon + pickel + tomato + onions + lettuce);
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
		return "Burger: " + getName() + ". " + "\n" + String.format("$%.2f", getPrice())
				+ "\n";
	}
}

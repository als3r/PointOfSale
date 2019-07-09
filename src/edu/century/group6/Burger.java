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
 * @author Anan Gedefa <pv2824bf@my.century.edu>
 * @author Evelline Samson <cj5673li@my.century.edu> 
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class Burger {

  private String burgerType;
  private int cheese;
  private int tomato;
  private int onion;
 
  
  /**
  * Default constractor initialized to null and 0
  *
  */
  public Burger(){
    
    this.burgerType = "";
    this.cheese = 0;
    this.tomato = 0;
    this.onion = 0;
    setPrice(calcCost());
 }
  
 public Burger (String burgerType, int cheese, int tomato, int onion ){
    
    this.burgerType = burgerType;
    this.bacon = cheese;
    this.pickel = tomato;
    this.tomato = onion;
    setPrice(calcCost());
 }
  
  
  /**
  * mutator and accessor methods to get and set burger type
  * and toppings
  *
  */
 
	public String getBurgerType()
	{
		return burgerType;
	}

	public void setBurgerType(String burgerType)
	{
		this.burgerType = burgerType;
	}

	public int getCheese()
	{
		return cheese;
	}

	public void setCheese(int cheese)
	{
		this.cheese = cheese;
	}

	public int getTomato()
	{
		return tomato;
	}

	public void setTomato(int tomato)
	{
		this.tomato = tomato;
	}

        public int getOnion()
	{
		return onion;
	}

	public void setOnion(int onion)
	{
		this.onion = onion;
	}
  
  
  
  /**
  * price calculation
  *
  *
  *
  */
public double calcCost()
	{		
		if(burgerType.equalsIgnoreCase("Small"))
		{
			return 4.99 + (bacon + pickel + tomato + onion + lattus)
		}
		else if(pizzaSize.equalsIgnoreCase("Medium"))
		{
			return 5.99 + (bacon + pickel + tomato + onion + lattus);
		}
		else if(pizzaSize.equalsIgnoreCase("Large"))
		{
			return 6.99 + (bacon + pickel + tomato + onion + lattus);
		}
		else
		{
			return 0.0;
		}
	}
  
  /**
  * @overide
  *
  */
public String toString()
	{
	return "Burger: " + burgerType + "\n Cheese: " 
		+ cheese + "\n Tomato: "
		+ tomato + "\n Onions: " + onions + 
		+ "\n Total Cost: $" + calcCost() + "\n";
	}
}

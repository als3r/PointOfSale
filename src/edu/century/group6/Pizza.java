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
public class Pizza extends OrderItem {

  private String pizzaSize;
  private int cheeseCount;
  private int pepperoniCount;
  private int hamCount;
  
  /**
  * Default constractor initialized to null and 0
  *
  */
  public Pizza(){
    
    this.pizzaSize = "";
    this.cheeseCount = 0;
    this.pepperoniCount = 0;
    this.hamCount = 0;
    setPrice(calcCost());
 }
  
 public Pizza (String pizzaSize, int cheeseCount, int pepperoniCount, int hamCount){
    
    this.pizzaSize = pizzaSize;
    this.cheeseCount = cheeseCount;
    this.pepperoniCount = pepperoniCount;
    this.hamCount = hamCount;
    setPrice(calcCost());
 }
  
  
  /**
  * mutator and accessor methods to get and set Pizza
  * size and toppings
  *
  */
 
	public String getPizzaSize()
	{
		return pizzaSize;
	}

	public void setPizzaSize(String pizzaSize)
	{
		this.pizzaSize = pizzaSize;
	}

	public int getNumCheeseToppings()
	{
		return cheeseCount;
	}

	public void setNumCheeseToppings(int cheeseCount)
	{
		this.cheeseCount = cheeseCount;
	}

	public int getNumPepperoniToppings()
	{
		return pepperoniCount;
	}

	public void setNumPepperoniToppings(int pepperoniCount)
	{
		this.pepperoniCount = pepperoniCount;
	}

	public int getNumHmaToppings()
	{
		return hamCount;
	}

	public void setNumHmaToppings(int hamCount)
	{
		this.hamCount = hamCount;
	}
  
  
  
  /**
  * price calculation
  *
  *
  *
  */
  
  
  
  
public double calcCost()
	{		
		if(pizzaSize.equalsIgnoreCase("small"))
		{
			return 10 + (cheeseCount + pepperoniCount + hamCount) * 2;
		}
		else if(pizzaSize.equalsIgnoreCase("medium"))
		{
			return 12 + (cheeseCount + pepperoniCount + hamCount) * 2;
		}
		else if(pizzaSize.equalsIgnoreCase("large"))
		{
			return 14 + (cheeseCount + pepperoniCount + hamCount) * 2;
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
		return "Pizza size: " + pizzaSize + "\n Cheese toppings: " 
				+ cheeseCount + "\n Pepperoni toppings: "
				+ pepperoniCount + "\n Ham toppings: " + hamCount
				+ "\n Pizza cost: $" + calcCost() + "\n";
	}
}

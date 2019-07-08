package edu.century.group6;

/**
 * PointOfSale
 * 
 * Definition of pizza class
 * Stores information about general side menu item and drinks
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
public class SideItem extends orderItem{

   private String drink;
  private String fries;
  
  
  /**
  * Default constractor initialized to null and 0
  *
  */
  public SideItem(){
    
    this.drink = "";
    this.fries = ""'
    
 }
  
 public SideItem (String drinks, String fries){
    
    this.drink = drink;
    this.fries = fries;
   
 }
  
  
  /**
  * mutator and accessor methods to get and set side items
  * 
  *
  */
 
	public String getDrink()
	{
		return drink;
	}

	public void setDrink(String drink)
	{
		this.drink = drink;
	}

	public String getFries()
	{
		return fries;
	}

	public void setFries(int fries)
	{
		this.fries = fries;
	}
  
  
  
  /**
  * price calculation
  *
  *
  *
  */
  
  
  
  
public double calcCost()
	{		
		if(drink.equalsIgnoreCase("coke"))
		{
			return 1.00;
		}
		else if(drink.equalsIgnoreCase("water"))
		{
			return 2.00;
		}
		else if(drink.equalsIgnoreCase("beer"))
		{
			return 3.99;
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
		return "Side item: " + drink + fries; 
				
	}
}
  
  
}

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
   
   private String fries;
   private double coke;
   private double water;
   private double beer;
  
  /**
  * Default constractor initialized to null and 0
  *
  */
  public SideItem(){
    
    this.fries = "";
    this.coke = 1.00;
    this.water = 2.00;
    this.beer = 3.00;

  }
  
 public SideItem (String fries, int coke, int water, int beer){
    
    this.fries = fries;
    this.coke = coke;
    this.water = water;
    this.beer = beer;
   
 }
  
  
  /**
  * mutator and accessor methods to get and set side items
  * 
  *
  */
 
	public String getFries()
	{
		return fries;
	}

	public void setFries(String fries)
	{
		this.fries = fries;
	}
	
	public String getCoke()
	{
		return coke;
	}

	public void setCoke(int coke)
	{
		this.coke = coke;
	}
	
	public String getWater()
	{
		return water;
	}

	public void setWater(int water)
	{
		this.water = water;
	
	public String getBeer()
	{
		return beer;
	}

	public void setBeer(int beer)
	{
		this.beer = beer;
  
  
  /**
  * price calculation
  *
  *
  *
  */
  
  
  
  
public double calcCost()
	{		
		if(fries.equalsIgnoreCase("small") )
		{
			return 1.00 + (coke + water + beer)
		}
		else if(fries.equalsIgnoreCase("mediu,"))
		{
			return 2.00 + (coke + water + beer);
		}
		else if(fries.equalsIgnoreCase("large"))
		{
			return 3.00 + (coke + water + beer);
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
		return "Fries: " + fries + "\n Drink: " + coke + "\n Water: "
			+ water + "\n Beer: " + beer;
			
				
	}
}
  
  
}

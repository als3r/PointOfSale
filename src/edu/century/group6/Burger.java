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
public class Burger extends MenuItem {

  private String burgerType;
  private int bacon;
  private int pickel;
  private int tomato;
  private int onion;
  private int lettuce;
  
  public static final String[] TYPE_ARRAY = {
	  "HamBurger", "CheeseBurger", "TurkeyBurger", "VeggieBurger"	  
  };
  
  /**
  * Default constructor initialized to null and 0
  *
  */
  public Burger(){
    
    this.burgerType = "";
    this.bacon = 0; //1.85;
    this.pickel = 0;
    this.tomato = 0;
    this.onion = 0;
    this.lettuce = 0;
    setPrice(calcCost());
 }
  
  public Burger (String burgerType, int burgerQuantity){
	    
	    this.burgerType = burgerType;
	    setPrice(calcCost());
	 }
  
 public Burger (String burgerType, int bacon, int pickel, int tomato, int onion, int lettus){
    
    this.burgerType = burgerType;
    this.bacon = bacon;
    this.pickel = pickel;
    this.tomato = tomato;
    this.onion = onion;
    this.lettuce = lettus;
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

	public int getBacon()
	{
		return bacon;
	}

	public void setBacon(int bacon)
	{
		this.bacon = bacon;
	}

	public int getPickel()
	{
		return pickel;
	}

	public void setPickel(int pickel)
	{
		this.pickel = pickel;
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
      
     
	public int getLettus()
	{
		return lettuce;
	}

	public void setLettus(int lettus)
	{
		this.lettuce = lettus;
	}
  
  
  
  /**
  * price calculation
  *
  *
  *
  */
  
  
  
  
public double calcCost()
	{		
		if(burgerType.equalsIgnoreCase("hamburger"))
		{
			return 4.99 + (bacon + pickel + tomato + onion + lettuce);
		}
		else if(burgerType.equalsIgnoreCase("cheeseburger"))
		{
			return 5.99 + (bacon + pickel + tomato + onion + lettuce);
		}
		else if(burgerType.equalsIgnoreCase("turkeyburger"))
		{
			return 5.99 + (bacon + pickel + tomato + onion + lettuce);
		}
		else if(burgerType.equalsIgnoreCase("veggieburger"))
		{
			return 6.99 + (bacon + pickel + tomato + onion + lettuce);
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
		return "Burger: " + burgerType + "\n Bacon: " 
				+ bacon + "\n Pickel: "
				+ pickel + "\n Tomato: " + tomato + "\n Onions: " + onion 
			        + "\n Lettus: " + lettuce
				+ "\n Total Cost: $" + calcCost() + "\n";
	}
}

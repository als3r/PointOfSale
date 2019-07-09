package edu.century.group6;

/**
* contains instance variable to hold
* Order price
* Unique order ID 
* Description of order
*
*
*/
public class OrderItem {

  private double price;
  String id;
  
  /**
  *
  *mutotor and accessor methods for price 
  *and id
  *
  */
  public void setPrice(double price){
    this.price=price;
  }
  
  public double getPrice(){
    return price;
  }
  
  public void setID(String id){
    this.id=id;
  }
  
  public String getID(){
    return id;
  }
  
  /**
  *
  *@overide
  *
  */
  public String toString(){
    
    return "";
    
  }
  
}

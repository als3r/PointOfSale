package edu.century.group6;

/**
 * PointOfSale
 * 
 * Driver program to test classes
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
public class Driver {

	public static void main(String[] args) {
		
		echo("***** PointOfSale tests *****");
		echo(""); echo(""); echo("");
		
		
		echo("***** Test Create Employees *****");
		echo("Create employees");		
		Employee employee1 = new Employee("00001", "John"   , "Doe", "1 Main St", "Saint Paul", "MN", "50101", "6510001001"); 
		Employee employee2 = new Employee("00002", "Jane"   , "Doe", "1 Main St", "Saint Paul", "MN", "50101", "6510001002"); 
		Employee employee3 = new Employee("00003", "Jasmin" , "Doe", "2 Main St", "Saint Paul", "MN", "50101", "6510001003"); 	
		Employee delivery1 = new Employee("00004", "Joffrey", "Doe", "2 Main St", "Saint Paul", "MN", "50101", "6510001004"); 
		Employee delivery2 = new Employee("00005", "Johhny" , "Doe", "2 Main St", "Saint Paul", "MN", "50101", "6510001005"); 
		Employee delivery3 = new Employee("00006", "James"  , "Doe", "1 Main St", "Saint Paul", "MN", "50101", "6510001006");
		
		echo(employee1.toString());
		echo(employee2.toString());
		echo(employee3.toString());
		
		echo(delivery1.toString());
		echo(delivery2.toString());
		echo(delivery3.toString());
		echo("***** // END Test Create Employees *****");
		echo("");
		
		
		echo("***** Test Create Customers *****");
		echo("Create pizzas");		
		Customer customer1 = new Customer("00001", "Anna", "Smith", "1 Main St", "Saint Paul", "MN", "50101", "6510002001"); 
		Customer customer2 = new Customer("00002", "Abel", "Smith", "1 Main St", "Saint Paul", "MN", "50101", "6510002002"); 
		Customer customer3 = new Customer("00003", "Andy", "Smith", "2 Main St", "Saint Paul", "MN", "50101", "6510002003"); 
		
		echo(customer1.toString());
		echo(customer2.toString());
		echo(customer3.toString());
		echo("***** // END Test Create Customers *****");
		echo("");
		
		
		
		echo("***** Test Create Pizzas *****");
		echo("Create pizzas");		
		Pizza pizza1 = new Pizza("small", 1, 1, 1); 
		Pizza pizza2 = new Pizza("medium", 1, 1, 1); 
		Pizza pizza3 = new Pizza("large", 1, 1, 1); 
		Pizza pizza4 = new Pizza("small", 2, 0, 1); 
		Pizza pizza5 = new Pizza("medium", 1, 1, 0); 
		Pizza pizza6 = new Pizza("large", 2, 1, 1); 
		Pizza pizza7 = new Pizza("small", 2, 0, 1); 
		Pizza pizza8 = new Pizza("small", 1, 3, 1); 
		Pizza pizza9 = new Pizza("small", 1, 2, 2); 
		Pizza pizza10 = new Pizza("small", 1, 1, 3); 		
		echo(pizza1.toString());
		echo("***** // END Test Create Pizzas *****");
		echo("");
		
		
		
		
		echo("***** Test Create Burgers *****");
		echo("Create burgers");	
		
		echo("***** // END Test Burgers Class *****");
		echo("");
		
		
		
		echo("***** Test Create Orders *****");
		echo("Create orders");		
		Order order1 = new Order("1"); 
		Order order2 = new Order("2"); 
		Order order3 = new Order("3"); 
		Order order4 = new Order("4");  
		Order order5 = new Order("5");  	
		echo("Order#1 OrderNumber: " + order1.getOrderNumber());
		echo("Order#2 OrderNumber: " + order2.getOrderNumber());
		echo("Order#3 OrderNumber: " + order3.getOrderNumber());
		echo("Order#4 OrderNumber: " + order4.getOrderNumber());
		echo("Order#5 OrderNumber: " + order5.getOrderNumber());
		echo("***** // END Test Create Orders *****");
		echo("Create orders");

		
		
		echo("***** Test Add/Remove Pizzas To Order *****");
		echo("Order#1 NumItems: " + order1.getNumItems());
		echo("Order#2 NumItems: " + order2.getNumItems());
		echo("Order#3 NumItems: " + order3.getNumItems());
		echo("Order#4 NumItems: " + order4.getNumItems());
		echo("Order#5 NumItems: " + order5.getNumItems());
		echo("Add pizzas");
		order1.addOrderItem(pizza1).addOrderItem(pizza2).addOrderItem(pizza3).addOrderItem(pizza4);
		order2.addOrderItem(pizza1).addOrderItem(pizza8).addOrderItem(pizza9).addOrderItem(pizza2).addOrderItem(pizza3);
		order3.addOrderItem(pizza4).addOrderItem(pizza5);
		order4.addOrderItem(pizza8).addOrderItem(pizza6).addOrderItem(pizza7);
		order5.addOrderItem(pizza10).addOrderItem(pizza8).addOrderItem(pizza9).addOrderItem(pizza2);
		echo("Order#1 NumItems: " + order1.getNumItems());
		echo("Order#2 NumItems: " + order2.getNumItems());
		echo("Order#3 NumItems: " + order3.getNumItems());
		echo("Order#4 NumItems: " + order4.getNumItems());
		echo("Order#5 NumItems: " + order5.getNumItems());
		echo("Remove 1 pizza from order#5");
		order5.removeOrderItem(3);
		echo("Order#5 NumItems: " + order5.getNumItems());
		echo("***** // END Add/Remove Pizzas To Order *****");
		echo("");
		
		
		
		echo("***** Test Printing Orders *****");
		echo("Printing orders");
		echo(order1.toString());
		echo(order2.toString());
		echo(order3.toString());
		echo(order4.toString());
		echo(order5.toString());
		echo("***** // END Test Printing Orders *****");
		echo("");
		
		
		
		// test order track time functions
		echo("***** Test Order Track Time *****");
		echo("Create empty order1");
		int sleepTime1 = 0 * 1000; // in milliseconds
		int sleepTime2 = 0 * 1000; // in milliseconds
		int sleepTime3 = 0 * 1000; // in milliseconds
		
		try {
			// change order status to order received
			echo("Order Received Time: " + order1.getOrderReceivedTimeFormatted());
			
			// wait and change to cooked
			Thread.sleep(sleepTime1);
			order1.orderStatusCooked();
			echo("Order Cooked Time: " + order1.getOrderCookTimeFormatted());
			
			// wait and change to delivered
			Thread.sleep(sleepTime2);
			order1.orderStatusDelivered();
			echo("Order Delivered Time: " + order1.getOrderDeliveryTimeFormatted());
			
			// wait and change to completed
			Thread.sleep(sleepTime3);
			order1.orderStatusCompleted();
			echo("Order Completed Time: " + order1.getOrderCompletedTimeFormatted());
			
			// get total order time
			echo("Total Order Time (full): " + order1.getOrderTotalTimeFormatted());
			echo("Total Order Time (in sec): " + order1.getOrderTotalTimeSeconds());
		
		} catch (InterruptedException ie) {
			echo("Error. Cannot use wait");
		}
		echo("***** // END Test Order Track Time *****");
		echo("");
		
		
		
	}
	
	
	public static void echo (String string) {
		System.out.println(string);
	}

}

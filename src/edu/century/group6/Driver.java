package edu.century.group6;

import java.util.concurrent.TimeUnit;

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
		
//		Customer customer = new Customer();
//		Employee employee = new Employee();
//		System.out.println("test");
//		System.out.println(customer.toString());
//		System.out.println(employee.toString());
		
		
		echo("***** PointOfSale tests *****");
		echo("");
		
		
		
		
		
		
		
		
		
		// test order track time functions
		Order order1 = new Order();
		echo("***** Test Order Track Time *****");
		echo("Create empty order1");
		
		try {
			// change order status to order received
			order1.orderStatusReceived();
			echo("Order Received Time: " + order1.getOrderReceivedTimeFormatted());
			
			// wait and change to cooked
			Thread.sleep(1500);
			order1.orderStatusCooked();
			echo("Order Cooked Time: " + order1.getOrderCookTimeFormatted());
			
			// wait and change to delivered
			Thread.sleep(2300);
			order1.orderStatusDelivered();
			echo("Order Delivered Time: " + order1.getOrderDeliveryTimeFormatted());
			
			// wait and change to completed
			Thread.sleep(4500);
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

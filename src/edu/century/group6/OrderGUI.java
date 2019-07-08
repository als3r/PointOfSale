package edu.century.group6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * PointOfSale
 * 
 * Definition of order GUI class
 * Displays GUI for user and allow him to make an order
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
public class OrderGUI extends JFrame implements ActionListener {
	
	/**
	 * Program Name
	 */
	private static final String PROGRAM_NAME = "PointOfSale";
	
	/**
	 * Version
	 */
	private static final long serialVersionUID = 1;
	
	/**
	 * Window's width
	 */
	private static final int WINDOW_WIDTH  = 1024;
	
	/**
	 * Window's height
	 */
	private static final int WINDOW_HEIGHT = 768;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	/**
	 * Buttons click handler
	 */
	public void actionPerformed(ActionEvent e)
	{
	    String actionCommand = e.getActionCommand( );
	    
	    if (actionCommand.equals("Order")) {
	    	
	    	// Place an order
	    
	    } else if (actionCommand.equals("Complete")) {
	    	
	    	// Complete Order
	    	
	    } else {
	    	
	    	// Could not find action
	    }
	}

}

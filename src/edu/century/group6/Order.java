package edu.century.group6;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * PointOfSale
 * 
 * Definition of order class
 * Stores information about order
 * 
 * Order has 4 step/statuses:
 * - new order
 * - cooking
 * - delivery
 * - completed
 * 
 * each time order status is changed we update time for each step/status
 * to be able to track order completion time
 * 
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
public class Order {


	/**
	 * Order Number
	 */
	private String orderNumber;

	/**
	 * Max Items in Order
	 */
	private static final int MAX_ORDER_ITEMS = 100;
	
	/**
	 * Tax constant, in percents
	 */
	private static final double TAX = 9;
	
	/**
	 * Stores order Items
	 */
	private List<MenuItem> orderItems = new ArrayList<>();
	
	/**
	 * Number of items in the order
	 */
	private int numItems;
	
	/**
	 * Order Comment
	 */
	private String comment;
	
	/**
	 * Customer
	 */
	private Customer customer;
	
	/**
	 * Employee who created order
	 */
	private Employee employee;
	
	/**
	 * Delivery person
	 */
	private Employee delivery;
	
	/**
	 * Delivery address
	 */
	private String deliveryAddress;
	
	/**
	 * Time needed to deliver order
	 */
	private Date deliveryTime;
	
	/**
	 * Time when order was received
	 */
	private Date orderReceivedTime;
	
	/**
	 * Time when order was cooked
	 */
	private Date orderCookTime;
	
	/**
	 * Time when order was delivered
	 */
	private Date orderDeliveryTime;
	
	/**
	 * Time when order was completed
	 */
	private Date orderCompletedTime;
	
	/**
	 * Order total time, in seconds
	 */
	private long orderTotalTime;

	/**
	 * Order Status
	 * 
	 */
	public enum ORDER_STATUSES {
		ORDER_STATUS_RECEIEVED, 
		ORDER_STATUS_PREPARED, 
		ORDER_STATUS_DELIVERED, 
		ORDER_STATUS_COMPLETED
	};
	
	/**
	 * order Status from orderStatuses
	 */
	private ORDER_STATUSES orderStatus;
	
	/**
	 * Order Created Format
	 */
	public static String orderDatePattern = "H:m:s MM/dd/yyyy";
	
	/**
	 * Whether customer required delivery
	 * Default: false (no delivery for this order)
	 */
	private boolean isDelivered = false;
	
	/**
	 * Order sub total
	 */
	private double subTotal = 0;
	
	/**
	 * Order Tax
	 */
	private double tax = 0;
	
	/**
	 * Total
	 */
	private double total = 0;

	
	/**
	 * 
	 * Mutators and Accessors
	 * 
	 */
	
	/**
	 * @return
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	/**
	 * Get order comment
	 * 
	 * @return comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Modify order comment
	 * 
	 * @param comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Get customer (Customer type)
	 * 
	 * @return customer Customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * Modify customer of Customer type
	 * 
	 * @param customer Customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * Get employee (Employee type)
	 * 
	 * @return employee Employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * Modify employee of Employee type
	 * 
	 * @param employee
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Get Delivery Person of Employee type
	 * 
	 * @return delivery Employee
	 */
	public Employee getDelivery() {
		return delivery;
	}

	/**
	 * Modify delivery person of Employee type
	 * 
	 * @param delivery Employee
	 */
	public void setDelivery(Employee delivery) {
		this.delivery = delivery;
	}

	/**
	 * Get delivery local address
	 * 
	 * @return deliveryAddress
	 */
	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Modify delivery local address
	 * 
	 * @param deliveryAddress
	 */
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	/**
	 * Get whether customer required delivery
	 * 
	 * @return isDelivered
	 */
	public boolean isDelivered() {
		return isDelivered;
	}

	/**
	 * Set whether customer required delivered
	 * 
	 * @param isDelivered
	 */
	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	/**
	 * Get order sub total
	 * 
	 * @return subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * Modify order subtotal
	 */
	private void setSubTotal() {
		this.subTotal = calcSubTotal();
	}

	/**
	 * Get order tax amount
	 * 
	 * @return tax
	 */
	public double getTax() {
		return tax;
	}

	/**
	 * 
	 */
	private void setTax() {
		tax = getSubTotal() * (TAX / 100);
	}

	/**
	 * Get order total price
	 * 
	 * @return total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * Modify order total price
	 */
	private void setTotal() {
		total = getSubTotal() * (1 + (TAX / 100));
	}
	
	/**
	 * Calculate order price including tax and sub total
	 */
	public void calcOrderPrice() {
		setSubTotal();
		setTax();
		setTotal();
	}

	/**
	 * Return order received time (Step 1)
	 * @return Date orderReceivedTime
	 */
	public Date getOrderReceivedTime() {
		return orderReceivedTime;
	}

	/**
	 * Return formatted order received time (Step 1)
	 * @return String orderDeliveryTime
	 */
	public String getOrderReceivedTimeFormatted() {
		return new SimpleDateFormat(orderDatePattern).format(getOrderReceivedTime());
	}
	
	/**
	 * Modifies orderReceivedTime
	 * Sets time to current time
	 */
	public void setOrderReceivedTime() {
		this.orderReceivedTime = new Date();
	}

	/**
	 * Modifies orderReceivedTime
	 * @param orderReceivedTime
	 */
	public void setOrderReceivedTime(Date orderReceivedTime) {
		this.orderReceivedTime = orderReceivedTime;
	}
	
	/**
	 * Return order cook time (Step 2)
	 * @return Date orderCookTime
	 */
	public Date getOrderCookTime() {
		return orderCookTime;
	}

	/**
	 * Return formatted order cook time (Step 2)
	 * @return String orderDeliveryTime
	 */
	public String getOrderCookTimeFormatted() {
		return new SimpleDateFormat(orderDatePattern).format(getOrderCookTime());
	}

	/**
	 * Modifies orderCookTime
	 * Sets time to current time
	 */
	public void setOrderCookTime() {
		this.orderCookTime = new Date();
	}
	
	/**
	 * Modifies orderCookTime
	 * @param orderCookTime
	 */
	public void setOrderCookTime(Date orderCookTime) {
		this.orderCookTime = orderCookTime;
	}
	
	/**
	 * Return order delivery time (Step 3)
	 * @return Date orderDeliveryTime
	 */
	public Date getOrderDeliveryTime() {
		return orderDeliveryTime;
	}

	/**
	 * Return formatted order delivery time (Step 3)
	 * @return String orderDeliveryTime
	 */
	public String getOrderDeliveryTimeFormatted() {
		return new SimpleDateFormat(orderDatePattern).format(getOrderDeliveryTime());
	}

	/**
	 * Modifies orderDeliveryTime
	 * Sets time to current time
	 */
	public void setOrderDeliveryTime() {
		this.orderDeliveryTime = new Date();
	}

	/**
	 * Modifies orderDeliveryTime
	 * @param orderCookTime
	 */
	public void setOrderDeliveryTime(Date orderDeliveryTime) {
		this.orderDeliveryTime = new Date();
	}
	
	/**
	 * Return order completed time (Step 4)
	 * @return Date orderCompletedTime
	 */
	public Date getOrderCompletedTime() {
		return orderCompletedTime;
	}

	/**
	 * Return formatted order total time (Step 4)
	 * @return String orderTotalTime
	 */
	public String getOrderCompletedTimeFormatted() {
		return new SimpleDateFormat(orderDatePattern).format(getOrderCompletedTime());
	}

	/**
	 * Modifies orderCompletedTime
	 * Sets time to current time
	 */
	public void setOrderCompletedTime() {
		this.orderCompletedTime = new Date();
	}

	/**
	 * Modifies orderCompletedTime
	 * @param orderCompletedTime
	 */
	public void setOrderCompletedTime(Date orderCompletedTime) {
		this.orderCompletedTime = orderCompletedTime;
	}

	/**
	 * Return order total time
	 * @return long orderTotalTime
	 */
	public long getOrderTotalTime() {
		return orderTotalTime;
	}
	
	public long getOrderTotalTimeSeconds() {
		return orderTotalTime;
	}

	/**
	 * Return formatted order total time (0m 0s)
	 * @return String orderTotalTime
	 */
	public String getOrderTotalTimeFormatted() {
		
		String message = "";
		long minutes = 0;
		long seconds = 0;
		
		minutes = getOrderTotalTime() / 60;
		seconds = getOrderTotalTime() % 60;
		
		if(minutes > 0) {
			message += minutes + "m ";
		}
		
		message += seconds + "s";
	
		return message;
	}

	/**
	 * Modify order total time
	 */
	public void setOrderTotalTime() {
		long miliseconds = (getOrderCompletedTime().getTime() - getOrderReceivedTime().getTime());
		this.orderTotalTime = miliseconds/1000;
	}
	
	/**
	 * Get order status
	 * 
	 * @return orderStatus
	 */
	public ORDER_STATUSES getOrderStatus() {
		return orderStatus;
	}

	/**
	 * Modify order status
	 * 
	 * @param orderStatus
	 */
	public void setOrderStatus(ORDER_STATUSES orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	
	/**
	 * Construct instance of order class
	 * with provided:
	 * order number 
	 * 
	 * @param orderNumber
	 */
	Order(String orderNumber){
		this.orderNumber = orderNumber;
		this.orderItems = new ArrayList<>(MAX_ORDER_ITEMS);
		orderStatusReceived();	
		calcOrderPrice();
	}
	
	
	/**
	 * Construct instance of order class
	 * with provided:
	 * order number and whether order has delivery 
	 * 
	 * @param orderNumber
	 * @param isDelivered
	 */
	Order(String orderNumber, boolean isDelivered){
		setOrderNumber(orderNumber);
		setDelivered(isDelivered);
		this.orderItems = new ArrayList<>(MAX_ORDER_ITEMS);
		orderStatusReceived();	
		calcOrderPrice();
	}
	
	
	/**
	 * Updates order status to Received (ORDER_STATUSES.ORDER_STATUS_RECEIEVED)
	 * Sets time when order was received
	 * 
	 * @return this instance of Order class
	 */
	public Order orderStatusReceived() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_RECEIEVED);
		setOrderReceivedTime();
		return this;
	}
	
	
	/**
	 * Updates order status to Received (ORDER_STATUSES.ORDER_STATUS_PREPARED)
	 * Sets time when order was prepared/cooked
	 * 
	 * @return this instance of Order class
	 */
	public Order orderStatusCooked() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_PREPARED);
		setOrderCookTime();
		return this;
	}
	
	
	/**
	 * Updates order status to Received (ORDER_STATUSES.ORDER_STATUS_DELIVERED)
	 * Sets time when order was delivered
	 * 
	 * @return this instance of Order class
	 */
	public Order orderStatusDelivered() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_DELIVERED);
		setOrderDeliveryTime();
		return this;
	}
	
	
	/**
	 * Updates order status to Received (ORDER_STATUSES.ORDER_STATUS_COMPLETED)
	 * Sets time when order was completed
	 * 
	 * @return this instance of Order class
	 */
	public Order orderStatusCompleted() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_COMPLETED);
		setOrderCompletedTime();
		setOrderTotalTime();
		return this;
	}
	
	
	/**
	 * Adds order item to order
	 * 
	 * @param orderItem
	 * @return this order
	 */
	public Order addOrderItem(MenuItem orderItem) {
		orderItems.add(orderItem);
		calcOrderPrice();
		return this;
	}
	
	
	/**
	 * Remove order item from order by index
	 * 
	 * @param index
	 * @return this order
	 */
	public Order removeOrderItem(int index) {
		if ( 
			index >= 0 && 
			index < orderItems.size() &&
			orderItems.get(index) != null && 
			orderItems.get(index) instanceof MenuItem
		) {
			orderItems.remove(index);
			calcOrderPrice();
		}
		return this;
	}
	
	
	/**
	 * Remove all order items from order
	 * 
	 * @param index
	 * @return this order
	 */
	public Order removeAllOrderItems() {
		this.orderItems = new ArrayList<>(MAX_ORDER_ITEMS);
		return this;
	}
	
	
	/**
	 * Calculate sub total of all order items
	 * 
	 * @return subTotal
	 */
	public double calcSubTotal() {
		double subTotal = 0;
		for (int i = 0; i < orderItems.size(); i++) {
			if (orderItems.get(i) != null && orderItems.get(i) instanceof MenuItem) {
				subTotal += orderItems.get(i).getPrice();
			}
		}
		return subTotal;
	}


	/**
	 * Returns number of items in the order
	 * 
	 * @return numItems
	 */
	public int getNumItems() {
		int numItems = 0;
		for (int i = 0; i < orderItems.size(); i++) {
			if (orderItems.get(i) != null && orderItems.get(i) instanceof MenuItem) {
				numItems++;
			}
		}
		return numItems;
	}
	
	
	public List<MenuItem> getOrderItems() {
		return orderItems;
	}
	
	
	/**
	 * Return formatted order information
	 * 
	 * @return String
	 */
	public String printOrder() {
		return toString();
	}
	
	
	
	/**
	 * Description For Kitchen
	 * 
	 * @return the formatted string of reservation data
	 */
	public String toKitchenString() {
		String message = "";
		String itemMessage = "";
		String customerMessage = "";
		
		message += "Order Number# " + getOrderNumber() + "\n";
		message += "Date: " + getOrderReceivedTimeFormatted() + "\n";
		if(getCustomer() != null && getCustomer() instanceof Customer) {
			customerMessage += "Customer#: " + getCustomer().getCustomerNumber() + "\n";
			customerMessage += "Name: " + getCustomer().getFirstName() + " " + getCustomer().getLastName() + "\n";
			customerMessage += "Phone: " + getCustomer().getFirstName() + " " + getCustomer().getLastName() + "\n";
		}
		message += customerMessage;
		
		message += "Items: " + getNumItems() + "\n";
		
		message += "----------------------------------------" + "\n";
		
		for (int i = 0; i < orderItems.size(); i++) {
			if (orderItems.get(i) != null && orderItems.get(i) instanceof MenuItem) {
				if(! itemMessage.isEmpty()) {					
					itemMessage += "----------------------------------------" + "\n";
				}
				itemMessage += "#" + (i+1) + "\n";
				itemMessage += orderItems.get(i).toKitchenString();
				
			}
		}
		if(! itemMessage.isEmpty()) {
			message += itemMessage;
			message += "----------------------------------------" + "\n";
		}
		return message;
	}
	
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of order
	 */
	@Override
	public String toString() {
		String message = "";
		String itemMessage = "";
		String customerMessage = "";
		
		message += "========================================" + "\n";
		message += "Order Number# " + getOrderNumber() + "\n";
		message += "Date: " + getOrderReceivedTimeFormatted() + "\n";
		if(getCustomer() != null && getCustomer() instanceof Customer) {
			customerMessage += "Customer#: " + getCustomer().getCustomerNumber() + "\n";
			customerMessage += "Name: " + getCustomer().getFirstName() + " " + getCustomer().getLastName() + "\n";
		}
		message += customerMessage;
		
		if(isDelivered) {
			message += "Delivery requested" + "\n";
			message += "Address: " + getDeliveryAddress() + "\n";
		}
		
		
		message += "Items: " + getNumItems() + "\n";
		
		message += "----------------------------------------" + "\n";
		
		for (int i = 0; i < orderItems.size(); i++) {
			if (orderItems.get(i) != null && orderItems.get(i) instanceof MenuItem) {
				if(! itemMessage.isEmpty()) {					
					itemMessage += "----------------------------------------" + "\n";
				}
				itemMessage += "Item #" + (i+1) + "\n";
				itemMessage += orderItems.get(i).toString();
				
			}
		}
		if(! itemMessage.isEmpty()) {
			message += itemMessage;
			message += "----------------------------------------" + "\n";
		}
		message += String.format("%-20s $%.2f%n", "SubTotal:", getSubTotal());
		message += String.format("%-20s $%.2f%n", "Tax ("+String.format("%.1f", TAX)+"%):"     , getTax()); 
		message += String.format("%-20s $%.2f%n", "Total:"   , getTotal());
		message += "========================================" + "\n";
		return message;
	}
}

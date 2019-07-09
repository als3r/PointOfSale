package edu.century.group6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.NumberFormat;

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
	private MenuItem[] orderItems;
	
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
	private enum ORDER_STATUSES {
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
	 * Whether order delivered or not
	 * Default: false
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

	

	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getDelivery() {
		return delivery;
	}

	public void setDelivery(Employee delivery) {
		this.delivery = delivery;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	
	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public double getSubTotal() {
		return subTotal;
	}

	private void setSubTotal() {
		this.subTotal = calcSubTotal();
	}

	public double getTax() {
		return tax;
	}

	private void setTax() {
		tax = getSubTotal() * (TAX / 100);
	}

	public double getTotal() {
		return total;
	}

	private void setTotal() {
		total = getSubTotal() * (1 + (TAX / 100));
	}
	
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

	public void setOrderTotalTime() {
		long miliseconds = (getOrderCompletedTime().getTime() - getOrderReceivedTime().getTime());
		this.orderTotalTime = miliseconds/1000;
	}
	
	public ORDER_STATUSES getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(ORDER_STATUSES orderStatus) {
		this.orderStatus = orderStatus;
	}



	/**
	 * Default constructor for order
	 * 
	 * Construct an instance with default values
	 */
	Order(){
		this.orderItems = new MenuItem[MAX_ORDER_ITEMS];
		orderStatusReceived();	
		calcOrderPrice();
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
		this.orderItems = new MenuItem[MAX_ORDER_ITEMS];
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
		this.orderItems = new MenuItem[MAX_ORDER_ITEMS];
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
		for (int i = 0; i < orderItems.length; i++) {
			if (orderItems[i] == null) {
				orderItems[i] = orderItem;
				calcOrderPrice();
				break;
			}
		}
		return this;
	}
	
	
	/**
	 * Remove order item from order by index
	 * 
	 * @param index
	 * @return this order
	 */
	public Order removeOrderItem(int index) {
		if (orderItems[index] != null && orderItems[index] instanceof MenuItem) {
			orderItems[index] = null;
			calcOrderPrice();
		}
		return this;
	}
	
	
	/**
	 * Calculate subtotal of all order items
	 * 
	 * @return subTotal
	 */
	public double calcSubTotal() {
		double subTotal = 0;
		for (int i = 0; i < orderItems.length; i++) {
			if (orderItems[i] != null && orderItems[i] instanceof MenuItem) {
				subTotal += orderItems[i].getPrice();
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
		for (int i = 0; i < orderItems.length; i++) {
			if (orderItems[i] != null && orderItems[i] instanceof MenuItem) {
				numItems++;
			}
		}
		return numItems;
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
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
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
		
		for (int i = 0; i < orderItems.length; i++) {
			if (orderItems[i] != null && orderItems[i] instanceof MenuItem) {
				if(! itemMessage.isEmpty()) {					
					itemMessage += "----------------------------------------" + "\n";
				}
				itemMessage += "Item #" + (i+1) + "\n";
				itemMessage += orderItems[i].toString();
				
			}
		}
		if(! itemMessage.isEmpty()) {
			message += itemMessage;
			message += "----------------------------------------" + "\n";
		}
		message += String.format("%-20s%5.2f\n", "SubTotal:", getSubTotal());
		message += String.format("%-20s%5.2f\n", "Tax:"     , getTax()); 
		message += String.format("%-20s%5.2f\n", "Total:"   , getTotal());
		message += "========================================" + "\n";
		return message;
	}
}

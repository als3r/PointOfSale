package edu.century.group6;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	 * Stores order Items
	 */
	private OrderItem[] orderItems;
	
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
	
	
	
	
	
	/*
	 * Getter and Setters
	 */
	
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



	/*
	 * Default constructor for order
	 * 
	 * Construct an instance with default values
	 */
	Order(){
		orderStatusReceived();	
	}
	
	public boolean orderStatusReceived() {
		this.orderItems = new OrderItem[MAX_ORDER_ITEMS];
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_RECEIEVED);
		setOrderReceivedTime();
		return true;
	}
	
	public boolean orderStatusCooked() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_PREPARED);
		setOrderCookTime();
		return true;
	}
	
	public boolean orderStatusDelivered() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_DELIVERED);
		setOrderDeliveryTime();
		return true;
	}
	
	public boolean orderStatusCompleted() {
		setOrderStatus(ORDER_STATUSES.ORDER_STATUS_COMPLETED);
		setOrderCompletedTime();
		setOrderTotalTime();
		return true;
	}
	
	public Order addOrderItem(OrderItem orderItem) {
		for (int i = 0; i < orderItems.length; i++) {
			if (orderItems[i] == null) {
				orderItems[i] = orderItem;
				break;
			}
		}
		return this;
	}
	
	public void removeOrderItem() {
		
	}



	public OrderItem[] getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(OrderItem[] orderItems) {
		this.orderItems = orderItems;
	}



	public int getNumItems() {
		return numItems;
	}



	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}
	
	
	public void calcSubTotal() {
		
	}
	
	public void calcTax() {
		
	}
	
	public void calcTotal() {
		
	}
	
	
	public void printOrder() {
		
	}
	
	
	public void sendOrder() {
		
	}
	
	
	public void calcOrderTime() {
		
	}
	
	public void calcWaitTime() {
		
	}
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		return message;
	}
}

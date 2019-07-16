package edu.century.group6;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	private static final String BUSINESS_NAME = "HOT OVEN & GRILL";
	
	/**
	 * Program Name
	 */
	private static final String PROGRAM_NAME = "Point Of Sale - " + BUSINESS_NAME + " - ORDER MENU";
	
	/**
	 * Version
	 */
	private static final long serialVersionUID = 1;
	
	/**
	 * Window's width
	 */
	private static final int WINDOW_WIDTH  = 1368;
	
	/**
	 * Window's height
	 */
	private static final int WINDOW_HEIGHT = 900;
	
	/**
	 * Console text area's "width" in number of characters
	 */
	private static final int TEXTAREA_NUMBER_OF_CHAR = 60;
	
	/**
	 * Console text area's "height" in number of lines
	 */
	private static final int TEXTAREA_NUMBER_OF_LINES = 36;
	
	/**
	 * Number of character for input text fields
	 */
	private static final int NUMBER_OF_CHAR_INPUT_10 = 10;
	private static final int NUMBER_OF_CHAR_INPUT_20 = 20;
	
	/**
	 * To keep order number
	 */
	private static int ORDER_NUMBER = 100;
	
	/**
	 * To keep customer number
	 */
	private static int CUSTOMER_NUMBER = 1000;
	
	
	/**
	 * Save order files path
	 * Default system temp dir
	 */
	private static String ORDERS_SAVE_PATH = System.getProperty("java.io.tmpdir");
	
	
	
	
	/**
	 * Order
	 */
	private Order order;
	
	/**
     * JTextArea for Console textArea
     */
    private JTextArea orderConsoleTextArea;
	
	/**
	 * Array of size
	 */
	public static final String[] SIZE_ARRAY = {
		"Small", "Medium", "Large"
	};
	
	/**
	 * Array of quantity
	 */
	public static final String[] QUANTITY_ARRAY = {
		"1","2","3","4","5","6","7","8","9","10"
	};
    
    
	/**
     * JComboBox for pizza size
     */
    private JComboBox  pizzaSizeSelector = new JComboBox(SIZE_ARRAY);
	
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaCheeseToppingQuantitySelector = new JComboBox(Pizza.QUANTITY_TOPPINGS_CHEESE);
    
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaPepperoniToppingQuantitySelector = new JComboBox(Pizza.QUANTITY_TOPPINGS_OTHER);
    
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaHamToppingQuantitySelector = new JComboBox(Pizza.QUANTITY_TOPPINGS_OTHER);
    
    
    
    /**
     * JComboBox for burger size
     */
    private JComboBox  burgerTypeSelector = new JComboBox(Burger.TYPE_ARRAY);
    
    /**
     * JComboBox for burger quantity (0-20)
     */
    private JComboBox  burgerQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    
    
    /**
     * JComboBox for French fries size
     */
    private JComboBox  frenchFriesSizeSelector = new JComboBox(SIZE_ARRAY);
    
    /**
     * JComboBox for French fries quantity (0-20)
     */
    private JComboBox  frenchFriesQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    
    
    /**
     * JComboBox for onion rings size
     */
    private JComboBox  onionRingsSizeSelector = new JComboBox(SIZE_ARRAY);
    
    /**
     * JComboBox for onion rings quantity (0-20)
     */
    private JComboBox  onionRingsQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    
    /**
     * JComboBox for onion rings size
     */
    private JComboBox  drinkTypeSelector = new JComboBox(Drink.TYPE_ARRAY);
    
    /**
     * JComboBox for onion rings size
     */
    private JComboBox  drinkSizeSelector = new JComboBox(Drink.SIZE_ARRAY);
    
    /**
     * JComboBox for onion rings quantity (0-20)
     */
    private JComboBox  drinkQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    /**
     * JTextField remove item index
     */
    private JTextField removeItemIndexTextField        = new JTextField(NUMBER_OF_CHAR_INPUT_10);
    
    /**
     * JTextField customer form
     */
    private JTextField customerFirstNameTextField      = new JTextField(NUMBER_OF_CHAR_INPUT_20);
    private JTextField customerLastNameTextField       = new JTextField(NUMBER_OF_CHAR_INPUT_20);
    private JTextField customerPhoneNumberTextField    = new JTextField(NUMBER_OF_CHAR_INPUT_10);
    private JTextField customerAddressTextField        = new JTextField(NUMBER_OF_CHAR_INPUT_20);
    private JTextField customerCityTextField           = new JTextField(NUMBER_OF_CHAR_INPUT_20);
    private JTextField customerStateTextField          = new JTextField(NUMBER_OF_CHAR_INPUT_10);
    private JTextField customerZIPTextField            = new JTextField(NUMBER_OF_CHAR_INPUT_10);
    private JCheckBox customerDeliveryNeededJCheckBox  = new JCheckBox("Delivery Needed?");
    
    
    
    /**
	 * Button Captions
	 */
	public static final String BUTTON_CAPTION_ADD_PIZZA          = "Add Pizza";
	public static final String BUTTON_CAPTION_ADD_BURGER         = "Add Burger";
	public static final String BUTTON_CAPTION_ADD_FRENCH_FRIES   = "Add French Fries";
	public static final String BUTTON_CAPTION_ADD_ONION_RINGS    = "Add Onion Rings";
	public static final String BUTTON_CAPTION_ADD_DRINK          = "Add Drink";
	public static final String BUTTON_CAPTION_ADD_CUSTOMER       = "Add Customer";
	
	public static final String BUTTON_CAPTION_RESET_PIZZA        = "Reset Pizza";
	public static final String BUTTON_CAPTION_RESET_BURGER       = "Reset Burger";
	public static final String BUTTON_CAPTION_RESET_FRENCH_FRIES = "Reset French Fries";
	public static final String BUTTON_CAPTION_RESET_ONION_RINGS  = "Reset Onion Rings";
	public static final String BUTTON_CAPTION_RESET_DRINK        = "Reset Drink";
	public static final String BUTTON_CAPTION_RESET_CUSTOMER     = "Reset Customer";
	
	public static final String BUTTON_CAPTION_REMOVE_ITEM        = "Remove Item";
	public static final String BUTTON_CAPTION_PLACE_ORDER        = "Order";
	public static final String BUTTON_CAPTION_CLEAR_ORDER_ITEMS  = "Clear Order";
    
    
	
	
	/**
     * Main function
     * 
     * @param args
     */
	public static void main(String[] args) {
		OrderGUI gui = new OrderGUI( );
    	// in order to display window centrally
    	gui.setLocationRelativeTo(null);
        gui.setVisible(true);
	}
	
	
	public OrderGUI( ) {
		
		super(PROGRAM_NAME);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        order = new Order(String.valueOf(ORDER_NUMBER));
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainPanel.setLayout(layout);
        
        
        // Define Console Text Area
        // Label and border around console text area
        JPanel consolePanel = new JPanel ();
        consolePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "ORDER RECEIPT" ) );
        // text area
        orderConsoleTextArea = new JTextArea(TEXTAREA_NUMBER_OF_LINES, TEXTAREA_NUMBER_OF_CHAR);
        orderConsoleTextArea.setFont(new Font("monospaced", Font.PLAIN, 14));
        // add scroll to text area
        JScrollPane scrollPanel = new JScrollPane(orderConsoleTextArea);
        scrollPanel.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        consolePanel.add(scrollPanel);
        
        
        
        //define form labels
        JLabel MenuLabel                = new JLabel(BUSINESS_NAME + " MENU");
        JLabel PizzaLabel               = new JLabel("PIZZA  FROM $10 Small; $12 Medium; $14 Large");
        
        JLabel PizzaSizeLabel           = new JLabel("Size");
        JLabel PizzaToppingsLabel       = new JLabel("PIZZA TOPPINGS");
        JLabel PizzaCheeseTopping       = new JLabel("Cheese (+$2)");
        JLabel PizzaPeperoniTopping     = new JLabel("Peperoni (+$2)");
        JLabel PizzaHamTopping          = new JLabel("Ham (+$2)");
        JLabel PizzaQuantity            = new JLabel("Quantity");
        
        
        JLabel BurgerLabel              = new JLabel("BURGERS");
        JLabel BurgerPriceLabel         = new JLabel("$4.99 Hamburger; $5.99 Cheeseburger, Turkey; $6.99 Veggie");
        JLabel BurgerTypeLabel          = new JLabel("Burger");
        JLabel BurderIncludeTextLabel   = new JLabel("Includes Tomato, Onion, Lettuce, Pickles");
        JLabel BurgerQuantityLabel      = new JLabel("Quantity");
        
        
        JLabel FrenchFriesLabel         = new JLabel("FRENCH FRIES  $2.00 Small; $2.50 Medium; $3.20 Large");
        JLabel FrenchFriesSizeLabel     = new JLabel("Size");
        JLabel FrenchFriesQuantityLabel = new JLabel("Quantity");
        
        JLabel OnionsLabel              = new JLabel("ONION RINGS  $3.00 Small; $3.75 Medium; $4.80 Large");
        JLabel OnionsSizeLabel          = new JLabel("Size");
        JLabel OnionsQuantityLabel      = new JLabel("Quantity");
        
        JLabel DrinksLabel              = new JLabel("DRINKS  FROM $1.00 Small; $1.25 Medium; $1.60 Large");
        JLabel DrinkTypeLabel           = new JLabel("Drink");
        JLabel DrinkSizeLabel           = new JLabel("Size");
        JLabel DrinkQuantityLabel       = new JLabel("Quantity");
        
        JLabel RemoveItemLabel          = new JLabel("Remove By Item#: ");
        
        JLabel CustomerLabel            = new JLabel("CUSTOMER");
        JLabel DeliveryAddressLabel     = new JLabel("DELIVERY ADDRESS");
        JLabel CustomerFirstNameLabel   = new JLabel("First Name");
        JLabel CustomerLastNameLabel    = new JLabel("Last Name");
        JLabel CustomerPhoneLabel       = new JLabel("Phone");
        JLabel CustomerAddressLabel     = new JLabel("Address");
        JLabel CustomerCityLabel        = new JLabel("City");
        JLabel CustomerStateLabel       = new JLabel("State");
        JLabel CustomerZIPLabel         = new JLabel("ZIP code");
        
        // Define buttons
        JButton actionAddPizzaButton = new JButton(BUTTON_CAPTION_ADD_PIZZA);
        actionAddPizzaButton.addActionListener(this);
        
        JButton actionAddBurgerButton = new JButton(BUTTON_CAPTION_ADD_BURGER);
        actionAddBurgerButton.addActionListener(this);
        
        JButton actionAddFrenchFriesButton = new JButton(BUTTON_CAPTION_ADD_FRENCH_FRIES);
        actionAddFrenchFriesButton.addActionListener(this);
        
        JButton actionAddOnionRingsButton = new JButton(BUTTON_CAPTION_ADD_ONION_RINGS);
        actionAddOnionRingsButton.addActionListener(this);
        
        JButton actionAddDrinkButton = new JButton(BUTTON_CAPTION_ADD_DRINK);
        actionAddDrinkButton.addActionListener(this);
        
        JButton actionAddCustomerButton = new JButton(BUTTON_CAPTION_ADD_CUSTOMER);
        actionAddCustomerButton.addActionListener(this);
        
        
        JButton actionResetPizzaButton = new JButton(BUTTON_CAPTION_RESET_PIZZA);
        actionResetPizzaButton.addActionListener(this);
        
        JButton actionResetBurgerButton = new JButton(BUTTON_CAPTION_RESET_BURGER);
        actionResetBurgerButton.addActionListener(this);
        
        JButton actionResetFrenchFriesButton = new JButton(BUTTON_CAPTION_RESET_FRENCH_FRIES);
        actionResetFrenchFriesButton.addActionListener(this);
        
        JButton actionResetOnionRingsButton = new JButton(BUTTON_CAPTION_RESET_ONION_RINGS);
        actionResetOnionRingsButton.addActionListener(this);
        
        JButton actionResetDrinkButton = new JButton(BUTTON_CAPTION_RESET_DRINK);
        actionResetDrinkButton.addActionListener(this);
        
        JButton actionResetCustomerButton = new JButton(BUTTON_CAPTION_RESET_CUSTOMER);
        actionResetCustomerButton.addActionListener(this);
        
        JButton actionRemoveItemButton = new JButton(BUTTON_CAPTION_REMOVE_ITEM);
        actionRemoveItemButton.addActionListener(this);
        
        JButton actionPlaceOrderButton = new JButton(BUTTON_CAPTION_PLACE_ORDER);
        actionPlaceOrderButton.addActionListener(this);
        
        JButton actionClearOrderButton = new JButton(BUTTON_CAPTION_CLEAR_ORDER_ITEMS);
        actionClearOrderButton.addActionListener(this);
        
        
        // Layout
        // Add labels
        mainPanel.add(consolePanel);
        
        mainPanel.add(MenuLabel);
        mainPanel.add(PizzaLabel);
        mainPanel.add(PizzaSizeLabel);
        mainPanel.add(PizzaToppingsLabel);
        mainPanel.add(PizzaCheeseTopping);
        mainPanel.add(PizzaPeperoniTopping);
        mainPanel.add(PizzaHamTopping);
        mainPanel.add(PizzaQuantity);
        
        
        mainPanel.add(BurgerLabel);
        mainPanel.add(BurgerTypeLabel);
        mainPanel.add(BurgerPriceLabel);
        mainPanel.add(BurderIncludeTextLabel);
        mainPanel.add(BurgerQuantityLabel);
        
        mainPanel.add(FrenchFriesLabel);
        mainPanel.add(FrenchFriesSizeLabel);
        mainPanel.add(FrenchFriesQuantityLabel);
        
        mainPanel.add(OnionsLabel);
        mainPanel.add(OnionsSizeLabel);
        mainPanel.add(OnionsQuantityLabel);
        
        mainPanel.add(DrinksLabel);
        mainPanel.add(DrinkTypeLabel);
        mainPanel.add(DrinkSizeLabel);
        mainPanel.add(DrinkQuantityLabel);
        
        mainPanel.add(RemoveItemLabel);
        
        mainPanel.add(CustomerLabel);
        mainPanel.add(DeliveryAddressLabel);
//        mainPanel.add(CustomerDeliveryNeededLabel);
        mainPanel.add(CustomerFirstNameLabel);
        mainPanel.add(CustomerLastNameLabel);
        mainPanel.add(CustomerPhoneLabel);
        mainPanel.add(CustomerAddressLabel);
        mainPanel.add(CustomerCityLabel);
        mainPanel.add(CustomerStateLabel);
        mainPanel.add(CustomerZIPLabel);
        
        
        // Add selectboxes
        mainPanel.add(pizzaSizeSelector);
        mainPanel.add(pizzaCheeseToppingQuantitySelector);
        mainPanel.add(pizzaPepperoniToppingQuantitySelector);
        mainPanel.add(pizzaHamToppingQuantitySelector);
        mainPanel.add(pizzaQuantitySelector);
        mainPanel.add(burgerTypeSelector);
        mainPanel.add(burgerQuantitySelector);
        mainPanel.add(frenchFriesSizeSelector);
        mainPanel.add(frenchFriesQuantitySelector);
        mainPanel.add(onionRingsSizeSelector);
        mainPanel.add(onionRingsQuantitySelector);
        mainPanel.add(drinkTypeSelector);
        mainPanel.add(drinkSizeSelector);
        mainPanel.add(drinkQuantitySelector);
        
        
        // add text Fields
        mainPanel.add(removeItemIndexTextField);
        mainPanel.add(customerFirstNameTextField);
        mainPanel.add(customerLastNameTextField);
        mainPanel.add(customerPhoneNumberTextField);
        mainPanel.add(customerAddressTextField);
        mainPanel.add(customerCityTextField);
        mainPanel.add(customerStateTextField);
        mainPanel.add(customerZIPTextField);
        
        
        // add checkboxes
        mainPanel.add(customerDeliveryNeededJCheckBox);
     
        
        // add buttons
        mainPanel.add(actionAddPizzaButton);
        mainPanel.add(actionAddBurgerButton);
        mainPanel.add(actionAddFrenchFriesButton);
        mainPanel.add(actionAddOnionRingsButton);
        mainPanel.add(actionAddDrinkButton);
        mainPanel.add(actionAddCustomerButton);
        mainPanel.add(actionResetPizzaButton);
        mainPanel.add(actionResetBurgerButton);
        mainPanel.add(actionResetFrenchFriesButton);
        mainPanel.add(actionResetOnionRingsButton);
        mainPanel.add(actionResetDrinkButton);
        mainPanel.add(actionResetCustomerButton);
        
        mainPanel.add(actionRemoveItemButton);
        mainPanel.add(actionPlaceOrderButton);
        mainPanel.add(actionClearOrderButton);
        
        
        
        
        
        
        // Padding from side of the window
        int leftPadding10 = 10; 
        int leftPadding2 = 80;
        int leftPadding3 = 250;
        int leftPadding4 = 320;
        int leftPadding50 = 50;
        int leftPadding100 = 100;
        int leftPadding200 = 200;
        int leftPadding300 = 300;
        int leftPadding400 = 400;
        int leftPadding500 = 500;
        int leftPadding600 = 600;
        
        // Order Console Panel
        layout.putConstraint(SpringLayout.EAST,  consolePanel, -leftPadding10, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, consolePanel, leftPadding10, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  orderConsoleTextArea, -leftPadding10, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, orderConsoleTextArea, 5, SpringLayout.NORTH, mainPanel);
        
        layout.putConstraint(SpringLayout.EAST,  actionRemoveItemButton, -leftPadding10, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionRemoveItemButton, leftPadding10, SpringLayout.SOUTH, consolePanel);
        layout.putConstraint(SpringLayout.EAST,  removeItemIndexTextField, -leftPadding10, SpringLayout.WEST, actionRemoveItemButton);
        layout.putConstraint(SpringLayout.NORTH, removeItemIndexTextField, leftPadding10, SpringLayout.SOUTH, consolePanel);
        layout.putConstraint(SpringLayout.EAST,  RemoveItemLabel, -leftPadding10, SpringLayout.WEST, removeItemIndexTextField);
        layout.putConstraint(SpringLayout.NORTH, RemoveItemLabel, leftPadding10, SpringLayout.SOUTH, consolePanel);
        
        // MENU Label
        layout.putConstraint(SpringLayout.WEST,  MenuLabel, leftPadding300, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, MenuLabel, 10, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row1 Col1 - PIZZA
        layout.putConstraint(SpringLayout.WEST,  PizzaLabel, leftPadding50, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaLabel, 40, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row2 Col1 - Size
        layout.putConstraint(SpringLayout.WEST,  PizzaSizeLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaSizeLabel, 70, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaSizeSelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaSizeSelector,  70, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row3 Col1 - Quantity
        layout.putConstraint(SpringLayout.WEST,  PizzaQuantity, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaQuantity, 100, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaQuantitySelector,  100, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row4 - Toppings
        layout.putConstraint(SpringLayout.WEST,  PizzaToppingsLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaToppingsLabel, 140, SpringLayout.NORTH, mainPanel);
       
        // Pizza Row5 Col1 - Cheese Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaCheeseTopping, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaCheeseTopping, 170, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaCheeseToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaCheeseToppingQuantitySelector,  170, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row6 Col1 - Pepperoi Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaPeperoniTopping, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaPeperoniTopping, 200, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaPepperoniToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaPepperoniToppingQuantitySelector,  200, SpringLayout.NORTH, mainPanel);
       
        // Pizza Row7 Col1 - Ham Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaHamTopping, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaHamTopping, 230, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaHamToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaHamToppingQuantitySelector,  230, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row8 Col1 - Add Pizza Button
        layout.putConstraint(SpringLayout.WEST,  actionAddPizzaButton, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddPizzaButton, 270, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetPizzaButton, leftPadding10, SpringLayout.EAST, actionAddPizzaButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetPizzaButton, 270, SpringLayout.NORTH, mainPanel);
        
        
        
        
        
        
        // Burger Row1 - Burger
        layout.putConstraint(SpringLayout.WEST,  BurgerLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerLabel, 330, SpringLayout.NORTH, mainPanel);
        
        // Burger Row2 - Burger Menu
        layout.putConstraint(SpringLayout.WEST,  BurgerPriceLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerPriceLabel, 360, SpringLayout.NORTH, mainPanel);
        
        // Burger Row3 - Burger Type
        layout.putConstraint(SpringLayout.WEST,  BurgerTypeLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerTypeLabel, 390, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerTypeSelector, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerTypeSelector, 390, SpringLayout.NORTH, mainPanel);
       
        // Burger Row4 - Burger Include Text
        layout.putConstraint(SpringLayout.WEST,  BurderIncludeTextLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurderIncludeTextLabel, 420, SpringLayout.NORTH, mainPanel);
       
        // Burger Row5 - Burger Quantity
        layout.putConstraint(SpringLayout.WEST,  BurgerQuantityLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerQuantityLabel, 450, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerQuantitySelector, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerQuantitySelector, 450, SpringLayout.NORTH, mainPanel);
       
        // Burger Row6 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddBurgerButton, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddBurgerButton, 490, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetBurgerButton, leftPadding10, SpringLayout.EAST, actionAddBurgerButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetBurgerButton, 490, SpringLayout.NORTH, mainPanel);
        
        
        
        // French Fries Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesLabel, 40, SpringLayout.NORTH, mainPanel);
        
        // French Fries Row2 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesSizeLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesSizeLabel, 70, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesSizeSelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesSizeSelector,  70, SpringLayout.NORTH, mainPanel);
        
        // French Fries Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesQuantityLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesQuantityLabel, 100, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesQuantitySelector,  100, SpringLayout.NORTH, mainPanel);
        
        
        // French Fries Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddFrenchFriesButton, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddFrenchFriesButton, 140, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetFrenchFriesButton, leftPadding10, SpringLayout.EAST, actionAddFrenchFriesButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetFrenchFriesButton, 140, SpringLayout.NORTH, mainPanel);
        


        
        // Onion Rings Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  OnionsLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsLabel, 200, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row2 - Size
        layout.putConstraint(SpringLayout.WEST,  OnionsSizeLabel,        leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsSizeLabel,        230, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsSizeSelector, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsSizeSelector, 230, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  OnionsQuantityLabel,         leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsQuantityLabel,         270, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsQuantitySelector,  270, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddOnionRingsButton, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddOnionRingsButton, 310, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetOnionRingsButton, leftPadding10, SpringLayout.EAST, actionAddOnionRingsButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetOnionRingsButton, 310, SpringLayout.NORTH, mainPanel);
        
        
        
        
        
        // Drink Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  DrinksLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinksLabel, 370, SpringLayout.NORTH, mainPanel);
        
        // Drink Row2 - Type
        layout.putConstraint(SpringLayout.WEST,  DrinkTypeLabel,        leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkTypeLabel,        400, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkTypeSelector,     leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkTypeSelector,     400, SpringLayout.NORTH, mainPanel);
        
        // Drink Row3 - Size
        layout.putConstraint(SpringLayout.WEST,  DrinkSizeLabel,         leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkSizeLabel,         430, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkSizeSelector,      leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkSizeSelector,      430, SpringLayout.NORTH, mainPanel);
        
        // Drink Row4 - Quantity
        layout.putConstraint(SpringLayout.WEST,  DrinkQuantityLabel,     leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkQuantityLabel,     460, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkQuantitySelector,  460, SpringLayout.NORTH, mainPanel);
        
        // Drink Row5 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddDrinkButton,   leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddDrinkButton,   500, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetDrinkButton, leftPadding10, SpringLayout.EAST, actionAddDrinkButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetDrinkButton, 500, SpringLayout.NORTH, mainPanel);
        
        
        
        // Customer Row0 - Customer Label
        layout.putConstraint(SpringLayout.WEST,  CustomerLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerLabel, 575, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  DeliveryAddressLabel, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DeliveryAddressLabel, 575, SpringLayout.NORTH, mainPanel);
        
        // Customer Row1 Col1 - Customer Phone Address
        layout.putConstraint(SpringLayout.WEST,  CustomerPhoneLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerPhoneLabel, 600, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerPhoneNumberTextField, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerPhoneNumberTextField, 600, SpringLayout.NORTH, mainPanel);
        
        // Customer Row2 Col1 - Customer First Name
        layout.putConstraint(SpringLayout.WEST,  CustomerFirstNameLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerFirstNameLabel, 630, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerFirstNameTextField,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerFirstNameTextField,  630, SpringLayout.NORTH, mainPanel);
       
        // Customer Row3 Col1 - Customer Last Name
        layout.putConstraint(SpringLayout.WEST,  CustomerLastNameLabel, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerLastNameLabel, 660, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerLastNameTextField,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerLastNameTextField,  660, SpringLayout.NORTH, mainPanel);
        
        // Customer Row4 Col1 - Customer Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddCustomerButton, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddCustomerButton, 710, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetCustomerButton, leftPadding10, SpringLayout.EAST, actionAddCustomerButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetCustomerButton, 710, SpringLayout.NORTH, mainPanel);
        
        
        // Customer Row1 Col1 - Customer Delivery
    	// layout.putConstraint(SpringLayout.WEST,  CustomerDeliveryNeededLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        // layout.putConstraint(SpringLayout.NORTH, CustomerDeliveryNeededLabel, 600, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerDeliveryNeededJCheckBox, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerDeliveryNeededJCheckBox, 600, SpringLayout.NORTH, mainPanel);
        
        // Customer Row2 Col2 - Customer Address
        layout.putConstraint(SpringLayout.WEST,  CustomerAddressLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerAddressLabel, 630, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerAddressTextField, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerAddressTextField, 630, SpringLayout.NORTH, mainPanel);
        
        // Customer Row3 Col2 - Customer City
        layout.putConstraint(SpringLayout.WEST,  CustomerCityLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerCityLabel, 660, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerCityTextField, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerCityTextField, 660, SpringLayout.NORTH, mainPanel);
        
        // Customer Row4 Col2 - Customer State
        layout.putConstraint(SpringLayout.WEST,  CustomerStateLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerStateLabel, 690, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerStateTextField,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerStateTextField,  690, SpringLayout.NORTH, mainPanel);
       
        // Customer Row5 Col2 - Customer ZIP Code
        layout.putConstraint(SpringLayout.WEST,  CustomerZIPLabel, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerZIPLabel, 720, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerZIPTextField,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerZIPTextField,  720, SpringLayout.NORTH, mainPanel);
        
        // Customer Row5 Col2 - Customer ZIP Code
        layout.putConstraint(SpringLayout.WEST,  actionPlaceOrderButton, leftPadding10, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionPlaceOrderButton, 750, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionClearOrderButton, leftPadding10, SpringLayout.EAST, actionPlaceOrderButton);
        layout.putConstraint(SpringLayout.NORTH, actionClearOrderButton, 750, SpringLayout.NORTH, mainPanel);
        
        add(mainPanel);
	}
	

	/**
	 * Buttons click handler
	 */
	public void actionPerformed(ActionEvent e)
	{
	    String actionCommand = e.getActionCommand( );
	    
	    if (actionCommand.equals(BUTTON_CAPTION_PLACE_ORDER)) {
	    	
	    	// Check if order is empty
	    	if(order.getNumItems() == 0 ) {
	    		alert("Please add something to the order!", "Order was not placed");
	    		return;
	    	}
	    	
	    	// Place an order
	    	// show message that order was placed, reset all forms
	    	orderConsoleTextArea.setText("Order was placed!");
	    	resetAllForms();
	    	
	    	// show final receipt to customer
	    	order.orderStatusReceived();
	    	orderConsoleTextArea.setText(order.printOrder() + "\nThank you for your order!");
	    	
	    	// save order to text file
	    	saveFile(order);
	    	
	    	// set current order to new empty order 
	    	// for next customer
	    	ORDER_NUMBER++;
	    	order = new Order(String.valueOf(ORDER_NUMBER));
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_CLEAR_ORDER_ITEMS)) {
	    	
	    	// Remove all order items from order
	    	order.removeAllOrderItems();
	    	order.calcOrderPrice();

	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
	    
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_PIZZA)) {
	    	
	    	// Create pizza object to add it to order
	    	String pizzaSize           = String.valueOf(pizzaSizeSelector.getSelectedItem());
	    	int pizzaCheeseToppings    = Integer.parseInt(String.valueOf(pizzaCheeseToppingQuantitySelector.getSelectedItem()));
	    	int pizzaPepperoniToppings = Integer.parseInt(String.valueOf(pizzaPepperoniToppingQuantitySelector.getSelectedItem()));
	    	int pizzaHamToppings       = Integer.parseInt(String.valueOf(pizzaHamToppingQuantitySelector.getSelectedItem()));
	    	Pizza pizza                = new Pizza(pizzaSize, pizzaCheeseToppings, pizzaPepperoniToppings, pizzaHamToppings);

	    	// Add needed number of items
	    	int quantity = Integer.parseInt(String.valueOf(pizzaQuantitySelector.getSelectedItem()));
	    	for (int i = 1; i <= quantity; i++) {
	    		// Add pizza to order
		    	order.addOrderItem(pizza);
			}

	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
		    
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_BURGER)) {
	    	
	    	// Create burger object to add it to order
	    	String burgerType = String.valueOf(burgerTypeSelector.getSelectedItem());	    	
	    	Burger burger     = new Burger(burgerType);
	    	
	    	// Add needed number of items
	    	int quantity = Integer.parseInt(String.valueOf(burgerQuantitySelector.getSelectedItem()));
	    	for (int i = 1; i <= quantity; i++) {
	    		// Add burger to order
		    	order.addOrderItem(burger);
			}
	    	
	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_FRENCH_FRIES)) {
	    	
	    	// Add French fries to order
    		// Create French fries object to add it to order
	    	String sideType     = "French Fries";
	    	String sideSize     = String.valueOf(frenchFriesSizeSelector.getSelectedItem());	    	
	    	SideItem sideItem   = new SideItem(sideType, sideSize);
	    	
	    	// Add needed number of items
	    	int quantity = Integer.parseInt(String.valueOf(frenchFriesQuantitySelector.getSelectedItem()));
    		for (int i = 1; i <= quantity; i++) {
    			// Add French fries to order
        		order.addOrderItem(sideItem);
			}
	    	
	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_ONION_RINGS)) {
	    	
	    	// Add onion rings to order
    		// Create onion rings object to add it to order
	    	String sideType     = "Onion Rings";
	    	String sideSize     = String.valueOf(onionRingsSizeSelector.getSelectedItem());	    	
	    	SideItem sideItem   = new SideItem(sideType, sideSize);
	    	
	    	// Add needed number of items
	    	int quantity = Integer.parseInt(String.valueOf(onionRingsQuantitySelector.getSelectedItem()));
	    	for (int i = 1; i <= quantity; i++) {
	    		// Add onion rings to order
	    		order.addOrderItem(sideItem);
			}
	    	
	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
	    	
    	} else if (actionCommand.equals(BUTTON_CAPTION_ADD_DRINK)) {
	    	
	    	// Add drink to order
    		// Create drink object to add it to order
	    	String drinkType     = String.valueOf(drinkTypeSelector.getSelectedItem());
	    	String drinkSize     = String.valueOf(drinkSizeSelector.getSelectedItem());
	    	Drink drink = new Drink(drinkType, drinkSize);

	    	// Add needed number of items
	    	int quantity = Integer.parseInt(String.valueOf(drinkQuantitySelector.getSelectedItem()));
	    	for (int i = 1; i <= quantity; i++) {
	    		// Add drink to order
	    		order.addOrderItem(drink);
			}
	    	
	    	// Update order receipt
	    	orderConsoleTextArea.setText(order.printOrder());
    		
    	} else if (actionCommand.equals(BUTTON_CAPTION_ADD_CUSTOMER)) {
	    	
    		// Add customer and update delivery address if needed
    		// Create customer object and assign to order 
    		Customer customer = new Customer(String.valueOf(CUSTOMER_NUMBER));
    		customer.setFirstName(customerFirstNameTextField.getText());
    		customer.setLastName(customerLastNameTextField.getText());
    		customer.setPhone(customerPhoneNumberTextField.getText());
    		customer.setAddress(customerAddressTextField.getText());
    		customer.setCity(customerCityTextField.getText());
    		customer.setState(customerStateTextField.getText());
    		customer.setZip(customerZIPTextField.getText());
    		
    		order.setCustomer(customer);
    		CUSTOMER_NUMBER++;
    		
    		// Check if delivery needed
    		if(customerDeliveryNeededJCheckBox.isSelected()) {
    			order.setDelivered(customerDeliveryNeededJCheckBox.isSelected());
    			order.setDeliveryAddress(customerAddressTextField.getText());
    		} else {
    			order.setDelivered(customerDeliveryNeededJCheckBox.isSelected());
    			order.setDeliveryAddress("");
    		}
    		
    		// update order receipt
    		orderConsoleTextArea.setText(order.printOrder());
    		
    	} else if (actionCommand.equals(BUTTON_CAPTION_REMOVE_ITEM)) {
	    	
	    	// Remove item from order by number (index)
    		int index = Integer.parseInt(removeItemIndexTextField.getText());
    		order.removeOrderItem(index-1);
    		orderConsoleTextArea.setText(order.printOrder());
    		
		/* Reset Forms Actions */
    		
    	} else if (actionCommand.equals(BUTTON_CAPTION_RESET_PIZZA)) {
	    	
	    	// Reset pizza
    		resetPizzaForm();
		    
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_BURGER)) {
	    	
	    	// Reset burger
	    	resetBurgerForm();
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_FRENCH_FRIES)) {
	    	
	    	// Reset French fries
	    	resetFrenchFriesForm();
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_ONION_RINGS)) {
	    	
	    	// Reset onion rings
	    	resetOnionRingsForm();
	    	
    	} else if (actionCommand.equals(BUTTON_CAPTION_RESET_DRINK)) {
	    	
	    	// Reset drinks
    		resetDrinksForm();
	    	
		} else if (actionCommand.equals(BUTTON_CAPTION_RESET_CUSTOMER)) {
	    	
	    	// Reset customer
    		resetCustomerForm();
    		orderConsoleTextArea.setText(order.printOrder());
    		
	    } else {
	    	
	    	// Could not find action
	    }
	}

	/**
	 * Reset pizza form to default
	 */
	public void resetPizzaForm() {
		pizzaSizeSelector.setSelectedItem("Small");
		pizzaCheeseToppingQuantitySelector.setSelectedItem("1");
		pizzaPepperoniToppingQuantitySelector.setSelectedItem("0");
		pizzaHamToppingQuantitySelector.setSelectedItem("0");
		pizzaQuantitySelector.setSelectedItem("1");
	}
	
	/**
	 * Reset burger form to default
	 */
	public void resetBurgerForm() {
		burgerTypeSelector.setSelectedItem("HamBurger");
    	burgerQuantitySelector.setSelectedItem("1");
	}
	
	
	/**
	 * Reset French fries form to default
	 */
	public void resetFrenchFriesForm() {
		frenchFriesSizeSelector.setSelectedItem("Small");
    	frenchFriesQuantitySelector.setSelectedItem("1");
	}

	/**
	 * Reset onion rings form to default
	 */
	public void resetOnionRingsForm() {
		onionRingsSizeSelector.setSelectedItem("Small");
    	onionRingsQuantitySelector.setSelectedItem("1");
	}
	
	/**
	 * Reset drinks form to default
	 */
	public void resetDrinksForm() {
		drinkTypeSelector.setSelectedItem("Coke");
		drinkSizeSelector.setSelectedItem("12oz");
    	drinkQuantitySelector.setSelectedItem("1");
	}
	
	/**
	 * Reset customer form to default
	 */
	public void resetCustomerForm() {
		customerAddressTextField.setText("");
		customerCityTextField.setText("");
		customerStateTextField.setText("");
		customerZIPTextField.setText("");
		
		customerFirstNameTextField.setText("");
		customerLastNameTextField.setText("");
		customerPhoneNumberTextField.setText("");
		customerDeliveryNeededJCheckBox.setSelected(false);
	}
	
	/**
	 * Reset customer form to default
	 */
	public void resetAllForms() {
		resetPizzaForm();
		resetBurgerForm();
		resetFrenchFriesForm();
		resetOnionRingsForm();
		resetDrinksForm();
		resetCustomerForm();
	}
	
	
	/**
     * Save order to file
     */
    public void saveFile(Order order) {
    	
    	// Define outputStream
    	PrintWriter outputStream = null;
    	
    	String pattern = "yyyy-MM-dd_HH-mm-ss";
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    	String filename = ORDERS_SAVE_PATH + order.getOrderNumber() + "_" + simpleDateFormat.format(new Date()) + ".txt";
    	
    	// try to open file
		try {
			
			outputStream = new PrintWriter(new FileOutputStream(filename));
			
		} catch (FileNotFoundException e) {
			
			alert("Error. Cannot open file: " + filename, "Fail");
			System.out.println("Error. Cannot open file (" + filename + ")");
			System.exit(0);
		}
		
		// write to file
		outputStream.println(order.toString());
		
		// close file
		outputStream.close();
		
		// Display message to the user
		String message = "";
		message += "Thank you for your order!" + "\n\n";
		message += "Order# " + order.getOrderNumber() + "\n\n";
		message += "Order was saved to " + filename + ".";
		alert(message, "Order was placed");
    }
	
	/**
     * Helper function to display messages
     * 
     * @param message (window message text)
     * @param messageHeader (window header)
     */
    public void alert(String message, String messageHeader) {
		JOptionPane optionPane = new JOptionPane();
		optionPane.showMessageDialog(null, message, messageHeader, JOptionPane.INFORMATION_MESSAGE);
    }
}

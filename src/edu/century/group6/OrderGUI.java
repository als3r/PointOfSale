package edu.century.group6;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
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
import javax.swing.JTable; 
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.Container;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	public static final String BUTTON_CAPTION_MENU_NAME          = "Demo Screens";
	public static final String BUTTON_CAPTION_MENU_LOGIN         = "Login";
	public static final String BUTTON_CAPTION_MENU_POS           = "Make An Order";
	public static final String BUTTON_CAPTION_MENU_KITCHEN       = "Kitchen";
	public static final String BUTTON_CAPTION_MENU_DELIVERY      = "Delivery";
	public static final String BUTTON_CAPTION_MENU_SALES         = "Sales";
	public static final String BUTTON_CAPTION_MENU_CUSTOMERS     = "Customers";
	public static final String BUTTON_CAPTION_MENU_EMPLOYEES     = "Employees";
	public static final String BUTTON_CAPTION_MENU_ORDERS        = "Orders";
	public static final String BUTTON_CAPTION_MENU_EXIT          = "Exit";
	
	public static final Dimension BUTTON_SIZE_250_30  = new Dimension(250, 30);
	public static final Dimension BUTTON_SIZE_200_300 = new Dimension(200, 300);
	public static final Dimension BUTTON_SIZE_250_300 = new Dimension(250, 300);
	public static final Dimension BUTTON_SIZE_250_400 = new Dimension(250, 400);
	public static final Dimension BUTTON_SIZE_220_400 = new Dimension(200, 400);
	
	public static final Color COLOR_REGULAR_ORDERS  = new Color(255,204,102);
	public static final Color COLOR_DELIVERY_ORDERS = new Color(153,204,255);
	
	public static final Font FONT_12 = new Font("SansSerif", Font.PLAIN, 12);
	public static final Font FONT_14 = new Font("SansSerif", Font.PLAIN, 14);
	public static final Font FONT_15 = new Font("SansSerif", Font.PLAIN, 15);
	public static final Font FONT_16 = new Font("SansSerif", Font.PLAIN, 16);
	public static final Font FONT_18 = new Font("SansSerif", Font.PLAIN, 18);
	public static final Font FONT_20 = new Font("SansSerif", Font.PLAIN, 20);
	public static final Font FONT_22 = new Font("SansSerif", Font.PLAIN, 22);
	public static final Font FONT_24 = new Font("SansSerif", Font.PLAIN, 24);
    
	JMenuBar  menuBar;
	JMenu     menu;
	JMenuItem menuItem0, menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, 
			  menuItem6, menuItem7, menuItem8, menuItem9, menuItem10;
	
	JPanel    mainPanel;
	
	JPanel    loginMainPanel;
	JPanel    orderMainPanel;
	JPanel    kitchenMainPanel;
	JPanel    ordersKitchenPanel;
	JPanel    deliveryMainPanel;
	JPanel    ordersDeliveryPanel;
	JPanel    salesMainPanel;
	JPanel    employeesMainPanel;
	JPanel    customersMainPanel;
	
	
	JLabel SalesStatsSectionLabel               = new JLabel("STATS");
    
    JLabel SalesNumberOfCustomersValue          = new JLabel("0");
    JLabel SalesNumberOfEmployeesValue          = new JLabel("0");
    JLabel SalesNumberOfOrdersValue             = new JLabel("0");
    JLabel AverageOrderTimeValue                = new JLabel("0");
    JLabel AverageOrderCheckValue               = new JLabel("0");
    
    JLabel SalesNumberOrdersReceivedValue       = new JLabel("0");
    JLabel SalesNumberOrdersInProgressValue     = new JLabel("0");
    JLabel SalesNumberOrdersForDeliveryValue    = new JLabel("0" );
    JLabel SalesNumberOrdersDeliveredValue      = new JLabel("0");
    JLabel SalesNumberOrdersCompletedValue      = new JLabel("0");
    
    JLabel SalesPizzaValue                      = new JLabel("$0.00");
    JLabel SalesBurgerValue                     = new JLabel("$0.00");
    JLabel SalesFrenchFriesValue                = new JLabel("$0.00");
    JLabel SalesOnionRingsValue                 = new JLabel("$0.00");
    JLabel SalesDrinksValue                     = new JLabel("$0.00");
    
    JLabel SalesPizzaValuePercent               = new JLabel("0.0%");
    JLabel SalesBurgerValuePercent              = new JLabel("0.0%");
    JLabel SalesFrenchFriesValuePercent         = new JLabel("0.0%");
    JLabel SalesOnionRingsValuePercent          = new JLabel("0.0%");
    JLabel SalesDrinksValuePercent              = new JLabel("0.0%");
    
    JLabel SalesTotalSubTotalValue              = new JLabel("$0.00");
    JLabel SalesTotalTaxValue                   = new JLabel("$0.00");
    JLabel SalesTotalSalesValue                 = new JLabel("$0.00");
    
    
    JPanel customersTablePanel = new JPanel ();
    JPanel customersSearchPanel = new JPanel ();
    JPanel customersFormPanel = new JPanel ();
    JPanel employeesTablePanel = new JPanel ();
    JPanel employeesSearchPanel = new JPanel ();
    JPanel employeesFormPanel = new JPanel ();
    
	
	/**
	 * Stores order Items
	 */
	private List<Order> orders = new ArrayList<>();
	private List<Employee> employees = new ArrayList<>();
	private List<Customer> customers = new ArrayList<>();
	
	
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
        
        setDefaultData();
        
        order = new Order(String.valueOf(ORDER_NUMBER));

        // Create spring layout
        SpringLayout layout = new SpringLayout();
        FlowLayout flowLayout = new FlowLayout();
        
        // Create main panel
        mainPanel = new JPanel();
        mainPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainPanel.setLayout(layout);
        
        // Start Point Of Sale / Make An Order
        orderMainPanel = new JPanel();
        orderMainPanel.setLayout(layout);
        
        //Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the first menu.
        menu = new JMenu(BUTTON_CAPTION_MENU_NAME);
        menuBar.add(menu);
        
//        menuItem0 = new JMenuItem(BUTTON_CAPTION_MENU_LOGIN);
//        menuItem0.addActionListener(this);
//        menu.add(menuItem0);
        
        menuItem1 = new JMenuItem(BUTTON_CAPTION_MENU_POS);
        menuItem1.addActionListener(this);
        menu.add(menuItem1);
        
        menuItem2 = new JMenuItem(BUTTON_CAPTION_MENU_KITCHEN);
        menuItem2.addActionListener(this);
        menu.add(menuItem2);
        
        menuItem3 = new JMenuItem(BUTTON_CAPTION_MENU_DELIVERY);
        menuItem3.addActionListener(this);
        menu.add(menuItem3);
        
        menuItem4 = new JMenuItem(BUTTON_CAPTION_MENU_SALES);
        menuItem4.addActionListener(this);
        menu.add(menuItem4);
        
//        menuItem5 = new JMenuItem(BUTTON_CAPTION_MENU_ORDERS);
//        menuItem5.addActionListener(this);
//        menu.add(menuItem5);
        
        menuItem6 = new JMenuItem(BUTTON_CAPTION_MENU_CUSTOMERS);
        menuItem6.addActionListener(this);
        menu.add(menuItem6);
        
        menuItem7 = new JMenuItem(BUTTON_CAPTION_MENU_EMPLOYEES);
        menuItem7.addActionListener(this);
        menu.add(menuItem7);
        
        menuItem10 = new JMenuItem(BUTTON_CAPTION_MENU_EXIT);
        menuItem10.addActionListener(this);
        menu.add(menuItem10);
        
        menuBar.add(menu);
        setJMenuBar(menuBar);
        
        
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
        orderMainPanel.add(consolePanel);
        
        orderMainPanel.add(MenuLabel);
        orderMainPanel.add(PizzaLabel);
        orderMainPanel.add(PizzaSizeLabel);
        orderMainPanel.add(PizzaToppingsLabel);
        orderMainPanel.add(PizzaCheeseTopping);
        orderMainPanel.add(PizzaPeperoniTopping);
        orderMainPanel.add(PizzaHamTopping);
        orderMainPanel.add(PizzaQuantity);
        
        
        orderMainPanel.add(BurgerLabel);
        orderMainPanel.add(BurgerTypeLabel);
        orderMainPanel.add(BurgerPriceLabel);
        orderMainPanel.add(BurderIncludeTextLabel);
        orderMainPanel.add(BurgerQuantityLabel);
        
        orderMainPanel.add(FrenchFriesLabel);
        orderMainPanel.add(FrenchFriesSizeLabel);
        orderMainPanel.add(FrenchFriesQuantityLabel);
        
        orderMainPanel.add(OnionsLabel);
        orderMainPanel.add(OnionsSizeLabel);
        orderMainPanel.add(OnionsQuantityLabel);
        
        orderMainPanel.add(DrinksLabel);
        orderMainPanel.add(DrinkTypeLabel);
        orderMainPanel.add(DrinkSizeLabel);
        orderMainPanel.add(DrinkQuantityLabel);
        
        orderMainPanel.add(RemoveItemLabel);
        
        orderMainPanel.add(CustomerLabel);
        orderMainPanel.add(DeliveryAddressLabel);
        orderMainPanel.add(CustomerFirstNameLabel);
        orderMainPanel.add(CustomerLastNameLabel);
        orderMainPanel.add(CustomerPhoneLabel);
        orderMainPanel.add(CustomerAddressLabel);
        orderMainPanel.add(CustomerCityLabel);
        orderMainPanel.add(CustomerStateLabel);
        orderMainPanel.add(CustomerZIPLabel);
        
        
        // Add selectboxes
        orderMainPanel.add(pizzaSizeSelector);
        orderMainPanel.add(pizzaCheeseToppingQuantitySelector);
        orderMainPanel.add(pizzaPepperoniToppingQuantitySelector);
        orderMainPanel.add(pizzaHamToppingQuantitySelector);
        orderMainPanel.add(pizzaQuantitySelector);
        orderMainPanel.add(burgerTypeSelector);
        orderMainPanel.add(burgerQuantitySelector);
        orderMainPanel.add(frenchFriesSizeSelector);
        orderMainPanel.add(frenchFriesQuantitySelector);
        orderMainPanel.add(onionRingsSizeSelector);
        orderMainPanel.add(onionRingsQuantitySelector);
        orderMainPanel.add(drinkTypeSelector);
        orderMainPanel.add(drinkSizeSelector);
        orderMainPanel.add(drinkQuantitySelector);
        
        
        // add text Fields
        orderMainPanel.add(removeItemIndexTextField);
        orderMainPanel.add(customerFirstNameTextField);
        orderMainPanel.add(customerLastNameTextField);
        orderMainPanel.add(customerPhoneNumberTextField);
        orderMainPanel.add(customerAddressTextField);
        orderMainPanel.add(customerCityTextField);
        orderMainPanel.add(customerStateTextField);
        orderMainPanel.add(customerZIPTextField);
        
        
        // add checkboxes
        orderMainPanel.add(customerDeliveryNeededJCheckBox);
     
        
        // add buttons
        orderMainPanel.add(actionAddPizzaButton);
        orderMainPanel.add(actionAddBurgerButton);
        orderMainPanel.add(actionAddFrenchFriesButton);
        orderMainPanel.add(actionAddOnionRingsButton);
        orderMainPanel.add(actionAddDrinkButton);
        orderMainPanel.add(actionAddCustomerButton);
        orderMainPanel.add(actionResetPizzaButton);
        orderMainPanel.add(actionResetBurgerButton);
        orderMainPanel.add(actionResetFrenchFriesButton);
        orderMainPanel.add(actionResetOnionRingsButton);
        orderMainPanel.add(actionResetDrinkButton);
        orderMainPanel.add(actionResetCustomerButton);
        
        orderMainPanel.add(actionRemoveItemButton);
        orderMainPanel.add(actionPlaceOrderButton);
        orderMainPanel.add(actionClearOrderButton);
        
        
        
        
        
        
        // Padding from side of the window
        int leftPadding10 = 10; 
        int leftPadding2 = 80;
        int leftPadding3 = 250;
        int leftPadding4 = 320;
        int leftPadding50 = 50;
        int leftPadding100 = 100;
        int leftPadding150 = 150;
        int leftPadding200 = 200;
        int leftPadding250 = 250;
        int leftPadding300 = 300;
        int leftPadding350 = 350;
        int leftPadding400 = 400;
        int leftPadding500 = 500;
        int leftPadding600 = 600;
        int leftPadding700 = 700;
        int leftPadding800 = 800;
        int leftPadding900 = 900;
        
        int topPadding10 = 1;
        int topPadding30 = 30;
        int topPadding40 = 40;
        
        // Order Main Panel
        layout.putConstraint(SpringLayout.WEST,  orderMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  orderMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, orderMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, orderMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        // Order Console Panel
        layout.putConstraint(SpringLayout.EAST,  consolePanel, -leftPadding10, SpringLayout.EAST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, consolePanel, leftPadding10, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.EAST,  orderConsoleTextArea, -leftPadding10, SpringLayout.EAST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, orderConsoleTextArea, 5, SpringLayout.NORTH, orderMainPanel);
        
        layout.putConstraint(SpringLayout.EAST,  actionRemoveItemButton, -leftPadding10, SpringLayout.EAST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionRemoveItemButton, leftPadding10, SpringLayout.SOUTH, consolePanel);
        layout.putConstraint(SpringLayout.EAST,  removeItemIndexTextField, -leftPadding10, SpringLayout.WEST, actionRemoveItemButton);
        layout.putConstraint(SpringLayout.NORTH, removeItemIndexTextField, leftPadding10, SpringLayout.SOUTH, consolePanel);
        layout.putConstraint(SpringLayout.EAST,  RemoveItemLabel, -leftPadding10, SpringLayout.WEST, removeItemIndexTextField);
        layout.putConstraint(SpringLayout.NORTH, RemoveItemLabel, leftPadding10, SpringLayout.SOUTH, consolePanel);
        
        // MENU Label
        layout.putConstraint(SpringLayout.WEST,  MenuLabel, leftPadding300, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, MenuLabel, 10, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row1 Col1 - PIZZA
        layout.putConstraint(SpringLayout.WEST,  PizzaLabel, leftPadding50, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaLabel, 40, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row2 Col1 - Size
        layout.putConstraint(SpringLayout.WEST,  PizzaSizeLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaSizeLabel, 70, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaSizeSelector,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaSizeSelector,  70, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row3 Col1 - Quantity
        layout.putConstraint(SpringLayout.WEST,  PizzaQuantity, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaQuantity, 100, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaQuantitySelector,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaQuantitySelector,  100, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row4 - Toppings
        layout.putConstraint(SpringLayout.WEST,  PizzaToppingsLabel, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaToppingsLabel, 140, SpringLayout.NORTH, orderMainPanel);
       
        // Pizza Row5 Col1 - Cheese Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaCheeseTopping, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaCheeseTopping, 170, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaCheeseToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaCheeseToppingQuantitySelector,  170, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row6 Col1 - Pepperoi Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaPeperoniTopping, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaPeperoniTopping, 200, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaPepperoniToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaPepperoniToppingQuantitySelector,  200, SpringLayout.NORTH, orderMainPanel);
       
        // Pizza Row7 Col1 - Ham Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaHamTopping, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaHamTopping, 230, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaHamToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaHamToppingQuantitySelector,  230, SpringLayout.NORTH, orderMainPanel);
        
        // Pizza Row8 Col1 - Add Pizza Button
        layout.putConstraint(SpringLayout.WEST,  actionAddPizzaButton, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddPizzaButton, 270, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetPizzaButton, leftPadding10, SpringLayout.EAST, actionAddPizzaButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetPizzaButton, 270, SpringLayout.NORTH, orderMainPanel);
        
        
        
        
        
        
        // Burger Row1 - Burger
        layout.putConstraint(SpringLayout.WEST,  BurgerLabel, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerLabel, 330, SpringLayout.NORTH, orderMainPanel);
        
        // Burger Row2 - Burger Menu
        layout.putConstraint(SpringLayout.WEST,  BurgerPriceLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerPriceLabel, 360, SpringLayout.NORTH, orderMainPanel);
        
        // Burger Row3 - Burger Type
        layout.putConstraint(SpringLayout.WEST,  BurgerTypeLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerTypeLabel, 390, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerTypeSelector, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerTypeSelector, 390, SpringLayout.NORTH, orderMainPanel);
       
        // Burger Row4 - Burger Include Text
        layout.putConstraint(SpringLayout.WEST,  BurderIncludeTextLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurderIncludeTextLabel, 420, SpringLayout.NORTH, orderMainPanel);
       
        // Burger Row5 - Burger Quantity
        layout.putConstraint(SpringLayout.WEST,  BurgerQuantityLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerQuantityLabel, 450, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerQuantitySelector, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerQuantitySelector, 450, SpringLayout.NORTH, orderMainPanel);
       
        // Burger Row6 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddBurgerButton, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddBurgerButton, 490, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetBurgerButton, leftPadding10, SpringLayout.EAST, actionAddBurgerButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetBurgerButton, 490, SpringLayout.NORTH, orderMainPanel);
        
        
        
        // French Fries Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesLabel, 40, SpringLayout.NORTH, orderMainPanel);
        
        // French Fries Row2 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesSizeLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesSizeLabel, 70, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesSizeSelector,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesSizeSelector,  70, SpringLayout.NORTH, orderMainPanel);
        
        // French Fries Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesQuantityLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesQuantityLabel, 100, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesQuantitySelector,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesQuantitySelector,  100, SpringLayout.NORTH, orderMainPanel);
        
        
        // French Fries Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddFrenchFriesButton, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddFrenchFriesButton, 140, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetFrenchFriesButton, leftPadding10, SpringLayout.EAST, actionAddFrenchFriesButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetFrenchFriesButton, 140, SpringLayout.NORTH, orderMainPanel);
        


        
        // Onion Rings Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  OnionsLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsLabel, 200, SpringLayout.NORTH, orderMainPanel);
        
        // Onion Rings Row2 - Size
        layout.putConstraint(SpringLayout.WEST,  OnionsSizeLabel,        leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsSizeLabel,        230, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsSizeSelector, leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsSizeSelector, 230, SpringLayout.NORTH, orderMainPanel);
        
        // Onion Rings Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  OnionsQuantityLabel,         leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsQuantityLabel,         270, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsQuantitySelector,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsQuantitySelector,  270, SpringLayout.NORTH, orderMainPanel);
        
        // Onion Rings Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddOnionRingsButton, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddOnionRingsButton, 310, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetOnionRingsButton, leftPadding10, SpringLayout.EAST, actionAddOnionRingsButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetOnionRingsButton, 310, SpringLayout.NORTH, orderMainPanel);
        
        
        
        
        
        // Drink Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  DrinksLabel, leftPadding400 + leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinksLabel, 370, SpringLayout.NORTH, mainPanel);
        
        // Drink Row2 - Type
        layout.putConstraint(SpringLayout.WEST,  DrinkTypeLabel,        leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkTypeLabel,        400, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkTypeSelector,     leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkTypeSelector,     400, SpringLayout.NORTH, orderMainPanel);
        
        // Drink Row3 - Size
        layout.putConstraint(SpringLayout.WEST,  DrinkSizeLabel,         leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkSizeLabel,         430, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkSizeSelector,      leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkSizeSelector,      430, SpringLayout.NORTH, orderMainPanel);
        
        // Drink Row4 - Quantity
        layout.putConstraint(SpringLayout.WEST,  DrinkQuantityLabel,     leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkQuantityLabel,     460, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkQuantitySelector,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkQuantitySelector,  460, SpringLayout.NORTH, orderMainPanel);
        
        // Drink Row5 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddDrinkButton,   leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddDrinkButton,   500, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetDrinkButton, leftPadding10, SpringLayout.EAST, actionAddDrinkButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetDrinkButton, 500, SpringLayout.NORTH, orderMainPanel);
        
        
        
        // Customer Row0 - Customer Label
        layout.putConstraint(SpringLayout.WEST,  CustomerLabel, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerLabel, 575, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  DeliveryAddressLabel, leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, DeliveryAddressLabel, 575, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row1 Col1 - Customer Phone Address
        layout.putConstraint(SpringLayout.WEST,  CustomerPhoneLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerPhoneLabel, 600, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerPhoneNumberTextField, leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerPhoneNumberTextField, 600, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row2 Col1 - Customer First Name
        layout.putConstraint(SpringLayout.WEST,  CustomerFirstNameLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerFirstNameLabel, 630, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerFirstNameTextField,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerFirstNameTextField,  630, SpringLayout.NORTH, orderMainPanel);
       
        // Customer Row3 Col1 - Customer Last Name
        layout.putConstraint(SpringLayout.WEST,  CustomerLastNameLabel, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerLastNameLabel, 660, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerLastNameTextField,  leftPadding100, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerLastNameTextField,  660, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row4 Col1 - Customer Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddCustomerButton, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddCustomerButton, 710, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetCustomerButton, leftPadding10, SpringLayout.EAST, actionAddCustomerButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetCustomerButton, 710, SpringLayout.NORTH, orderMainPanel);
        
        
        // Customer Row1 Col1 - Customer Delivery
    	// layout.putConstraint(SpringLayout.WEST,  CustomerDeliveryNeededLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        // layout.putConstraint(SpringLayout.NORTH, CustomerDeliveryNeededLabel, 600, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerDeliveryNeededJCheckBox, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerDeliveryNeededJCheckBox, 600, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row2 Col2 - Customer Address
        layout.putConstraint(SpringLayout.WEST,  CustomerAddressLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerAddressLabel, 630, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerAddressTextField, leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerAddressTextField, 630, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row3 Col2 - Customer City
        layout.putConstraint(SpringLayout.WEST,  CustomerCityLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerCityLabel, 660, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerCityTextField, leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerCityTextField, 660, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row4 Col2 - Customer State
        layout.putConstraint(SpringLayout.WEST,  CustomerStateLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerStateLabel, 690, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerStateTextField,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerStateTextField,  690, SpringLayout.NORTH, orderMainPanel);
       
        // Customer Row5 Col2 - Customer ZIP Code
        layout.putConstraint(SpringLayout.WEST,  CustomerZIPLabel, leftPadding400, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, CustomerZIPLabel, 720, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  customerZIPTextField,  leftPadding500, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, customerZIPTextField,  720, SpringLayout.NORTH, orderMainPanel);
        
        // Customer Row5 Col2 - Customer ZIP Code
        layout.putConstraint(SpringLayout.WEST,  actionPlaceOrderButton, leftPadding10, SpringLayout.WEST, orderMainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionPlaceOrderButton, 750, SpringLayout.NORTH, orderMainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionClearOrderButton, leftPadding10, SpringLayout.EAST, actionPlaceOrderButton);
        layout.putConstraint(SpringLayout.NORTH, actionClearOrderButton, 750, SpringLayout.NORTH, orderMainPanel);
        
        mainPanel.add(orderMainPanel);
        
        
        
        // End Point Of Sale/ Make an Order screen
        
        // Start Login Screen
        loginMainPanel = new JPanel ();
        loginMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Login" ) );
        loginMainPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST,  loginMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  loginMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, loginMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, loginMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        mainPanel.add(loginMainPanel);
        // End Login screen 
        
        
        
        
        // Start Kitchen Screen
        kitchenMainPanel = new JPanel ();
        kitchenMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Kitchen" ) );
        kitchenMainPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST,  kitchenMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  kitchenMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, kitchenMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, kitchenMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        
        ordersKitchenPanel = new JPanel ();
		ordersKitchenPanel.setLayout(flowLayout);
		
		kitchenMainPanel.add(ordersKitchenPanel);
        mainPanel.add(kitchenMainPanel);
        // End Kitchen screen   
        
        
        
        
        // Start Delivery Screen
        deliveryMainPanel = new JPanel ();
        deliveryMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Delivery" ) );
        deliveryMainPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST,  deliveryMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  deliveryMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, deliveryMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, deliveryMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        ordersDeliveryPanel = new JPanel ();
        ordersDeliveryPanel.setLayout(flowLayout);
        
        deliveryMainPanel.add(ordersDeliveryPanel);
        mainPanel.add(deliveryMainPanel);
        // End Delivery screen   
        
        
        
        
        // Start Sales/Statistics Screen
        salesMainPanel = new JPanel ();
        salesMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Statistics" ) );
        salesMainPanel.setLayout(layout);
        
        //define form labels
        JLabel SalesBusinessLabel                   = new JLabel(BUSINESS_NAME);
        
        JLabel SalesStatsSectionLabel               = new JLabel("STATS");
        
        JLabel SalesNumberOfCustomersLabel          = new JLabel("CUSTOMERS: ");
        JLabel SalesNumberOfEmployeesLabel          = new JLabel("EMPLOYEES: ");
        JLabel SalesNumberOfOrdersLabel             = new JLabel("ORDERS: ");
        JLabel AverageOrderTimeLabel                = new JLabel("AVERAGE TIME: ");
        JLabel AverageOrderCheckLabel               = new JLabel("AVERAGE CHECK: ");
        
        JLabel SalesOrdersLabel                     = new JLabel("ORDERS");
        JLabel SalesNumberOrdersReceivedOrdersLabel = new JLabel("RECEIVED: ");
        JLabel SalesNumberOrdersPreparedOrdersLabel = new JLabel("IN PROGRESS: ");
        JLabel SalesNumberOrdersForDeliveryLabel    = new JLabel("DELIVERY NEEDED:" );
        JLabel SalesNumberOrdersDeliveredLabel      = new JLabel("DELIVERED: ");
        JLabel SalesNumberOrdersCompletedLabel      = new JLabel("COMPLETED: ");
        
        JLabel SalesSalesSectionLabel               = new JLabel("SALES");
        JLabel SalesPizzaLabel                      = new JLabel("PIZZA: ");
        JLabel SalesBurgerLabel                     = new JLabel("BURGER: ");
        JLabel SalesFrenchFriesLabel                = new JLabel("FRENCH FRIES: ");
        JLabel SalesOnionRingsLabel                 = new JLabel("ONION RINGS: ");
        JLabel SalesDrinksLabel                     = new JLabel("DRINKS: ");
        JLabel SalesTotalSubTotalLabel              = new JLabel("SUBTOTAL: ");
        JLabel SalesTotalTaxLabel                   = new JLabel("TAX: ");
        JLabel SalesTotalSalesLabel                 = new JLabel("TOTAL SALES: ");
        
        SalesBusinessLabel.setFont(FONT_24);
        
        SalesStatsSectionLabel.setFont(FONT_20);
        SalesNumberOfCustomersLabel.setFont(FONT_18);
        SalesNumberOfEmployeesLabel.setFont(FONT_18);
        SalesNumberOfOrdersLabel.setFont(FONT_18);
        AverageOrderTimeLabel.setFont(FONT_18);
        AverageOrderCheckLabel.setFont(FONT_18);
        
        SalesOrdersLabel.setFont(FONT_20);
        SalesNumberOrdersReceivedOrdersLabel.setFont(FONT_18);
        SalesNumberOrdersPreparedOrdersLabel.setFont(FONT_18);
        SalesNumberOrdersForDeliveryLabel.setFont(FONT_18);
        SalesNumberOrdersDeliveredLabel.setFont(FONT_18);
        SalesNumberOrdersCompletedLabel.setFont(FONT_18);
        
        SalesSalesSectionLabel.setFont(FONT_20);
        SalesPizzaLabel.setFont(FONT_18);
        SalesBurgerLabel.setFont(FONT_18);
        SalesFrenchFriesLabel.setFont(FONT_18);
        SalesOnionRingsLabel.setFont(FONT_18);
        SalesDrinksLabel.setFont(FONT_18);
        SalesTotalSubTotalLabel.setFont(FONT_18);
        SalesTotalTaxLabel.setFont(FONT_18);
        SalesTotalSalesLabel.setFont(FONT_18);
        
        
        layout.putConstraint(SpringLayout.WEST,  salesMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  salesMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, salesMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, salesMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        // SALES - BUSINESS NAME
        layout.putConstraint(SpringLayout.WEST,  SalesBusinessLabel, leftPadding500, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesBusinessLabel, 0*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        

        // SALES - STATS SECTION
        layout.putConstraint(SpringLayout.WEST,  SalesStatsSectionLabel, leftPadding800, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesStatsSectionLabel, 2*topPadding40, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - STATS - CUSTOMERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfCustomersLabel, leftPadding700, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfCustomersLabel, 3*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfCustomersValue, leftPadding900, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfCustomersValue, 3*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - STATS - EMPLOYEES
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfEmployeesLabel, leftPadding700, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfEmployeesLabel, 4*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfEmployeesValue, leftPadding900, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfEmployeesValue, 4*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - STATS - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfOrdersLabel, leftPadding700, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfOrdersLabel, 5*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOfOrdersValue, leftPadding900, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOfOrdersValue, 5*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - STATS - AVERAGE ORDER CHECK
        layout.putConstraint(SpringLayout.WEST,  AverageOrderCheckLabel, leftPadding700, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, AverageOrderCheckLabel, 6*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  AverageOrderCheckValue, leftPadding900, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, AverageOrderCheckValue, 6*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - STATS - AVERAGE ORDER TIME
        layout.putConstraint(SpringLayout.WEST,  AverageOrderTimeLabel, leftPadding700, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, AverageOrderTimeLabel, 7*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  AverageOrderTimeValue, leftPadding900, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, AverageOrderTimeValue, 7*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        
       
        
       
        // SALES - ORDERS SECTION
        layout.putConstraint(SpringLayout.WEST,  SalesOrdersLabel, leftPadding150, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesOrdersLabel, 2*topPadding40, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersReceivedOrdersLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersReceivedOrdersLabel, 3*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersReceivedValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersReceivedValue, 3*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
       
        // SALES - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersPreparedOrdersLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersPreparedOrdersLabel, 4*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersInProgressValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersInProgressValue, 4*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersForDeliveryLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersForDeliveryLabel, 5*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersForDeliveryValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersForDeliveryValue, 5*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersDeliveredLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersDeliveredLabel, 6*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersDeliveredValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersDeliveredValue, 6*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - ORDERS
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersCompletedLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersCompletedLabel, 7*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesNumberOrdersCompletedValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesNumberOrdersCompletedValue, 7*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        

        
        // SALES - SALES SECTION
        layout.putConstraint(SpringLayout.WEST,  SalesSalesSectionLabel, leftPadding200, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesSalesSectionLabel, 9*topPadding40, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - PIZZA
        layout.putConstraint(SpringLayout.WEST,  SalesPizzaLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesPizzaLabel, 10*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesPizzaValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesPizzaValue, 10*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesPizzaValuePercent, leftPadding350, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesPizzaValuePercent, 10*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - BURGER
        layout.putConstraint(SpringLayout.WEST,  SalesBurgerLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesBurgerLabel, 11*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesBurgerValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesBurgerValue, 11*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesBurgerValuePercent, leftPadding350, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesBurgerValuePercent, 11*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - FRENCH FRIES
        layout.putConstraint(SpringLayout.WEST,  SalesFrenchFriesLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesFrenchFriesLabel, 12*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesFrenchFriesValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesFrenchFriesValue, 12*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesFrenchFriesValuePercent, leftPadding350, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesFrenchFriesValuePercent, 12*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - ONION RINGS
        layout.putConstraint(SpringLayout.WEST,  SalesOnionRingsLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesOnionRingsLabel, 13*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesOnionRingsValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesOnionRingsValue, 13*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesOnionRingsValuePercent, leftPadding350, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesOnionRingsValuePercent, 13*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - DRINKS
        layout.putConstraint(SpringLayout.WEST,  SalesDrinksLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesDrinksLabel, 14*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesDrinksValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesDrinksValue, 14*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesDrinksValuePercent, leftPadding350, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesDrinksValuePercent, 14*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - TOTAL SUBTOTAL
        layout.putConstraint(SpringLayout.WEST,  SalesTotalSubTotalLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalSubTotalLabel, 16*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesTotalSubTotalValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalSubTotalValue, 16*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - TOTAL TAX
        layout.putConstraint(SpringLayout.WEST,  SalesTotalTaxLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalTaxLabel, 17*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesTotalTaxValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalTaxValue, 17*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        // SALES - SALES - TOTAL SALES
        layout.putConstraint(SpringLayout.WEST,  SalesTotalSalesLabel, leftPadding50, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalSalesLabel, 18*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        layout.putConstraint(SpringLayout.WEST,  SalesTotalSalesValue, leftPadding250, SpringLayout.WEST, salesMainPanel);
        layout.putConstraint(SpringLayout.NORTH, SalesTotalSalesValue, 18*topPadding40 + topPadding10, SpringLayout.NORTH, salesMainPanel);
        
        
        salesMainPanel.add(SalesBusinessLabel);
        salesMainPanel.add(SalesStatsSectionLabel);
        salesMainPanel.add(SalesNumberOfCustomersLabel);
        salesMainPanel.add(SalesNumberOfEmployeesLabel);
        salesMainPanel.add(AverageOrderTimeLabel);
        salesMainPanel.add(AverageOrderCheckLabel);
        salesMainPanel.add(SalesNumberOfOrdersLabel);
        salesMainPanel.add(SalesOrdersLabel);
        salesMainPanel.add(SalesNumberOrdersReceivedOrdersLabel);
        salesMainPanel.add(SalesNumberOrdersPreparedOrdersLabel);
        salesMainPanel.add(SalesNumberOrdersForDeliveryLabel);
        salesMainPanel.add(SalesNumberOrdersDeliveredLabel);
        salesMainPanel.add(SalesNumberOrdersCompletedLabel);
        
        salesMainPanel.add(SalesSalesSectionLabel);
        salesMainPanel.add(SalesPizzaLabel);
        salesMainPanel.add(SalesBurgerLabel);
        salesMainPanel.add(SalesFrenchFriesLabel);
        salesMainPanel.add(SalesOnionRingsLabel);
        salesMainPanel.add(SalesDrinksLabel);
        salesMainPanel.add(SalesTotalSubTotalLabel);
        salesMainPanel.add(SalesTotalTaxLabel);
        salesMainPanel.add(SalesTotalSalesLabel);
        
        SalesNumberOfCustomersValue.setFont(FONT_18);
	    SalesNumberOfEmployeesValue.setFont(FONT_18);
	    SalesNumberOfOrdersValue.setFont(FONT_18);
	    AverageOrderTimeValue.setFont(FONT_18);
	    AverageOrderCheckValue.setFont(FONT_18);
	    
	    SalesNumberOrdersReceivedValue.setFont(FONT_18);
	    SalesNumberOrdersInProgressValue.setFont(FONT_18);
	    SalesNumberOrdersForDeliveryValue.setFont(FONT_18);
	    SalesNumberOrdersDeliveredValue.setFont(FONT_18);
	    SalesNumberOrdersCompletedValue.setFont(FONT_18);
	    
	    SalesPizzaValue.setFont(FONT_18);
	    SalesBurgerValue.setFont(FONT_18);
	    SalesFrenchFriesValue.setFont(FONT_18);
	    SalesOnionRingsValue.setFont(FONT_18);
	    SalesDrinksValue.setFont(FONT_18);
	    
	    SalesPizzaValuePercent.setFont(FONT_18);
	    SalesBurgerValuePercent.setFont(FONT_18);
	    SalesFrenchFriesValuePercent.setFont(FONT_18);
	    SalesOnionRingsValuePercent.setFont(FONT_18);
	    SalesDrinksValuePercent.setFont(FONT_18);
	    
	    SalesTotalSubTotalValue.setFont(FONT_18);
	    SalesTotalTaxValue.setFont(FONT_18);
	    SalesTotalSalesValue.setFont(FONT_18);
        
        
        salesMainPanel.add(SalesNumberOfCustomersValue);
        salesMainPanel.add(SalesNumberOfEmployeesValue);
        salesMainPanel.add(SalesNumberOfOrdersValue);
        salesMainPanel.add(AverageOrderTimeValue);
        salesMainPanel.add(AverageOrderCheckValue);
	    
        salesMainPanel.add(SalesNumberOrdersReceivedValue);
        salesMainPanel.add(SalesNumberOrdersInProgressValue);
        salesMainPanel.add(SalesNumberOrdersForDeliveryValue);
        salesMainPanel.add(SalesNumberOrdersDeliveredValue);
        salesMainPanel.add(SalesNumberOrdersCompletedValue);
	    
        salesMainPanel.add(SalesPizzaValue);
        salesMainPanel.add(SalesBurgerValue);
        salesMainPanel.add(SalesFrenchFriesValue);
        salesMainPanel.add(SalesOnionRingsValue);
        salesMainPanel.add(SalesDrinksValue);
        
        salesMainPanel.add(SalesPizzaValuePercent);
        salesMainPanel.add(SalesBurgerValuePercent);
        salesMainPanel.add(SalesFrenchFriesValuePercent);
        salesMainPanel.add(SalesOnionRingsValuePercent);
        salesMainPanel.add(SalesDrinksValuePercent);
        
        salesMainPanel.add(SalesTotalSubTotalValue);
        salesMainPanel.add(SalesTotalTaxValue);
        salesMainPanel.add(SalesTotalSalesValue);
        
        mainPanel.add(salesMainPanel);
        // End Sales/Statistics screen   
        
        
        
        
        // Start Customers Screen
        customersMainPanel = new JPanel ();
        customersMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Customers" ) );
        customersMainPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST,  customersMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  customersMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, customersMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, customersMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
              
        customersMainPanel.add(customersSearchPanel);
        customersMainPanel.add(customersFormPanel);
        customersMainPanel.add(customersTablePanel);
        mainPanel.add(customersMainPanel);
        // End Customers screen    
        
        
        
        
        // Start Employees Screen
        employeesMainPanel = new JPanel ();
        employeesMainPanel.setBorder( new TitledBorder ( new EtchedBorder (), "Employees" ) );
        employeesMainPanel.setLayout(layout);
        layout.putConstraint(SpringLayout.WEST,  employeesMainPanel, 0, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  employeesMainPanel, 0, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, employeesMainPanel, 0, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.SOUTH, employeesMainPanel, 0, SpringLayout.SOUTH, mainPanel);
        
        layout.putConstraint(SpringLayout.WEST,  employeesTablePanel, 0, SpringLayout.WEST, employeesMainPanel);
        layout.putConstraint(SpringLayout.NORTH,  employeesTablePanel, 10, SpringLayout.NORTH, employeesMainPanel);
        
        
        
        employeesMainPanel.add(employeesSearchPanel);
        employeesMainPanel.add(employeesFormPanel);
        employeesMainPanel.add(employeesTablePanel);
        
        mainPanel.add(employeesMainPanel);
        // End Employees screen    
        
        add(mainPanel);
        
        hideAllPanels();
        orderMainPanel.setVisible(true);
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
	    	
	    	// save order to orders
	    	orders.add(order);
	    	
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
    		customers.add(customer);
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
    		
    		
		/* 
		* For Demonstration
		*/
    		
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_LOGIN)) {
			
			// Login Screen
			hideAllPanels();
			loginMainPanel.setVisible(true);
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_POS)) {
			
			// Point Of Sale/Make An Order  Screen
			hideAllPanels();
			orderMainPanel.setVisible(true);
			
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_KITCHEN)) {
			
			// Kitchen Orders Screen
			hideAllPanels();
			kitchenMainPanel.setVisible(true);
			ordersKitchenPanel.removeAll();
			
			for(Order o : orders) {
				
				if(o.getOrderStatus() != Order.ORDER_STATUSES.ORDER_STATUS_RECEIEVED) {
					continue;
				}
				
				JPanel kitchenOrderPanel = new JPanel();
				BoxLayout boxlayout = new BoxLayout(kitchenOrderPanel, BoxLayout.Y_AXIS);
				kitchenOrderPanel.setLayout(boxlayout);
				kitchenOrderPanel.setAutoscrolls(true);
				kitchenOrderPanel.setBackground(o.isDelivered() ? COLOR_DELIVERY_ORDERS : COLOR_REGULAR_ORDERS);
				
				JLabel kitchenOrderLabel = new JLabel("<html>" + o.toKitchenString().replaceAll("\\n", "<br>") + "</html>"); 
				kitchenOrderLabel.setFont(FONT_16);
			
				String buttonText = "";
				buttonText += "Complete Order# " + o.getOrderNumber();
				JButton kitchenOrderButton = new JButton();
				kitchenOrderButton.setText(buttonText);
				kitchenOrderButton.setPreferredSize(BUTTON_SIZE_250_30);
				
				kitchenOrderButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e)
				    {
				    	String buttonText = e.getActionCommand();
				    	String currentOrderNumber = buttonText.replace("Complete Order# ", "");
				          
				        for(Order o : orders) {
				        	if(o.getOrderNumber().equalsIgnoreCase(currentOrderNumber)) {
				        		if(o.isDelivered()) {
				        			// move to delivery
				        			o.orderStatusCooked();
				        		} else {
				        			// complete order if not delivered
				        			o.orderStatusCompleted();
				        		}
				        		
				        		// remove panel and button
				        		JButton button = (JButton) e.getSource();
				        		Container parentPanel = button.getParent();
				        		Container parentPanel2 = parentPanel.getParent();
				        		Container parentPanel3 = parentPanel2.getParent();
				        		ordersKitchenPanel.remove(parentPanel3);
						        ordersKitchenPanel.validate();
						        ordersKitchenPanel.repaint();  
						        kitchenMainPanel.validate();
						        kitchenMainPanel.repaint();
				        	}
				        }
				    }
				});
				kitchenOrderPanel.add(kitchenOrderButton);
				kitchenOrderPanel.add(kitchenOrderLabel);
				
				JScrollPane kitchenOrderScrollpanel = new JScrollPane(kitchenOrderPanel,
						   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
						   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				kitchenOrderScrollpanel.setPreferredSize(BUTTON_SIZE_250_400);
				
				ordersKitchenPanel.add(kitchenOrderScrollpanel);
			}
	
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_DELIVERY)) {
			
			// Delivery Orders Screen
			hideAllPanels();
			deliveryMainPanel.setVisible(true);
			ordersDeliveryPanel.removeAll();
			
			for(Order o : orders) {
				
				if(o.getOrderStatus() != Order.ORDER_STATUSES.ORDER_STATUS_PREPARED || ! o.isDelivered()) {
					continue;
				}
				
				JPanel deliveryOrderPanel = new JPanel();
				BoxLayout boxlayout = new BoxLayout(deliveryOrderPanel, BoxLayout.Y_AXIS);
				deliveryOrderPanel.setLayout(boxlayout);
				deliveryOrderPanel.setAutoscrolls(true);
				deliveryOrderPanel.setBackground(o.isDelivered() ? COLOR_DELIVERY_ORDERS : COLOR_REGULAR_ORDERS);
				
				JLabel deliveryOrderLabel = new JLabel("<html>" + o.toString().replaceAll("\\n", "<br>") + "</html>"); 
				deliveryOrderLabel.setFont(FONT_16);
			
				String buttonText = "";
				buttonText += "Mark Delivered Order# " + o.getOrderNumber();
				JButton deliveryOrderButton = new JButton();
				deliveryOrderButton.setText(buttonText);
				deliveryOrderButton.setPreferredSize(BUTTON_SIZE_250_30);
				
				deliveryOrderButton.addActionListener(new ActionListener() {
				    public void actionPerformed(ActionEvent e)
				    {
				    	String buttonText = e.getActionCommand();
				    	String currentOrderNumber = buttonText.replace("Mark Delivered Order# ", "");
				          
				        for(Order o : orders) {
				        	if(o.getOrderNumber().equalsIgnoreCase(currentOrderNumber)) {
				        		if(o.isDelivered()) {
				        			o.orderStatusDelivered();
				        			o.orderStatusCompleted();
				        		}
				        		
				        		// remove panel and button
				        		JButton button = (JButton) e.getSource();
				        		Container parentPanel  = button.getParent();
				        		Container parentPanel2 = parentPanel.getParent();
				        		Container parentPanel3 = parentPanel2.getParent();
				        		ordersDeliveryPanel.remove(parentPanel3);
				        		ordersDeliveryPanel.validate();
				        		ordersDeliveryPanel.repaint();  
						        deliveryMainPanel.validate();
						        deliveryMainPanel.repaint();
				        	}
				        }
				    }
				});
				deliveryOrderPanel.add(deliveryOrderButton);
				deliveryOrderPanel.add(deliveryOrderLabel);
				
				JScrollPane deliveryOrderScrollpanel = new JScrollPane(deliveryOrderPanel,
						   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
						   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				deliveryOrderScrollpanel.setPreferredSize(BUTTON_SIZE_250_400);
				
				ordersDeliveryPanel.add(deliveryOrderScrollpanel);
			}
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_SALES)) {
			
			// Sales Orders Screen
			hideAllPanels();
			salesMainPanel.setVisible(true);
			
			int    numberOrders            = orders.size();
			int    numberOfCustomers       = customers.size();
			int    numberOfEmployees       = employees.size();
			
			int    numberOrdersReceived    = orders.size();
			int    numberOrdersInProgress    = 0;
			int    numberOrdersForDelivery = 0;
			int    numberOrdersDelivered   = 0;
			int    numberOrdersCompleted   = 0;
			
			
			double averageOrderTimeSum     = 0.0;		
			double averageOrderTime        = 0.0;		
			double averageCheck            = 0.0;		
			
			
			double totalSalesPizza = 0.0;
			double totalSalesBurger = 0.0;
			double totalSalesFrenchFries = 0.0;
			double totalSalesOnionRings = 0.0;
			double totalSalesDrinks = 0.0;
			
			double totalSalesPizzaShare = 0.0;
			double totalSalesBurgerShare = 0.0;
			double totalSalesFrenchFriesShare = 0.0;
			double totalSalesOnionRingsShare = 0.0;
			double totalSalesDrinksShare = 0.0;			
			
			double subTotalSales = 0.0;
			double taxSales = 0.0;
			double totalSales = 0.0;
			
			// orders loop
			for (Order o : orders) {
				
				// order items loop
				for(MenuItem oi : o.getOrderItems()) {		
					
					// Check type of the order item
					if(oi instanceof Pizza) {						
						totalSalesPizza += oi.getPrice();
					}
					if(oi instanceof Burger) {						
						totalSalesBurger += oi.getPrice();
					}
					if(oi instanceof SideItem) {	
						if(oi.getName().equalsIgnoreCase("french fries") ) {
							totalSalesFrenchFries += oi.getPrice();
						}
						if(oi.getName().equalsIgnoreCase("onion rings") ) {
							totalSalesOnionRings += oi.getPrice();
						}
					}
					if(oi instanceof Drink) {						
						totalSalesDrinks += oi.getPrice();
					}
				}
				
				if(o.isDelivered()) {
					numberOrdersForDelivery++;
				}
				if(o.getOrderStatus().equals(Order.ORDER_STATUSES.ORDER_STATUS_PREPARED) || o.getOrderStatus().equals(Order.ORDER_STATUSES.ORDER_STATUS_RECEIEVED)) {
					numberOrdersInProgress ++;
				}
				if(o.getOrderStatus().equals(Order.ORDER_STATUSES.ORDER_STATUS_COMPLETED) ) {
					numberOrdersCompleted ++;
					averageOrderTimeSum += o.getOrderTotalTimeSeconds();
				}
				if(o.isDelivered() && o.getOrderStatus().equals(Order.ORDER_STATUSES.ORDER_STATUS_COMPLETED) ) {
					numberOrdersDelivered ++;
				}
				
				System.out.println();
				
				// Calculate totals
				subTotalSales += o.getSubTotal();
				taxSales += o.getTax();
				totalSales += o.getTotal();
			}
			
			totalSalesPizzaShare       = (subTotalSales > 0) ? totalSalesPizza       / subTotalSales * 100 : 0;
			totalSalesBurgerShare      = (subTotalSales > 0) ? totalSalesBurger      / subTotalSales * 100 : 0;
			totalSalesFrenchFriesShare = (subTotalSales > 0) ? totalSalesFrenchFries / subTotalSales * 100 : 0;
			totalSalesOnionRingsShare  = (subTotalSales > 0) ? totalSalesOnionRings  / subTotalSales * 100 : 0;
			totalSalesDrinksShare      = (subTotalSales > 0) ? totalSalesDrinks      / subTotalSales * 100 : 0;		
			averageOrderTime           = (numberOrdersCompleted > 0) ? averageOrderTimeSum / numberOrdersCompleted : 0;
			averageCheck               = (numberOrdersReceived > 0) ? totalSales / numberOrdersReceived : 0;
			
			SalesNumberOfOrdersValue.setText(String.valueOf(numberOrders));
		    SalesNumberOfCustomersValue.setText(String.valueOf(numberOfEmployees));
		    SalesNumberOfEmployeesValue.setText(String.valueOf(numberOfCustomers));
		    AverageOrderTimeValue.setText(String.format("%.2fs", averageOrderTime));
		    AverageOrderCheckValue.setText(String.format("$%.2f", averageCheck));
		    
		    SalesNumberOrdersReceivedValue.setText(String.valueOf(numberOrdersReceived));
		    SalesNumberOrdersInProgressValue.setText(String.valueOf(numberOrdersInProgress));
		    SalesNumberOrdersForDeliveryValue.setText(String.valueOf(numberOrdersForDelivery));
		    SalesNumberOrdersDeliveredValue.setText(String.valueOf(numberOrdersDelivered));
		    SalesNumberOrdersCompletedValue.setText(String.valueOf(numberOrdersCompleted));
		    
		    SalesPizzaValuePercent.setText(String.format("%.2f%%", totalSalesPizzaShare));
	        SalesBurgerValuePercent.setText(String.format("%.2f%%", totalSalesBurgerShare));
	        SalesFrenchFriesValuePercent.setText(String.format("%.2f%%", totalSalesFrenchFriesShare));
	        SalesOnionRingsValuePercent.setText(String.format("%.2f%%", totalSalesOnionRingsShare));
	        SalesDrinksValuePercent.setText(String.format("%.2f%%", totalSalesDrinksShare));
		    
		    SalesPizzaValue.setText(String.format("$%.2f", totalSalesPizza));
		    SalesBurgerValue.setText(String.format("$%.2f", totalSalesBurger));
		    SalesFrenchFriesValue.setText(String.format("$%.2f", totalSalesFrenchFries));
		    SalesOnionRingsValue.setText(String.format("$%.2f", totalSalesOnionRings));
		    SalesDrinksValue.setText(String.format("$%.2f", totalSalesDrinks));
		    
		    SalesTotalSubTotalValue.setText("$" + String.format("%.2f", subTotalSales));
		    SalesTotalTaxValue.setText("$" + String.format("%.2f", taxSales));
		    SalesTotalSalesValue.setText("$" + String.format("%.2f", totalSales));
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_EMPLOYEES)) {
			
			// Employees Screen
			hideAllPanels();
			employeesMainPanel.setVisible(true);	
			
			
			
			
			
			// Column Names 
	        String[] employeeColumnNames = { "Employee Number", "Phone", "First Name", "Last Name",
	        		"Address", "City", "State", "ZIP code"}; 
			
	        // Data to be displayed in the JTable 
			String[][] employeeTableData = new String[employees.size()][8]; 
			
			for(int i = 0; i < employees.size(); i++) {
				employeeTableData[i][0] = employees.get(i).getEmployeeNumber();
				employeeTableData[i][1] = employees.get(i).getPhone();
				employeeTableData[i][2] = employees.get(i).getFirstName();
				employeeTableData[i][3] = employees.get(i).getLastName();
				employeeTableData[i][4] = employees.get(i).getAddress();
				employeeTableData[i][5] = employees.get(i).getCity();
				employeeTableData[i][6] = employees.get(i).getState();
				employeeTableData[i][7] = employees.get(i).getZip();
			}
			
			
	  
	        
	  
	        // Initializing the JTable 
	        JTable table = new JTable(employeeTableData, employeeColumnNames); 
	        table.setRowHeight(40);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(300);
			table.getColumnModel().getColumn(5).setPreferredWidth(150);
			table.getColumnModel().getColumn(6).setPreferredWidth(150);
			table.getColumnModel().getColumn(7).setPreferredWidth(150);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setPreferredSize(new Dimension(1320, 500));
	        
	        employeesTablePanel.add(scrollPane);
			
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_CUSTOMERS)) {
			
			// Customers Screen
			hideAllPanels();
			customersMainPanel.setVisible(true);
			
			customersTablePanel.removeAll();
			
			
			// Column Names 
	        String[] columnNames = { "Customer Number", "Phone", "First Name", "Last Name",
	        		"Address", "City", "State", "ZIP code"}; 
	        
	        String[][] tableData;
			
	        if(customers.size() > 0) {
	        	// Data to be displayed in the JTable 
				tableData = new String[customers.size()][8]; 
				
				for(int i = 0; i < customers.size(); i++) {
					tableData[i][0] = customers.get(i).getCustomerNumber();
					tableData[i][1] = customers.get(i).getPhone();
					tableData[i][2] = customers.get(i).getFirstName();
					tableData[i][3] = customers.get(i).getLastName();
					tableData[i][4] = customers.get(i).getAddress();
					tableData[i][5] = customers.get(i).getCity();
					tableData[i][6] = customers.get(i).getState();
					tableData[i][7] = customers.get(i).getZip();
				}
	        } else {
	        	tableData = new String[1][8]; 
	        	tableData[0][0] = "";
	        	tableData[0][1] = "";
	        	tableData[0][2] = "";
	        	tableData[0][3] = "";
	        	tableData[0][4] = "";
	        	tableData[0][5] = "";
	        	tableData[0][6] = "";
	        	tableData[0][7] = "";
	        }
	        
	        // Initializing the JTable 
	        JTable table = new JTable(tableData, columnNames); 
	        table.setRowHeight(40);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(150);
			table.getColumnModel().getColumn(2).setPreferredWidth(150);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(300);
			table.getColumnModel().getColumn(5).setPreferredWidth(150);
			table.getColumnModel().getColumn(6).setPreferredWidth(150);
			table.getColumnModel().getColumn(7).setPreferredWidth(150);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setPreferredSize(new Dimension(1320, 500));
	        
	        customersTablePanel.add(scrollPane);
			
		} else if(actionCommand.equals(BUTTON_CAPTION_MENU_EXIT)) {
			
    		// Exit button
			System.exit(0);
    		    		
    		
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
	
	
	public void hideAllPanels() {
		loginMainPanel.setVisible(false);
		orderMainPanel.setVisible(false);
		kitchenMainPanel.setVisible(false);
		deliveryMainPanel.setVisible(false);
		salesMainPanel.setVisible(false);
		customersMainPanel.setVisible(false);
		employeesMainPanel.setVisible(false);
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
//			System.exit(0);
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
    
    
    public void setDefaultData() {
    	Employee employye1 = new Employee(
    			"1000",
    			"John",
    			"Smith",
    			"172 East 6th St E",
    			"St Paul",
    			"MN",
    			"55101",
    			"6511231234"
		);
    	
    	Employee employye2 = new Employee(
    			"1001",
    			"John",
    			"Smith",
    			"400 Spring St,",
    			"St Paul",
    			"MN",
    			"55102",
    			"6512231237"
		);
    	
    	Employee employye3 = new Employee(
    			"1002",
    			"John",
    			"Smith",
    			"422 W Superior",
    			"St Paul",
    			"MN",
    			"55102",
    			"6515557779"
		);
    	
    	employees.add(employye1);
    	employees.add(employye2);
    	employees.add(employye3);
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

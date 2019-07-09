package edu.century.group6;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParsePosition;
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
	private static final String PROGRAM_NAME = "PointOfSale";
	
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
	private static final int TEXTARE_NUMBER_OF_CHAR = 40;
	
	/**
	 * Console text area's "height" in number of lines
	 */
	private static final int TEXTAREA_NUMBER_OF_LINES = 40;
	
	/**
	 * Number of character for input text fields
	 */
	private static final int NUMBER_OF_CHAR_INPUT = 10;
	
	/**
	 * To keep order number
	 */
	private static int ORDER_NUMBER = 1;
	
	
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
		"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"
	};
	
	/**
	 * Array of quantity options
	 */
	public static final String[] QUANTITY_OPTIONS_ARRAY = {
		"0", "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"
	};
	
	/**
	 * Array of quantity options
	 */
	public static final String[] DRINK_OPTIONS_ARRAY = {
		"Coke", "Diet Coke"
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
    private JComboBox  pizzaCheeseToppingQuantitySelector = new JComboBox(QUANTITY_OPTIONS_ARRAY);
    
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaPepperoniToppingQuantitySelector = new JComboBox(QUANTITY_OPTIONS_ARRAY);
    
    /**
     * JComboBox for pizza quantity (0-20)
     */
    private JComboBox  pizzaHamToppingQuantitySelector = new JComboBox(QUANTITY_OPTIONS_ARRAY);
    
    
    
    /**
     * JComboBox for burger size
     */
    private JComboBox  burgerSizeSelector = new JComboBox(SIZE_ARRAY);
    
    /**
     * JComboBox for burger quantity (0-20)
     */
    private JComboBox  burgerQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    
    
    /**
     * JComboBox for french fries size
     */
    private JComboBox  frenchFriesSizeSelector = new JComboBox(SIZE_ARRAY);
    
    /**
     * JComboBox for french fries quantity (0-20)
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
    private JComboBox  drinkTypeSelector = new JComboBox(DRINK_OPTIONS_ARRAY);
    
    /**
     * JComboBox for onion rings size
     */
    private JComboBox  drinkSizeSelector = new JComboBox(SIZE_ARRAY);
    
    /**
     * JComboBox for onion rings quantity (0-20)
     */
    private JComboBox  drinkQuantitySelector = new JComboBox(QUANTITY_ARRAY);
    
    
    /**
	 * Button Captions
	 */
	public static final String BUTTON_CAPTION_ADD_PIZZA          = "Add Pizza";
	public static final String BUTTON_CAPTION_ADD_BURGER         = "Add Burger";
	public static final String BUTTON_CAPTION_ADD_FRENCH_FRIES   = "Add French Fries";
	public static final String BUTTON_CAPTION_ADD_ONION_RINGS    = "Add Onion Rings";
	public static final String BUTTON_CAPTION_ADD_DRINK          = "Add Drink";
	
	public static final String BUTTON_CAPTION_RESET_PIZZA        = "Reset Pizza";
	public static final String BUTTON_CAPTION_RESET_BURGER       = "Reset Burger";
	public static final String BUTTON_CAPTION_RESET_FRENCH_FRIES = "Reset French Fries";
	public static final String BUTTON_CAPTION_RESET_ONION_RINGS  = "Reset Onion Rings";
	public static final String BUTTON_CAPTION_RESET_DRINK        = "Reset Drink";
    
    
	
	
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
        ORDER_NUMBER++;
        
        // Create main panel
        JPanel mainPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        mainPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainPanel.setLayout(layout);
        
        
        // Define Console Text Area
        // Label and border around console text area
        JPanel consolePanel = new JPanel ();
        consolePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "ORDER DETAILS" ) );
        // text area
        orderConsoleTextArea = new JTextArea(TEXTAREA_NUMBER_OF_LINES, TEXTARE_NUMBER_OF_CHAR);
        // add scroll to text area
        JScrollPane scrollPanel = new JScrollPane(orderConsoleTextArea);
        scrollPanel.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        consolePanel.add(scrollPanel);
        
        
        
        //define form labels
        JLabel MenuLabel                = new JLabel("MENU");
        JLabel PizzaLabel               = new JLabel("PIZZA");
        
        JLabel PizzaSizeLabel           = new JLabel("Size");
        JLabel PizzaToppingsLabel       = new JLabel("PIZZA TOPPINGS");
        JLabel PizzaCheeseTopping       = new JLabel("Cheese");
        JLabel PizzaPeperoniTopping     = new JLabel("Peperoni");
        JLabel PizzaHamTopping          = new JLabel("Ham");
        JLabel PizzaQuantity            = new JLabel("Quantity");
        
        
        JLabel BurgerLabel              = new JLabel("BURGER");
        JLabel BurgerSizeLabel          = new JLabel("Size");
        JLabel BurgerCheeseLabel        = new JLabel("Cheese");
        JLabel BurderTomatoLabel        = new JLabel("Tomato");
        JLabel BurgerOnionLabel         = new JLabel("Onions");
        JLabel BurgerQuantityLabel      = new JLabel("Quantity");
        
        
//        JLabel SideItemLabel            = new JLabel("SIDES");
        JLabel FrenchFriesLabel         = new JLabel("FRENCH FRIES");
        JLabel FrenchFriesSizeLabel     = new JLabel("Size");
        JLabel FrenchFriesQuantityLabel = new JLabel("Quantity");
        
        JLabel OnionsLabel              = new JLabel("ONION RINGS");
        JLabel OnionsSizeLabel          = new JLabel("Size");
        JLabel OnionsQuantityLabel      = new JLabel("Quantity");
        
        JLabel DrinksLabel              = new JLabel("DRINKS");
        JLabel DrinkTypeLabel           = new JLabel("Drink");
        JLabel DrinkSizeLabel           = new JLabel("Size");
        JLabel DrinkQuantityLabel       = new JLabel("Quantity");
        
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
        mainPanel.add(BurgerSizeLabel);
        mainPanel.add(BurgerCheeseLabel);
        mainPanel.add(BurderTomatoLabel);
        mainPanel.add(BurgerOnionLabel);
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
        
        // Add selectboxes
        mainPanel.add(pizzaSizeSelector);
        mainPanel.add(pizzaCheeseToppingQuantitySelector);
        mainPanel.add(pizzaPepperoniToppingQuantitySelector);
        mainPanel.add(pizzaHamToppingQuantitySelector);
        mainPanel.add(pizzaQuantitySelector);
        mainPanel.add(burgerSizeSelector);
        mainPanel.add(burgerQuantitySelector);
        mainPanel.add(frenchFriesSizeSelector);
        mainPanel.add(frenchFriesQuantitySelector);
        mainPanel.add(onionRingsSizeSelector);
        mainPanel.add(onionRingsQuantitySelector);
        mainPanel.add(drinkTypeSelector);
        mainPanel.add(drinkSizeSelector);
        mainPanel.add(drinkQuantitySelector);
        
        // add buttons
        mainPanel.add(actionAddPizzaButton);
        mainPanel.add(actionAddBurgerButton);
        mainPanel.add(actionAddFrenchFriesButton);
        mainPanel.add(actionAddOnionRingsButton);
        mainPanel.add(actionAddDrinkButton);
        mainPanel.add(actionResetPizzaButton);
        mainPanel.add(actionResetBurgerButton);
        mainPanel.add(actionResetFrenchFriesButton);
        mainPanel.add(actionResetOnionRingsButton);
        mainPanel.add(actionResetDrinkButton);
        
        
        
        
        // Padding from side of the window
        int leftPadding1 = 10; 
        int leftPadding2 = 80;
        int leftPadding3 = 250;
        int leftPadding4 = 320;
        int leftPadding100 = 100;
        int leftPadding200 = 200;
        int leftPadding300 = 300;
        int leftPadding400 = 400;
        int leftPadding500 = 500;
        int leftPadding600 = 600;
        
        // Order Console Panel
        layout.putConstraint(SpringLayout.EAST,  consolePanel, -leftPadding1, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, consolePanel, leftPadding1, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.EAST,  orderConsoleTextArea, -leftPadding1, SpringLayout.EAST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, orderConsoleTextArea, 5, SpringLayout.NORTH, mainPanel);
        
        // MENU Label
        layout.putConstraint(SpringLayout.WEST,  MenuLabel, leftPadding300, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, MenuLabel, 10, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row1 Col1 - PIZZA
        layout.putConstraint(SpringLayout.WEST,  PizzaLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaLabel, 40, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row2 Col1 - Size
        layout.putConstraint(SpringLayout.WEST,  PizzaSizeLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaSizeLabel, 70, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaSizeSelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaSizeSelector,  70, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row3 Col1 - Quantity
        layout.putConstraint(SpringLayout.WEST,  PizzaQuantity, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaQuantity, 100, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaQuantitySelector,  100, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row4 - Toppings
        layout.putConstraint(SpringLayout.WEST,  PizzaToppingsLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaToppingsLabel, 140, SpringLayout.NORTH, mainPanel);
       
        // Pizza Row5 Col1 - Cheese Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaCheeseTopping, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaCheeseTopping, 170, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaCheeseToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaCheeseToppingQuantitySelector,  170, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row6 Col1 - Pepperoi Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaPeperoniTopping, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaPeperoniTopping, 200, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaPepperoniToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaPepperoniToppingQuantitySelector,  200, SpringLayout.NORTH, mainPanel);
       
        // Pizza Row7 Col1 - Ham Topping
        layout.putConstraint(SpringLayout.WEST,  PizzaHamTopping, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, PizzaHamTopping, 230, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  pizzaHamToppingQuantitySelector,  leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, pizzaHamToppingQuantitySelector,  230, SpringLayout.NORTH, mainPanel);
        
        // Pizza Row8 Col1 - Add Pizza Button
        layout.putConstraint(SpringLayout.WEST,  actionAddPizzaButton, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddPizzaButton, 270, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetPizzaButton, leftPadding1, SpringLayout.EAST, actionAddPizzaButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetPizzaButton, 270, SpringLayout.NORTH, mainPanel);
        
        
        
        
        
        
     // Burger Row1 - Burger
        layout.putConstraint(SpringLayout.WEST,  BurgerLabel, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerLabel, 330, SpringLayout.NORTH, mainPanel);
        
        // Burger Row2 - Burger Size
        layout.putConstraint(SpringLayout.WEST,  BurgerSizeLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerSizeLabel, 360, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerSizeSelector, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerSizeSelector, 360, SpringLayout.NORTH, mainPanel);
        
        // Burger Row3 - Burger Cheese
        layout.putConstraint(SpringLayout.WEST,  BurgerCheeseLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerCheeseLabel, 390, SpringLayout.NORTH, mainPanel);
//        layout.putConstraint(SpringLayout.WEST,  departureCityTextField,  leftPadding100, SpringLayout.WEST, mainPanel);
//        layout.putConstraint(SpringLayout.NORTH, departureCityTextField,  390, SpringLayout.NORTH, mainPanel);
       
        // Burger Row4 - Burger Tomato
        layout.putConstraint(SpringLayout.WEST,  BurderTomatoLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurderTomatoLabel, 420, SpringLayout.NORTH, mainPanel);
//        layout.putConstraint(SpringLayout.WEST,  destinationCityTextField,  leftPadding100, SpringLayout.WEST, mainPanel);
//        layout.putConstraint(SpringLayout.NORTH, destinationCityTextField,  420, SpringLayout.NORTH, mainPanel);
        
        // Burger Row5 - Burger Onion
        layout.putConstraint(SpringLayout.WEST,  BurgerOnionLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerOnionLabel, 450, SpringLayout.NORTH, mainPanel);
//        layout.putConstraint(SpringLayout.WEST,  destinationCityTextField,  leftPadding100, SpringLayout.WEST, mainPanel);
//        layout.putConstraint(SpringLayout.NORTH, destinationCityTextField,  450, SpringLayout.NORTH, mainPanel);
       
        // Burger Row6 - Burger Quantity
        layout.putConstraint(SpringLayout.WEST,  BurgerQuantityLabel, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, BurgerQuantityLabel, 480, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  burgerQuantitySelector, leftPadding100, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, burgerQuantitySelector, 480, SpringLayout.NORTH, mainPanel);
       
        // Burger Row7 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddBurgerButton, leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddBurgerButton, 520, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetBurgerButton, leftPadding1, SpringLayout.EAST, actionAddBurgerButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetBurgerButton, 520, SpringLayout.NORTH, mainPanel);
        
        
        
        // French Fries Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesLabel, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesLabel, 40, SpringLayout.NORTH, mainPanel);
        
        // French Fries Row2 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesSizeLabel, leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesSizeLabel, 70, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesSizeSelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesSizeSelector,  70, SpringLayout.NORTH, mainPanel);
        
        // French Fries Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  FrenchFriesQuantityLabel, leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, FrenchFriesQuantityLabel, 100, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  frenchFriesQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, frenchFriesQuantitySelector,  100, SpringLayout.NORTH, mainPanel);
        
        
        // French Fries Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddFrenchFriesButton, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddFrenchFriesButton, 140, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetFrenchFriesButton, leftPadding1, SpringLayout.EAST, actionAddFrenchFriesButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetFrenchFriesButton, 140, SpringLayout.NORTH, mainPanel);
        


        
        // Onion Rings Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  OnionsLabel, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsLabel, 200, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row2 - Size
        layout.putConstraint(SpringLayout.WEST,  OnionsSizeLabel,        leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsSizeLabel,        230, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsSizeSelector, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsSizeSelector, 230, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row3 - Quantity
        layout.putConstraint(SpringLayout.WEST,  OnionsQuantityLabel,         leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, OnionsQuantityLabel,         270, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  onionRingsQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, onionRingsQuantitySelector,  270, SpringLayout.NORTH, mainPanel);
        
        // Onion Rings Row4 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddOnionRingsButton, leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddOnionRingsButton, 310, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetOnionRingsButton, leftPadding1, SpringLayout.EAST, actionAddOnionRingsButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetOnionRingsButton, 310, SpringLayout.NORTH, mainPanel);
        
        
        
        
        
        // Drink Row1 - Label
        layout.putConstraint(SpringLayout.WEST,  DrinksLabel, leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinksLabel, 370, SpringLayout.NORTH, mainPanel);
        
        // Drink Row2 - Type
        layout.putConstraint(SpringLayout.WEST,  DrinkTypeLabel,        leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkTypeLabel,        400, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkTypeSelector,     leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkTypeSelector,     400, SpringLayout.NORTH, mainPanel);
        
        // Drink Row3 - Size
        layout.putConstraint(SpringLayout.WEST,  DrinkSizeLabel,         leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkSizeLabel,         430, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkSizeSelector,      leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkSizeSelector,      430, SpringLayout.NORTH, mainPanel);
        
        // Drink Row4 - Quantity
        layout.putConstraint(SpringLayout.WEST,  DrinkQuantityLabel,     leftPadding400 + leftPadding1, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, DrinkQuantityLabel,     460, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  drinkQuantitySelector,  leftPadding500, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, drinkQuantitySelector,  460, SpringLayout.NORTH, mainPanel);
        
        // Drink Row5 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionAddDrinkButton,   leftPadding400, SpringLayout.WEST, mainPanel);
        layout.putConstraint(SpringLayout.NORTH, actionAddDrinkButton,   500, SpringLayout.NORTH, mainPanel);
        layout.putConstraint(SpringLayout.WEST,  actionResetDrinkButton, leftPadding1, SpringLayout.EAST, actionAddDrinkButton);
        layout.putConstraint(SpringLayout.NORTH, actionResetDrinkButton, 500, SpringLayout.NORTH, mainPanel);
        
        add(mainPanel);
	}
	

	/**
	 * Buttons click handler
	 */
	public void actionPerformed(ActionEvent e)
	{
	    String actionCommand = e.getActionCommand( );
	    
	    if (actionCommand.equals("Order")) {
	    	
	    	// Place an order
	    
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_PIZZA)) {
	    	
	    	String pizzaSize           = String.valueOf(pizzaSizeSelector.getSelectedItem()).toLowerCase();
	    	int pizzaCheeseToppings    = Integer.parseInt(String.valueOf(pizzaCheeseToppingQuantitySelector.getSelectedItem()));
	    	int pizzaPepperoniToppings = Integer.parseInt(String.valueOf(pizzaPepperoniToppingQuantitySelector.getSelectedItem()));
	    	int pizzaHamToppings       = Integer.parseInt(String.valueOf(pizzaHamToppingQuantitySelector.getSelectedItem()));
	    	int pizzaQuantity          = Integer.parseInt(String.valueOf(pizzaQuantitySelector.getSelectedItem()));
	    	
	    	Pizza pizza = new Pizza(pizzaSize, pizzaCheeseToppings, pizzaPepperoniToppings, pizzaHamToppings);
	    	
	    	order.addOrderItem(pizza);
	    	
	    	// Add pizza to order
	    	orderConsoleTextArea.setText(order.printOrder());
		    
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_BURGER)) {
	    	
	    	// Add burger to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_ADD_BURGER);
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_FRENCH_FRIES)) {
	    	
	    	// Add french fries to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_ADD_FRENCH_FRIES);
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_ADD_ONION_RINGS)) {
	    	
	    	// Add onion rings to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_ADD_ONION_RINGS);
	    	
    	} else if (actionCommand.equals(BUTTON_CAPTION_ADD_DRINK)) {
	    	
	    	// Add onion rings to order
    		orderConsoleTextArea.setText(BUTTON_CAPTION_ADD_DRINK);
    		
    	} else if (actionCommand.equals(BUTTON_CAPTION_RESET_PIZZA)) {
	    	
	    	// Reset pizza to order
    		orderConsoleTextArea.setText(BUTTON_CAPTION_RESET_PIZZA);
		    
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_BURGER)) {
	    	
	    	// Reset burger to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_RESET_BURGER);
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_FRENCH_FRIES)) {
	    	
	    	// Reset french fries to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_RESET_FRENCH_FRIES);
	    	
	    } else if (actionCommand.equals(BUTTON_CAPTION_RESET_ONION_RINGS)) {
	    	
	    	// Reset onion rings to order
	    	orderConsoleTextArea.setText(BUTTON_CAPTION_RESET_ONION_RINGS);
	    	
    	} else if (actionCommand.equals(BUTTON_CAPTION_RESET_DRINK)) {
	    	
	    	// Reset onion rings to order
    		orderConsoleTextArea.setText(BUTTON_CAPTION_RESET_DRINK);
	    	
	    } else {
	    	
	    	// Could not find action
	    }
	}

}

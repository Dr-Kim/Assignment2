package bikerental;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;		// Needed for arraylist

/**
 * This program is a bike rental application that manages customer order.
 */

public class BikeRental {
	
	static ArrayList<CustomerOrder> orders = new ArrayList<CustomerOrder>();	//new arraylist to hold CustomerOrder objects
	
	// Create a Scanner object for keyboard input.
	static Scanner keyboard = new Scanner (System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		while (true)	//main loop for the application
		{
			System.out.println("(N)ew Customer Order, (R)eport, or (Q)uit:");	//main three options
			
			char input = keyboard.nextLine().charAt(0);							//keyboard input
			
			switch (input) 
			{
			case 'Q' :															//option to exit the application
			case 'q' :
				System.exit(0);
				break;
			case 'N' :															//option to enter a new customer order
			case 'n' :
				getCustomerOrder();
				break;
			case 'R' :															//option to produce a report
			case 'r' :
				printReport();
				break;
			default :															//incorrect option
				System.out.println("Bad option: " + input);
				break;
				
			}
		}

	}
	
	/**
	 * The getCustomerOrder method creates a new CustomerOrder object and populate the data from the user input.
	 */
	public static void getCustomerOrder()
	{
		String name;				//to hold a customer name
		LocalDate start;			//to hold the starting date
		int days;					//to hold the number of rental date
		String model;				//to hold the model of a bike
		String lock;				//to hold the input for the lock option
		String delivery;			//to hold the input for the delivery option
		String helmet;				//to hold the input for the helmet option
		String repair;				//to hold the input for the repair kit option
		Bike userBike = new Bike();	//Bike object
		CustomerOrder userOrder = new CustomerOrder();	//CustomerOrder object
		
		//to receive Bike object in CustomerOrder object
		userOrder.setSelectedBike(userBike);
		
		//Get a customer name.
		System.out.println("Enter customer name:");
		name = keyboard.nextLine();
		userOrder.setCustomerName(name);
		
		//Get the rental start date.
		System.out.println("Enter rental start date (YYYY-MM-DD):");	
		start = LocalDate.parse(keyboard.nextLine());
		userOrder.setStartDate(start);
		
		//Get the number of rental days.
		System.out.println("Enter number of rental days:");				
		days = Integer.parseInt(keyboard.nextLine());
		while (days == 0)												//Get the value again if the number of days is 0.
		{
			System.out.println("Number of rental days must be > 0\n" + "Enter number of rental days:");
			days = Integer.parseInt(keyboard.nextLine());
		}
		userOrder.setNumberOfDays(days);
		
		//Set the end date.
		userOrder.setEndDate();
		
		//Get the bike model.
		System.out.println("Enter desired bike model: Road, Mountain, Cruiser, Kids");
		model = keyboard.nextLine();
		while (!(model.equals("Road") || model.equals("Mountain") || model.equals("Cruiser") || model.equals("Kids")))	//Get the value again if the input is incorrect.
		{
			System.out.println(model + " not available. Choose another.\n" + "Enter desired bike model: Road, Mountain, Cruiser, Kids");
			model = keyboard.nextLine();
		}
		userBike.setBikeModel(model);
		
		//Set the daily rate of the model.
		userBike.setbikeDailyRate();
		
		//Get the decision of a bike lock.
		System.out.println("Need bike lock? (Y/N)");		
		lock = keyboard.nextLine();
		while (!(lock.equals("Y") || lock.equals("N")))				//Get the input again if the input is incorrect.
		{
			System.out.println("Must be Y or N\n" + "Need bike lock? (Y/N)");
			lock = keyboard.nextLine();
		}
		userOrder.setLockOption(lock);
		
		//Get the decision of delivery.
		System.out.println("Need Delivery? (Y/N)");
		delivery = keyboard.nextLine();
		while (!(delivery.equals("Y") || delivery.equals("N")))		//Get the input again if the input is incorrect.
		{
			System.out.println("Must be Y or N\n" + "Need bike lock? (Y/N)");
			delivery = keyboard.nextLine();
		}
		userOrder.setDeliveryOption(delivery);
		
		//Get the decision of a helmet.
		System.out.println("Need Helmet? (Y/N)");
		helmet = keyboard.nextLine();
		while (!(helmet.equals("Y") || helmet.equals("N")))			//Get the input again if the input is incorrect.
		{
			System.out.println("Must be Y or N\n" + "Need bike lock? (Y/N)");
			helmet = keyboard.nextLine();
		}
		userOrder.setHelmetOption(helmet);
		
		//Get the decision of a repair kit.
		System.out.println("Need Repair Kit? (Y/N)");		
		repair = keyboard.nextLine();
		while (!(repair.equals("Y") || repair.equals("N")))			//Get the input again if the input is incorrect.
		{
			System.out.println("Must be Y or N\n" + "Need bike lock? (Y/N)");
			repair = keyboard.nextLine();
		}
		userOrder.setRepairKitOption(repair);
		
		showOrder(userOrder);		//ShowOrder method.
		
		orders.add(userOrder);		//Add an item in orders arraylist.
	}

	/**
	 * The printReport method displays each order in CustomerOrder arraylist.
	 */
	public static void printReport()
	{
		double totalRent = 0;		//To hold total rental fee.
		double totalOption = 0;		//To hold total option fee.
		double totalSales = 0;		//To hold total sales fee.
		
		//The number of orders.
		System.out.println("\nSales Report - Number of Orders: " + orders.size() + "\n");
		
		//Display each order in arraylist.
		for(int index = 0; index < orders.size(); index++)
		{
			System.out.println("Order #" + (index+1));
			showOrder(orders.get(index));
			totalRent += orders.get(index).getSelectedBike().getBikeDailyRate() * orders.get(index).getNumberOfDays();		//Running total for total rental fee.
			totalOption += orders.get(index).getLockFee() + orders.get(index).getRepairKitFee() + orders.get(index).getHelmetFee() + orders.get(index).getDeliveryFee();	//Running total for total option fee.
		}
		
		totalSales = totalRent + totalOption;	//Total sales fee.
		
		//Display totals.
		System.out.println("\nSales Summary\n");
		System.out.printf("%31s $%7.2f\n", "Total Rental Sales:", totalRent);
		System.out.printf("%31s $%7.2f\n", "Total Options Sales:", totalOption);
		System.out.printf("%31s $%7.2f\n", "Total Sales:", totalSales);
	}
	
	/**
	 * The showOrder method displays a single CustomerOrder object.
	 * @param singleOrder The object rental data come from.
	 */
	public static void showOrder(CustomerOrder singleOrder)
	{
		System.out.println("Customer: " + singleOrder.getCustomerName());  	//Display the customer name.
		System.out.println("Rental starts: " + singleOrder.getStartDate() + " ends: " + singleOrder.getEndDate());		//Display date information.
		System.out.printf("%31s $%7.2f\n", singleOrder.getSelectedBike().getBikeModel() + " Bike Daily Rate:", singleOrder.getSelectedBike().getBikeDailyRate());		//Display daily rate.
		System.out.printf("%31s $%7.2f\n", "Bike Rental for " + singleOrder.getNumberOfDays() + " days:", singleOrder.getSelectedBike().getBikeDailyRate() * singleOrder.getNumberOfDays());		//Display total rental fee.
		
		//Show lock option fee if there is.
		if (singleOrder.getLockOption() == true)
		{
			System.out.printf("%31s $%7.2f\n", "Bike Lock:", singleOrder.getLockFee());
		}
		
		//Show repair kit option fee if there is.
		if (singleOrder.getRepairKitOption() == true)
		{
			System.out.printf("%31s $%7.2f\n", "Repair Kit:", singleOrder.getRepairKitFee());
		}
		
		//Show helmet option fee if there is.
		if (singleOrder.getHelmetOption() == true)
		{
			System.out.printf("%31s $%7.2f\n", "Helmet:", singleOrder.getHelmetFee());
		}
		
		//Show delivery option fee if there is.
		if (singleOrder.getDeliveryOption() == true)
		{
			System.out.printf("%31s $%7.2f\n", "Delivery:", singleOrder.getDeliveryFee());
		}
		
		//Display total fee.
		System.out.printf("%31s $%7.2f\n", "Order Total Cost:", singleOrder.getTotalCost());
	}
}

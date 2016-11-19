package bikerental;

import java.time.LocalDate;

/**
 * The CustomerOrder class holds all the information of a single rental service including fee data.
 */
public class CustomerOrder
{
	private String customerName;		//name of a customer
	private Bike selectedBike;			//reference to selected bike
	private LocalDate startDate;		//starting date of rent
	private LocalDate endDate;			//ending date of rent
	private int numberOfDays;			//the number of renting days
	private boolean lockOption;			//lock option
	private boolean deliveryOption;		//delivery option
	private boolean helmetOption;		//helmet option
	private boolean repairKitOption;	//repair kit option
	
	/**
	* The setCustomerName method stores a value in the customerName field.
	* @param name The value to store in customerName.
	*/
	public void setCustomerName(String name)
	{
		customerName = name;
	}
	
	/**
	* The getCustomerName method returns the name of a customer.
	* @return The value in the customerName field.
	*/
	public String getCustomerName()
	{
		return customerName;
	}
	
	/**
	* The setSelectedBike method stores a object in the customerName field.
	* @param myBike The Bike object to store in the selectedBike field.
	*/
	public void setSelectedBike(Bike myBike)
	{
		selectedBike = myBike;
	}
	
	/**
	* The getSelectedBike method returns the Bike object.
	* @return The value in the selectedBike field.
	*/
	public Bike getSelectedBike()
	{
		return selectedBike;
	}
	
	/**
	* The setStartDate method stores the starting date in the startDate field.
	* @param start The value to store in the startDate field.
	*/
	public void setStartDate(LocalDate start)
	{
		startDate = start;
	}
	
	/**
	* The getStartDate method returns the starting date.
	* @return The value in the startDate field.
	*/
	public LocalDate getStartDate()
	{
		return startDate;
	}
	
	/**
	* The setNumberOfDays method stores a value in the numberOfDays field.
	* @param days The value to store in the numberOfDays field.
	*/
	public void setNumberOfDays(int days)
	{
		numberOfDays = days;
	}
	
	/**
	* The getNumberOfDays method returns the number of rental days.
	* @return The value in the numberOfDays field.
	*/
	public int getNumberOfDays()
	{
		return numberOfDays;
	}
	
	/**
	* The setEndDate method stores a value in the endDate field.
	*/
	public void setEndDate()
	{
		endDate = startDate.plusDays(numberOfDays);
	}
	
	/**
	* The getEndDate method returns the end date of the renting.
	* @return The value in the endDate field.
	*/
	public LocalDate getEndDate()
	{
		return endDate;
	}
	
	/**
	* The setLockOption method stores a boolean value in the lockOption field.
	* @param lock The value to determine the lockOption field.
	*/
	public void setLockOption(String lock)
	{
		if (lock.equals("Y"))
		{
			lockOption = true;
		}
		else if (lock.equals("N"))
		{
			lockOption = false;
		}
	}
	
	/**
	* The getLockOption method returns the lock option.
	* @return The value in the lockOption field.
	*/
	public boolean getLockOption()
	{
		return lockOption;
	}
	
	/**
	* The setDeliveryOption method stores a boolean value in the deliveryOption field.
	* @param delivery The value to determine the deliveryOption field.
	*/
	public void setDeliveryOption(String delivery)
	{
		if (delivery.equals("Y"))
		{
			deliveryOption = true;
		}
		else if (delivery.equals("N"))
		{
			deliveryOption = false;
		}
	}
	
	/**
	* The getDeliveryOption method returns the delivery option.
	* @return The value in the deliveryOption field.
	*/
	public boolean getDeliveryOption()
	{
		return deliveryOption;
	}
	
	/**
	* The setHelmetOption method stores a boolean value in the helmetOption field.
	* @param helmet The value to determine the helmetOption field.
	*/
	public void setHelmetOption(String helmet)
	{
		if (helmet.equals("Y"))
		{
			helmetOption = true;
		}
		else if (helmet.equals("N"))
		{
			helmetOption = false;
		}
	}
	
	/**
	* The getHelmetOption method returns the helmet option.
	* @return The value in the helmetOption field.
	*/
	public boolean getHelmetOption()
	{
		return helmetOption;
	}
	
	/**
	* The setRepairKitOption method stores a boolean value in the repairKitOption field.
	* @param repair The value to determine the repairKitOption field.
	*/
	public void setRepairKitOption(String repair)
	{
		if (repair.equals("Y"))
		{
			repairKitOption = true;
		}
		else if (repair.equals("N"))
		{
			repairKitOption = false;
		}
	}
	
	/**
	* The getRepairKitOption method returns the repair kit option.
	* @return The value in the repairKitOption field.
	*/
	public boolean getRepairKitOption()
	{
		return repairKitOption;
	}
	
	/**
	* The getLockFee method returns the fee of the lock option.
	* @return The fee value depends on lockOption field.
	*/
	public double getLockFee()
	{
		if (lockOption == true)
		{
			return 20.00;
		}
		else
		{
			return 0.00;
		}
	}
	
	/**
	* The getDeliveryFee method returns the fee of the delivery option.
	* @return The fee value depends on deliveryOption field.
	*/
	public double getDeliveryFee()
	{
		if (deliveryOption == true)
		{
			return 70.00;
		}
		else
		{
			return 0.00;
		}
	}
	
	/**
	* The getHelmetFee method returns the fee of the helmet option.
	* @return The fee value depends on helmetOption field.
	*/
	public double getHelmetFee()
	{
		if (helmetOption == true)
		{
			return 10.00;
		}
		else
		{
			return 0.00;
		}
	}
	
	/**
	* The getRepairKitFee method returns the fee of the repair kit option.
	* @return The fee value depends on repairKitOption field.
	*/
	public double getRepairKitFee()
	{
		if (repairKitOption == true)
		{
			return 5.75;
		}
		else
		{
			return 0.00;
		}
	}
	
	/**
	* The getTotalCost method returns the total cost of the rental fee and option fees.
	* @return The total cost value: sum of total rental fee and all options fee.
	*/
	public double getTotalCost()
	{
		return selectedBike.getBikeDailyRate() * numberOfDays + getLockFee() + getDeliveryFee() + getHelmetFee() + getRepairKitFee();
	}
}

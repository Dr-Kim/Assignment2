package bikerental;

/**
 * The Bike class holds the various models and rates
 * as well as including the data for the one the user selects
 */
public class Bike 
{
	private String bikeModel;				//model type of a bike
	private double bikeDailyRate;			//daily rate of a chosen type bike

	
	/**
	* The setBikeModel method stores a value in the bikeModel field.
	* @param model The data to store in model.
	*/
	public void setBikeModel(String model)
	{
		bikeModel = model;
	}
	
	/**
	* The getBikeModel method returns a model of a bike.
	* @return The value in the bikeModel field.
	*/
	public String getBikeModel()
	{
		return bikeModel;
	}
	
	/**
	* The setbikeDailyRate method stores a value in the bikeDailyRate field.
	*/
	public void setbikeDailyRate()
	{
		if (bikeModel.equals("Road"))			//Daily rate of Road model.
		{
			bikeDailyRate = 80.00;
		}
		else if (bikeModel.equals("Mountain"))	//Daily rate of Mountain model.
		{
			bikeDailyRate = 51.25;
		}
		else if (bikeModel.equals("Cruiser"))	//Daily rate of Cruiser model.
		{
			bikeDailyRate = 35.50;
		}
		else if (bikeModel.equals("Kids"))		//Daily rate of Kids model.
		{
			bikeDailyRate = 20.00;
		}
	}
	
	/**
	* The getBikeDailyRate method returns daily rate of a chosen bike model.
	* @return The value in the bikeDailyRate field.
	*/
	public double getBikeDailyRate()
	{
		return bikeDailyRate;
	}
}

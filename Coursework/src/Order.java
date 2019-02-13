/**
 * This is the Order class
 * 
 *  
 * @author Jamie Morse (jtm1)
 *
 */
import java.sql.Timestamp;
import java.util.Hashtable;



public class Order{
	
	private String orderID;
	private int customerID;
	private Timestamp timestamp;
	private String itemID;
	private double cost;
	private double discountAmount;

	
	public Order(String orderID, int customerID, Timestamp timestamp, String itemID, double cost, double discountAmount)
	{
		try {
		this.orderID = orderID;
		this.customerID = customerID;
		this.timestamp = timestamp;
		this.itemID = itemID;
		this.cost = cost;
		this.discountAmount = discountAmount;
		}
		catch (IllegalArgumentException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getOrderID()
	{
		if(orderID == null)
		{
			throw new NullPointerException("Could not get orderID as object value is null");
		}else {
			return orderID;
		}	
	}
	
	public void setOrderID(String newOrderID)	
	{
		 newOrderID = orderID;
		 if (newOrderID == null) {
			 throw new IllegalStateException("Cannot set orderID as newOrderID is null");
		 }
		 if(!(newOrderID instanceof String))
		 {
			 throw new IllegalArgumentException("Cannot set orderID as newOrderID is not of type String");
		 }
	}
	
	public int getCustomerID() 
	{
		//cannot check if int is null or convert int to boolean so checked if ID was greater than 0
		//needs changing if customer ID can be 000 for example.
		if(!(customerID > 0))	
		{
			throw new IllegalStateException("Cannot get customerID as ID does not exist");
		}else {
			return customerID;
		}
			/*if(CustomerList.containsKey(customerID key))
			{
				throw new CustomerDoesNotExistException(customerID);
			}
			else
			{
				return customerID;
			}*/
	}
	
	public void setCustomerID(int newCustomerID)	
	{
		newCustomerID = customerID;
		 if (!(newCustomerID > 0)) {
			 throw new IllegalStateException("Cannot set customerID as newCustomerID is not greater than 0");
		 }
		 if(!(newCustomerID == (int)newCustomerID))
		 {
			 throw new IllegalArgumentException("Cannot set customerID as newCustomerID is not of type int");
		 }
	}
	
	public Timestamp getTimeStamp() 
	{
		if(timestamp == null)
		{
			throw new NullPointerException("Could not get timestamp as object value is null");
		}else {
			return timestamp;
		}	
	}
	
	public void setTimeStamp(Timestamp newTimeStamp) 
	{
		newTimeStamp = timestamp;
		 if (newTimeStamp == null) {
			 throw new IllegalStateException("Cannot set timestamp as newTimeStamp is null");
		 }
		 if(!(newTimeStamp instanceof Timestamp))
		 {
			 throw new IllegalArgumentException("Cannot set timestamp as newTimeStamp is not of type Timestamp");
		 }
	}
	
	public String getItemID() 
	{
		if(itemID == null)
		{
			throw new NullPointerException("Could not get itemID as object value is null");
		}else {
			return itemID;
		}
	}
	
	public void setItemID(String newItemID) 
	{
		newItemID = itemID;
		 if (newItemID == null) {
			 throw new IllegalStateException("Cannot set itemID as newItemID is null");
		 }
		 if(!(newItemID instanceof String))
		 {
			 throw new IllegalArgumentException("Cannot set itemID as newItemID is not of type String");
		 }
	}
	
	public double getCost() 
	{
		if(Double.isNaN(cost))
		{
			throw new NullPointerException("Could not get cost as object value is Not A Number");
		}else {
			return cost;
		}
	}	
	
	public void setCost(double newCost)	
	{
		newCost = cost;
		if (!(cost >= 0)) {
			 throw new IllegalStateException("Cannot set cost as newCost cannot be less than 0");
		}
		if(!(cost == (double)newCost)) {
			throw new IllegalArgumentException("Cannot set cost as newCost is not of type double");
		}
	}
	
	public double getDiscountAmount() 
	{
		if(Double.isNaN(discountAmount))
		{
			throw new NullPointerException("Could not get discountAmount as object value is Not A Number");
		}else {
			return discountAmount;
		}
	}
	
	public void setDiscount(double newDiscountAmount)
	{
		newDiscountAmount = discountAmount;
		if (!(discountAmount >= 0)) {
			 throw new IllegalStateException("Cannot set discount as newDiscountAmount cannot be less than 0");
		}
		if(!(discountAmount == (double)newDiscountAmount)) {
			throw new IllegalArgumentException("Cannot set discount as newDiscountAmount is not of type double");
		}
	}
	
	
	
	

}	
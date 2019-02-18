package main;
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
		return orderID;	
	}
	
	public void setOrderID(String newOrderID)	
	{
		 newOrderID = orderID;
	}
	
	public int getCustomerID() 
	{
		return customerID;
	}
	
	public void setCustomerID(int newCustomerID)	
	{
		newCustomerID = customerID;
	}
	
	public Timestamp getTimeStamp() 
	{
		return timestamp;
	}
	
	public void setTimeStamp(Timestamp newTimeStamp) 
	{
		newTimeStamp = timestamp;
	}
	
	public String getItemID() 
	{
		return itemID;
	}
	
	public void setItemID(String newItemID) 
	{
		newItemID = itemID;
	}
	
	public double getCost() 
	{
		return cost;
	}	
	
	public void setCost(double newCost)	
	{
		newCost = cost;
	}
	
	public double getDiscountAmount() 
	{
		return discountAmount;
	}
	
	public void setDiscount(double newDiscountAmount)
	{
		newDiscountAmount = discountAmount;
	}
	
}	
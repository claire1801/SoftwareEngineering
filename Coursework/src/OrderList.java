/**
 * This is the OrderList class
 * 
 *  
 * @author Jamie Morse (jtm1)
 *
 */
import java.util.ArrayList;

public class OrderList {
	
	
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public ArrayList<Order> getOrderList() {
		String message= "";
		try {
		 return orderList;
		}
		catch (NullPointerException e){
			 message = e.getMessage() + "Could not get orderList, value is null";
			 System.out.println(message);
		}
		return orderList;
		 
	}
	
	public void addOrder(Order order)
	{
	
		orderList.add(order);
		if (order == null) {
			throw new IllegalStateException("Cannot add order to orderList as order object has value null");
		}
		if (!(order instanceof Order))
		{
			throw new IllegalArgumentException("Cannot add order to orderList as order object is not of Order type");
		}
	}
	
	public void removeOrder(Order order)
	{
		
		orderList.remove(order);
		if (orderList.size() == 0)
		{
			throw new IndexOutOfBoundsException("Cannot remove order, orderList is empty");
		}
	}
	
	public String writeReport() {
		String report = new String();
		for(Order order : orderList) {
			report += order.getOrderID();
			report += "/";
			report += order.getTimeStamp();
			report += "/";
			report += order.getCustomerID();
			report += "/";
			report += order.getItemID();
			report += "/";
			report += order.getCost();
			report += "/";
			report += order.getDiscountAmount();
			report += "\n";
			System.out.println(report);
		}
		if (orderList.size() == 0)
		{
			throw new IndexOutOfBoundsException("Cannot generate order report, orderList is empty");
		}
		return report;
	}
	
	
}


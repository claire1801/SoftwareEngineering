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
	
	public int totalSales() {
		return orderList.size();
	}
	public double totalIncome() {
		double total = 0;
		for(Order order : orderList) {
			total += order.getCost();
		}
		
		return total;
	}
	
	public String writeReport() {

		try {
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

		}
		catch(IndexOutOfBoundsException e){
				System.out.println(e.getMessage());
				System.out.println("Cannot generate order report, orderList is empty");
	            System.exit(1);
		}
		return report;
		
		
		
		
		//if (orderList.size() == 0)
		//{
		//	throw new IndexOutOfBoundsException("Cannot generate order report, orderList is empty");
		//}
		
	}
	
	
}


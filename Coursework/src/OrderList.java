import java.util.ArrayList;

public class OrderList {
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	
	public ArrayList<Order> getOrderList() {
		 return orderList;
	}
	
	public void addOrder()
	{
		Order order = null; //delete as needed
		orderList.add(order);
	}
	
	public void removeOrder()
	{
		Order order = null; //delete as needed
		orderList.remove(order);
	}
	
	public OrderList writeReport() {
		return null; //change
		
	}


}


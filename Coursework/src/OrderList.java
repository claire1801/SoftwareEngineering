import java.util.ArrayList;

public class OrderList {
	
	
	private ArrayList<Order> orderList = new ArrayList<Order>();
	
	public ArrayList<Order> getOrderList() {
		 return orderList;
	}
	
	public void addOrder(Order order)
	{
	
		orderList.add(order);
	}
	
	public void removeOrder(Order order)
	{
		
		orderList.remove(order);
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
		String report = new String();
		for(Order order : orderList) {
			report += order.getOrderID();
			report += "/";
			report += order.getCustomerID();
			report += "/";
			report += order.getTimeStamp();
			report += "/";
			report += order.getItemID();
			report += "/";
			report += order.getCost();
			report += "/";
			report += order.getDiscountAmount();
			report += "\n";
			//System.out.println(report);
		}
		return report;
	}
	
	
}


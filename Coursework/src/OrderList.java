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
		return report;
	}


}



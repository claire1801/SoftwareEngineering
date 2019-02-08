import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class CustomerList {
	Hashtable<Integer, Customer> customerList;

	public CustomerList(Hashtable<Integer, Customer> customerList) {
		this.customerList = customerList;
	}

	public Hashtable<Integer, Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(Integer key, Customer value) {
		customerList.put(key, value);
	}

	public Customer getCustomer(Integer key) {
        return customerList.get(key);
	}
	
	public void removeCustomer(Integer key) {
		customerList.remove(key);
	}
	

	
	public String writeReport() {
		String report = new String();
		
		for(Customer customer: customerList.values()) {
			report += customer.getName() + "/";
			report += customer.getCustomerId() + "/";
			report += customer.getNumberPreviousCoffees()+ "/";
			report += customer.getType() + "\n";
			
			
		}
//		for(Entry<Integer, Customer> customer : customerList.entrySet()){
//		//report += customer.getValue();
//		report += ((Customer) customer).getName() + "/";
//		report += customer.getKey() + "/";
//		report += ((Customer) customer).getType() + "/";
//		report += ((Customer) customer).getNumberPreviousCoffees();
//	
//		}
		
		return report;
				
	}
	
	
	

}

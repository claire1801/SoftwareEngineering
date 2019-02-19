package main;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;

public class CustomerList {
	Hashtable<Integer, Customer> customerList;

	public CustomerList() {
		customerList = new Hashtable<Integer, Customer> ();
	}

	public Hashtable<Integer, Customer> getCustomerList() {
		return customerList;
	}

	public void addCustomer(Integer key, Customer value) {
		customerList.put(key, value);
		if(value == null) {
			throw new IllegalArgumentException ("Can not add a new customer as not all the details are provided");
		}
		if(key == null) {
			throw new IllegalArgumentException ("Key must contain a customer ID");
		}
		
		
	}

	public Customer getCustomer(Integer key) {
        return customerList.get(key);
	}
	
	public void removeCustomer(Integer key) {
		
		if (customerList.containsKey(key)) {
			customerList.remove(key);
		}
		else  {
			throw new IllegalArgumentException ("Customer ID doesn't exist");
		}
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


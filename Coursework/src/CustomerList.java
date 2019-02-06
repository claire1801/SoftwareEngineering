
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class CustomerList {
	Hashtable<String, Customer> customerList;

	public CustomerList(Hashtable<String, Customer> customerList) {
		this.customerList = customerList;
	}

	public Hashtable<String, Customer> getCustomerList() {
		return customerList;
	}

	public Customer addCustomer(String key, Customer value) {
		return customerList.put(key, value);
	}

	public Customer getCustomer(String key) {
        return customerList.get(key);
	}
	
	public Customer removeCustomer(String key) {
		return customerList.remove(key);
	}
	
	public void writeReport() {
		FileWriter fw;

		try {
			fw = new FileWriter("CustomerReport.txt");

			// formatting of table
			fw.write(String.format("%-5s %-40s %-20s %-20s \n\n", "Customer", "Orders", "Discount", "Total Amount"));
		
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	
	
	

}

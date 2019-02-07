
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

public class CustomerList {
	Hashtable<Integer, Customer> customerList;

	public CustomerList(Hashtable<Integer, Customer> customerList) {
		this.customerList = customerList;
	}

	public Hashtable<Integer, Customer> getCustomerList() {
		return customerList;
	}

	public Customer addCustomer(Integer key, Customer value) {
		return customerList.put(key, value);
	}

	public Customer getCustomer(Integer key) {
        return customerList.get(key);
	}
	
	public Customer removeCustomer(Integer key) {
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

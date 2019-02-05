import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Manager {
	public static OrderList orderList = new OrderList();
	public static MenuList menuList = new MenuList();
	public static StaffList staffList = new StaffList();
	public static CustomerList customerList = new CustomerList();
	
	
	public static GUI gui = new  GUI();
	
	
	/**
	 * read in menu name/id/cost/description/allergy
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private static void readMenuItems(String fileName) throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] item = line.split("/");
			double cost = Double.parseDouble(item[2]);
			//System.out.println(item[0]);
			MenuItem newMenuItem = new MenuItem(item[0],item[1],cost,item[3],item[4]);//wrong in class diagram
			menuList.addItem(newMenuItem);
		}
		scanner.close();
	}
	
	/**
	 * read in orders - id/customerid/timestamp/item/cost/discount
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws ParseException
	 */
	private static void readOrders(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException, ParseException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] order = line.split("/");
			double cost = Double.parseDouble(order[4]);
			double discount = Double.parseDouble(order[5]);
			int customerID = Integer.parseInt(order[1]);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date parsedDate = dateFormat.parse(order[2]);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			
			//System.out.println(timestamp);
			
			Order newOrder = new Order(order[0],customerID, timestamp, order[3],cost,discount);
			OrderList.addOrder(newOrder);
		}
		scanner.close();
		
	}
	
	/**
	 * read in staff name/id
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private static void readStaff(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] staff = line.split("/");
			int ID = Integer.parseInt(staff[1]);
			//int noDrinks = Integer.parseInt(staff[2]);
			//System.out.println(staff[0]);
			Staff staffmember = new Staff(staff[0], ID);
			staffList.addStaff(staffmember);
			
			
			
			
		}
		scanner.close();
		
	}
	
	/**
	 * read in customers name/id/number of coffees 
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private static  void readCustomers(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] customer = line.split("/");
			int ID = Integer.parseInt(customer[1]);
			int noDrinks = Integer.parseInt(customer[2]);
			//System.out.println(customer[0]);
			Customer newCustomer = new Customer(customer[0],ID,noDrinks);
			customerList.addCustomer(newCustomer);

		}
		scanner.close();
		
	}
	

	

	public static void main(String[] args) {
		try {
			readCustomers("customerList.txt");
			readStaff("StaffList.txt");
			readMenuItems("MenuItems.txt");
			readOrders("orderList.txt");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		gui.initGUI();

	}
	
	public void writeReport() {
		menuList.writeReport("MenuItems.txt");
		orderList.writeReport("orderList.txt");
		staffList.writeReport("StaffList.txt");
		customerList.writeReport("customerList.txt");
		
	}

}

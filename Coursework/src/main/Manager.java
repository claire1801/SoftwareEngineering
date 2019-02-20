package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JFrame;

import java.util.Date;
import java.util.Hashtable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Reads and out files and reports
 * @author samth
 *
 */
public class Manager {
	

	
	public static OrderList orderList = new OrderList();
	public static MenuList menuList = new MenuList();
	public static StaffList staffList = new StaffList();
	public static CustomerList customerList = new CustomerList();
	public static Basket basket = new Basket();
	
	
	//public static GUI gui;
	
	
	/**
	 * read in menu name/id/cost/description/allergy
	 * @param fileName
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public static void readMenuItems(String fileName) throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		
	
		
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		//int counter = 0; not used????
		
		while (scanner.hasNextLine()) {
			
			String line = scanner.nextLine();
			String[] item = line.split("/");
			if(item.length < 5) {
				continue;
			}
			
			double cost = Double.parseDouble(item[2]);
			//System.out.println(item[0]);
			//String code = item[1].
			
			if(item[1].substring(0, 5).equals("DRINK")||item[1].substring(0, 5).equals("COFEE")) {
				MenuItems newMenuItem = new Drinks(item[0],item[1],cost,item[3],item[4]);
				//System.out.println("Drink");
				//System.out.println(item[0]);
				menuList.addItem(item[1], newMenuItem);
			}
			else if(item[1].substring(0, 5).equals("MEALS")) {
				MenuItems newMenuItem = new Meals(item[0],item[1],cost,item[3],item[4]);
				//System.out.println("meal");
				menuList.addItem(item[1], newMenuItem);
			}
			else if(item[1].substring(0, 5).equals("SNACK")) {
				MenuItems newMenuItem = new Snacks(item[0],item[1],cost,item[3],item[4]);
				//System.out.println("snack");
				menuList.addItem(item[1], newMenuItem);
			}
			//counter += 1;
			//System.out.println(counter);
			
		//	menuList.addItem(newMenuItem);
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
	 * @throws InvalidCustomerIDException
	 */
	public static void readOrders(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException, ParseException, InvalidCustomerIDException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] order = line.split("/");
			if(order.length < 5) {
				continue;
			}
			double cost = Double.parseDouble(order[4]);
			double discount = Double.parseDouble(order[5]);
			int customerID = Integer.parseInt(order[1]);
			int orderID = Integer.parseInt(order[0]);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date parsedDate = dateFormat.parse(order[2]);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			
			//System.out.println(timestamp);
			
			Order newOrder = new Order(orderID,customerID, timestamp, order[3],cost,discount);
			orderList.addOrder(newOrder);
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
	public static void readStaff(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] staff = line.split("/");
			int ID = Integer.parseInt(staff[1]);
			String name = staff[0];
			String[] names = name.split("\\W+");//split name into first last using whitespace
			int lastIndex = names.length - 1;// index of last name
			//int noDrinks = Integer.parseInt(staff[2]);
			//System.out.print(names[0] + " ");
			//System.out.println(names[lastIndex]);
			Staff staffmember = new Staff(ID,names[0],names[lastIndex]);
			staffList.addStaffToList(staffmember);
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
	public static  void readCustomers(String fileName)  throws FileNotFoundException, NumberFormatException, ArrayIndexOutOfBoundsException {
		
		
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] customer = line.split("/");
			if(customer.length < 2) {
				continue;
			}
			int ID = Integer.parseInt(customer[1]);
			int noDrinks = Integer.parseInt(customer[2]);
			String member = customer[3];
			MembershipType memType;
			if(member.charAt(0) == 'E') {
				memType = MembershipType.EMPLOYEE;
			}else if(member.charAt(0) == 'S') {
				memType = MembershipType.STUDENT;
			}else  {
				memType = MembershipType.MEMBER;
			}
			
			 
			
			//System.out.println(customer[0]);
			//Customer newCustomer = new Customer(customer[0],ID,noDrinks);
			Customer newCustomer = new Customer(ID,memType,noDrinks,customer[0]);
			//System.out.println(newCustomer.isMember());
			customerList.addCustomer(ID,newCustomer);//name?

		}
		scanner.close();
	}
	

	

	public static void main(String[] args) throws InvalidCustomerIDException {
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
//		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//		Date date= new Date();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		
//		Order testorder1 = new Order("0002",0001,timestamp,"COFEE001",20.1,1.1);
		
		  javax.swing.SwingUtilities.invokeLater(new Runnable() {
			  
			  public void run() {
			   
			      createAndShowGUI(); 
			   
			  }
			   
			    });
		//gui = new GUI();
		//gui.guiRun();
		//progExit();

	}
	private static void createAndShowGUI() {
   	 
  	  //Create and set up the window.
  	 
  	  JFrame frame = new GUI();
  	 
  	  //Display the window.
  	 
  	  frame.pack();
  	 
  	  frame.setVisible(true);
  	 
  	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	 
  	 }
	
	/**
	 * runs shutdown procedure
	 */
	
	public static void progExit() {
		updateFiles();
		writeReport("report.txt");
		System.exit(0);
		
	}
	
	
	/**
	 * update all data files
	 */
	
	public static void updateFiles() {
		String order = orderList.writeReport();
		printToFile("orderList.txt",order);
		
		String menu = menuList.writeReport();
		printToFile("MenuItems.txt",menu);
//		
//		String menu = staffList.writeReport();    // not needed?
//		printToFile("StaffList.txt",menu);
//		
		String customer = customerList.writeReport();
		printToFile("customerList.txt",customer);

		
	}
	
	/**
	 * Write report
	 * @param filename
	 * @param details
	 */
	
	public static void printToFile(String filename, String details)  {
		try {
			FileWriter fw = new FileWriter(filename);
			PrintWriter pw = new PrintWriter(fw);
			pw.print(details);
			pw.close();
		} catch (FileNotFoundException e1) {
			System.out.println("input file does not exist!");
			System.exit(1);
		}catch (IOException e2) {
			e2.printStackTrace();
			System.exit(1);
		}
		
	}
	
	
	public static  void writeReport(String filename) {
		String details = "Summary of Cafe\n";
		int sales = orderList.totalSales();
		double income = orderList.totalIncome();
		details += "In total there have been " + sales + " orders made.\n";
		details += "This gives a total income of " + income + " (£)\n\n";
		details += "The following is a full list of all items Ordered:\n";
		details += orderList.writeReport();
		
		printToFile(filename, details);
		
		
		
	}
	
	

}

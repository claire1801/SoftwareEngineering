package main;
import java.util.Map;
import java.util.TreeMap;

public class MenuList {
	
	static TreeMap<String, MenuItems> menuList; 

	public MenuList(TreeMap<String, MenuItems> menuList) { 
		// I don't think the constructor should take an argument
		this.menuList = menuList; // this is also looks strange
	}

	public TreeMap<String, MenuItems> getMenuList() { // I don't really understand the point of this method
		String message = "";
		try { 
			return menuList; 
		} catch (NullPointerException e) {
			message = e.getMessage() + "Could not get menuList";	
			System.out.println(message); 
			return null;
		}
	}

	public void addItem(String key, MenuItems value) {
		if (menuList.containsKey(key)) {
			throw new IllegalArgumentException ("Key already exists");  
		}
		menuList.put(key, value);
	}

	public MenuItems getItem(String key) {
		if (menuList.containsKey(key)) {
			return menuList.get(key);
		} throw new IllegalArgumentException ("Key does not exist"); 
	}
	 
	
	public void remove(String key){
		if (!menuList.containsKey(key)) {
			throw new IllegalArgumentException ("Item does not exist");
		} 
		menuList.remove(key);
	}

	// commented method out
	// this method isn't used anywhere ever and will print out the address space of the object
//	public void printAll() {
//		for (Map.Entry<String, MenuItems> entry : menuList.entrySet()) {
//     	System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
//		}
//	}
	
	public String writeReport() {
		String report = new String();
		for(MenuItems entry: menuList.values()) {
			report += entry.getName() + "/";
			report += entry.getID()+ "/";
			report += entry.getCost() + "/";
			report += entry.getDescription() + "/";
			report += entry.getAllergens() + "\n";
		}
		return report;
	}
	
}

package main;
import java.util.Map;
import java.util.TreeMap;

public class MenuList {
	
	private static TreeMap<String, MenuItems> menuList;

	public MenuList(TreeMap<String, MenuItems> menuList) {
		
		this.menuList = menuList;
	}

	public TreeMap<String, MenuItems> getMenuList() {
		String message = "";
		try { return menuList; }
		catch (NullPointerException e) {
			message = e.getMessage() + "Could not get menuList";	
			System.out.println(message); }
		return menuList;
	}

	public void addItem(String key, MenuItems value) {
		menuList.put(key, value);
		if (!menuList.containsKey(key)) {
			throw new IllegalArgumentException ("Item does not exist");
		}
	}
	
	public MenuItems getItem(String key) {
	        return menuList.get(key);
	}
	 
	public void remove(String key){
		menuList.remove(key);
		if (!menuList.containsKey(key)) {
			throw new IllegalArgumentException ("Item does not exist");
		}
}

	public void printAll() {
		for (Map.Entry<String, MenuItems> entry : menuList.entrySet()) {
     	System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
	}
	
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

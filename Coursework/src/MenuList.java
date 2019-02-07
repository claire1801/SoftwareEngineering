import java.util.Map;
import java.util.TreeMap;

public class MenuList {
	
	private static TreeMap<String, MenuItems> menuList;

	public MenuList(TreeMap<String, MenuItems> menuList) {
		
		this.menuList = menuList;
	}

	public TreeMap<String, MenuItems> getMenuList() {
		return menuList;
	}

	public void addItem(String key, MenuItems value) {
		menuList.put(key, value);
	}
	
	public MenuItems getItem(String key) {
	        return menuList.get(key);
	}
	 
	public void remove(String key){
			menuList.remove(key);
	}

	public void printAll() {
		for (Map.Entry<String, MenuItems> entry : menuList.entrySet()) {
     	System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
	}
	
	public String writeReport() {
		String report = new String();
		for(Map.Entry<String, MenuItems> entry : menuList.entrySet()){
		report += ((MenuItems) entry).getName() + "/";
		report += entry.getKey() + "/";
		//report += entry.getValue() + "/";
		report += ((MenuItems) entry).getCost() + "/";
		report += ((MenuItems) entry).getDescription() + "/";
		report += ((MenuItems) entry).getAllergens();
		}
		
		return report;
	}
}

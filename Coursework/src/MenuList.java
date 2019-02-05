import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class MenuList {
	
	TreeMap<String, ? extends MenuItems> menuList;

	public MenuList(TreeMap<String, ? extends MenuItems> menuList) {
		
		this.menuList = menuList;
	}

	public TreeMap<String, ? extends MenuItems> getMenuList() {
		return menuList;
	}

	public MenuItems get(String key) {
	        return menuList.get(key);
	}
	 
	public MenuItems remove(String key){
			return menuList.remove(key);
	}

	public void printAll() {
		for (Map.Entry<String, ? extends MenuItems> entry : menuList.entrySet()) {
     	System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
		}
	}
	
	public void writeReport() {
		FileWriter fw;

		try {
			fw = new FileWriter("MenuReport.txt");
			fw.write(String.format("%-40s %-5s \n\n", "Menu Item", "Ordered"));
		
			fw.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	
	}	
	
}

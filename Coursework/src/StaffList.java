
import java.util.Hashtable;

/**
 * 
 * @author frsrg
 *
 */

public class StaffList {

	private Hashtable<Integer, Staff> staffList;
	
	public StaffList() {
		staffList = new Hashtable<Integer, Staff> ();		
	}
	
	public void addStaffToList(Staff staff) {
		staffList.put(staff.getStaffID(), staff);
	}

	
	// this would be better if we can remove by staff id 
	public void removeStaffFromList(Staff staff) {
		staffList.remove(staff.getStaffID());
	}
//	public void removeStaffFromList(int id) {
//		staffList.remove(id);
//	}
	
}

	


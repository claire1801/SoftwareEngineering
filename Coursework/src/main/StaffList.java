package main;

import java.util.Hashtable;

/**
 * 
 * @author frsrg
 *
 */

public class StaffList {

	Hashtable<Integer, Staff> staffList;
	
	// for Singleton
	private static StaffList list = new StaffList();
	
	private StaffList() {
		staffList = new Hashtable<Integer, Staff> ();		
	}
	
	// for Singleton
	public static StaffList getInstance() {
		return list;
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

	


package test;
import static org.junit.jupiter.api.Assertions.*;


import main.Staff;
import main.StaffList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffListTest {
	
	Staff staff = new Staff(123, "John", "Smith");
	StaffList staffList;
	
	@BeforeEach
	public void setup() {
		staffList = new StaffList();
		staffList.addStaffToList(staff);
		
	}
	
	@Test
	void testAddStaffToList() {
		 assertTrue(staffList.getStaffList().containsKey(123));
		  
	}

	@Test
	void testRemoveStaffFromList() {
		staffList.getStaffList().remove(123);
		assertFalse(staffList.getStaffList().containsKey(123));
	}

}

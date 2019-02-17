import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StaffTest {
	private int staffID = 123; 
	private String firstName = "John";
	private String lastName = "Smith";
	
	private Staff s;
	
	@BeforeEach 
	public void setup() {
		s = new Staff(staffID, firstName, lastName);
	}

	@Test
	public void testGetStaffID() {
		assertEquals(staffID, s.getStaffID());
	}

	@Test
	public void testGetStaffFirstName() {
		assertEquals(firstName, s.getStaffFirstName());
	}

	@Test
	public void testGetStaffLastName() {
		assertEquals(lastName, s.getStaffLastName());
	}

}

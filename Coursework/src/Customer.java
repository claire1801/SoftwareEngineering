
public class Customer {
	
	
	private int customerID; 
	private MembershipType member; 
	private int numberPreviousCoffees;
	private String name;
	
	
	public Customer(int customerID, MembershipType member, int numberPreviousCoffees, String name) {
		this.customerID = customerID;
		this.member = member;
		this.numberPreviousCoffees = numberPreviousCoffees;
		this.name = name;
	}

	public int getCustomerId() {
		return customerID;
	}

	public void setCustomerId(int customerId) {
		this.customerID = customerId;
	}

	public int getNumberPreviousCoffees() {
		return numberPreviousCoffees;
	}

	public void setNumberPreviousCoffees(int numberPreviousCoffees) {
		this.numberPreviousCoffees = numberPreviousCoffees;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public MembershipType getType() {
		return member;
	}

	public void setType(MembershipType member) {
		this.member = member;
	}
	
}

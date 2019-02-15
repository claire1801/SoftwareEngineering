
public class Customer {
	
	
	private int customerID; 
	private MembershipType member; 
	private int numberPreviousCoffees;
	private String name;
	
	
	public Customer(int customerID, MembershipType member, int numberPreviousCoffees, String name) {
		if(customerID < 1 || customerID > 1000) {
			throw new IllegalStateException("Customer ID is not valid, must be between 1 and 1000");
		}
		
		if(member != MembershipType.STUDENT || member != MembershipType.EMPLOYEE || member != MembershipType.MEMBER) {
			throw new IllegalStateException("Invalid membership type: Customer must be either a STUDENT, EMPLOYEE OR MEMBER");
		}
		
		if(numberPreviousCoffees < 0 || numberPreviousCoffees > 9) {
			throw new IllegalStateException("Number of previous coffees must be between 0 and 9");
		}
		
		if(name.length() == 0) {
         		throw new IllegalStateException("Name can not be blank");
		}
		
	
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
	
	public double getDiscount() {
		double discount = 0;
		if(member == MembershipType.STUDENT) {
			discount = 0.80;
		}
		else if(member == MembershipType.MEMBER) {
			discount = 0.75;
		}
		else if(member == MembershipType.EMPLOYEE){
			discount = 0.70;
		}	
		
		return discount;
	}
	
}


public class Customer {
	
	private int customerId;
	private boolean member;
	private int numberPreviousCoffees;
	
	public Customer(int customerID, boolean member, int numberPreviousCoffees) {
		this.customerId = customerId;
		this.member = member;
		this.numberPreviousCoffees = numberPreviousCoffees;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member) {
		this.member = member;
	}

	public int getNumberPreviousCoffees() {
		return numberPreviousCoffees;
	}

	public void setNumberPreviousCoffees(int numberPreviousCoffees) {
		this.numberPreviousCoffees = numberPreviousCoffees;
	}
	
	
	
}

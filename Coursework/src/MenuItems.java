//package cafe;

public abstract class MenuItems {
	
	protected String uniqueID;
	protected double cost; 
	protected String description;
	protected String allergens;
	protected String name;
	
	public MenuItems(String name, String id, double cost, String desc, String algns) {
		
		this.name = name;
		uniqueID = id;
		this.cost = cost;
		description = desc;
		allergens = algns;
		
	}
	

	






	public String getName() { return name; }
	
	public String getID() { return uniqueID; }
	
	public void setID(String newID) { uniqueID = newID; }
	
	public double getCost() { return cost; }
	
	public void setCost(double newCost) { cost = newCost; }
	
	public String getDescription() { return description; }
	
	public void setDescription(String newDescription) { description = newDescription; }
	
	public String getAllergens() { return allergens; }
	
	public void setAllergens(String newAllergens) { allergens = newAllergens; }
	
	

}
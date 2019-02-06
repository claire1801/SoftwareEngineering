import java.util.ArrayList;

/**
 * This is the basket class - not case!
 * 
 * It will store orders before they have been committed to the OrderList
 * @author frsrg
 *
 */


public class Basket {
	
	private ArrayList<Order> unconfirmedOrder;

	
	/**
	 * Global variable used in the Basket class
	 * 
	 * unDiscountBill		:			total bill without discount
	 * totalDiscount		:			total value of discount to be applied
	 * MEAL_DEAL_DISCOUNT	:			deduction applied when a qualifying meal deal is purchased
	 */
	private double unDiscountedBill = 0;
	private double totalDiscount = 0;
	private static final double MEAL_DEAL_DISCOUNT = 1.5;
	

	public Basket() {
		unconfirmedOrder = new ArrayList<Order> ();		
	}
		
	
	/**
	 * 
	 * @param item 
	 */
	public void addItemToUnconfirmedOrder(Order item) {   // setUnconfirmedOrder in class diagram
		unconfirmedOrder.add(item);
		unDiscountedBill += item.getCost();
	}
	
	
	/**
	 * 
	 */
	public void clearBasket() {
		unconfirmedOrder.clear();
	}
	
	
	/**
	 * 
	 */
	public void createOrder() {

	}
	
	
	/**
	 * 
	 * @return discount, total value of discount to be applied
	 */
	public double getDiscount() { //could possibly be broken down into smaller chunks at later stage
		
		int countOfFoodItems = 0, countOfSoftDrinks = 0, countOfSnacks = 0; // counters for the meal deal discount
		
		// discounts
		double mealDealDiscount = 0;
		double coffeeLoyaltyDiscount = 0;
		double memberDiscount = 0;
		
		// cost of meal deal items without discount
		double unDiscountedCostForMealDealItems = 0;
		
		// get the customer from the customer list	    // manager? is this how the customer list should be retrieved, not sure
		Customer customer = Manager.customerList.getCustomer(unconfirmedOrder.get(0).getCustomerID());  
		
		for (Order item : unconfirmedOrder) {

			// determine number of qualifying meal deals
			if (unconfirmedOrder.size() > 2) {
				// possible sub function here at later point, currently coded following the plan
				//could also consider Orders holding MenuItem objects rather than just ID 
				if(item.getItemID().substring(0, 4).equals("MEALS")) {
					countOfFoodItems++;
					unDiscountedCostForMealDealItems += item.getCost();
				}
				else if(item.getItemID().substring(0, 4).equals("DRINK")) {
					countOfSoftDrinks++;
					unDiscountedCostForMealDealItems += item.getCost();
				}
				else if(item.getItemID().substring(0, 4).equals("SNACK")) {
					countOfSnacks++;
					unDiscountedCostForMealDealItems += item.getCost();
				}
			}

			// coffee loyalty scheme discount
			// would be nice to maybe break these into sub functions at later point, although may mean need for globals.      
			// this.coffeeLoyaltyCard(customer, item);
			if(item.getItemID().substring(0, 3).equals("COFEE") && customer.coffeeLoyaltyCounter() == 4) {
				coffeeLoyaltyDiscount += item.getCost();
				customer.setCoffeeLoyaltyCounter(0);
			} else {
				customer.setCoffeeLoyaltyCounter(customer.coffeeLoyaltyCounter() + 1);
			}
		}

		// back to meal deals now we are outside the for loop
		int numberOfFullMealDeals = Math.min(countOfFoodItems, Math.min(countOfSoftDrinks, countOfSnacks));
		mealDealDiscount = unDiscountedCostForMealDealItems - (numberOfFullMealDeals*MEAL_DEAL_DISCOUNT);
		
		// members 10% discount
		if(customer.isMember()) {
			double tempDiscountedBill = unDiscountedBill - mealDealDiscount - coffeeLoyaltyDiscount;
			memberDiscount = 0.1 * tempDiscountedBill;
		}
		
		// total discount
		totalDiscount = mealDealDiscount + coffeeLoyaltyDiscount + memberDiscount;
		
		return totalDiscount;
	}
	
	
}
import java.util.*;

public class ShopArr {

	// Instance Variables
	private Cheese[] cheese;
	
	// Initialize method
	private void init(int max) {
		
		// Create max number of Cheese pointers
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Humboldt Fog");
			cheese[0].setPrice(25.00);
			
			if (max > 1) {
				cheese[1] = new Cheese("Red Hawk");
				cheese[1].setPrice(40.50);
			
				if (max > 2) {
					cheese[2] = new Cheese("Teleme", 17.25);
					//cheese[2].setName("Wrong Name");
				}
			}
		}
		
		Random ranGen = new Random(100);
		String name;
		
		for (int i = 3; i < max; i++) {
			cheese[i] = new Cheese("Cheese Type " + (char)('A' + i), (ranGen.nextInt(1000)/100.0));
		}
		
	}
	public ShopArr() {
		init(10);
	}
	
	public ShopArr(int max) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		max = scan.nextInt();
		init(max);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {
		System.out.println("We sell " + cheese.length + " kinds of Cheese (in 0.5 lb packages)");
		for(int i = 0; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
		}
		for(int i = 0; i < cheese.length; i++) {
			System.out.print("\nEnter the amount of " + cheese[i].getName() + " in lbs: ");
			cheese[i].setAmount(input);
			
			while (((cheese[i].getAmount() % 0.5) != 0) || (cheese[i].getAmount() < 0)) {
				if (cheese[i].getAmount() < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					cheese[i].setAmount(input);
				}
				else {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					cheese[i].setAmount(input);
				}
			}
			
		}
		
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		int zero = 0;
		for(int i = 0; i < cheese.length; i++) {
			if (cheese[i].getAmount() == 0) {
				zero++;
			}
		}
		if (zero == cheese.length) {
			System.out.println("No items were purchased.");
			System.out.println("");
		}
		else {
			for (int i = 0; i < cheese.length; i++) {
				if ((amt = cheese[i].getAmount()) > 0) {
					price = cheese[i].getPrice();
					System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, cheese[i].getName(), price, price*amt);
				}
			}
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		for(int i = 0; i < cheese.length; i++) {
			subTotal += cheese[i].getAmount() * cheese[i].getPrice();
		}

		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 07 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};
		
		if (cheese.length == 0) {
			return disSpecials;
		}
		
		double hfAmt = cheese[0].getAmount();
		double rhAmt = 0;
		if(cheese.length > 1) {
			rhAmt = cheese[1].getAmount();
		}
		if (hfAmt > 0) {
			int hTemp = (int)(hfAmt);
			double hTemp2 = hTemp/1;
			hTemp2 = hTemp2 * 0.5;
			disSpecials[0] = hTemp2 * cheese[0].getPrice();
		}
		
		if(rhAmt > 0) {
			double packs = rhAmt/0.5;
			int rTemp = (int)(packs/3);
			double rTemp2 = rTemp * 0.5;
			disSpecials[1] = rTemp2 * cheese[1].getPrice();
		}
		
		return disSpecials;	
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 07.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		int check = 0;
		
		System.out.print("Original Sub Total:                 $");
		System.out.printf("%.2f", subTotal);
		System.out.println("");
		System.out.println("Specials...");
		
		if (disSpecials[0] > 0) {
		subTotal -= disSpecials[0];
		System.out.print("Humboldt Fog (Buy 1 Get 1 Free):   -$");
		System.out.printf("%.2f" ,disSpecials[0]);
		System.out.println();
		check++;
		}
		if(disSpecials[1] > 0) {
			subTotal -= disSpecials[1];
			System.out.print("Red Hawk (Buy 2 Get 1 Free):       -$");
			System.out.printf("%.2f" ,disSpecials[1]);
			System.out.println();
			check++;
		}
		if (check == 0) {
			System.out.println("None\t\t\t           -$0.0");
		}
		
		System.out.print("New Sub Total:                      $");
		double newTotal = subTotal;
		System.out.printf("%.2f", newTotal);
		System.out.println("");
		
		
		return newTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 07.
	 */
	private void printFinalTotal(double newSubTotal) {
		double percentDis = 0;
		int numDis = 0;
		if (newSubTotal > 150) {
			percentDis = 0.10;
			numDis = 10;
		}
		if (newSubTotal > 250) {
			percentDis = 0.25;
			numDis = 25;
		}
		double subDis = (newSubTotal * percentDis);
		double total = (newSubTotal - subDis);
		
		if (numDis == 0) {
			System.out.print("Additional " + numDis + "%" + " Discount:            -$");
			System.out.printf("%.2f" ,subDis);
			System.out.println("");
		}
		else {
			System.out.print("Additional " + numDis + "%" + " Discount:           -$");
			System.out.printf("%.2f" ,subDis);
			System.out.println("");
		}
		System.out.print("Final Total:                        $");
		System.out.printf("%.2f" ,total);
		System.out.print("");
	}

	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lb of " + cheese[i].getName() + " @ $0 = $" + 0);
		System.out.println("Total Price: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();
		
		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}
		
		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();
		
		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}

import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */

	
	
	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		
		if (amounts.length == 0) {
			System.out.println("We sell " + amounts.length + " kinds of Cheese (in 0.5 lb packages)");
			System.out.println();
			System.out.println();
			System.out.println("Original Sub Total:                 $0.00");
			System.out.println("Specials...");
			System.out.println("None\t\t\t           -$0.00");
			System.out.println("New Sub Total:                      $" + "0.00");
			System.out.println("Additional 0% " + " Discount:           -$" + "0.00");
			System.out.println("Final Total:                        $" + "0.00");
			System.exit(0);
		}
		
		if (amounts.length != 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			if (amounts.length != 1) {
				names[1] = "Red Hawk";
				prices[1] = 40.50;
				if (amounts.length != 2) {
				names[2] = "Teleme";
				prices[2] = 17.25;
				}
			}
		}
		System.out.println();
 		System.out.println("We sell " + amounts.length + " kinds of Cheese (in 0.5 lb packages)");
 		
 		if (amounts.length != 0) {
		System.out.println(names[0] + ": $" + prices[0] + " per pound");
			if (amounts.length != 1) {
				System.out.println(names[1] + ": $" + prices[1] + " per pound");
				if (amounts.length != 2) {
				System.out.println(names[2] + ": $" + prices[2] + " per pound");
				}
			}
 		}
		
		
 		Random ranGen = new Random(100);

		for (int i = 3; i < amounts.length; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		System.out.println();
	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		for(int k = 0; k < amounts.length; k++) {
			System.out.print("Enter the amount of " + names[k] + " in lb: ");
			amounts[k] = sc.nextDouble();
			while (((amounts[k] % 0.5) != 0) || (amounts[k] < 0)) {
				if (amounts[k] < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					amounts[k] = sc.nextDouble();
				}
				else {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[k] = sc.nextDouble();
				}
			}
		}
		System.out.println();

	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		int zero = 0;
		for (int v = 0; v < amounts.length; v++) {
			if(amounts[v] == 0) {
				zero++;
			}
		}
		if(zero == amounts.length) {
			System.out.println("No items were purchased.");
		}
		else {
			for (int j = 0; j < amounts.length; j++) {
				if (amounts[j] == 0) {
					
				}
				else {
					System.out.print(amounts[j] + " lb of " + names[j] + " @ " + " $");
					System.out.printf("%.2f" ,prices[j]);
					System.out.print(" = $");
					System.out.printf("%.2f" ,(amounts[j] * prices[j]));
					System.out.println("");
				}
			}
		}
		System.out.println("");
	}
	
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		double total = 0;
		for(int d = 0; d < amounts.length; d++) {
			total += amounts[d] * prices[d];
		}
		return total;
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		double fogDiscount = 0;
		double hawkDiscount = 0;
		
		double[] disSpecials = new double[amounts.length];
		for (int c = 0; c < amounts.length; c++) {
			if(c == 0) {
				int fogTemp = (int)(amounts[c]);
				fogDiscount = fogTemp/1;
				double fogTemp2 = amounts[c];
			

				fogDiscount = fogDiscount * 0.5;
				disSpecials[c] = fogDiscount * prices[c];
				fogTemp2 = fogTemp2 - fogDiscount;

			}
			if (c == 1) {
				double hawkTemp = 0;
				double packs = amounts[c]/0.5;
				hawkTemp = (int)(packs/3);
				hawkDiscount = hawkTemp;
				double hawkTemp2 = amounts[c];
				

				hawkDiscount = hawkDiscount * 0.5;

				disSpecials[c] = hawkDiscount * prices[c];
				hawkTemp2 = hawkTemp2 - hawkDiscount;

			}
		}
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		// Fix
		System.out.print("Original Sub Total:                 $");
		System.out.printf("%.2f" ,subTotal);
		System.out.println();
		System.out.println("Specials...");
		
		int check = 0;
		
		if (disSpecials[0] > 0) {
		subTotal -= disSpecials[0];
		System.out.print("Humboldt Fog (Buy 1 Get 1 Free):   -$");
		System.out.printf("%.2f" ,disSpecials[0]);
		System.out.println();
		check++;
		}
		if (disSpecials.length > 1) {
			if(disSpecials[1] > 0) {
				subTotal -= disSpecials[1];
				System.out.print("Red Hawk (Buy 2 Get 1 Free):       -$");
				System.out.printf("%.2f" ,disSpecials[1]);
				System.out.println();
				check++;
			}
		}
		if (check == 0) {
			if (((disSpecials[0] == 0) || (disSpecials[1] == 0))){
				System.out.println("None\t\t\t           -$0.0");
			}
		}
		double newTotal = subTotal;
		
		System.out.print("New Sub Total:                      $");
		System.out.printf("%.2f" ,newTotal);
		System.out.println();
		return newTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
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
		
	}
	
	/*
	 * Program starts here
	 */
	public static void main(String[] args) {
		final int MAXCHEESE;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = scan.nextInt();
		
		
		

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(scan, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = scan.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		scan.close();
	}
}
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
//---------------------NUMBER OF CHEESE TYPES---------------------
		
		System.out.print("Enter the number of Cheeses for shop setup: ");
		final int MAXCHEESE = scan.nextInt();
		System.out.println();
		
		if (MAXCHEESE == 0) {
			System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");
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
		
//---------------------CHEESE LIST CALCULATIONS---------------------
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];
		double[] subcost = new double[MAXCHEESE];
		double[] discounts = new double[2];
		double[] totals = new double[MAXCHEESE];
		// Three Special Cheeses
		if (MAXCHEESE != 0) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			if (MAXCHEESE != 1) {
				names[1] = "Red Hawk";
				prices[1] = 40.50;
				if (MAXCHEESE != 2) {
				names[2] = "Teleme";
				prices[2] = 17.25;
				}
			}
		}
 		System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages)");
 		
 		if (MAXCHEESE != 0) {
		System.out.println(names[0] + ": $" + prices[0] + " per pound");
			if (MAXCHEESE != 1) {
				System.out.println(names[1] + ": $" + prices[1] + " per pound");
				if (MAXCHEESE != 2) {
				System.out.println(names[2] + ": $" + prices[2] + " per pound");
				}
			}
 		}
		
		
 		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(names[i] + ": $" + prices[i] + " per pound");
		}
		System.out.println();
//---------------------AMOUNTS OF CHEESE TYPE IN LB---------------------
		for(int k = 0; k < MAXCHEESE; k++) {
			System.out.print("Enter the amount of " + names[k] + " in lb: ");
			amounts[k] = scan.nextDouble();
			while (((amounts[k] % 0.5) != 0) || (amounts[k] < 0)) {
				if (amounts[k] < 0) {
					System.out.print("Invalid Input. Enter a value >= 0: ");
					amounts[k] = scan.nextDouble();
				}
				else {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
					amounts[k] = scan.nextDouble();
				}
			}
		}
		System.out.println();
//---------------------COST---------------------
		double fogDiscount = 0;
		double hawkDiscount = 0;
		for(int c = 0; c < MAXCHEESE; c++) {
			if(c == 0) {
				int fogTemp = (int)(amounts[c]);
				fogDiscount = fogTemp/1;
				double fogTemp2 = amounts[c];
				
				subcost[c] = amounts[c] * prices[c];
				fogDiscount = fogDiscount * 0.5;
				discounts[c] = fogDiscount * prices[c];
				fogTemp2 = fogTemp2 - fogDiscount;
				totals[c] = fogTemp2 * prices[c];
			}
			if(c == 1) {
				double hawkTemp = 0;
				double packs = amounts[c]/0.5;
				hawkTemp = (int)(packs/3);
				hawkDiscount = hawkTemp;
				double hawkTemp2 = amounts[c];
				
				subcost[c] = amounts[c] * prices[c];
				hawkDiscount = hawkDiscount * 0.5;

				discounts[c] = hawkDiscount * prices[c];
				hawkTemp2 = hawkTemp2 - hawkDiscount;
				totals[c] = hawkTemp2 * prices[c];
			}
			else {
				subcost[c] = amounts[c] * prices[c];
				totals[c] = amounts[c] * prices[c];
				
				
			}
		}
		
//---------------------ITEMIZED LIST---------------------
		System.out.print("Display the itemized list? (1 for yes) ");
		int response = scan.nextInt();
		int zero = 0;
		if(response == 1) {
			for (int v = 0; v < MAXCHEESE; v++) {
				if(amounts[v] == 0) {
					zero++;
				}
			}
			if(zero == MAXCHEESE) {
				System.out.println("No items were purchased.");
			}
			else {
				for (int j = 0; j < MAXCHEESE; j++) {
					if (amounts[j] == 0) {
						
					}
					else {
						System.out.print(amounts[j] + " lb of " + names[j] + " @ " + " $");
						System.out.printf("%.2f" ,prices[j]);
						System.out.print(" = $");
						System.out.printf("%.2f" ,subcost[j]);
						System.out.println("");
					}
				}
			}
		}
		System.out.println();
//---------------------------------------------------------------
		
		if(zero == MAXCHEESE) {
			System.out.println("Original Sub Total:                 $0.00");
			System.out.println("Specials...");
			System.out.println("None\t\t\t           -$0.00");
			System.out.println("New Sub Total:                      $" + "0.00");
			System.out.println("Additional 0% " + " Discount:           -$" + "0.00");
			System.out.println("Final Total:                        $" + "0.00");
			System.exit(0);
		}
		
//---------------------------------------------------------------
		double origSub = 0;
		for (int z = 0; z < MAXCHEESE; z++) {
			origSub = origSub + subcost[z];
		}
		System.out.print("Original Sub Total:                 $");
		System.out.printf("%.2f" ,origSub);
		
		System.out.println();
		
		System.out.println("Specials...");
		int check = 0;
		if ((amounts[0] > 0) && (discounts[0] != 0)) {
			System.out.print("Humboldt Fog (Buy 1 Get 1 Free):   -$");
			System.out.printf("%.2f" ,discounts[0]);
			System.out.println();
			check++;
		}
		if (amounts.length > 1){
			if ((amounts[1] > 0) && (discounts[1] != 0)) {
				System.out.print("Red Hawk (Buy 2 Get 1 Free):       -$");
				System.out.printf("%.2f" ,discounts[1]);
				System.out.println();
				check++;
			}
		}
		if (check == 0) { 
			if (((amounts[0] == 0) && (amounts[1] == 0)) || ((discounts[0] == 0) || (discounts[1] == 0))){
				System.out.println("None\t\t\t         -$0.0");
			}
		}
//---------------------------------------------------------------
		double newSub = 0;
		for(int a = 0; a < MAXCHEESE; a++) {
			double tempDiscount = discounts[0] + discounts[1];
			newSub = origSub - tempDiscount;
		}
		System.out.print("New Sub Total:                      $");
		System.out.printf("%.2f" ,newSub);
		System.out.println();
		
		double percentDis = 0;
		int numDis = 0;
		if (newSub > 150) {
			percentDis = 0.10;
			numDis = 10;
		}
		if (newSub > 250) {
			percentDis = 0.25;
			numDis = 25;
		}
		double subDis = (newSub * percentDis);
		double total = (newSub - subDis);
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

}

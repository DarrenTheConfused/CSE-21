import java.util.Scanner;

public class Shop {
	
	
//---------------------------------------------------------------------------------------------
	public static void intro() {
		System.out.println("This program supports 4 functions:");
		System.out.println("1. Setup Shop");
		System.out.println("2. Buy");
		System.out.println("3. List Items");
		System.out.println("4. Checkout");
	}
	
	
//----------------------------------------------------------------------------------------------
	public static void setupShop(int num, String[] names, double[] prices, double[] discounts, double addis, double rates) {
	
		Scanner scan = new Scanner(System.in);
		
		
		for (int i = 0; i < num; i++) {
			System.out.print("Enter the name of the " + numSuffix(i + 1) + " product: ");
			names[i] = scan.next();
			scan.nextLine();
			
			System.out.print("Enter the per package price of " + names[i] + ": ");
			prices[i] = scan.nextDouble();
			scan.nextLine();
			
			System.out.print("Enter the number of packages ('x') to qualify for Special Discount (buy 'x' get 1 free) for " + names[i] + ", or 0 if no Special Discount offered: ");
			discounts[i] = scan.nextDouble();
			scan.nextLine();
			
			
		}
		System.out.println("");
		System.out.print("Enter the dollar amount to qualify for Additional Discount (or 0 if none offered): ");
		addis = scan.nextDouble();
		scan.nextLine();
		if (addis < 0) {
			while (addis < 0) {
				System.out.print("Invalid input. Enter a value >= 0: ");
				addis = scan.nextDouble();
				scan.nextLine();
			}
		}
		
		if (addis != 0) {
			System.out.print("Enter the Additional Discount rate (e.g., 0.1 for 10%): ");
			rates = scan.nextDouble();
			if ((rates <= 0) || (rates > 0.5)) {
				while ((rates <= 0) || (rates > 0.5)) {
					System.out.print("Invalid input. Enter a value > 0 and <= 0.5: ");
					rates = scan.nextDouble();
				}
			}
		}
		
	
	}
//----------------------------------------------------------------------------------------------
	public static String numSuffix(int i) {
		int rem = i % 10;
		switch (rem) {
			case 0:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				return (i + "th");
			case 1:
				if (i % 100 != 11)
					return (i + "st");
				else
					return (i + "th");
			case 2:
				if (i % 100 != 12)
					return (i + "nd");
				else
					return (i + "th");
			case 3:
				if (i % 100 != 13)
					return (i + "rd");
				else
					return (i + "th");
			default:
				break;
		}
		return "";
	}
	
	
//--------------------------------------------------------------------------------------
	public static void buy(int itemNum, String[] names, double[] packs, double[] prices, double[] costs) {
		
		Scanner scan = new Scanner(System.in);
		
		
		for (int i = 0; i < itemNum; i++) {
			System.out.print("Enter the number of " + names[i] + " packages to buy: ");
			packs[i] = scan.nextDouble();
			while(packs[i] < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				packs[i] = scan.nextDouble();
			}
		}
		for (int i = 0; i < itemNum; i++) {
			costs[i] = packs[i] * prices[i];
		}
		

	}
	
	
//--------------------------------------------------------------------------------------
	public static void listItems(int itemNum, String[] names, double[] packs, double[] prices, double[] costs) {
		int checkZero = 0;
		for (int i = 0; i < itemNum; i++) {
			if (packs[i] != 0) {
				System.out.println(packs[i] + " packages of " + names[i] + " @ $" + prices[i] + " per pkg = $" + costs[i] );
			}
			else {
				checkZero++;
			}
		}
		if(checkZero == itemNum) {
			System.out.println("No items were purchased.");
		}
		System.out.println("");
		
		
	}
	
	
//---------------------------------------------------------------------------------------
	public static void checkout(int itemNum, double rates, double[] packs, double[] prices, double[] costs, double[] discounts, double addis) {
		double origSub = 0;
		double newSub = 0;
		double packDis = 0;
		double temp = 0;
		double percentDis = 0;
		double finalAmount = 0;
		
		//original sub calculation
		for(int i = 0; i < itemNum; i++) {
			origSub = origSub + costs[i];
		}
		//discount calculation
		for(int i = 0; i < itemNum; i++) {
			packDis = 0;
			if (discounts[i] != 0) {
				packDis = (int)(packs[i]/discounts[i]);
				packDis = prices[i] * packDis;
			}
			temp = temp + packDis;
		}
		newSub = origSub - temp;
		percentDis = newSub * addis;
		finalAmount = newSub - percentDis;
		
		System.out.print("Original Sub Total: $");
		System.out.printf("%.2f" ,origSub);
		System.out.println();
		
		System.out.print("Special Discounts: -$");
		System.out.printf("%.2f" ,temp);
		System.out.println();
		
		System.out.print("New Sub Total: $");
		System.out.printf("%.2f" ,newSub);
		System.out.println();
		if (addis > 0) {
			System.out.print("Additional " + (rates * 100) + "% Discount: -");
			System.out.printf("%.2f" ,percentDis);
			System.out.println();
		}
		
		System.out.print("Final Sub Total: $");
		System.out.printf("%.2f" ,finalAmount);
		System.out.println();
		
	}
	
//---------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int itemNum = 0;
		int checkSetup = 0;
		//temporary number for array initialization
		//temp can be set to any integer
		int temp = 0;
		
		String names[] = new String[temp];
		double prices[] = new double[temp];
		double discounts[] = new double[temp];
		double[] packs = new double[temp];
		double[] costs = new double[temp];
		
		int option = 0;
		int done = 1;
		int boughtItems = 0;
		double addis = 0;
		double rates = 0;
		
		
		while ((done != 0) || (checkSetup == 0)){
			
			intro();
			System.out.print("Please choose the function you want: ");
			option = scan.nextInt();
			scan.nextLine();
		
			//shop setup option
			if (option == 1) {
				System.out.print("Please enter the number of items to setup shop: ");
				itemNum = scan.nextInt();
				
				names = new String[itemNum];
				prices = new double[itemNum];
				discounts = new double[itemNum];
				packs = new double[itemNum];
				costs = new double[itemNum];
				
				System.out.println("");
				setupShop(itemNum, names, prices, discounts, addis, rates);
				checkSetup = 1;
				continue;
			}
			
			//buy items option
			if ((option == 2) && (checkSetup == 1)){
				buy(itemNum, names, packs, prices, costs);
				boughtItems++;
				continue;
			}
			else if (checkSetup == 0) {
				System.out.println("");
				System.out.println("Shop is not set up yet!");
				System.out.println("");
				continue;
			}
			
			//list items option
			if ((option == 3) && (checkSetup == 1) && (boughtItems == 1)) {
				listItems(itemNum, names, packs, prices, costs);
				continue;
			}
			else if (checkSetup == 0) {
				System.out.println("");
				System.out.println("Shop is not set up yet!");
				System.out.println("");
				continue;
			}
			else if (boughtItems == 0) {
				System.out.println("");
				System.out.println("You have not bought anything!");
				System.out.println("");
				continue;
			}
			
			//checkout
			if ((option == 4) && (checkSetup == 1)) {
				checkout(itemNum, rates, packs, prices, costs, discounts, addis);
				System.out.println("");
				System.out.println("-------------------------------------------------");
				System.out.print("Would you like to re-run (1 for yes, 0 for no)? ");
				done = scan.nextInt();
				System.out.println("");
				System.out.println("-------------------------------------------------");
			}
			else if (checkSetup == 0) {
				System.out.println("");
				System.out.println("Shop is not set up yet!");
				System.out.println("");
				continue;
			}
			else if (boughtItems == 0) {
				System.out.println("");
				System.out.println("You have not bought anything!");
				System.out.println("");
				continue;
			}
			
		}
		scan.close();
	}

	
	
}

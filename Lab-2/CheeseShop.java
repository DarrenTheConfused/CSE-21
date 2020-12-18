import java.util.Scanner;

public class CheeseShop {

	public static void main(String[] args) {
		
		double fogPounds = 0;
		double hawkPounds = 0;
		double telePounds = 0;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println("Humboldt Fog: $25.0 per pound");
		System.out.println("Red Hawk: $40.5 per pound");
		System.out.println("Teleme: $17.25 per pound");
		
		System.out.println("");
		
		//------------------------------FOG-----------------------------
		System.out.print("Enter the amount of Humboldt Fog in lbs: ");
		fogPounds = scan.nextDouble();
		
		while ((fogPounds < 0) || ((fogPounds % 0.5) != 0)){
			if (fogPounds < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				fogPounds = scan.nextDouble();
			}
			else {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				fogPounds = scan.nextDouble();
			}
			
		}
		
		double fogFinal = fogPounds;
		
		double fogDiscount = 0;
		int fogTemp = (int)fogPounds;
		fogDiscount = fogTemp/1;
		
		double fogSub = fogPounds * 25;
		fogDiscount = fogDiscount * 0.5;
		fogPounds = fogPounds - fogDiscount;
		double fogPrice = fogPounds * 25;
		fogDiscount = fogDiscount * 25;
		
		//------------------------------HAWK------------------------------
		System.out.print("Enter the amount of Red Hawk in lbs: ");
		hawkPounds = scan.nextDouble();
		
		while ((hawkPounds < 0) || ((hawkPounds % 0.5) != 0)){
			if (hawkPounds < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				hawkPounds = scan.nextDouble();
			}
			else {
				System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
				hawkPounds = scan.nextDouble();
			}
			
		}
		
		double hawkFinal = hawkPounds;
		
		double hawkDiscount = 0;
		int hawkTemp = (int)hawkPounds;
		hawkDiscount = hawkTemp/2;
		
		double hawkSub = hawkPounds * 40.5;
		hawkDiscount = hawkDiscount * 0.5;
		hawkPounds = hawkPounds - hawkDiscount;
		double hawkPrice = hawkPounds * 40.5;
		hawkDiscount = hawkDiscount * 40.5;
		
		
		//------------------------------TELE------------------------------
		System.out.print("Enter the amount of Teleme in lbs: ");
		telePounds = scan.nextDouble();
		
		if(telePounds < 0) {
			while(telePounds < 0) {
				System.out.print("Invalid Input. Enter a value >= 0: ");
				telePounds = scan.nextDouble();
			}
		}
		double teleFinal = telePounds;
		double telePrice = telePounds * 17.25;
		System.out.println();
		//------------------------------ITEMIZED LIST------------------------------
		System.out.print("Display the itemized list? (1 for yes) ");
		int response = scan.nextInt();
		if(response == 1) {
			if ((fogPounds == 0) && (hawkPounds == 0) && (telePounds == 0)) {
				System.out.println("No items were purchased.");
			}
			else {
				if (fogSub != 0) {
					System.out.println(fogPounds + " lb of Humboldt Fog @ $25.0 = $" + fogSub);
				}
				if (hawkSub != 0) {
					System.out.println(hawkPounds + " lb of Red Hawk @ $40.5 = $" + hawkSub);
				}
				if (telePrice != 0) {
					System.out.println(telePounds + " lb of Teleme @ $17.25 = $" + telePrice);
				}
			}
		}
		//------------------------------RESULTS------------------------------
		double subtotal = fogSub + hawkSub + telePrice;
		double total = telePrice + hawkPrice + fogPrice;
		int check = 0;
		System.out.println();
		
		System.out.println("Sub Total:\t\t\t  $" + subtotal);
		System.out.println("Discounts...");
		if ((fogFinal > 0) && (fogDiscount != 0)) {
			System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + fogDiscount);
			check++;
		}
		if ((hawkFinal > 0) && (hawkDiscount != 0)) {
			System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$" + hawkDiscount);
			check++;
		}
		if (check == 0) { 
			if (((fogFinal == 0) && (hawkFinal == 0)) || ((fogDiscount == 0) || (hawkDiscount == 0))){
				System.out.println("None\t\t\t         -$0.0");
			}
		}
		System.out.println("Final Total:\t\t\t  $" + total);
		
		
		scan.close();
	}

}

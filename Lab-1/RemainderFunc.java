import java.util.Scanner;

public class RemainderFunc {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//max
		System.out.print("Please enter the max number: ");
		int max = scan.nextInt();
		
		if (max < 0) {
			while (max < 0) {
				System.out.print("Invalid input. Please enter a valid max number (>= 0): ");
				max = scan.nextInt();				
			}
		}
		
		//divisor
		System.out.print("Please enter the divisor: ");
		int div = scan.nextInt();
		
		if (div <= 0) {
			while (div <= 0) {
				System.out.print("Invalid input. Please enter a valid divisor (> 0): ");
				div = scan.nextInt();				
			}
		}	
		
		//multiples
		System.out.println("Multiples of " + div + " between 1 and " + max + " (inclusive) are:");
		int i = 1;
		while ( i <= max) {
			if ((i % div) == 0) {
				System.out.println(i);
			}
			i++;
		}
		
		if (div > max) {
			System.out.println("None were found.");
		}
		scan.close();

	}

}

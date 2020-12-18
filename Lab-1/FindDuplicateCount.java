


public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		
		int max = Integer.MIN_VALUE;
		

		int index = 0;
		for (int a = 0; a < arr.length ; a++) {
			
			int occur = 0;
			int num = arr[a];
			
			
			int b = a;
			while (b < arr.length) {
				if (arr[b] == num) {
					occur++;
					if (occur == 1) {
						index = b;
					}
				}
				b++;
			}
			
			
			
			
			
			/*
			for (int b = a; b < arr.length; b++) {
				
				if (arr[b] == num) {
					occur++;
					if ((occur < 2) || (occur == 2)) {
					
						index = b;
					}

				}
				
			}
			*/
			if((occur - 1) == 1) {
				System.out.println("There is only " + (occur - 1) + " more occurrence of value " + arr[a] + " starting at index " + (index));
			}
			else if (occur > 1) {
				System.out.println("There are " + (occur - 1) + " more occurrences of value " + arr[a] + " starting at index " + (index));
			}
			else{
				System.out.println("There are no duplicates with value " + arr[a] + " beyond index " + index);
			}
			
			
		}
		
		
		
		
		
	}

}

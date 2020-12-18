package oop;

public class SeasonCounter extends ModNCounter {

	
	private static String[] names =  {"spring", "summer", "fall", "winter"};
	
	
	public SeasonCounter() {
        // fill-in by creating an object with 4 as the modulus
		super(4);
    }
	

	@Override
	public String toString() {
        if (value() == 0) {
        	return names[0];
        }
        if (value() == 1) {
        	return names[1];
        }
        if (value() == 2) {
        	return names[2];
        }
        if (value() == 3) {
        	return names[3];
        }
        return names[0];
	}
	
  	
}

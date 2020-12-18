package oop;


/**
 * A counter class that cycles its internal value back to 0 when it
 * reaches a maximum value. 
 * 
 * e.g., A (new) ModNCounter with a cycleLength (maximum) of 5 will
 * have an internal value of 2 after increment() is called 7 times
 */
public class ModNCounter extends Counter { 


    private int cycleLength; 

    public ModNCounter (int n) { 
    	cycleLength = n;
    	/*
    	for(int i = 0; i <= cycleLength; i++) {
    		increment();
    		System.out.print(super.value() + " ");
    		
    	}
    	 */
    }

    
    public void increment() { 
    	if (super.value() < cycleLength) {
    		super.increment();
    	}
    	if (super.value() >= cycleLength) {
    		reset();
    	}
    	
    	/*int mod = (arrNum % cycleLength);
    	reset();
    	for(int i = 1; i <= mod; i++) {
    		super.increment();
    	}
    	*/
    	
    }
} 
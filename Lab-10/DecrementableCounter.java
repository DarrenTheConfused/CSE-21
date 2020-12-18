package oop;

public class DecrementableCounter extends Counter {
	
	public void decrement() {
		if(value() == 0) {
			//do nothing
		}
		else {
			int newValue = value() - 1;
			if(newValue == 0) {
				super.reset();
			}
			else {
				super.reset();
				for(int i = 1; i <= newValue; i++) {
					super.increment();
				}
			}
		}
	}
	
	
}

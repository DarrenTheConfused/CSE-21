package oop;

public class Runner {

	public static void main(String[] args) {
		testCounter();

		testCounter7Statements();

		testModNCounter2();

		testDecrementableCounter();

		testSeasonCounter();
	}

	
	public static void testCounter() {
		System.out.println("-- Testing Counter");

		Counter c = new Counter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());

	}

	
	public static void testCounter7Statements() {
		Counter c = new Counter();
		System.out.println("-- Testing 7 statements");
		// include exactly 7 increment() and reset() statements below
		c.reset();
		c.increment();
		c.reset();
		c.increment();
		c.reset();
		c.increment();
		c.reset();
		c.reset();
		c.increment();
		c.reset();
		c.reset();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current value: " + c.value());
	}
	
	public static void testModNCounter2() {
		System.out.println("-- Testing ModNCounter2");

		ModNCounter2 c = new ModNCounter2(3);
		c.increment();
		c.increment();
		c.increment();
		c.value();
		System.out.println("Current value: " + c.value());

	}
	
	public static void testDecrementableCounter() {
		System.out.println("-- Testing Decrementable Counter");

		DecrementableCounter c = new DecrementableCounter();
		c.increment();
		c.increment();
		c.increment();
		c.decrement();
		System.out.println("Current decreased value: " + c.value());

	}
	
	public static void testSeasonCounter() {
		System.out.println("-- Testing SeasonCounter");

		SeasonCounter c = new SeasonCounter();
		c.increment();
		c.increment();
		c.increment();
		System.out.println("Current season: " + c.toString());

	}

}

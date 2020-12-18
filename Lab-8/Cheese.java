import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		this.name = name;
		this.price = price;
		numCheese++;
	}

	public String getName() { // Accessor
		return this.name;
	}

	public void setName(String newName) { // Mutator 
		this.name = newName;
	}

	public double getPrice() {
		double price = this.price;
		return price;
	}

	public void setPrice(double newPrice) {
		this.price = newPrice;
	}

	public double getAmount() {
		double amount = this.amount;
		return amount;
	}

	public void setAmount(Scanner input) {
		this.amount = input.nextDouble();
	}
	
}

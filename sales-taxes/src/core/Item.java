package core;

public class Item {

	private int quantity;
	private String product;
	private double price;

	public Item(int quantity, String product, double price) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
	}

	public int quantity() {
		return this.quantity;
	}

	public String product() {
		return this.product;
	}

	public double price() {
		return this.price;
	}

}

package core;

public class Item {

	private int quantity;
	private String product;
	private double price;
	private String category;

	public Item(int quantity, String product, String category, double price) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
		this.category = category;
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

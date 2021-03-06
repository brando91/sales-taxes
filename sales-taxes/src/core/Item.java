package core;

public class Item {

	private int quantity;
	private String product;
	private double price;
	private String category;
	private boolean imported;

	public Item(int quantity, String product, String category, double price, boolean imported) {
		this.quantity = quantity;
		this.product = product;
		this.price = price;
		this.category = category;
		this.imported = imported;
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

	public String category() {
		return this.category;
	}
	
	public boolean isImported(){
		return this.imported;
	}
}

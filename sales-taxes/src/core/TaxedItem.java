package core;

public class TaxedItem {

	private Tax tax;
	private Item item;

	public TaxedItem(Item item, Tax tax) {
		this.item = item;
		this.tax = tax;
	}

	public double price() {
		return round(item.price() + tax());
	}
	
	public double tax() {
		return round(tax.on(item));
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}
}

package core;

public class TaxedItem {

	private Tax[] taxes;
	private Item item;

	public TaxedItem(Item item, Tax... taxes) {
		this.item = item;
		this.taxes = taxes;
	}

	public double price() {
		return round(item.price() + tax());
	}
	
	public double tax() {
		double total = 0;
		for(Tax tax : this.taxes){
			total += tax.on(this.item);
		}
		return round(total);
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}
}

package core;

import java.text.DecimalFormat;

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
		return roundUpToClosestFive(total);
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}

	private double roundUpToClosestFive(double original) {
		original = round(original);
		double lastDecimal = lastDecimal(original);
		if(lastDecimal == 0){
			return original;
		}
		else if(lastDecimal <= 5){
			return sumUpTo(0.05, original);
		}
		else{
			return sumUpTo(0.1, original);
		}
	}

	private double sumUpTo(double bound, double original) {
		return round(original + (bound - lastDecimal(original)/100.0));
	}

	private double lastDecimal(double number) {
		String formatted = new DecimalFormat("0.00").format(number);
		return Double.parseDouble(formatted.charAt(formatted.length()-1) + "");
	}
}

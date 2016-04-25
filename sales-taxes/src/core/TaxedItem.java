package core;

import java.text.DecimalFormat;

public class TaxedItem {

	private Tax[] taxes;
	private Item item;

	public TaxedItem(Item item, Tax... taxes) {
		this.item = item;
		this.taxes = taxes;
	}

	public Price price() {
		return new Price(item.price() + tax().rounded());
	}
	
	public Price tax() {
		double total = 0;
		for(Tax tax : this.taxes){
			total += tax.on(this.item);
		}
		return roundUpToClosestFive(total);
	}

	private Price roundUpToClosestFive(double original) {
		Price price = new Price(original);
		double lastDecimal = lastDecimal(price);
		if(lastDecimal == 0){
			return price;
		}
		else if(lastDecimal <= 5){
			return sumUpTo(0.05, price);
		}
		else{
			return sumUpTo(0.1, price);
		}
	}

	private Price sumUpTo(double bound, Price original) {
		return new Price(original.rounded() + (bound - lastDecimal(original)/100.0));
	}

	private double lastDecimal(Price number) {
		String formatted = new DecimalFormat("0.00").format(number.rounded());
		return Double.parseDouble(formatted.charAt(formatted.length()-1) + "");
	}
}

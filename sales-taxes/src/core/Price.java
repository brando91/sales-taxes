package core;

import java.text.DecimalFormat;

public class Price {

	private double price;

	public Price(double price) {
		this.price = price;
	}

	public double rounded() {
		return round(this.price);
	}

	public String formatted() {
		return new DecimalFormat("0.00").format(rounded());
	}
	
	private double round(double value) {
		return Math.round(value*100)/100.0;
	}
}

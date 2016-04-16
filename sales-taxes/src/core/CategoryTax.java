package core;

public class CategoryTax {

	private double tax;

	public CategoryTax(double tax) {
		this.tax = tax;
	}

	public double on(double originalPrice) {
		return round(originalPrice*this.tax);
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}

}

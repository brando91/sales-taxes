package core;

public class CategoryTax {

	private double tax;

	public CategoryTax(double tax) {
		this.tax = tax;
	}

	public double on(double originalPrice) {
		return originalPrice*this.tax;
	}

}

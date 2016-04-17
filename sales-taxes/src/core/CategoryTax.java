package core;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryTax {

	private double tax;
	private ArrayList<String> taxedCategories;

	public CategoryTax(double tax) {
		this.tax = tax;
		this.taxedCategories = new ArrayList<String>();
	}

	public double on(Item item) {
		if(this.taxedCategories.contains(item.category())){
			return round(item.price()*this.tax);
		}
		return 0;
	}

	public CategoryTax forCategories(String... category) {
		this.taxedCategories = new ArrayList<String>(Arrays.asList(category));
		return this;
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}
}

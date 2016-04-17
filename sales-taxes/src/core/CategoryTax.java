package core;

import java.util.ArrayList;
import java.util.Arrays;

public class CategoryTax implements Tax{

	private double tax;
	private ArrayList<String> untaxedCategories;

	public CategoryTax(double tax) {
		this.tax = tax;
		this.untaxedCategories = new ArrayList<String>();
	}

	@Override
	public double on(Item item) {
		if(this.untaxedCategories.contains(item.category())){
			return 0;
		}
		return round(item.price()*this.tax);
	}

	public CategoryTax exceptCategories(String... category) {
		this.untaxedCategories = new ArrayList<String>(Arrays.asList(category));
		return this;
	}

	private double round(double value) {
		return Math.round(value*100)/100.0;
	}
}

package core;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class Receipt {

	private Cart cart;
	private Tax tax;

	public Receipt(Cart cart) {
		this.cart = cart;
	}

	public String print() {
		ArrayList<String> entries = new ArrayList<String>();
		double total = 0;
		double taxes = 0;
		
		for(Item item : cart.items()){
			double appliedTax = this.tax.on(item);
			double taxedPrice = item.price() + appliedTax;
			entries.add(asEntry(item.quantity() + " " + item.product(), taxedPrice));
			total += taxedPrice;
			taxes += appliedTax;
		}
		entries.add(asEntry("Sales Taxes", taxes));
		entries.add(asEntry("Total", total));
		
		return StringUtils.join(entries, newLine());
	}

	public Receipt applyingTax(Tax tax) {
		this.tax = tax;
		return this;
	}
	
	private String asEntry(String label, double value) {
		return label + ": " + value;
	}

	private String newLine() {
		return System.getProperty("line.separator");
	}
}

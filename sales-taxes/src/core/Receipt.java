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
		
		for(Item item : cart.items()){
			double taxedPrice = item.price() + this.tax.on(item);
			entries.add(asEntry(item.quantity() + " " + item.product(), taxedPrice));
			total += taxedPrice;
		}
		entries.add(asEntry("Sales Taxes", 0));
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

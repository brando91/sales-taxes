package core;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class Receipt {

	private Cart cart;

	public Receipt(Cart cart) {
		this.cart = cart;
	}

	public String print() {
		ArrayList<String> entries = new ArrayList<String>();
		double total = 0;
		
		for(Item item : cart.items()){
			entries.add(asEntry(item.quantity() + " " + item.product(), item.price()));
			total += item.price();
		}
		entries.add(asEntry("Sales Taxes", 0));
		entries.add(asEntry("Total", total));
		
		return StringUtils.join(entries, newLine());
	}

	private String asEntry(String label, double value) {
		return label + ": " + value;
	}

	private String newLine() {
		return System.getProperty("line.separator");
	}

}

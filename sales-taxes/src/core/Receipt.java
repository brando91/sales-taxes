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
		ArrayList<Item> items = cart.items();
		for(Item item : items){
			entries.add(item.quantity() + " " + item.product() + ": " + item.price());
		}
		entries.add("Sales Taxes: 0");
		entries.add("Total: 0");
		
		return StringUtils.join(entries, newLine());
	}

	private String newLine() {
		return System.getProperty("line.separator");
	}

}

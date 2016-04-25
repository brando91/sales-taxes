package core;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;


public class Receipt {

	private Cart cart;
	private Tax[] taxes;

	public Receipt(Cart cart) {
		this.cart = cart;
		this.taxes = new Tax[0];
	}

	public String print() {
		ArrayList<String> entries = new ArrayList<String>();
		double total = 0;
		double taxes = 0;
		
		for(Item item : cart.items()){
			TaxedItem taxedItem = new TaxedItem(item, this.taxes);
			entries.add(asEntry(item.quantity() + " " + item.product(), taxedItem.price().rounded()));
			total += taxedItem.price().rounded();
			taxes += taxedItem.tax().rounded();
		}
		entries.add(asEntry("Sales Taxes", taxes));
		entries.add(asEntry("Total", total));
		
		return StringUtils.join(entries, newLine());
	}

	public Receipt applyingTax(Tax... tax) {
		this.taxes = tax;
		return this;
	}
	
	private String asEntry(String label, double value) {
		return label + ": " + new Price(value).formatted();
	}

	private String newLine() {
		return System.getProperty("line.separator");
	}
}

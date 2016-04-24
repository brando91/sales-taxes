package acceptance;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;
import org.junit.Test;

import core.Cart;
import core.Item;
import core.Transaction;

public class AcceptanceTest {

	@Test
	public void ReceiptWithNoImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "book", "books", 12.49, false))
			.add(new Item(1, "music CD", "music", 14.99, false))
			.add(new Item(1, "chocolate bar", "food", 0.85, false));
		
		String receipt = new Transaction(cart).printReceipt();

		assertThat(receipt, equalTo(asLines("1 book: 12.49", 
										    "1 music CD: 16.49", 
										    "1 chocolate bar: 0.85",
										    "Sales Taxes: 1.5",
											"Total: 29.83")));
	}

	@Test
	public void ReceiptWithImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "imported box of chocolates", "food", 10.00, true))
			.add(new Item(1, "imported bottle of perfume", "perfumes", 47.50, true));
		
		String receipt = new Transaction(cart).printReceipt();
		
		assertThat(receipt, equalTo(asLines("1 imported box of chocolates: 10.5",
											"1 imported bottle of perfume: 54.65", 
											"Sales Taxes: 7.65",
											"Total: 65.15")));
	}
	
	@Ignore
	public void ReceiptWithBothImportedAndNotImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "imported bottle of perfume", "perfumes", 27.99, true))
			.add(new Item(1, "bottle of perfume", "perfumes", 18.99, false))
			.add(new Item(1, "packet of headache pills", "medical products", 9.75, false))
			.add(new Item(1, "imported box of chocolates", "food", 11.25, true));
		
		String receipt = new Transaction(cart).printReceipt();
		
		assertThat(receipt, equalTo(asLines("1 imported bottle of perfume: 32.19",
											"1 bottle of perfume: 20.89",
											"1 packet of headache pills: 9.75",
											"1 imported box of chocolates: 11.85",
											"Sales Taxes: 6.70",
											"Total: 74.68")));
	}
	
	private String asLines(String... lines) {
		String newLine = System.getProperty("line.separator");
		return StringUtils.join(lines, newLine);
	}
}

package acceptance;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.StringUtils;
import org.junit.Ignore;

import core.Cart;
import core.Item;
import core.Receipt;

public class AcceptanceTest {

	@Ignore
	public void ReceiptWithNoImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "book", 12.49))
			.add(new Item(1, "music CD", 14.99))
			.add(new Item(1, "chocolate bar", 0.85));
		
		String receipt = new Receipt(cart).print();

		assertThat(receipt, equalTo(asLines("1 book: 12.49 ", 
										    "1 music CD: 16.49", 
										    "1 chocolate bar: 0.85",
										    "Sales Taxes: 1.50",
											"Total: 29.83")));
	}

	@Ignore
	public void ReceiptWithImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "imported box of chocolates", 10.00))
			.add(new Item(1, "imported bottle of perfume", 47.50));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, equalTo(asLines("1 imported box of chocolates: 10.50" + 
											"1 imported bottle of perfume: 54.65" + 
											"Sales Taxes: 7.65" +
											"Total: 65.15")));
	}
	
	@Ignore
	public void ReceiptWithBothImportedAndNotImportedItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "imported bottle of perfume", 27.99))
			.add(new Item(1, "bottle of perfume", 18.99))
			.add(new Item(1, "packet of headache pills", 9.75))
			.add(new Item(1, "imported box of chocolates", 11.25));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, equalTo(asLines("1 imported bottle of perfume: 32.19" +
											"1 bottle of perfume: 20.89" +
											"1 packet of headache pills: 9.75" +
											"1 imported box of chocolates: 11.85" +
											"Sales Taxes: 6.70" +
											"Total: 74.68")));
	}
	
	private String asLines(String... lines) {
		String newLine = System.getProperty("line.separator");
		return StringUtils.join(lines, newLine);
	}
}

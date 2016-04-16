package unit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import core.Cart;
import core.Item;
import core.Receipt;

public class ReceiptTest {

	String newLine = System.getProperty("line.separator");
	
	@Test
	public void ShouldPrintAnItemWithNoTaxes() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", 3.87));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, containsString("1 banana: 3.87"));
	}
	
	@Test
	public void ShouldPrintAnEmptyCart() throws Exception {
		String receipt = new Receipt(new Cart()).print();
		
		assertThat(receipt, equalTo("Sales Taxes: 0" + newLine +
									"Total: 0"));
	}
	
	@Test
	public void ShouldPrintAllTheItemsInTheCart() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", 3.87));
		cart.add(new Item(1, "apple", 1.05));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, containsString("1 banana: 3.87"));
		assertThat(receipt, containsString("1 apple: 1.05"));
	}
	
	@Ignore
	public void ShouldCountTheTotalAmount() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", 2.0));
		cart.add(new Item(1, "apple", 1.55));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, containsString("Total: 3.55"));
	}
}

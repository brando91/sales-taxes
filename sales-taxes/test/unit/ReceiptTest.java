package unit;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

import org.junit.Test;

import core.Cart;
import core.Item;
import core.Receipt;

public class ReceiptTest {

	@Test
	public void ShouldPrintAnItemWithNoTaxes() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", 3.87));
		
		String receipt = new Receipt(cart).print();
		
		assertThat(receipt, containsString("1 banana at 3.87"));
	}
}

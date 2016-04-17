package unit;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.Cart;
import core.Item;
import core.Transaction;

public class TransactionTest {

	@Test
	public void ShouldNotApplyTaxesToBooksFoodsAndMedicals() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "book", "books", 12.49))
			.add(new Item(1, "aspirine", "medical products", 13.55))
			.add(new Item(1, "music CD", "music", 14.99))
			.add(new Item(1, "chocolate bar", "food", 0.85));
		
		String receipt = new Transaction(cart).printReceipt();
		
		assertThat(receipt, containsString("1 book: 12.49"));
		assertThat(receipt, containsString("1 aspirine: 13.55"));
		assertThat(receipt, containsString("1 music CD: 16.49"));
		assertThat(receipt, containsString("1 chocolate bar: 0.85"));
	}
}

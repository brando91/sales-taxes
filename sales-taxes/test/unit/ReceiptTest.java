package unit;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.Cart;
import core.CategoryTax;
import core.Item;
import core.NoTaxes;
import core.Receipt;

public class ReceiptTest {

	String newLine = System.getProperty("line.separator");
	
	@Test
	public void ShouldPrintAnItemWithNoTaxes() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", "any category", 3.87));
		
		String receipt = new Receipt(cart)
								.applyingTax(new NoTaxes())
								.print();
		
		assertThat(receipt, containsString("1 banana: 3.87"));
	}
	
	@Test
	public void ShouldPrintAnEmptyCart() throws Exception {
		String receipt = new Receipt(new Cart())
								.applyingTax(new NoTaxes())
								.print();
		
		assertThat(receipt, equalTo("Sales Taxes: 0.0" + newLine +
									"Total: 0.0"));
	}
	
	@Test
	public void ShouldPrintAllTheItemsInTheCart() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", "any category", 3.87));
		cart.add(new Item(1, "apple", "any category", 1.05));
		
		String receipt = new Receipt(cart)
								.applyingTax(new NoTaxes())
								.print();
		
		assertThat(receipt, containsString("1 banana: 3.87"));
		assertThat(receipt, containsString("1 apple: 1.05"));
	}
	
	@Test
	public void ShouldCountTheTotalAmount() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", "any category", 2.0));
		cart.add(new Item(1, "apple", "any category", 1.55));
		
		String receipt = new Receipt(cart)
									.applyingTax(new NoTaxes())
									.print();
		
		assertThat(receipt, containsString("Total: 3.55"));
	}
	
	@Test
	public void ShouldApplyTaxesToItems() throws Exception {
		Cart cart = new Cart();
		cart.add(new Item(1, "banana", "fruits", 2.0));
		
		CategoryTax categoryTax = new CategoryTax(0.10).forCategories("fruits");
		String receipt = new Receipt(cart)
								.applyingTax(categoryTax)
								.print();
		
		assertThat(receipt, containsString("1 banana: 2.2"));
	}
}

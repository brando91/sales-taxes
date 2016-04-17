package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.CategoryTax;
import core.Item;

public class CategoryTaxTest {

	@Test
	public void ShouldReturnApplyedTax() throws Exception {
		Item item = new Item(1, "taxed book", "any", 10);
		double taxedPrice = new CategoryTax(0.10).on(item);
		
		assertThat(taxedPrice, equalTo(1.0));
	}
	
	@Test
	public void ShouldReturnRoundedApplyedTax() throws Exception {
		Item item = new Item(1, "taxed book", "any", 14.99);
		double taxedPrice = new CategoryTax(0.10).on(item);
		
		assertThat(taxedPrice, equalTo(1.5));
	}
	
	@Test
	public void ShouldTaxOnlySpecificCategoryItems() throws Exception {
		Item taxableItem = new Item(1, "banana", "fruits", 3.5);
		Item notTaxableItem = new Item(1, "tomato", "vegetables", 3.5);
		CategoryTax tax = new CategoryTax(0.10).exceptCategories("vegetables");
		
		assertThat(tax.on(taxableItem), equalTo(0.35));
		assertThat(tax.on(notTaxableItem), equalTo(0.0));
	}
	
	@Test
	public void ShouldNotTaxMoreCategories() throws Exception {
		Item banana = new Item(1, "banana", "fruits", 3.5);
		Item tomato = new Item(1, "tomato", "vegetables", 3.5);
		CategoryTax tax = new CategoryTax(0.10).exceptCategories("fruits", "vegetables");
		
		assertThat(tax.on(banana), equalTo(0.0));
		assertThat(tax.on(tomato), equalTo(0.0));
	}
}

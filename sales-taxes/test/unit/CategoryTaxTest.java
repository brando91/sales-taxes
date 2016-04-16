package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import core.CategoryTax;
import core.Item;

public class CategoryTaxTest {

	@Test
	public void ShouldReturnApplyedTax() throws Exception {
		Item item = new Item(1, "taxed item", "any category", 10);
		double taxedPrice = new CategoryTax(0.10).on(item);
		
		assertThat(taxedPrice, equalTo(1.0));
	}
	
	@Test
	public void ShouldReturnRoundedApplyedTax() throws Exception {
		Item item = new Item(1, "taxed item", "any category", 14.99);
		double taxedPrice = new CategoryTax(0.10).on(item);
		
		assertThat(taxedPrice, equalTo(1.5));
	}
	
	@Ignore
	public void ShouldTaxOnlySpecificCategoryItems() throws Exception {
		Item taxableItem = new Item(1, "banana", "fruits", 3.5);
		Item notTaxableItem = new Item(1, "tomato", "vegetables", 3.5);
		CategoryTax tax = new CategoryTax(0.10).forCategory("fruits");
		
		assertThat(tax.on(taxableItem), equalTo(0.35));
		assertThat(tax.on(notTaxableItem), equalTo(0.0));
	}
}

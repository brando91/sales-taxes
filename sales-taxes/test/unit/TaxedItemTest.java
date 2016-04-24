package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.CategoryTax;
import core.ImportTax;
import core.Item;
import core.TaxedItem;

public class TaxedItemTest {

	@Test
	public void ShouldReturnRoundedTaxedPrice() throws Exception {
		TaxedItem taxedItem = new TaxedItem(new Item(1, "apple", "any", 14.99, false), 
											new CategoryTax(0.10));
		
		assertThat(taxedItem.price(), equalTo(16.49));
	}
	
	@Test
	public void ShouldReturnRoundedAppliedTax() throws Exception {
		TaxedItem taxedItem = new TaxedItem(new Item(1, "apple", "any", 14.99, false), 
											new CategoryTax(0.10));
		
		assertThat(taxedItem.tax(), equalTo(1.5));
	}
	
	@Test
	public void ShouldRoundCorrectly() throws Exception {
		TaxedItem item = new TaxedItem(new Item(1, "apple", "any", 12.2, false), new CategoryTax(0.10));
		TaxedItem item2 = new TaxedItem(new Item(1, "apple", "any", 12.5, false), new CategoryTax(0.10));
		TaxedItem item3 = new TaxedItem(new Item(1, "apple", "any", 12.7, false), new CategoryTax(0.10));
		
		assertThat(item.tax(), equalTo(1.25));
		assertThat(item2.tax(), equalTo(1.25));
		assertThat(item3.tax(), equalTo(1.3));
	}
	
	@Test
	public void ShouldApplyMultipleTaxes() throws Exception {
		TaxedItem taxedItem = new TaxedItem(new Item(1, "imported apple", "any", 15.0, true), 
											new CategoryTax(0.10),
											new ImportTax(0.05));
		
		assertThat(taxedItem.tax(), equalTo(2.25));
	}
	
	@Test
	public void ShouldRoundMultipleAppliedTaxes() throws Exception {
		TaxedItem taxedItem = new TaxedItem(new Item(1, "imported apple", "any", 47.5, true), 
											new CategoryTax(0.10),
											new ImportTax(0.05));
		
		assertThat(taxedItem.tax(), equalTo(7.15));
	}
}

package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import core.CategoryTax;
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
}

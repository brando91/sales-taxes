package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import core.ImportTax;
import core.Item;

public class ImportTaxTest {

	@Test
	public void ShouldCalculateTaxOnImportedProduct() throws Exception {
		Item item = new Item(1, "imported banana", "any", 10, true);
		double tax = new ImportTax(0.05).on(item);
		
		assertThat(tax, equalTo(0.5));
	}
	
	@Test
	public void ShouldApplyTaxOnlyToImportedProduct() throws Exception {
		Item notImportedItem = new Item(1, "banana", "any", 10, false);
		double tax = new ImportTax(0.05).on(notImportedItem);
		
		assertThat(tax, equalTo(0.0));
	}
}

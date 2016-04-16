package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import core.CategoryTax;

public class CategoryTaxTest {

	@Test
	public void ShouldReturnApplyedTax() throws Exception {
		double originalPrice = 10;
		double taxedPrice = new CategoryTax(0.10).on(originalPrice);
		
		assertThat(taxedPrice, equalTo(1.0));
	}
	
	@Test
	public void ShouldReturnRoundedApplyedTax() throws Exception {
		double originalPrice = 14.99;
		double taxedPrice = new CategoryTax(0.10).on(originalPrice);
		
		assertThat(taxedPrice, equalTo(1.5));
	}
}

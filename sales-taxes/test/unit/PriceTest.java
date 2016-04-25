package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import core.Price;

public class PriceTest {

	@Test
	public void ShouldRoundPrices() throws Exception {
		Price price = new Price(1.4999);
		assertThat(price.rounded(), equalTo(1.5));
	}
	
	@Test
	public void ShouldFormatPrices() throws Exception {
		Price price = new Price(1.5);
		assertThat(price.formatted(), equalTo("1.50"));
	}
}

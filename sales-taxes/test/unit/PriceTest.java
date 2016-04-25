package unit;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import core.Price;

public class PriceTest {

	@Test
	public void ShouldRoundPrices() throws Exception {
		assertThat(new Price(1.4999).rounded(), equalTo(1.5));
	}
	
	@Test
	public void ShouldFormatPrices() throws Exception {
		assertThat(new Price(1.5).formatted(), equalTo("1.50"));
	}
}

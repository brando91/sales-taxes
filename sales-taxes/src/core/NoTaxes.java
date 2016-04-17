package core;

public class NoTaxes implements Tax {

	@Override
	public double on(Item item) {
		return 0;
	}

}

package core;

public class ImportTax implements Tax{

	private double tax;

	public ImportTax(double tax) {
		this.tax = tax;
	}

	@Override
	public double on(Item item) {
		if(item.isImported()){
			return item.price()*this.tax;
		}
		return 0;
	}
}

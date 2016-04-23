package core;

public class ImportTax {

	private double tax;

	public ImportTax(double tax) {
		this.tax = tax;
	}

	public double on(Item item) {
		if(item.isImported()){
			return item.price()*this.tax;
		}
		return 0;
	}

}

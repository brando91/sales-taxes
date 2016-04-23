package core;

public class Transaction {

	private Receipt receipt;

	public Transaction(Cart cart) {
		this.receipt = new Receipt(cart).applyingTax(categoryTax(), importTax());
	}

	public String printReceipt() {
		return this.receipt.print();
	}
	
	private ImportTax importTax() {
		return new ImportTax(0.05);
	}

	private Tax categoryTax() {
		return new CategoryTax(0.10).exceptCategories("books", "food", "medical products");
	}
}

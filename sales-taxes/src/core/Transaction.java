package core;

public class Transaction {

	private Receipt receipt;

	public Transaction(Cart cart) {
		this.receipt = new Receipt(cart).applyingTax(tax());
	}

	private Tax tax() {
		return new CategoryTax(0.10).exceptCategories("books", "food", "medical products");
	}

	public String printReceipt() {
		return this.receipt.print();
	}

}

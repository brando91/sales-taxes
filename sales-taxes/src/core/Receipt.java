package core;


public class Receipt {

	private Cart cart;

	public Receipt(Cart cart) {
		this.cart = cart;
	}

	public String print() {
		Item item = cart.items().get(0);
		return item.quantity() + " " + item.product() + " at " + item.price();
	}

}

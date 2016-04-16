package core;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Item> items;

	public Cart(){
		this.items = new ArrayList<Item>();
	}

	public Cart add(Item item) {
		items.add(item);
		return this;
	}

	public ArrayList<Item> items() {
		return this.items;
	}

}

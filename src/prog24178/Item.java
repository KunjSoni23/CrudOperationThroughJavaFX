/*
 * Name : Soni Kunj Mayurkumar
 * Id : 991591881
 * Project : Assignment6
 * Performed Date : 6th August 2020
 */

//Item class to define id, item name , numbers of quantity & price 

package prog24178;

import java.util.ArrayList;

public class Item {
	
		//private variables named id, item, quantity & price
		private int id;
		private String item;
		private int quantity;
		private double price;

		//Arraylist to store the  number of data for items
		private ArrayList<Item> items = new ArrayList<Item>();

		//default no argument constructor
		public Item() {
			super();
		}
	
		//four arguments constructor
		public Item(int id, String item, int quantity, double price) {
			super();
			this.id = id;
			this.item = item;
			this.quantity = quantity;
			this.price = price;
		}

		//public getters and setters for item class
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		//toString method to return item description
		@Override
		public String toString() {
			return "Item [id=" + id + ", item=" + item + ", quantity=" + quantity + ", price=" + price + "]";
		}
		
}//end of item.java

package restaurant;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
	//menu class is created to keep track of every menuitem and to add them on menu object
	// a menu object has an hashmap having the name of menuitem as key and menuitem itself as value
	
	//creating fields
	private HashMap<String, MenuItem> menu; 
	private ArrayList<String> products=new ArrayList<>(); //this arraylist is created to use in a method thats returns all menuitems names
	private ArrayList<MenuItem> menuitems=new ArrayList<>();//this arraylist is created to use in a method thats returns all menuitems.
	//constructor
	public Menu() {
		this.menu = new HashMap<String, MenuItem>();
		
	}
	
	//method to add menu items to menu object
	public void addItem(MenuItem item) {
		this.menu.put(item.getName(), item);
	}
	
	//method to return the menuitem corresponding the name
	public MenuItem getItem(String name) {
		return this.menu.get(name);
	}
	//method to return all of the items as menuitem objects in a list
	public ArrayList<MenuItem> getItemList() {
		for (String x: menu.keySet()) {
			menuitems.add(getItem(x));
		}
		return menuitems;
		
	}
	
	//method to return all of the items with their names in a list
	public ArrayList<String> getItemNames() {
		for (String x: menu.keySet()) {
			products.add(x);
		}
		return products;
		
		
	}
	//method to decrease the stock of a menuitem in menu using decStock method created in menuitem class
	public boolean decItem(String name) {
		return this.menu.get(name).decStock();
	}
	
	

}

package restaurant;


//base class for menu items 
//starters, main course, desserts, drinks, cocktails will be subclasses of it.
//all the subclasses of this class are a specialized menuitem types.
//all of the required method for all menuitem and the super constructor is defined in that class. 
//since every menuitem has the same varibales they are all initialized here.
//every menuitem has a name, price and availability

public abstract class MenuItem {
	//creating the fields for menuitem
	private String name;
	private double price;
	private int stock;
	private boolean av;
	
	//constructor
	public MenuItem(String name, double price, int stock) {
		this.name=name;
		this.price=price;
		this.stock=stock;
		if(isAvailable())
			setAv(true);
	}
	
	//getters and setters
	
	public String getName() {
		return this.name;
	}
	
	
	
	public void setName(String name) {
		this.name=name;
	}
	
	public double getPrice() {
		return this.price;
		
	}
	public void setPrice (double price) {
		this.price=price;
	}
	//this methods are created to get and set the availabilty of the menuitem to show it grayed out
	public boolean getAv() {
		return this.av;
	}
	
	public void setAv(boolean av) {
		this.av=av;
	}
	
	//to get and set stock
	public int getStock() {
		return this.stock;
	}

	public boolean setStock(int stock) {
		this.stock = stock;
		return true;
	}
	
	public boolean isAvailable() {
		return this.stock > 0;
	}
	//this method is created to keep track of the stock, it decreases stock by one, if stock is 1 since it will become 0 sets availabilty
	//to false and when finished returns to false for easier use.
	public boolean decStock() {
		if (this.stock > 0) {
			if (this.stock == 1)
				setAv(false);
			return setStock(this.stock-1);
		}
		return false;
	}
	//to string method that will be used in displaying the menuitems
	public String toString() {
		String str= " "+this.getName()+":  price : "+String.valueOf(this.getPrice())+" ";
		return str;
		
	}
	
	
	

}

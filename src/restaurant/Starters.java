package restaurant;
//one of the subclasses of MenuItem, creates a new menuitem type called starters, extends the class and uses super constructor to create 
//new starters object

public class Starters extends MenuItem {
	
	public Starters(String name, double price, int stock) {
		super(name, price, stock);
	}

}
	
package restaurant;
//one of the subclasses of MenuItem, creates a new menuitem type called drinks, extends the class and uses super constructor to create 
//new drink object
public class Drinks extends MenuItem {
	
	public Drinks(String name, double price, int stock) {
		super(name, price, stock);
	}

}

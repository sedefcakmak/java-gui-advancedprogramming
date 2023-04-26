package restaurant;
//one of the subclasses of MenuItem, creates a new menuitem type called cocktails, extends the class and uses super constructor to create 
//new cocktail object
public class Cocktails extends MenuItem {
	public Cocktails (String name, double price, int stock) {
		super(name, price, stock);
	}

}

package restaurant;
//one of the subclasses of MenuItem, creates a new menuitem type called maincourses, extends the class and uses super constructor to create 
//new maincourses object

public class MainCourses extends MenuItem {
	public MainCourses (String name, double price, int stock) {
		super(name, price, stock);
	}
}

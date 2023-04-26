package restaurant;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.swing.JPanel;
import java.util.HashMap;
import restaurant.Menu;

import restaurant.MenuItem;

import restaurant.Starters;
import restaurant.Drinks;
import restaurant.MainCourses;
import restaurant.Desserts;
import restaurant.Cocktails;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import restaurant.Table;
import javax.swing.JOptionPane;
import java.awt.image.BufferedImage;

public class Restaurant extends JFrame {
	//creating fields
	//to keep track of customers in the order of their age
	private TreeMap<Integer,Customer> customerlist=new TreeMap<>();
	//to put all orders in a same hashmap coming from customers from all sessions
	private HashMap<String,Integer> allorders= new HashMap<String,Integer>();
	
	
	
	//2 panels are created to keep track for customers for managers
	private JPanel customerp;
	private JPanel managerp;
	
	//menu object is created to add all menuitems
	Menu menu=new Menu();
	//table object is created to add all tables
	Table table=new Table();
	
	//Creating menu items
	//5 starter type
	Starters fr=new Starters("Fries",8,2);
	Starters s=new Starters("Salad",10,7);
	Starters n=new Starters("Nuggets",12,12);
	Starters y=new Starters("Yogurt",3,30);
	Starters sh=new Starters("Shrimp cocktail",15,14);
	
	//5 drinks type
	Drinks w=new Drinks("Water",1,50);
	Drinks wi=new Drinks("Wine",5,55);
	Drinks i=new Drinks("Beer",4,40);
	Drinks sp=new Drinks("Sprite",2.5,40);
	Drinks c=new Drinks("Coke",3,45);
	
	//5 maincourses type
	MainCourses main=new MainCourses("Steak",45,25);
	MainCourses mai=new MainCourses("Salmon",40,20);
	MainCourses ma=new MainCourses("Duck",38,15);
	MainCourses m=new MainCourses("Sushi",43,45);
	MainCourses mm=new MainCourses("Chicken teriyaki",25,2);
	
	//5 desserts type
	Desserts desrt=new Desserts("Souffle",15,10);
	Desserts desr=new Desserts("Apple Pie",8,20);
	Desserts des=new Desserts("Cake",7,30);
	Desserts de=new Desserts("Baklava",9,30);
	Desserts d=new Desserts("Creme Brullee",15,8);
	
	//5 cocktails type
	Cocktails cockt=new Cocktails("Mojito",12,30);
	Cocktails cock=new Cocktails("Pina Colada",13,25);
	Cocktails coc=new Cocktails("Old Fashioned",14,30);
	Cocktails co=new Cocktails("JagerBomb",10,35);
	Cocktails cc=new Cocktails("Cosmopolitan",12,80);
	//one more menu item is created called none to add all of the comboboxes that allows customers to choose none of them
	//it cretaed as cocktails type since they all got the same constructor so this is type indifferent
	Cocktails none=new Cocktails("None",0,100000000);
	
	
	
	//Cretaing JLabels for gui
	private JLabel groupnum; //ask number of people
	private JLabel name;//asks name of customer
	private JLabel age;//asks age of customer
	//menu lables
	private JLabel starters;
	private JLabel mainc;
	private JLabel dess;
	private JLabel drinks;
	private JLabel cocktails;
	//table label
	private JLabel t;
	
	
	
	//creating buttons
	private JButton csession; //button to see available tables
	private JButton next; //button to see menu with pictures
	private JButton finish; //button to give orders
	private JButton menuu; //button to see menu with image prices and availabilty
	private JButton showcustom; //button to show customers
	private JButton check; //button for customers to see the check
	private JButton seeorder; //button for managers to see all orders
	private JButton seestock; //button for managers to see item availabilty
	private JButton seetables;//button for customers to see the number of tables available
	
	//comboboxes are used to get the orders from customers and to dsiplay the menuitems
	private JComboBox<String> start; 
	private JComboBox<String> maincc;
	private JComboBox<String> desi;
	private JComboBox<String> drr;
	private JComboBox<String> ccc;
	
	
	
	//textfields for inputs
	
	private JTextField gnumber;//to get the number of person for a table
	private JTextField entname;//to get name of customer
	private JTextField entage;//to get age of customer
	
	//creating textareas
	private JTextArea paycheck;//text area to display the total amount to pay
	private JTextArea bigmenu;//to display the menu
	private JTextArea allcustom;//to display all added customers to managers
	private JTextArea orderlist;//to display all orders
	private JTextArea showstock;//to display stock info
	private JTextArea tt; //to display the available tables
	
	//creating some fields for class
	private double totalp;//new field to keep the total price that customer should pay
	private String res;//creating a class string to use it customer session frames
	
	
	//constructor
	public Restaurant() {
		super("Restaurant Java");
		GridLayout grid =new GridLayout(2,1,5,15);
		this.setLayout(grid);
		
		
		//adding all menuitems to menu object
		menu.addItem(fr);
		menu.addItem(s);
		menu.addItem(n);
		menu.addItem(y);
		menu.addItem(sh);
		menu.addItem(w);
		menu.addItem(wi);
		menu.addItem(i);
		menu.addItem(sp);
		menu.addItem(c);
		menu.addItem(main);
		menu.addItem(mai);
		menu.addItem(ma);
		menu.addItem(m);
		menu.addItem(mm);
		menu.addItem(desrt);
		menu.addItem(desr);
		menu.addItem(des);
		menu.addItem(de);
		menu.addItem(d);
		menu.addItem(cockt);
		menu.addItem(cock);
		menu.addItem(coc);
		menu.addItem(co);
		menu.addItem(cc);
		menu.addItem(none);
		//adding to table object
		table.addTable(2, 4);
		table.addTable(4, 4);
		table.addTable(8, 2);
		//adding all items to hashmap to keep track easily to display in maager panel the number of orders for each item
		for (String x:menu.getItemNames()) {
			allorders.put(x, 0);
			
		}
		
		
		
		//settinglabels
		groupnum =new JLabel("How many people are you? ");
		name=new JLabel("Enter your name ");
		age=new JLabel("Enter your age ");
		starters=new JLabel("Starters");
		mainc=new JLabel("Main Courses");
		dess=new JLabel("Deserts");
		drinks=new JLabel("Drinks");
		cocktails=new JLabel("Cocktails");
		t=new JLabel("Available tables");
		
		
		//setting buttons
		csession=new JButton("Continue");//to create new session
		next=new JButton("Next");
		finish=new JButton("Done"); //to conclude orders
		menuu=new JButton("See Menu");
		showcustom=new JButton("Show Customers");
		check=new JButton("Get check");
		seeorder=new JButton("see orders");
		seestock=new JButton("see stock info");
		seetables=new JButton("see tables");
		
		
		
		//setting ComboBoxes
		start=new JComboBox<String>();
		start.addItem(none.getName());
		start.addItem(fr.getName());
		start.addItem(s.getName());
		start.addItem(n.getName());
		start.addItem(y.getName());
		start.addItem(sh.getName());
		
		
		maincc=new JComboBox<String>();
		maincc.addItem(none.getName());
		maincc.addItem(main.getName());
		maincc.addItem(mai.getName());
		maincc.addItem(ma.getName());
		maincc.addItem(m.getName());
		maincc.addItem(mm.getName());
		
		
		desi=new JComboBox<String>();
		desi.addItem(none.getName());
		desi.addItem(desrt.getName());
		desi.addItem(desr.getName());
		desi.addItem(des.getName());
		desi.addItem(de.getName());
		desi.addItem(d.getName());
		
		drr=new JComboBox<String>();
		drr.addItem(none.getName());
		drr.addItem(w.getName());
		drr.addItem(wi.getName());
		drr.addItem(i.getName());
		drr.addItem(sp.getName());
		drr.addItem(c.getName());
		
		ccc=new JComboBox<String>();
		ccc.addItem(none.getName());
		ccc.addItem(cockt.getName());
		ccc.addItem(cock.getName());
		ccc.addItem(coc.getName());
		ccc.addItem(co.getName());
		ccc.addItem(c.getName());
		
		
		
		//setting textfields
		gnumber=new JTextField(10);
		gnumber.setEditable(true);
		entname=new JTextField(15);
		entname.setEditable(true);
		entage=new JTextField(10);
		entage.setEditable(true);
		//setting textareas
		paycheck=new JTextArea();
		bigmenu=new JTextArea();
		allcustom=new JTextArea();
		orderlist=new JTextArea();
		showstock=new JTextArea();
		tt=new JTextArea();
		
		
		//creating the customer panel
		customerp=new JPanel(new FlowLayout());
		customerp.setBorder(BorderFactory.createTitledBorder("Customers"));
		customerp.add(groupnum);
		gnumber.setColumns(7);
		customerp.add(gnumber);
		customerp.add(csession);
		customerp.add(menuu);
		customerp.add(seetables);
		customerp.add(tt);
		
		//creating the manager panel
		managerp=new JPanel(new FlowLayout());
		managerp.setBorder(BorderFactory.createTitledBorder("Managers"));
		managerp.add(showcustom);
		managerp.add(allcustom);
		managerp.add(seeorder);
		managerp.add(orderlist);
		managerp.add(seestock);
		managerp.add(showstock);
		
		
		this.add(customerp); //to adding panels
		this.add(managerp);
		
		
		
		
		
		
		
		//adding events for buttons
		csession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//creates new session, adds groups to proper tables, decreases the tables,opens name side if there is empty table
				int num1=Integer.parseInt(gnumber.getText());
				if (((num1>=1) && (num1<=2) && (table.getValue(2)!=0)) || ((num1>2) &&(num1<=4) && (table.getValue(4)!=0)) || ((num1>4) && (num1<=8) && (table.getValue(8)!=0))  ) {
					//creates a new frame for each session
					JFrame fr2=new JFrame();
					fr2.setLayout(new FlowLayout());
						//totalprice is to display total bill for each session so becomes zero when each session is created
						totalp=0;
						//res is to display total bill with the name and products for each session so becomes zero when a new session is created
						res="";
						paycheck.setText(null);
						fr2.add(name);
						fr2.add(entname);
						fr2.add(age);
						fr2.add(entage);
						fr2.setVisible(true);
						fr2.add(starters);
						fr2.add(start);
						fr2.add(mainc);
						fr2.add(maincc);
						fr2.add(dess);
						fr2.add(desi);
						fr2.add(drinks);
						fr2.add(drr);
						fr2.add(cocktails);
						fr2.add(ccc);
						fr2.add(finish);
						fr2.add(check);
						fr2.add(paycheck);
						fr2.setSize(350,350);
						
					
						JOptionPane.showMessageDialog(null, "your session is created"); // if there is a table available this message will be displayed
						
					table.decTable(num1); // when each session created number of specific type of table will be decreased
					
						
				}
				else {
					JOptionPane.showMessageDialog(null, "your session does not created"); //if no available table message is displayed
					
				}
					
				}
			
		} );
		//finish button is pressed after each new order, so orders would be added to checklist and allorders list that managers
		//use, with this button also the stock of the item is decreasing, new customer with name would be added
		finish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Customer custom=new Customer(entname.getText(),Integer.parseInt(entage.getText()));
				
				
				customerlist.put(custom.getAge(),custom);
				
				
				
				//a new hashmap will be created for each session sepeartely when a session opens and therefore can display the 
				//total bill of each session seperately
				//orders are also added to allorders hashmap for managers to see orders of every session
				//all of the addings are in if statement to avoid adding the "None" objects
				HashMap<String,Double> grouporder=new HashMap<String,Double>();
				if (start.getSelectedItem().toString()!="None") {
					grouporder.put(start.getSelectedItem().toString(),(menu.getItem(start.getSelectedItem().toString())).getPrice());
					allorders.put(start.getSelectedItem().toString(), allorders.get(start.getSelectedItem().toString())+1);
				}
				if (maincc.getSelectedItem().toString()!="None") {
					grouporder.put(maincc.getSelectedItem().toString(),(menu.getItem(maincc.getSelectedItem().toString())).getPrice());
					allorders.put(maincc.getSelectedItem().toString(), allorders.get(maincc.getSelectedItem().toString())+1);
				}
				if (desi.getSelectedItem().toString()!="None") {
					grouporder.put(desi.getSelectedItem().toString(),(menu.getItem(desi.getSelectedItem().toString())).getPrice());
					allorders.put(desi.getSelectedItem().toString(), allorders.get(desi.getSelectedItem().toString())+1);
				}
				
				if (drr.getSelectedItem().toString()!="None") {
					grouporder.put(drr.getSelectedItem().toString(),(menu.getItem(drr.getSelectedItem().toString())).getPrice());
					allorders.put(drr.getSelectedItem().toString(), allorders.get(drr.getSelectedItem().toString())+1);
				}
				
				if (ccc.getSelectedItem().toString()!="None") {
					grouporder.put(ccc.getSelectedItem().toString(),(menu.getItem(ccc.getSelectedItem().toString())).getPrice());
					allorders.put(ccc.getSelectedItem().toString(), allorders.get(ccc.getSelectedItem().toString())+1);
				}
				

				
				
				
				
				//for decreasing stocks
				menu.decItem(start.getSelectedItem().toString());
				menu.decItem(maincc.getSelectedItem().toString());
				menu.decItem(desi.getSelectedItem().toString());
				menu.decItem(drr.getSelectedItem().toString());
				menu.decItem(ccc.getSelectedItem().toString());
				
				
				//to create the check
				for (String v:grouporder.keySet()) {
					totalp+=grouporder.get(v);
					res+=""+v+"   "+grouporder.get(v)+"\n";
				}
				entname.setText(null); //after pressing the button name and age area is set to null for new customer
				entage.setText(null);
				
			}
			
			
		}		
				);
		
		
		
		//after entering all of the customers order in one session, to get the total check, this button should be used, check is displayed
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				paycheck.setText(null);
				paycheck.append(res+"\n"+"your total fee is "+totalp); 
				
				
				
			}
			
		}
				
				
				);
		
		
		//for manager panel this button is created to show all the registered customers sorted by age
		TreeMap<Customer,Integer> temp=new TreeMap<Customer,Integer>();
		showcustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String res="";
				
				for (Entry<Integer, Customer> k: customerlist.entrySet()) {
					
					
					res+=""+k.getKey()
					+"  "+k.getValue().getName()+"\n";
				}
				
				
				
				allcustom.setText(null);
				allcustom.append(res);
				
			}
		}
				
				
				);
		
		//this button is created to make manage4rs see all of the orders
		seeorder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String res="";
				for (String x:allorders.keySet()) {
					if (allorders.get(x)!=0) {
						res+=""+x+"  "+allorders.get(x)+"\n";
					}
					
				}
				orderlist.setText(null);
				orderlist.append(res);
				
				
				
			}
		}
				
				
				);
		
	
	
		//this button is created to make managers see all the items with remaining stock in a new frame
		seestock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame fr3=new JFrame();
				fr3.setLayout(new FlowLayout());
				String rr="";
				for (String x:menu.getItemNames()) {
					if (menu.getItem(x).getName()!="None") {
						rr+=""+menu.getItem(x).getName()+"   "+menu.getItem(x).getStock()+" remaining "+"\n";
					}
					
				}
				showstock.setText(null);
				showstock.append(rr);
				showstock.setEditable(false);
				fr3.add(showstock);
				fr3.setVisible(true);
			}
		}
				
				
				
				
				);
		
		//this button is created for customers to see the whole menu with name, price and availability in a new frame
		menuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame fr4=new JFrame();
				fr4.setLayout(new FlowLayout());
				String r="";
				for (String i:menu.getItemNames()) {
					if (menu.getItem(i).getName()!="None") {
						r+=menu.getItem(i).toString()+"  available stock: "+menu.getItem(i).getStock()+"\n";
						
					}
					
				}
				bigmenu.setText(null);
				bigmenu.append(r);
				bigmenu.setEditable(false);
				
				fr4.add(bigmenu);
				fr4.setVisible(true);
				
				
			}
			
		}
				
				
				
				
				);
		
		//this button is created for customers to see all the available tables at the time
		seetables.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tt.add(t);
				tt.setText(null);
				tt.append(table.toString());
				
			}
		
	
	
		}
			
	);
	
	
	
	}
	
	
	
	
	
	

}

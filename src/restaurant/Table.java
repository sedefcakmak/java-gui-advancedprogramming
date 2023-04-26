package restaurant;

import java.util.HashMap;

//a class called table is cretaed to keep track of tables, create table objects for easier use to keep track of the sessions

public class Table {
	//this class has an hashmap field to add the number of tables and the size of the table
	//first integer is how many tables there are in a specific size and second integer is the size of the table (2,4,6 etc.)
	//field
	public HashMap<Integer,Integer> table=new HashMap<Integer,Integer>();
	//constructor
	public Table() {
		this.table=table;
	}
	//method to get the number of tables availbale for a specific size
	public int getValue(int n) {
		return table.get(n);
	}
	//method to decrease the number of tables in a specific size
	public void decTable(int i) {
		table.put(i,table.get(i)-1);
		
	}
	
	//method to add table to table hashmap to easily keep track
	public void addTable(int i, int j) {
		table.put(i,j);
		
	}
	// topString method is created to display the number of tables remaining to customers
	public String toString() {
		String ress="";
		for (int i:table.keySet()) {
			ress+=table.get(i)+" "+i+" person table available \n";
		}
		return ress;
	}

}



package restaurant;

import java.util.HashMap;
import java.util.LinkedList;
//a customer class is created to create a customer object and keep track of the customers
//a customer object have size and age

public class Customer {
		//creating fields
		private String name;
		private int age;
		
		//constructor
		public Customer(String name, int age) {
			this.name = name;
			this.age = age;
		}
		//getters and setters
		public String getName() {
			return this.name;
		}
		
		public int getAge() {
			return this.age;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public void setAge(Integer age) {
			this.age=age;
		}
		
		
}

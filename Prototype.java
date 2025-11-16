/**
 * Prototype Design Pattern is a creational design pattern that allows
 * cloning of objects, even complex ones, without coupling to their specific classes.
 * It is used when the creation of an object is costly or complex.	
 */

class Address implements Cloneable {
	String city;
	String street;

	public Address(String n,String c){
		this.city = n;
		this.street = c;
	}
	
	@Override
	public Address clone(){
		try{
			return (Address) super.clone();
		} catch(CloneNotSupportedException e){
			return null;
		}
	}
}

class Person implements Cloneable {
	String name;
	int age;
	Address address;

	public Person(String n,int a,Address add){
		this.name = n;
		this.age = a;
		this.address = add;
	}

	// Deep Copy
	@Override
	public Person clone(){
		try{
			Person cl = (Person) super.clone();
			cl.address = this.address.clone();
			return cl;
		} catch(CloneNotSupportedException e){
			return null;
		}
	}
}

public class Main{
	public static void main(String[] args){
		Person p1 = new Person("John",23, new Address("LA","West side avenue"));
		Person p2 = p1.clone();
	}
}
/**
 * Factory Method Pattern defines an interface for creating an object,
 * but lets subclasses alter the type of objects that will be created.
 * This pattern is used when the exact type of the object to be created
 * is determined by subclasses.
 */


interface Burger {
	void serve();
}

class chickenBurger implements Burger {
	public void serve(){
		System.out.println("Delivering Chicken Burger");
	}
}

class paneerBurger implements Burger {
	public void serve(){
		System.out.println("Delivering Paneer Burger");
	}
}

abstract class BurgerKing {
	// factory method
	abstract Burger createBurger();

	public void orderBurger(){
		Burger burger = createBurger();
		burger.serve();
	}
}

class nonVegBurger extends BurgerKing {
	Burger createBurger(){
		return new chickenBurger();
	}
}

class vegBurger extends BurgerKing {
	Burger createBurger() {
		return new paneerBurger();
	}
}

// usage

public class Main {
	public static void main(String[] args){
		BurgerKing shop;

		shop = new nonVegBurger();
		shop.orderBurger(); // gets Chicken burger
		
		shop = new vegBurger();
		shop.orderBurger(); // gets Paneer burger
	}
}




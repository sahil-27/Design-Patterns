/**
 * Abstract Factory Pattern provides an interface for creating families of related
 * or dependent objects without specifying their concrete classes.
 * This pattern is useful when the system needs to be independent of how its
 * objects are created, composed, and represented.
 */

interface Chair {
	void getChair();
}

interface Sofa {
	void getSofa();
}

class VictorianChair implements Chair {
	public void getChair(){
		System.out.println("delivering Victorian Chair");
	}
}

class VictorianSofa implements Sofa {
	public void getSofa(){
		System.out.println("delivering Victorian Sofa");
	}
}

class ModernChair implements Chair {
	public void getChair(){
		System.out.println("delivering Modern Chair");
	}
}

class ModernSofa implements Sofa {
	public void getSofa(){
		System.out.println("delivering Modern Sofa");
	}
}

interface Factory {
	Chair deliverChair();
	Sofa deliverSofa();
}

class VictorianSet implements Factory {
	public Chair deliverChair(){
		return new VictorianChair();
	}
	public Sofa deliverSofa(){
		return new VictorianSofa();
	}
}

class ModernSet implements Factory {
	public Chair deliverChair(){
		return new ModernChair();
	}
	public Sofa deliverSofa(){
		return new ModernSofa();
	}
}

class Application {
	Chair chair;
	Sofa sofa;

	public Application(Factory obj){
		chair = obj.deliverChair();
		sofa = obj.deliverSofa();
	}

	public void Buy(){
		chair.getChair();
		sofa.getSofa();
	} 
}

public class Main{
	public static void main(String[] args){
		Factory set;
		set = new ModernSet();
		
		Application shop;

		shop = new Application(set);
		shop.Buy();

		set = new VictorianSet();
		shop = new Application(set);
		shop.Buy();
	}
}
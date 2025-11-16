/**
 * Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime.
 * It defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * This allows the algorithm to vary independently from clients that use it.
 */


interface Route {
	void getRoute(String desA,String desB);
}

class CarRoute implements Route {
	@Override
	public void getRoute(String A,String B){
		System.out.println("Printing route of Car"+A+" "+B);
	}
}

class WalkRoute implements Route {

	@Override
	public void getRoute(String A,String B){
		System.out.println("Printing route by walking"+A+" "+B);
	}
}

class BusRoute implements Route {

	@Override
	public void getRoute(String A,String B){
		System.out.println("Printing route by Bus"+A+" "+B);
	}
}

class RouteAlgo {
	private Route obj;

	public void setRouteType(Route obj){
		this.obj = obj;
	}

	public void getRoute(String A,String B){
		 if (obj == null) {
            System.out.println("Please set a route type first!");
            return;
        }
		obj.getRoute(A,B);
	}
}

public class Main {
	public static void main(String[] args){

		RouteAlgo app = new RouteAlgo();
		app.setRouteType(new WalkRoute());
		app.getRoute("A","B");

		app.setRouteType(new BusRoute());
		app.getRoute("A","B");
	}
}


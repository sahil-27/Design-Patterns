/**
 * Proxy Design Pattern is a structural design pattern that provides an object
 * that acts as a substitute for a real service object used to control access to it.
 * It is used to provide controlled access to the original object, allowing you to add
 * functionality like lazy initialization, access control, logging, etc.
 */


interface Document {
	void displayDoc();
}

class SecretDoc implements Document {
	private String content;

	public SecretDoc(){
		this.content = loadFromDB();
	}

	@Override
	public void displayDoc(){
		System.out.println("Displaying Doc..."+content);
	}
}

class DocProxy implements Document {
	private String username;
	private String userRole;
	private SecretDoc obj;

	public DocProxy(String username, String userRole){
		this.username = username;
		this.userRole = userRole;
	}

	@Override
	public void displayDoc(){
		if(!checkRole(this.userRole)){
			System.out.println("Unauthorized Access");
			return;
		}

		if(obj == null){
			obj = new SecretDoc();
		}

		obj.displayDoc();
	}

	boolean checkRole(String userRole){
		if(userRole.equals("ADMIN")){
			return true;
		}
		else{
			return false;
		}
	}
}

public class Main {
	public static void main(String[] args){
		DocProxy server = new DocProxy("john","USER");
		server.displayDoc();

		DocProxy server2 = new DocProxy("Adam","ADMIN");
		server2.displayDoc();
	}
}
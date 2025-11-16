/**
 * Singleton class ensures that only one instance of the class is created.
 * It provides a global point of access to that instance.
 */

public final class Singleton {
	private static Singleton instance;
	public String value;

	private Singleton(String value){
		this.value = value;
	}

	public static Singleton getInstance(String value){
		if(instance  == null){
			instance = new Singleton(value);
		}
		return instance;
	}
}
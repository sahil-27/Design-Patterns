/**
 * Observer Pattern is a behavioral design pattern that defines a one-to-many dependency
 * between objects so that when one object changes state, all its dependents are notified
 * and updated automatically.
 */

import java.util.*;

interface User {
	void notifyUser(String msg);
}

interface Channel {
	void addSubscriber(User user);
	void removeSubscriber(User user);
	void notifySubscribers(String msg);
}

class Users implements User {
	String name;
	public Users(String n){
		this.name = n;
	}

	@Override
	public void notifyUser(String msg){
		System.out.println("user "+name+" notified of "+msg);
	}
}

class Channel1 implements Channel {
	private String ChannelName; 
	private List<Users> subscribersList;

	public Channel1(String name){
		subscribersList = new ArrayList<>();
		this.ChannelName = name;
	}		

	@Override
	public void addSubscriber(User user){
		subscribersList.add(user);
	}

	@Override
	public void removeSubscriber(User user){
		subscribersList.remove(user);
	}

	@Override
	public void notifySubscribers(String msg){
		for(User user: subscribersList) {
			user.notifyUser(msg);
		}
	}
}

public class Main {
	public static void main(String[] args){
		User obj1 = new Users("Sahil");
		User obj2 = new Users("John");

		Channel1 ChannelObj = new Channel1("Veritasium");
		ChannelObj.addSubscriber(obj1);
		ChannelObj.addSubscriber(obj2);

		ChannelObj.notifySubscribers("hello from veritasium");
	}
}


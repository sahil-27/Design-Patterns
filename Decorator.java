/**
 * Decorator Design Pattern is a structural design pattern that allows
 * behavior to be added to individual objects, either statically or dynamically,
 * without affecting the behavior of other objects from the same class.
 */

interface Notification {
	void send(String msg);
}

class BaseNotification implements Notification {
	@Override
	public void send(String msg){
		System.out.println("message sent"+" "+msg);
	}
}

abstract class NotificationDecorator implements Notification {
	protected final Notification notiObj;

	public NotificationDecorator(Notification obj){
		this.notiObj = obj;
	}

	@Override
	public void send(String msg){
		if(notiObj != null){
			notiObj.send(msg);
		}
	}
}

class EmailDecorator extends NotificationDecorator {
	public EmailDecorator(Notification obj){
		super(obj);
	}

	@Override
	public void send(String msg){
		super.send(msg);
		sendEmailNoti(msg);
	}

	private void sendEmailNoti(String msg){
		System.out.println("Email Noti sent "+msg);
	}
}

class SlackDecorator extends NotificationDecorator {
	public SlackDecorator(Notification obj){
		super(obj);
	}

	@Override
	public void send(String msg){
		super.send(msg);
		sendSlackNoti(msg);
	} 

	private void sendSlackNoti(String msg){
		System.out.println("Slack Noti sent "+msg);
	}
}

class SMSDecorator extends NotificationDecorator {
	public SMSDecorator(Notification obj){
		super(obj);
	}

	@Override
	public void send(String msg){
		super.send(msg);
		sendSMSNoti(msg);
	}

	private void sendSMSNoti(String msg){
		System.out.println("SMS Noti sent "+msg);
	}
}

class Main {
	public static void main(String[] args){
		Notification obj = new BaseNotification();
		obj.send("hello");

		Notification email = new EmailDecorator(obj);
		email.send("hello");

		Notification emailandslack = new SlackDecorator(email);
		emailandslack.send("hello");
		
		Notification all = new SMSDecorator(emailandslack);
		all.send("hello");
	}
}
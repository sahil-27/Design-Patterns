/**
 * Command Pattern is a behavioral design pattern that turns a request into a stand-alone object
 * that contains all information about the request. This transformation lets you parameterize methods
 * with different requests, delay or queue a request's execution, and support undoable operations.
 */

interface Command {
	void execute();
}

class TV {
	public void on(){
		System.out.println("Turning TV on");
	}

	public void off(){
		System.out.println("Turning TV off");
	}
}

class Speaker {
	public void on(){
		System.out.println("Turning Speaker on");
	}

	public void off(){
		System.out.println("Turning Speaker off");
	}
}

class TVOn implements Command {
	private TV obj;
	
	public TVOn(TV obj){
		this.obj = obj;
	}

	@Override
	public void execute(){
		if( obj == null){
			return;
		}
		obj.on();
	}
}

class TVOff implements Command {
	private TV obj;
	
	public TVOff(TV obj){
		this.obj = obj;
	}

	@Override
	public void execute(){
		if( obj == null){
			return;
		}
		obj.off();
	}
}

class SpeakerOn implements Command {
	private Speaker obj;
	
	public SpeakerOn(Speaker obj){
		this.obj = obj;
	}

	@Override
	public void execute(){
		if( obj == null){
			return;
		}
		obj.on();
	}
}

class SpeakerOff implements Command {
	private Speaker obj;
	
	public SpeakerOff(Speaker obj){
		this.obj = obj;
	}

	@Override
	public void execute(){
		if( obj == null){
			return;
		}
		obj.off();
	}
}

class Remote {
	private Command obj;

	public void setCommand(Command command){
		this.obj = command;
	}

	public void executeCommand(){
		if(obj == null){
			return;
		}
		obj.execute();
	}
}

public class Main {
	public static void main(String[] args){
		TV tv = new TV();
		Speaker speaker = new Speaker();

		Command tvOn = new TVOn(tv);
        Command tvOff = new TVOff(tv);
        Command speakerOn = new SpeakerOn(speaker);
        Command speakerOff = new SpeakerOff(speaker);

		Remote remote = new Remote();

		remote.setCommand(tvOn);
		remote.executeCommand();

		remote.setCommand(tvOff);
		remote.executeCommand();

		remote.setCommand(speakerOn);
		remote.executeCommand();

		remote.setCommand(speakerOff);
		remote.executeCommand();
	}
}
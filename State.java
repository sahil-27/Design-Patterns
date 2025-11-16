/**
 * State Pattern is a behavioral design pattern that allows an object to alter its behavior
 * when its internal state changes. The object will appear to change its class.
 */


interface PlayerState {
	void play(AudioPlayer obj);
	void pause(AudioPlayer obj);
	void stop(AudioPlayer obj);
}

class PlayAudioState implements PlayerState {
	@Override
	public void play(AudioPlayer obj){
		System.out.println("Audio is already playing");
	}

	@Override
	public void pause(AudioPlayer obj){
		System.out.println("Audio is paused");
		obj.setState(obj.getPausedState());
	}

	@Override
	public void stop(AudioPlayer obj){
		System.out.println("Audio is stopped");
		obj.setState(obj.getStopState());
	}
}

class PauseAudioState implements PlayerState {
	@Override
	public void play(AudioPlayer obj){
		System.out.println("Audio is now playing");
		obj.setState(obj.getPlayState());
	}

	@Override
	public void pause(AudioPlayer obj){
		System.out.println("Audio is already paused");
	}

	@Override
	public void stop(AudioPlayer obj){
		System.out.println("Audio is stopped");
		obj.setState(obj.getStopState());
	}
}

class StopAudioState implements PlayerState {
	@Override
	public void play(AudioPlayer obj){
		System.out.println("Audio is now playing");
		obj.setState(obj.getPlayState());
	}

	@Override
	public void pause(AudioPlayer obj){
		System.out.println("Cannot pause, audio is stopped");
	}

	@Override
	public void stop(AudioPlayer obj){
		System.out.println("Audio is already stopped");
	}
}

class AudioPlayer {
	private PlayerState play;
	private PlayerState pause;
	private PlayerState stop;
	private PlayerState currentState;

	public AudioPlayer(){
		this.play = new PlayAudioState();
		this.pause = new PauseAudioState();
		this.stop = new StopAudioState();

		this.currentState = stop;
	}

	public void play(){
		currentState.play(this);
	}

	public void pause(){
		currentState.pause(this);
	}

	public void stop(){
		currentState.stop(this);
	}

	public void setState(PlayerState obj){
		this.currentState = obj;
	}

	public PlayerState getPlayState(){
		return this.play;
	}

	public PlayerState getPausedState(){
		return this.pause;
	}

	public PlayerState getStopState(){
		return this.stop;
	}

	public void getCurrentState(){
		System.out.println(this.currentState.toString());
	}
}

public class Main {
	public static void main(String[] args){
		AudioPlayer player = new AudioPlayer();

		player.play();
		player.pause();
		player.getCurrentState();

		player.play();
		player.stop();
	}
}
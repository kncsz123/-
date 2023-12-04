package exp5.stickman.exception;

public class StickManInitializationException extends RuntimeException{
	private static final long serialVersionUID = 5205205205209999999L;

	public StickManInitializationException(){}
	public StickManInitializationException(String msg){
		super(msg);
	}
}

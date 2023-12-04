package exp5.stickman.exception;

public class JointsAreSameException extends RuntimeException{
	public static final long serialVersionUID = 3337658999999999999L;
	public JointsAreSameException() {
		super("Two Joints can not be the same");
	}
	public JointsAreSameException(String msg) {
		super(msg);
	}
}

package exp5.stickman.exception;

public class RadiusIsNegativeException extends RuntimeException {
	public static final long serialVersionUID = 1234567899999999999L;
	public RadiusIsNegativeException() {
		super("Radius can not be a negative value");
	}
	public RadiusIsNegativeException(String msg) {
		super(msg);
	}
}

package exp5.stickman.exception;

public class JointIsNoneException extends RuntimeException{
	public static final long serialVersionUID = -5014257318999999999L;
	//默认错误信息
	public JointIsNoneException() {
		super("The joint can not be none");
	}
	//自定义错误信息
	public JointIsNoneException(String msg) {
		super(msg);
	}
}

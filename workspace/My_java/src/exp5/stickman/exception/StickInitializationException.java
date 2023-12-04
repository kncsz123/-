package exp5.stickman.exception;

public class StickInitializationException extends RuntimeException{
//	serialVersionUID 是 Java 中用于版本控制的一个标识符，它是一个长整数（long），
//	用于确保在序列化和反序列化对象时的版本一致性。
//	try catch语句块可以放在任何可能发生的异常处，比如主函数，方法，构造函数等。
	private static final long serialVersionUID = -6026447143285749889L;

	public StickInitializationException(){}
	public StickInitializationException(String msg){
		super(msg);
	}
}

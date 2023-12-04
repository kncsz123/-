package map;

public class Point implements Feature{
	private double x;
	private double y;
	Point(double x,double y){
		this.x = x;
		this.y = y;
	}
	@Override
	public void move(double dx,double dy) {
		x += dx;
		y += dy;
	}
	@Override
	//"Point(" + x + ", " + y + ")" 是一个字符串连接操作，用于将多个字符串和变量连接在一起以构建一个新的字符串。
	public String toString() {
		return "Point(" + x + ", " + y + ")";
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
}

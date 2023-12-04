package canvas;

public class Circle implements Shape{
	public String getShape() {
		return "圆形";
	}
	public void draw() {
		System.out.println("绘制"+getShape());
	}

}

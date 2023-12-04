package canvas;

public class Rectangle implements Shape {
	@Override
	public String getShape() {
		return "矩形";
	}
	@Override
	public void draw() {
		System.out.println("绘制"+getShape());
	}
}

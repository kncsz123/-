package canvas;

public class Canvas {
	public void draw(Shape shape) {
        System.out.print("绘制" + shape.getShape() + ": ");
        shape.draw();
    }
}

package canvas;

public class Maintest {
	public static void main(String[] args) {
		Canvas canvas = new Canvas();
		Shape circle = new Circle();
		Shape rectangle = new Rectangle();
		canvas.draw(circle);
		canvas.draw(rectangle);
	}
}

package grid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GUIClient extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LayerView view = new LayerView(600, 400, 2);
		Pane backPane = new Pane(view);
		
		VBox box = new VBox();
		box.getChildren().addAll(backPane);
		
		
		Scene scene = new Scene(box);
		
		Circle c = new Circle(100, 100, 50);
		Rectangle r = new Rectangle(120, 120, 80, 40);
		Rectangle R = new Rectangle(120,120,60,20);
		Triangle t = new Triangle(100,100,200,200,300,300);
		Raster r1 = c.raster();
		Raster r2 = r.raster();
		Raster r3 = R.raster();
		Raster r4 = t.raster();
//		Raster r3 = new Raster(100, 100, 120, 40);
		
//		view.render(r1);
//		view.render(r2);
//		view.render(r3);
//		view.render(r1.intersect(r2));
//		view.render(r1.merge(r2));
		view.render(r2.clip(r3));
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("栅格化");
		primaryStage.show();
	}

	public static int random(int max) {
		return (int) (Math.random() * (max + 1));
	}
	
	public static void main(String[] args) {
		launch();
	}
}

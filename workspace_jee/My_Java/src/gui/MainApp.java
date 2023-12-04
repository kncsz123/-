package gui;


import biz.Controller;
import biz.SquareBox;
import biz.*;
import biz.Controller.ActionType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		SquareBox box = new SquareBox(10, 20);
		Controller controller = new Controller(box);
		SquareBoxView view = new SquareBoxView(box.getWidth(), box.getHeight(), 30);
		
		GameLoop gameLoop = new GameLoop() {

			@Override
			public void preprocess() {
				
			}

			@Override
			public void refresh() {
				// 游戏逻辑自动触发一次动作
				controller.run();
			}

			@Override
			public void display() {
				view.render(controller.show()); // 屏幕刷新
			}
			
		};
		
		gameLoop.start();
		Pane backPane = new Pane(view);

		Scene scene = new Scene(backPane);
		
		// 键盘控制
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
				case SPACE:{
					controller.receive(ActionType.ROTATE);
				};break;
				case LEFT:{
					controller.receive(ActionType.LEFT);
				};break;
				case RIGHT:{
					controller.receive(ActionType.RIGHT);
				};break;
				case DOWN:{
					controller.receive(ActionType.DOWN);
				};break;
				default:break;
			}
			controller.run(); // 键盘按键会促发一次动作
		});
		
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("俄罗斯方块");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}


package view;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {
	
	Button button;
	Button button2;
	Stage window;
	Scene scene1, scene2;
	model.SceneFactory sceneFactory;

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		sceneFactory = new model.SceneFactory(window);
		
		window.setScene(sceneFactory.getWelcomeScene());
		window.setTitle("Sales Company History");
		window.show();
		
	}

}

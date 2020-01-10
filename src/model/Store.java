package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Store implements FXScene {

	private Button backButton;
	private Stage window;
	
	public Store(Stage window) {
		this.window = window;
	}
	@Override
	public Scene getScene() {
		backButton = new BackButton(window);
		Label label = new Label("Store table");
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
}

package model;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tax implements FXScene{

	private Button backButton;
	private Stage window;
	
	public Tax(Stage window) {
		this.window = window;
	}
	@Override
	public Scene getScene() {
		backButton = new BackButton(window);
		Label label = new Label("Tax table");
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}

}
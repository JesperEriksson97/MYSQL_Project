package model;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BackButton extends Button implements EventHandler<ActionEvent> {
	
	Welcome welcome;
	Stage window;
	
	public BackButton(Stage window) {
		this.window = window;
		setText("Back");
		setOnAction(this);
	}

	public void handle(ActionEvent e) {
		welcome = new Welcome(window);
		window.setScene(welcome.getScene());
	}
}

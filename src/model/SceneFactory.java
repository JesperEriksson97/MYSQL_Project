package model;

import java.io.FileNotFoundException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneFactory {

	Stage window;
	Button backButton;
	Welcome welcome;
	Manufactor manufactor;
	Products products;
	Tax tax;
	Sales sales;
	Store store;
	Customers customers;
	
	
	
	public SceneFactory(Stage window) {
		this.window = window;
	}
	
	// This class is supposed to create the needed scenes to switch between.
	
	public Scene getWelcomeScene() {
		welcome = new Welcome(window);
		return welcome.getScene();
	}
	
	public Scene getProductsScene() {
		products = new Products(window);
		return products.getScene();
	}
	
	public Scene getTaxScene() {
		tax = new Tax(window);
		return tax.getScene();
	}
	
	public Scene getStoreScene() {
		store = new Store(window);
		return store.getScene();
	}
	
	public Scene getSalesScene() {
		sales = new Sales(window);
		return sales.getScene();
	}
	
	public Scene getCustomersScene() throws FileNotFoundException {
		customers = new Customers(window);
		return customers.getScene();
	}
	
	public Scene getManufactorsScene() {
		manufactor = new Manufactor(window);
		return manufactor.getScene();
	}
	
	// -------------------------------- Some syntax of JavaFX
	
	/* Label label = new Label("Railroad System");
	
	//String path = "file:railroadSystem.jpg";
	String path = "https://i.gyazo.com/edd809ec2e594e8e24b3fd824b1fe250.png";
	Image railroad = new Image(path);
	
	ImageView imageView = new ImageView();
	imageView.setImage(railroad);
	imageView.setFitHeight(600);
	imageView.setFitWidth(250);
    imageView.setPreserveRatio(true); 
	
	// Layout
	StackPane layout = new StackPane();
	
	StackPane.setMargin(imageView, new Insets(0,20,0,0));
	StackPane.setMargin(label, new Insets(20,0,0,20));
	StackPane.setMargin(backButton, new Insets(0,0,20,20));
	
	StackPane.setAlignment(label, Pos.TOP_LEFT);
	StackPane.setAlignment(backButton, Pos.BOTTOM_LEFT);
	StackPane.setAlignment(imageView, Pos.TOP_RIGHT);
			
	layout.getChildren().addAll(label,backButton,imageView);
	// Scene
	Scene scene = new Scene(layout, 600, 600);
	return scene;
	
	
	
	Label label = new Label("Railroad System");
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
	return scene;
	
	
	 *
	 *
	 */
	
}

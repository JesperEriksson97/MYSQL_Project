package model;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Welcome implements FXScene {
	
	Stage window;

	public Welcome(Stage window) {
		this.window = window;
	}

	@Override
	public Scene getScene() {
		// Buttons
				Button products = new Button("Products");
				Button manufactor = new Button("Manufactor");
				Button tax = new Button("Tax table");
				Button store = new Button("Stores");
				Button customer = new Button("Customers");
				Button sales = new Button("Previous Sales");
				
				// Button Actions
				products.setOnAction(e -> {
					Products prod = new Products(window);
					window.setScene(prod.getScene());
				});
				
				manufactor.setOnAction(e -> {
					Manufactor manuf = new Manufactor(window);
					window.setScene(manuf.getScene());
				});
				
				tax.setOnAction(e -> {
					Tax t = new Tax(window);
					window.setScene(t.getScene());
				});
				
				store.setOnAction(e -> {
					Store st = new Store(window);
					window.setScene(st.getScene());
				});
				
				customer.setOnAction(e -> {
					Customers c = new Customers(window);
					window.setScene(c.getScene());
				});
				
				sales.setOnAction(e -> {
					Sales s = new Sales(window);
					window.setScene(s.getScene());
				});
				
				
				// Layout
				VBox layout = new VBox();
				layout.getChildren().addAll(products,manufactor, tax, store, customer, sales);
				
				// Scene
				Scene scene = new Scene(layout, 600, 600);
				return scene;
	}

}

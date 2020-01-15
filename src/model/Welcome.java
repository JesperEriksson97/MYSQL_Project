package model;


import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

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
				Button topStore = new Button("Top Store");
				
				// Button Actions
				products.setOnAction(e -> {
					Products prod = new Products(window);
					try {
						window.setScene(prod.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				manufactor.setOnAction(e -> {
					Manufactor manuf = new Manufactor(window);
					try {
						window.setScene(manuf.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				});
				
				tax.setOnAction(e -> {
					Tax t = new Tax(window);
					try {
						window.setScene(t.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				store.setOnAction(e -> {
					Store st = new Store(window);
					try {
						window.setScene(st.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				customer.setOnAction(e -> {
					Customers c = new Customers(window);
					try {
						window.setScene(c.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				sales.setOnAction(e -> {
					Sales s = new Sales(window);
					try {
						window.setScene(s.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				topStore.setOnAction(e -> {
					TopStore ts = new TopStore(window);
					try {
						window.setScene(ts.getScene());
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException | NoSuchMethodException | SecurityException
							| ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				});
				
				
				// Layout
				VBox layout = new VBox();
				layout.getChildren().addAll(products,manufactor, tax, store, customer, sales, topStore);
				
				// Scene
				Scene scene = new Scene(layout, 600, 600);
				return scene;
	}

}

package model;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

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
	TopStore topStore;
	
	
	
	public SceneFactory(Stage window) {
		this.window = window;
	}
	
	// This class is supposed to create the needed scenes to switch between.
	
	public Scene getWelcomeScene() {
		welcome = new Welcome(window);
		return welcome.getScene();
	}
	
	public Scene getProductsScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		products = new Products(window);
		return products.getScene();
	}
	
	public Scene getTaxScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		tax = new Tax(window);
		return tax.getScene();
	}
	
	public Scene getStoreScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		store = new Store(window);
		return store.getScene();
	}
	
	public Scene getSalesScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		sales = new Sales(window);
		return sales.getScene();
	}
	
	public Scene getCustomersScene() throws FileNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		customers = new Customers(window);
		return customers.getScene();
	}
	
	public Scene getManufactorsScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		manufactor = new Manufactor(window);
		return manufactor.getScene();
	}
	
	public Scene getTopStoreScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		topStore = new TopStore(window);
		return topStore.getScene();
	}
	
}

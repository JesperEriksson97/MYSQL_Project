package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.objects.ProductObject;


public class Products implements FXScene {
	
	private dao.SQL_Connector cn;
	private String query;
	private Button backButton;
	private Stage window;
	private TableView<ProductObject> table;
	
	public Products(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT product.product_id, tax.rate, manufactor.name, product.description, product.price, product.price - (product.price * (tax.rate/100)) AS notax_price " + 
				"FROM company.product " + 
				"JOIN company.manufactor ON product.manufactor_id = manufactor.manufactor_id " +
				"JOIN company.tax ON product.tax_id = tax.tax_id;";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Products");
		
		// id column
		TableColumn<ProductObject, Integer> idColumn =  new TableColumn<>("Product ID");
		idColumn.setMinWidth(50);
		idColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, Integer>("id"));
		
		// tax column
		TableColumn<ProductObject, Integer> taxColumn =  new TableColumn<>("Tax rate(%)");
		taxColumn.setMinWidth(50);
		taxColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, Integer>("tax"));
				
		// manufactor column
		TableColumn<ProductObject, Integer> manufactorColumn =  new TableColumn<>("Manufactor");
		manufactorColumn.setMinWidth(50);
		manufactorColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, Integer>("manufactor"));
		
		// desc column
		TableColumn<ProductObject, String> descriptionColumn =  new TableColumn<>("Description");
		descriptionColumn.setMinWidth(150);
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, String>("description"));
		
		// total price column
		TableColumn<ProductObject, Integer> priceColumn =  new TableColumn<>("Total price");
		priceColumn.setMinWidth(50);
		priceColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, Integer>("price"));
		
		// total price with no tax column
		TableColumn<ProductObject, Integer> notaxColumn =  new TableColumn<>("Price (tax excluded)");
		notaxColumn.setMinWidth(50);
		notaxColumn.setCellValueFactory(new PropertyValueFactory<ProductObject, Integer>("notax"));
		
		// table set up
		table = new TableView<>();
		table.setItems(getProducts());
		table.getColumns().addAll(idColumn, taxColumn, manufactorColumn, descriptionColumn, priceColumn, notaxColumn);
		
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}

	private ObservableList<ProductObject> getProducts() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<ProductObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("product_id");
			int taxid = rs.getInt("rate");
			String manufactorid = rs.getString("name");
			String description = rs.getString("description");
			int price = rs.getInt("price");
			int notaxprice = rs.getInt("notax_price");
			
			list.add(new ProductObject(id, taxid, manufactorid, description, price, notaxprice));	
		}
		
		return list;
	}
}

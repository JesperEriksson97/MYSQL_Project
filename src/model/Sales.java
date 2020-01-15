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
import model.objects.SalesObject;
import model.objects.StoreObject;

public class Sales implements FXScene {
	private dao.SQL_Connector cn;
	private String query;
	private Button backButton;
	private Stage window;
	private TableView<SalesObject> table;
	
	public Sales(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT sales.sales_id, customer.name, product.description, store.address, sales.quantity, sales.total_price " + 
				"FROM company.sales " + 
				"JOIN company.customer ON customer.personal_id = sales.customer_nr " + 
				"JOIN company.product ON sales.product_id = product.product_id " + 
				"JOIN company.store ON sales.store_id = store.store_id;";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Previous Sales");
		
		// sale_id column
		TableColumn<SalesObject, Integer> saleidColumn =  new TableColumn<>("Sale ID");
		saleidColumn.setMinWidth(50);
		saleidColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, Integer>("sales_id"));
		
		// customer column
		TableColumn<SalesObject, String> customerColumn =  new TableColumn<>("Customer");
		customerColumn.setMinWidth(200);
		customerColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, String>("customer_name"));
			
		// product column
		TableColumn<SalesObject, String> productColumn =  new TableColumn<>("Product");
		productColumn.setMinWidth(200);
		productColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, String>("product_name"));
		
		// store column
		TableColumn<SalesObject, String> storeColumn =  new TableColumn<>("Store Location");
		storeColumn.setMinWidth(100);
		storeColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, String>("store_address"));
		
		// quantity column
		TableColumn<SalesObject, Integer> quantityColumn =  new TableColumn<>("Quantity");
		quantityColumn.setMinWidth(50);
		quantityColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, Integer>("quantity"));
		
		// total_price column
		TableColumn<SalesObject, Integer> totalPriceColumn =  new TableColumn<>("Total Price($)");
		totalPriceColumn.setMinWidth(100);
		totalPriceColumn.setCellValueFactory(new PropertyValueFactory<SalesObject, Integer>("total_price"));

		// table set up
		table = new TableView<>();
		table.setItems(getSales());
		table.getColumns().addAll(saleidColumn, customerColumn, productColumn, storeColumn , quantityColumn, totalPriceColumn);

		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<SalesObject> getSales() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<SalesObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			int saleid = rs.getInt("sales_id");
			String customer = rs.getString("name");
			String desc = rs.getString("description");
			String address = rs.getString("address");
			int quantity = rs.getInt("quantity");
			int total_price = rs.getInt("total_price");
			
			list.add(new SalesObject(saleid, customer, desc, address, quantity, total_price));	
		}
		
		return list;
	}


}

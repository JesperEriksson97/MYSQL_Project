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
import model.objects.CustomerObject;


public class Customers implements FXScene {
	
	private String query;
	dao.SQL_Connector cn;
	private Button backButton;
	private Stage window;
	TableView<CustomerObject> table;
	
	public Customers(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT * FROM company.customer";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Customers");
		
		// id column
		TableColumn<CustomerObject, Integer> idColumn =  new TableColumn<>("Customer ID");
		idColumn.setMinWidth(100);
		idColumn.setCellValueFactory(new PropertyValueFactory<CustomerObject, Integer>("id"));
		
		// name column
		TableColumn<CustomerObject, String> nameColumn =  new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<CustomerObject, String>("name"));
				
		// address column
		TableColumn<CustomerObject, String> addressColumn =  new TableColumn<>("Address");
		addressColumn.setMinWidth(200);
		addressColumn.setCellValueFactory(new PropertyValueFactory<CustomerObject, String>("address"));
		
		// country column
		TableColumn<CustomerObject, String> countryColumn =  new TableColumn<>("Country");
		countryColumn.setMinWidth(100);
		countryColumn.setCellValueFactory(new PropertyValueFactory<CustomerObject, String>("country"));
		
		table = new TableView<>();
		table.setItems(getCustomers());
		table.getColumns().addAll(idColumn, nameColumn, addressColumn, countryColumn);
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, table, backButton);
		
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<CustomerObject> getCustomers() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<CustomerObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			double id = rs.getDouble("personal_id");
			String name = rs.getString("name");
			String address = rs.getString("address");
			String country = rs.getString("country");
			System.out.println(id + " " + name + " " + address + " " + country + " ");
			list.add(new CustomerObject(id, name, address, country));	
		}
		
		return list;
	}
}

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
import model.objects.StoreObject;
import model.objects.TaxObject;

public class Store implements FXScene {

	private dao.SQL_Connector cn;
	private String query;
	private Button backButton;
	private Stage window;
	private TableView<StoreObject> table;
	
	public Store(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT * FROM company.store";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Stores table");
		
		// store_id column
		TableColumn<StoreObject, Integer> storeidColumn =  new TableColumn<>("Store ID");
		storeidColumn.setMinWidth(200);
		storeidColumn.setCellValueFactory(new PropertyValueFactory<StoreObject, Integer>("store_id"));
		
		// rate column
		TableColumn<StoreObject, String> addressColumn =  new TableColumn<>("Address");
		addressColumn.setMinWidth(200);
		addressColumn.setCellValueFactory(new PropertyValueFactory<StoreObject, String>("address"));
		
		// table set up
		table = new TableView<>();
		table.setItems(getTax());
		table.getColumns().addAll(storeidColumn, addressColumn);

		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<StoreObject> getTax() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<StoreObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			int storeid = rs.getInt("store_id");
			String address = rs.getString("address");
			
			list.add(new StoreObject(storeid, address));	
		}
		
		return list;
	}

}


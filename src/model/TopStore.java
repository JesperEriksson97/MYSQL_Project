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
import model.objects.TopStoreObject;

public class TopStore implements FXScene {

	private dao.SQL_Connector cn;
	private String query;
	private Button backButton;
	private Stage window;
	private TableView<TopStoreObject> table;
	
	public TopStore(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT address, COUNT(address) AS number_of_sales " + 
				"FROM Test " + 
				"GROUP BY address " + 
				"ORDER BY number_of_sales DESC " + 
				"LIMIT 3;";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Top Store");
		
		// store_address column
		TableColumn<TopStoreObject, Integer> storeColumn =  new TableColumn<>("Store");
		storeColumn.setMinWidth(50);
		storeColumn.setCellValueFactory(new PropertyValueFactory<TopStoreObject, Integer>("address"));
		
		// number of sales column
		TableColumn<TopStoreObject, String> salesColumn =  new TableColumn<>("Number of sales");
		salesColumn.setMinWidth(200);
		salesColumn.setCellValueFactory(new PropertyValueFactory<TopStoreObject, String>("number_of_sales"));
			
		// table set up
		table = new TableView<>();
		table.setItems(getTopStores());
		table.getColumns().addAll(storeColumn, salesColumn);

		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label, table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<TopStoreObject> getTopStores() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<TopStoreObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			String address = rs.getString("address");
			int nr_of_sales = rs.getInt("number_of_sales");
			
			
			list.add(new TopStoreObject(address, nr_of_sales));	
		}
		
		return list;
	}
}

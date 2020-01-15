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
import model.objects.ManufactorObject;

public class Manufactor implements FXScene {

	dao.SQL_Connector cn;
	private String query;
	Button backButton;
	Stage window;
	TableView<ManufactorObject> table;
	
	public Manufactor(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT * FROM company.manufactor";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Manufactors table");
		
		// id column
		TableColumn<ManufactorObject, Integer> idColumn =  new TableColumn<>("Manufactor_ID");
		idColumn.setMinWidth(200);
		idColumn.setCellValueFactory(new PropertyValueFactory<ManufactorObject, Integer>("id"));
		
		System.out.println("gets here");
		
		// id column
		TableColumn<ManufactorObject, String> nameColumn =  new TableColumn<>("Name");
		nameColumn.setMinWidth(200);
		nameColumn.setCellValueFactory(new PropertyValueFactory<ManufactorObject, String>("name"));
		
		table = new TableView<>();
		table.setItems(getManufactors());
		table.getColumns().addAll(idColumn, nameColumn);
		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label,  table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<ManufactorObject> getManufactors() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<ManufactorObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			int id = rs.getInt("manufactor_id");
			String name = rs.getString("name");
			System.out.println(id + " " + name);
			list.add(new ManufactorObject(id, name));	
		}
		
		return list;
	}

}

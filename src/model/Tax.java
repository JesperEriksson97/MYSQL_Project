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
import model.objects.TaxObject;

public class Tax implements FXScene{
	
	private dao.SQL_Connector cn;
	private String query;
	private Button backButton;
	private Stage window;
	private TableView<TaxObject> table;
	
	public Tax(Stage window) {
		this.window = window;
		cn = new dao.SQL_Connector();
		query = "SELECT * FROM company.tax";
	}
	@SuppressWarnings("unchecked")
	@Override
	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		backButton = new BackButton(window);
		Label label = new Label("Tax table");
		
		// tax_id column
		TableColumn<TaxObject, Integer> taxidColumn =  new TableColumn<>("Tax ID");
		taxidColumn.setMinWidth(200);
		taxidColumn.setCellValueFactory(new PropertyValueFactory<TaxObject, Integer>("tax_id"));
		
		// rate column
		TableColumn<TaxObject, Integer> rateColumn =  new TableColumn<>("Tax rate(%)");
		rateColumn.setMinWidth(200);
		rateColumn.setCellValueFactory(new PropertyValueFactory<TaxObject, Integer>("rate"));
		
		// table set up
		table = new TableView<>();
		table.setItems(getTax());
		table.getColumns().addAll(taxidColumn, rateColumn);

		// Layout
		VBox layout = new VBox();
		layout.getChildren().addAll(label,table, backButton);
				
		// Scene
		Scene scene = new Scene(layout, 600, 600);
		return scene;
	}
	
	private ObservableList<TaxObject> getTax() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
		ObservableList<TaxObject> list = FXCollections.observableArrayList();
		ResultSet rs = cn.doQuery(query);
		
		while(rs.next()) {
			int taxid = rs.getInt("tax_id");
			int rate = rs.getInt("rate");
			
			list.add(new TaxObject(taxid, rate));	
		}
		
		return list;
	}

}

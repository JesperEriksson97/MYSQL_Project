package model;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javafx.scene.Scene;

public interface FXScene {

	public Scene getScene() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException;
}

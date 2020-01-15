package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class SQL_Connector {

	static Connection connection = null;
	static String databaseName = "company";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false";
	private static java.sql.Statement stmt;
	
	static String username = "root";
	static String password = "kommer10";
	
	BufferedReader reader;
	
	public SQL_Connector() {
			
	}
		
	public ResultSet doQuery(String sql) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, SQLException {
			
		Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
		connection = DriverManager.getConnection(url, username, password);
		
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
		
	}
	
}
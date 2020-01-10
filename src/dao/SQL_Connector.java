package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class SQL_Connector {

	static Connection connection = null;
	static String databaseName = "reddit";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName + "?useSSL=false";
	
	static String username = "root";
	static String password = "kommer10";
	java.sql.PreparedStatement ps_id = null;
	BufferedReader reader;
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, SQLException, IOException {
		
		long startTime = System.nanoTime();
		JSONDecoder jd = new JSONDecoder();
		jd.createTables("reddit"); // real deal
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in seconds:" + (timeElapsed / 1000000) / 1000);
		System.out.println("Execution time in miliseconds:" + (timeElapsed / 1000000));
		// jd.createTables("reddit"); // test
		
		/* for(long i = 0; i < jo.size(); i++) {
			
			 Creating tables.
			ps_id = connection.prepareStatement("INSERT INTO `reddit200710`.`2011`(`id`, `parent_id`, `link_id`, `name`, `author`, `body`, `subreddit_id`, `subreddit`, `score`, `created_utc`) VALUES ('"+jo.get((int)i).get("id")+"', '"
					+ jo.get((int) i).get("parent_id")+"', '"
					+ jo.get((int) i).get("link_id")+"', '"
					+ jo.get((int) i).get("name")+"', '"
					+ jo.get((int) i).get("author")+"', '"
					+ StringEscapeUtils.escapeEcmaScript((jo.get((int) i).get("body")).toString()) +"', '"
					+ jo.get((int) i).get("subreddit_id")+"', '"
					+ jo.get((int) i).get("subreddit")+"', '"
					+ jo.get((int) i).get("score")+"', '"
					+ jo.get((int) i).get("created_utc")+"')");
			
			// Executing Query.
			int log = ps_id.executeUpdate();
			System.out.println("LOG :" + log);
			
			ps_id = null; */

			
		}
	
	}
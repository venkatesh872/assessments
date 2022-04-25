package com.thoughtFocus.mobile_applications;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.Server;

public class MobileApplicationsClass {

	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
		createTable(connection);
		insertRecord(connection);
		updateRecord(connection,67000,"Instagram");
		updateRecord(connection,67.8,102);
		updateRecord(connection,false,"education");
		deleteRecord(connection);
		try {
			Server.startWebServer(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:ThoughtFocus", "sa", "sa");
			if (con != null) {
				System.out.println("connection acquired successfully");
			} else {
				System.out.println("connection failed");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static final String  createTableQuery = "CREATE TABLE mobile_app " + 
											"(id INTEGER primary key, "+
											" app_name VARCHAR(25), " +
											" app_type VARCHAR(25), " +
											" size double, " + 
											" free boolean, " +
											" internet_access boolean, " +
											" no_of_users long)";
	
	public static final String insertQuery = "INSERT INTO mobile_app VALUES ("+
											"?,"+ //1 index position
											"?,"+ //2 index position
											"?,"+ //3 index position
											"?,"+ //4 index position
											"?,"+ //5 index position
											"?,"+ //6 index position
											"?)";//7 index position
											
	
	public static final String update =" UPDATE mobile_app "+ "SET no_of_users=? "+" where app_name =?";
	public static final String update1 =" UPDATE mobile_app "+ "SET size=? "+" where id =?";
	public static final String update2 =" UPDATE mobile_app "+ "SET free=? "+" where app_type =?";
	
	private static String deleteQuery="DELETE from mobile_app where internet_access=false and no_of_users <1000";
	


	private static void createTable(Connection connection) {
		Statement statement ;

		try {
			statement = connection.createStatement();
			statement.execute(createTableQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		

	}
	private static void insertRecord(Connection connection) {
		
		try(PreparedStatement preparedStatement =connection.prepareStatement(insertQuery)) {
			

			preparedStatement.setInt(1, 101);
			preparedStatement.setString(2,"Instagram");
			preparedStatement.setString(3, "social");
			preparedStatement.setDouble(4, 98.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 20000);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 102);
			preparedStatement.setString(2,"Flipkart");
			preparedStatement.setString(3, "shopping");
			preparedStatement.setDouble(4, 58.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 123456);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 103);
			preparedStatement.setString(2,"Paytm");
			preparedStatement.setString(3, "paying_type");
			preparedStatement.setDouble(4, 78.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 43536);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 104);
			preparedStatement.setString(2,"youtube");
			preparedStatement.setString(3, "social");
			preparedStatement.setDouble(4, 78.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 695659);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 105);
			preparedStatement.setString(2,"Facebook");
			preparedStatement.setString(3, "social");
			preparedStatement.setDouble(4, 56.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 9536484);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 106);
			preparedStatement.setString(2,"Mynthra");
			preparedStatement.setString(3, "shopping");
			preparedStatement.setDouble(4, 34.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 3546758);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 107);
			preparedStatement.setString(2,"Udemy");
			preparedStatement.setString(3, "education");
			preparedStatement.setDouble(4, 789.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 63740);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 108);
			preparedStatement.setString(2,"gaana");
			preparedStatement.setString(3, "music_app");
			preparedStatement.setDouble(4, 234.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7,74895);
			preparedStatement.execute();
			
			
			preparedStatement.setInt(1, 109);
			preparedStatement.setString(2,"WynkMusic");
			preparedStatement.setString(3, "music_app");
			preparedStatement.setDouble(4, 97.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, false);
			preparedStatement.setLong(7, 789);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 110);
			preparedStatement.setString(2,"Google");
			preparedStatement.setString(3, "social");
			preparedStatement.setDouble(4, 90.7);
			preparedStatement.setBoolean(5, true);
			preparedStatement.setBoolean(6, true);
			preparedStatement.setLong(7, 2000);
			preparedStatement.execute();
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void updateRecord(Connection connection,long no_of_users,String app_name ) {
		
		try (PreparedStatement preparedStatement =connection.prepareStatement(update)){
			
			preparedStatement.setDouble(1, no_of_users);
		preparedStatement.setString(2, app_name);
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
			e.printStackTrace();
		}
	}
private static void updateRecord(Connection connection,double size,Integer id ) {
		
		try (PreparedStatement preparedStatement =connection.prepareStatement(update1)){
			
			preparedStatement.setDouble(1, size);
		preparedStatement.setInt(2, id);
		preparedStatement.executeUpdate();
	} catch (SQLException e) {
			e.printStackTrace();
		}
	}
private static void updateRecord(Connection connection,boolean free,String app_type ) {
	
	try (PreparedStatement preparedStatement =connection.prepareStatement(update2)){
		
		preparedStatement.setBoolean(1, free);
	preparedStatement.setString(2, app_type);
	preparedStatement.executeUpdate();
} catch (SQLException e) {
		e.printStackTrace();
	}
}


private static void deleteRecord(Connection connection) {
		PreparedStatement preparedStatement = null;
		try {
			
			preparedStatement =connection.prepareStatement(deleteQuery);
	
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

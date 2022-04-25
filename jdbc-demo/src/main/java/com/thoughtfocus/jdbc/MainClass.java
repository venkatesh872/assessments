package com.thoughtfocus.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.h2.tools.Server;

public class MainClass {

	public static void main(String[] args) {
		Connection connection = getConnection();
		System.out.println(connection);
		createTable(connection);
		insertRecord(connection);
		updateRecord(connection, 8999.23, "Lenovo");
		deleteRecord(connection);
		readLaptopById(connection, 103);
		readBrandAndStorageById(connection, 102);
		readAll(connection);
		readAllByPriceGreaterThan50000(connection);
		readIdAndPriceByStorageEqualto500(connection);
		
		
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

	public static final String createTableQuery = "CREATE TABLE laptop " + "(id INTEGER primary key, "
			+ " brand VARCHAR(255), " + " ram number, " + " storage INTEGER, " + "price double)";

	public static final String insertQuery = "INSERT INTO laptop VALUES (" + "?," + // 1 index position
			"?," + // 2 index position
			"?," + // 3 index position
			"?," + // 4 index position
			"?)"; // 5 index position

	public static final String update = " UPDATE laptop " + "SET price=? " + " where brand =?";

	private static String deleteQuery = "DELETE from laptop where id=101";

	

	private static void createTable(Connection connection) {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(createTableQuery);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void insertRecord(Connection connection) {

		try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setInt(1, 101);
			preparedStatement.setString(2, "Apple");
			preparedStatement.setInt(3, 8);
			preparedStatement.setInt(4, 500);
			preparedStatement.setDouble(5, 54667.23);
			preparedStatement.execute();

			preparedStatement.setInt(1, 102);
			preparedStatement.setString(2, "Dell");
			preparedStatement.setInt(3, 16);
			preparedStatement.setInt(4, 256);
			preparedStatement.setDouble(5, 78967.23);
			preparedStatement.execute();

			preparedStatement.setInt(1, 103);
			preparedStatement.setString(2, "acer");
			preparedStatement.setInt(3, 16);
			preparedStatement.setInt(4, 500);
			preparedStatement.setDouble(5, 34667.23);
			preparedStatement.execute();

			preparedStatement.setInt(1, 104);
			preparedStatement.setString(2, "hp");
			preparedStatement.setInt(3, 8);
			preparedStatement.setInt(4, 256);
			preparedStatement.setDouble(5, 87667.23);
			preparedStatement.execute();

			preparedStatement.setInt(1, 105);
			preparedStatement.setString(2, "Lenovo");
			preparedStatement.setInt(3, 32);
			preparedStatement.setInt(4, 500);
			preparedStatement.setDouble(5, 44667.23);
			preparedStatement.execute();
			
			preparedStatement.setInt(1, 106);
			preparedStatement.setString(2, "Sony");
			preparedStatement.setInt(3, 32);
			preparedStatement.setInt(4, 500);
			preparedStatement.setDouble(5, 34667.23);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateRecord(Connection connection, double price, String brand) {

		try (PreparedStatement preparedStatement = connection.prepareStatement(update)) {

			preparedStatement.setDouble(1, price);
			preparedStatement.setString(2, brand);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void deleteRecord(Connection connection) {
		PreparedStatement preparedStatement = null;
		try {

			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void readLaptopById(Connection connection, int primaryKey) {
		String query = "SELECT brand,price FROM laptop WHERE id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("Read brand and price from laptop by id 103");
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, primaryKey);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// print the result
				String brand = resultSet.getString("brand");
				double price = resultSet.getDouble("price");
			
				System.out.println("Brand: " + brand);
				System.out.println("Price: " + price);
				
			} else {
				System.out.println("No result found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static void readBrandAndStorageById(Connection connection, int primaryKey) {
		String query = "SELECT brand,storage FROM laptop WHERE id=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("-----------------------------------------------------------");
		System.out.println("Read brand and storage from laptop by id 102");
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, primaryKey);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				// print the result
				String brand = resultSet.getString("brand");
				double price = resultSet.getDouble("storage");
			

				System.out.println("Brand: " + brand);
				System.out.println("Storage: " + price);
				
			} else {
				System.out.println("No result found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static void readAll(Connection connection) {
		String query = "SELECT * FROM laptop";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("-----------------------------------------------------------");
		System.out.println("Read All from laptop");

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String brand = resultSet.getString("brand");
				int ram = resultSet.getInt("ram");
				int storage = resultSet.getInt("storage");
				double price = resultSet.getDouble("price");
	
				
				System.out.println(
						id + "," + brand + "," + ram + ","+storage+"," + price);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private static void readAllByPriceGreaterThan50000(Connection connection) {
		String query = "SELECT * FROM laptop WHERE price>50000";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("-----------------------------------------------------------");
		System.out.println("Read All by price >50000:");
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String brand = resultSet.getString("brand");
				int ram = resultSet.getInt("ram");
				int storage = resultSet.getInt("storage");
				double price = resultSet.getDouble("price");
			
				
				System.out.println(
						id + "," + brand + "," + ram + ","+storage+"," + price);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private static void readIdAndPriceByStorageEqualto500(Connection connection) {
		String query = "SELECT id,price FROM laptop WHERE storage=500";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		System.out.println("-----------------------------------------------------------");
		System.out.println("Read id and price from laptop where storage=500:");

		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
		
				double price = resultSet.getDouble("price");
				
				System.out.println("Id: "+id);
				System.out.println("price: "+price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
	
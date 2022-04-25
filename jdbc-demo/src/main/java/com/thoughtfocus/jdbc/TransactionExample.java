package com.thoughtfocus.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private static void createMobileTable() {
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(createTableQuery);
			statement.execute(createTableQuery);
			System.out.println("Creation of table is successful");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		

	}

}

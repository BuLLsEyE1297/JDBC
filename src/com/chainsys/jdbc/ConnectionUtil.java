package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static void main(String[] args) throws SQLException,
		ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = DriverManager.getConnection(url, "hr", "hr");
		System.out.println(connection);
		String sql = "select id, name,price from book";
		System.out.println(sql);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// int rows = preparedStatement . executeUpdate();
		// System.out.println("rows inserted"+ rows);
		ResultSet rset = preparedStatement.executeQuery();
		while (rset.next()) {
			System.out.println(rset.getInt("id"));
			System.out.println(rset.getString("name"));
			System.out.println(rset.getInt("price"));

		}

	}

}

package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class SampleJdbc {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = DriverManager.getConnection(url, "hr", "hr");
		System.out.println(connection);
		int rows = 0, id = 0, price = 0;
		String name = "";
		Scanner scanner = new Scanner(System.in);
		String sql = "insert into book(id,name,price) values(?,?,?)";
		System.out.println(sql);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		for (int i = 0; i < 3; i++) {
			id = scanner.nextInt();
			name = scanner.next();
			price = scanner.nextInt();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3, price);
			rows = preparedStatement.executeUpdate();
		}

		System.out.println("rows inserted" + rows);
		scanner.close();

	}
}

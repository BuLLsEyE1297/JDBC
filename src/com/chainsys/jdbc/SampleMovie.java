package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SampleMovie {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection connection = DriverManager.getConnection(url, "hr", "hr");
		System.out.println(connection);
		@SuppressWarnings("unused")
		int rows = 0, seat = 0, id = 0, price = 0;
		@SuppressWarnings("unused")
		String movie = "";
		Scanner scanner = new Scanner(System.in);
		//String sql = "insert into movies(id,movie,seat,price) values(?,?,?,?)";

		//System.out.println(sql);
		//rows = getinginput(rows, scanner, preparedStatement);

		System.out.println("rows inserted" + rows);

		String sql="select id,movie,seat,price from movies where movie like 'A%'  order by movie ASC";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		ResultSet rset = preparedStatement.executeQuery();
		System.out.println("the outputs are");
		while (rset.next()) {
			
			System.out.println(rset.getInt("id"));
			System.out.println(rset.getString("name"));
			System.out.println(rset.getInt("price"));
		}
			
		scanner.close();
	}
	
	@SuppressWarnings("unused")
	private static int getinginput(int rows, Scanner scanner,
			PreparedStatement preparedStatement) throws SQLException {
		int seat;
		int id;
		int price;
		String movie;
		for (int i = 0; i < 5; i++) {
			id = scanner.nextInt();
			movie = scanner.next();
			seat = scanner.nextInt();
			price = scanner.nextInt();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, movie);
			preparedStatement.setInt(3, seat);
			preparedStatement.setInt(4, price);
			rows = preparedStatement.executeUpdate();
		}
		return rows;
	
	}
	
	
}

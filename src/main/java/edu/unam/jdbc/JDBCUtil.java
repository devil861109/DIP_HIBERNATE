package edu.unam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String URL = "jdbc:mariadb://localhost:3306/jdbc";
			String USER = "root";
			String PASS = "d1p10m4d0j4v4";
			conn = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
		return conn;
	}
}

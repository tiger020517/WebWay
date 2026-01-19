package problem_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
	private static final String DB_URL = "jdbc:sqlite:pom.db";
	private static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(DB_URL);
				System.out.println("DB/ON");
			} catch (SQLException e) {
				System.err.println("DB/ER: " + e.getMessage());
				return null;
			}
		}
		return conn;
	}
}

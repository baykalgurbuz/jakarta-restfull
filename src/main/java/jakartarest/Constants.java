package jakartarest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Constants
{
	public static final String USER = "postgres";

	public static final String PASSWORD = "sql123";

	public static final String URL = "jdbc:postgresql://127.0.0.1:5433/OBS";

	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			System.err.println("Hata bulundu");
		}
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
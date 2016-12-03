package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	public static Connection connect() throws SQLException {

		try {
			Class.forName(DbAccessConfig.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(DbAccessConfig.DB_URL,
				DbAccessConfig.USER, DbAccessConfig.PASS);

	}
}

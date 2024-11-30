package exercise1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static final String DB_URL = "199.212.26.208";
  private static final String DB_USER = "COMP228_F24_soh_22";
  private static final String DB_PASSWORD = "luizlindo";
  private static Connection connection;

  public static Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
    return connection;
  }
}


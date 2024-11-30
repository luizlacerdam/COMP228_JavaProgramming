package exercise1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
  public static void main(String[] args) {
    try (Connection connection = DatabaseConnection.getConnection()) {
      if (connection != null) {
        System.out.println("Connection to Oracle database established successfully.");

        // Example SELECT query
        String query = "SELECT * FROM Game";

        // Execute the query
        try (Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)) {

          // Process the results
          while (resultSet.next()) {
            int gameId = resultSet.getInt("game_id");
            String gameTitle = resultSet.getString("game_title");
            System.out.printf("Game ID: %d, Game Title: %s%n", gameId, gameTitle);
          }
        }
      }
    } catch (SQLException e) {
      System.err.println("Failed to connect to Oracle database or execute query.");
      e.printStackTrace();
    }
  }
}

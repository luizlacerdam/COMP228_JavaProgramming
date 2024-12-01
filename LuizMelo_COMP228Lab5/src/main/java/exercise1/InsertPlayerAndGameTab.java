package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertPlayerAndGameTab {
  public static JPanel createInsertPlayerAndGameTab() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    // ComboBoxes for selecting players and games
    JComboBox<String> playerComboBox = new JComboBox<>();
    JComboBox<String> gameComboBox = new JComboBox<>();

    // Input fields for date and score
    JTextField dateField = new JTextField();
    JTextField scoreField = new JTextField();

    // Button to insert data
    JButton insertButton = new JButton("Insert Data");

    // Populate player and game combo boxes
    try (Connection connection = DatabaseConnection.getConnection()) {
      // Populate players
      String playerQuery = "SELECT player_id, first_name, last_name FROM Player";
      try (PreparedStatement psPlayer = connection.prepareStatement(playerQuery);
          ResultSet rsPlayer = psPlayer.executeQuery()) {
        while (rsPlayer.next()) {
          String player = rsPlayer.getInt("player_id") + " - " + rsPlayer.getString("first_name") + " " + rsPlayer.getString("last_name");
          playerComboBox.addItem(player);
        }
      }

      // Populate games
      String gameQuery = "SELECT game_id, game_title FROM Game";
      try (PreparedStatement psGame = connection.prepareStatement(gameQuery);
          ResultSet rsGame = psGame.executeQuery()) {
        while (rsGame.next()) {
          String game = rsGame.getInt("game_id") + " - " + rsGame.getString("game_title");
          gameComboBox.addItem(game);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(panel, "Failed to load players or games.");
    }

    // Add components to the panel
    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(new JLabel("Select Player:"), gbc);

    gbc.gridx = 1;
    panel.add(playerComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(new JLabel("Select Game:"), gbc);

    gbc.gridx = 1;
    panel.add(gameComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(new JLabel("Playing Date (YYYY-MM-DD):"), gbc);

    gbc.gridx = 1;
    panel.add(dateField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(new JLabel("Score:"), gbc);

    gbc.gridx = 1;
    panel.add(scoreField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 4;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(insertButton, gbc);

    // Add ActionListener to handle the insert operation
    insertButton.addActionListener((ActionEvent e) -> {
      String selectedPlayer = (String) playerComboBox.getSelectedItem();
      String selectedGame = (String) gameComboBox.getSelectedItem();
      String playingDate = dateField.getText();
      String scoreText = scoreField.getText();

      if (selectedPlayer == null || selectedGame == null || playingDate.isEmpty() || scoreText.isEmpty()) {
        JOptionPane.showMessageDialog(panel, "All fields must be filled.");
        return;
      }

      try {
        int playerId = Integer.parseInt(selectedPlayer.split(" - ")[0]); // Extract player_id
        int gameId = Integer.parseInt(selectedGame.split(" - ")[0]);   // Extract game_id
        int score = Integer.parseInt(scoreText); // Convert score to integer

        try (Connection connection = DatabaseConnection.getConnection()) {
          String insertSQL = """
                        INSERT INTO PlayerAndGame (player_game_id, game_id, player_id, playing_date, score)
                        VALUES (player_game_seq.NEXTVAL, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?)
                    """;
          try (PreparedStatement psInsert = connection.prepareStatement(insertSQL)) {
            psInsert.setInt(1, gameId);
            psInsert.setInt(2, playerId);
            psInsert.setString(3, playingDate);
            psInsert.setInt(4, score);
            psInsert.executeUpdate();
            JOptionPane.showMessageDialog(panel, "Data inserted successfully!");
          }
        }
      } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(panel, "Score must be a valid integer.");
      } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(panel, "Failed to insert data.");
      }
    });

    return panel;
  }
}

package exercise1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerGameReportTab {
  public static JPanel createPlayerGameReportTab() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    JComboBox<String> playerComboBox = new JComboBox<>();

    DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Game Title", "Playing Date", "Score"}, 0);
    JTable reportTable = new JTable(tableModel);

    try (Connection connection = DatabaseConnection.getConnection()) {
      String playerQuery = "SELECT player_id, first_name, last_name FROM Player";
      try (PreparedStatement psPlayer = connection.prepareStatement(playerQuery);
          ResultSet rsPlayer = psPlayer.executeQuery()) {
        while (rsPlayer.next()) {
          String player = rsPlayer.getInt("player_id") + " - " + rsPlayer.getString("first_name") + " " + rsPlayer.getString("last_name");
          playerComboBox.addItem(player);
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(panel, "Failed to load players.");
    }

    // Listener to load report when a player is selected
    playerComboBox.addActionListener(e -> {
      String selectedPlayer = (String) playerComboBox.getSelectedItem();
      if (selectedPlayer != null) {
        int playerId = Integer.parseInt(selectedPlayer.split(" - ")[0]); // Extract player_id
        loadReport(playerId, tableModel);
      }
    });

    JPanel topPanel = new JPanel();
    topPanel.add(new JLabel("Select Player:"));
    topPanel.add(playerComboBox);
    panel.add(topPanel, BorderLayout.NORTH);

    JScrollPane tableScrollPane = new JScrollPane(reportTable);
    panel.add(tableScrollPane, BorderLayout.CENTER);

    return panel;
  }

  private static void loadReport(int playerId, DefaultTableModel tableModel) {
    tableModel.setRowCount(0);

    String reportQuery = """
            SELECT g.game_title, TO_CHAR(pg.playing_date, 'YYYY-MM-DD') AS playing_date, pg.score
            FROM PlayerAndGame pg
            INNER JOIN Game g ON pg.game_id = g.game_id
            WHERE pg.player_id = ?
            ORDER BY pg.playing_date DESC
        """;

    try (Connection connection = DatabaseConnection.getConnection();
        PreparedStatement psReport = connection.prepareStatement(reportQuery)) {
      psReport.setInt(1, playerId);
      try (ResultSet rsReport = psReport.executeQuery()) {
        while (rsReport.next()) {
          String gameTitle = rsReport.getString("game_title");
          String playingDate = rsReport.getString("playing_date"); // Date without time
          int score = rsReport.getInt("score");

          tableModel.addRow(new Object[]{gameTitle, playingDate, score});
        }
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
      JOptionPane.showMessageDialog(null, "Failed to load report data.");
    }
  }
}

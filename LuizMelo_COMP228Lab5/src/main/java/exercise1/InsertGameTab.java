package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertGameTab {
  public static JPanel createInsertGameTab() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;


    JTextField gameTitleField = new JTextField(20);
    gameTitleField.setPreferredSize(new Dimension(300, 30));

    JButton insertButton = new JButton("Insert Game");
    insertButton.setPreferredSize(new Dimension(150, 40));


    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(new JLabel("Game Title:"), gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    panel.add(gameTitleField, gbc);


    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(insertButton, gbc);


    insertButton.addActionListener((ActionEvent e) -> {
      String gameTitle = gameTitleField.getText();

      if (gameTitle.isEmpty()) {
        JOptionPane.showMessageDialog(panel, "Game title cannot be empty!");
        return;
      }

      try (Connection connection = DatabaseConnection.getConnection()) {
        connection.setAutoCommit(false);


        String insertGameSQL = """
                    INSERT INTO Game (game_id, game_title)
                    VALUES (game_seq.NEXTVAL, ?)
                """;
        try (PreparedStatement psGame = connection.prepareStatement(insertGameSQL)) {
          psGame.setString(1, gameTitle);
          psGame.executeUpdate();

          connection.commit();
          JOptionPane.showMessageDialog(panel, "Game inserted successfully!");
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(panel, "Failed to insert game.");
      }
    });

    return panel;
  }
}

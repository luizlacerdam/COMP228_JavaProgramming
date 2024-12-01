package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePlayerTab {
  public static JPanel createUpdatePlayerTab() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JComboBox<String> playerComboBox = new JComboBox<>();

    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField postalCodeField = new JTextField();
    JTextField provinceField = new JTextField();
    JTextField phoneNumberField = new JTextField();

    JButton updateButton = new JButton("Update Player");

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

    gbc.gridx = 0;
    gbc.gridy = 0;
    panel.add(new JLabel("Select Player:"), gbc);

    gbc.gridx = 1;
    panel.add(playerComboBox, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
    panel.add(new JLabel("First Name:"), gbc);

    gbc.gridx = 1;
    panel.add(firstNameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    panel.add(new JLabel("Last Name:"), gbc);

    gbc.gridx = 1;
    panel.add(lastNameField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 3;
    panel.add(new JLabel("Address:"), gbc);

    gbc.gridx = 1;
    panel.add(addressField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 4;
    panel.add(new JLabel("Postal Code:"), gbc);

    gbc.gridx = 1;
    panel.add(postalCodeField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 5;
    panel.add(new JLabel("Province:"), gbc);

    gbc.gridx = 1;
    panel.add(provinceField, gbc);

    gbc.gridx = 0;
    gbc.gridy = 6;
    panel.add(new JLabel("Phone Number:"), gbc);

    gbc.gridx = 1;
    panel.add(phoneNumberField, gbc);

    gbc.gridx = 1;
    gbc.gridy = 7;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(updateButton, gbc);

    playerComboBox.addItemListener((ItemEvent e) -> {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        String selectedPlayer = (String) playerComboBox.getSelectedItem();
        if (selectedPlayer != null) {
          int playerId = Integer.parseInt(selectedPlayer.split(" - ")[0]);
          try (Connection connection = DatabaseConnection.getConnection()) {
            String query = """
                            SELECT first_name, last_name, address, postal_code, province, phone_number
                            FROM Player
                            WHERE player_id = ?
                        """;
            try (PreparedStatement ps = connection.prepareStatement(query)) {
              ps.setInt(1, playerId);
              try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                  firstNameField.setText(rs.getString("first_name"));
                  lastNameField.setText(rs.getString("last_name"));
                  addressField.setText(rs.getString("address"));
                  postalCodeField.setText(rs.getString("postal_code"));
                  provinceField.setText(rs.getString("province"));
                  phoneNumberField.setText(rs.getString("phone_number"));
                }
              }
            }
          } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(panel, "Failed to load player details.");
          }
        }
      }
    });

    updateButton.addActionListener((ActionEvent e) -> {
      String selectedPlayer = (String) playerComboBox.getSelectedItem();
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String address = addressField.getText();
      String postalCode = postalCodeField.getText();
      String province = provinceField.getText();
      String phoneNumber = phoneNumberField.getText();

      if (selectedPlayer == null || firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() ||
          postalCode.isEmpty() || province.isEmpty() || phoneNumber.isEmpty()) {
        JOptionPane.showMessageDialog(panel, "All fields must be filled.");
        return;
      }

      try {
        int playerId = Integer.parseInt(selectedPlayer.split(" - ")[0]); // Extract player_id

        try (Connection connection = DatabaseConnection.getConnection()) {
          String updateSQL = """
                        UPDATE Player
                        SET first_name = ?, last_name = ?, address = ?, postal_code = ?, province = ?, phone_number = ?
                        WHERE player_id = ?
                    """;
          try (PreparedStatement psUpdate = connection.prepareStatement(updateSQL)) {
            psUpdate.setString(1, firstName);
            psUpdate.setString(2, lastName);
            psUpdate.setString(3, address);
            psUpdate.setString(4, postalCode);
            psUpdate.setString(5, province);
            psUpdate.setString(6, phoneNumber);
            psUpdate.setInt(7, playerId);
            psUpdate.executeUpdate();
            JOptionPane.showMessageDialog(panel, "Player updated successfully!");
          }
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(panel, "Failed to update player.");
      }
    });

    return panel;
  }
}

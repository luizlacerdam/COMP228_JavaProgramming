package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPlayerTab {
  public static JPanel createInsertPlayerTab() {
    JPanel panel = new JPanel(new GridLayout(7, 2));

    // Input fields for player data
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField postalCodeField = new JTextField();
    JTextField provinceField = new JTextField();
    JTextField phoneNumberField = new JTextField();

    JButton insertButton = new JButton("Insert Player");

    // Add components to the panel
    panel.add(new JLabel("First Name:"));
    panel.add(firstNameField);
    panel.add(new JLabel("Last Name:"));
    panel.add(lastNameField);
    panel.add(new JLabel("Address:"));
    panel.add(addressField);
    panel.add(new JLabel("Postal Code:"));
    panel.add(postalCodeField);
    panel.add(new JLabel("Province:"));
    panel.add(provinceField);
    panel.add(new JLabel("Phone Number:"));
    panel.add(phoneNumberField);

    panel.add(new JLabel());
    panel.add(insertButton);

    insertButton.addActionListener((ActionEvent e) -> {
      String firstName = firstNameField.getText();
      String lastName = lastNameField.getText();
      String address = addressField.getText();
      String postalCode = postalCodeField.getText();
      String province = provinceField.getText();
      String phoneNumber = phoneNumberField.getText();

      try (Connection connection = DatabaseConnection.getConnection()) {
        connection.setAutoCommit(false);

        // Insert Player into the database
        String insertPlayerSQL = """
                    INSERT INTO Player (player_id, first_name, last_name, address, postal_code, province, phone_number)
                    VALUES (player_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)
                """;
        try (PreparedStatement psPlayer = connection.prepareStatement(insertPlayerSQL)) {
          psPlayer.setString(1, firstName);
          psPlayer.setString(2, lastName);
          psPlayer.setString(3, address);
          psPlayer.setString(4, postalCode);
          psPlayer.setString(5, province);
          psPlayer.setString(6, phoneNumber);
          psPlayer.executeUpdate();

          connection.commit();
          JOptionPane.showMessageDialog(panel, "Player inserted successfully!");
        }
      } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(panel, "Failed to insert player.");
      }
    });

    return panel;
  }
}

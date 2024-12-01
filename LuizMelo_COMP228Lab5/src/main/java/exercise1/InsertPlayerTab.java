package exercise1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPlayerTab {
  public static JPanel createInsertPlayerTab() {
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;

    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField addressField = new JTextField();
    JTextField postalCodeField = new JTextField();
    JTextField provinceField = new JTextField();
    JTextField phoneNumberField = new JTextField();

    JButton insertButton = new JButton("Insert Player");


    Dimension fieldSize = new Dimension(300, 30); // Width: 300px, Height: 30px
    Dimension buttonSize = new Dimension(150, 40); // Width: 150px, Height: 40px

    firstNameField.setPreferredSize(fieldSize);
    lastNameField.setPreferredSize(fieldSize);
    addressField.setPreferredSize(fieldSize);
    postalCodeField.setPreferredSize(fieldSize);
    provinceField.setPreferredSize(fieldSize);
    phoneNumberField.setPreferredSize(fieldSize);
    insertButton.setPreferredSize(buttonSize);

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    panel.add(new JLabel("First Name:"), gbc);

    gbc.gridx = 1;
    panel.add(firstNameField, gbc);

    gbc.gridx = 0; gbc.gridy = 1;
    panel.add(new JLabel("Last Name:"), gbc);

    gbc.gridx = 1;
    panel.add(lastNameField, gbc);

    gbc.gridx = 0; gbc.gridy = 2;
    panel.add(new JLabel("Address:"), gbc);

    gbc.gridx = 1;
    panel.add(addressField, gbc);

    gbc.gridx = 0; gbc.gridy = 3;
    panel.add(new JLabel("Postal Code:"), gbc);

    gbc.gridx = 1;
    panel.add(postalCodeField, gbc);

    gbc.gridx = 0; gbc.gridy = 4;
    panel.add(new JLabel("Province:"), gbc);

    gbc.gridx = 1;
    panel.add(provinceField, gbc);

    gbc.gridx = 0; gbc.gridy = 5;
    panel.add(new JLabel("Phone Number:"), gbc);

    gbc.gridx = 1;
    panel.add(phoneNumberField, gbc);

    gbc.gridx = 1; gbc.gridy = 6;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(insertButton, gbc);

    // Add ActionListener to handle the insert operation
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

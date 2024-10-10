package exercise1;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
      String[] options = {"Health Insurance", "Life Insurance"};
      int choice = JOptionPane.showOptionDialog(
          null,
          "Select Insurance Type",
          "Insurance Selector",
          JOptionPane.DEFAULT_OPTION,
          JOptionPane.INFORMATION_MESSAGE,
          null,
          options,
          options[0]
      );

      String monthlyCost = JOptionPane.showInputDialog(null, "Enter the insurance monthly cost:", "Monthly Cost Input", JOptionPane.QUESTION_MESSAGE);

      if (choice == 0) {
        Health health = new Health();
        health.setInsuranceCost(Double.parseDouble(monthlyCost));
        health.displayInfo();
      } else if (choice == 1) {
        Life life = new Life();
        life.setInsuranceCost(Double.parseDouble(monthlyCost));
        life.displayInfo();
      } else {
        JOptionPane.showMessageDialog(null, "No selection was made.");
      }
    }
}

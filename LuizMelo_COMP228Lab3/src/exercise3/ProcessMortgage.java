package exercise3;

import javax.swing.*;

public class ProcessMortgage {
  public static void main(String[] args) {
    String primeRateStr = JOptionPane.showInputDialog("Enter the current prime interest rate:");
    double primeRate = Double.parseDouble(primeRateStr);
    String[] termOptions = {"1", "3", "5"};
    Mortgage[] mortgages = new Mortgage[3];

    for (int i = 0; i < mortgages.length; i++) {
      String mortgageNumber = JOptionPane.showInputDialog("Enter mortgage number for Mortgage " + (i + 1) + ":");

      String customerName = JOptionPane.showInputDialog("Enter customer name for Mortgage " + (i + 1) + ":");

      String amountStr = JOptionPane.showInputDialog("Enter mortgage amount for Mortgage " + (i + 1) + ":");
      double amount = Double.parseDouble(amountStr);

      String termStr = (String) JOptionPane.showInputDialog(null,
          "Select mortgage term (years):", "Mortgage Term",
          JOptionPane.QUESTION_MESSAGE, null, termOptions, termOptions[0]);
      int term = Integer.parseInt(termStr);

      String[] typeOptions = {"Business", "Personal"};
      String mortgageTypeStr = (String) JOptionPane.showInputDialog(null,
          "Select mortgage type:", "Mortgage Type",
          JOptionPane.QUESTION_MESSAGE, null, typeOptions, typeOptions[0]);

      if (mortgageTypeStr.equals("Business")) {
        mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, primeRate, term);
      } else if (mortgageTypeStr.equals("Personal")) {
        mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, primeRate, term);
      } else {
        JOptionPane.showMessageDialog(null, "Please try again.");
        i--; // Redo
      }
    }

    StringBuilder mortgageDetails = new StringBuilder("Mortgage Details:\n");

    for (Mortgage mortgage : mortgages) {
      mortgageDetails.append(mortgage.getMortgageInfo()).append("\n-----------------------\n");
    }

    JOptionPane.showMessageDialog(null, mortgageDetails.toString());

    System.exit(0);
  }
}

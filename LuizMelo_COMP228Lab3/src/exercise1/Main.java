package exercise1;

import java.sql.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
      boolean stopper = true;
      ArrayList<Insurance> insuranceList = new ArrayList<>();
      while (stopper) {
        String[] options = {"Add Insurance", "Display Insurance Info"};
        String[] insuranceOptions = { "Health Insurance", "Life Insurance" };
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
        if (choice == 0) {
          Insurance insurance = null;
          String selectedOption = (String) JOptionPane.showInputDialog(
              null,
              "Select Insurance Type:",
              "Insurance Selector",
              JOptionPane.QUESTION_MESSAGE,
              null,
              insuranceOptions,
              insuranceOptions[0]
          );
          String monthlyCost = JOptionPane.showInputDialog(null, "Enter the insurance monthly cost:", "Monthly Cost Input", JOptionPane.QUESTION_MESSAGE);
          if (selectedOption.equals("Health Insurance")) {
            insurance = new Health();
            insurance.setInsuranceCost(Double.parseDouble(monthlyCost));
            insurance.displayInfo();
          } else if (selectedOption.equals("Life Insurance")) {
            insurance = new Life();
            insurance.setInsuranceCost(Double.parseDouble(monthlyCost));
            insurance.displayInfo();
          } else {
            stopper = false;
          }
          insuranceList.add(insurance);
        } else if (choice == 1) {
          for ( Insurance insure : insuranceList) {
            insure.displayInfo();
          }
        } else {
          stopper = false;
        }
      }
    }
}

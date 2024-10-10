package exercise1;

import javax.swing.JOptionPane;

public class Life extends Insurance {
  public Life() {
    this.insuranceType = "Life";
  }
  @Override
  public void setInsuranceCost(double cost) {
    this.monthlyCost = cost;
  }

  @Override
  public void displayInfo() {
    JOptionPane.showMessageDialog(null, String.format("Insurance type: Life. \nMonthly insurance cost is: $%.2f", getMonthlyCost()), "Insurance details", JOptionPane.INFORMATION_MESSAGE);
  }
}

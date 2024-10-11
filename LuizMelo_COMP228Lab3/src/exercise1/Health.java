package exercise1;

import javax.swing.JOptionPane;

public class Health extends Insurance {
  public Health() {
    this.insuranceType = "Health Insurance";
  }
  @Override
  public void setInsuranceCost(double cost) {
    this.monthlyCost = cost;
  }
  @Override
  public void displayInfo() {
    JOptionPane.showMessageDialog(null, String.format("Insurance type: Health. \nMonthly insurance cost is: $%.2f", getMonthlyCost()), "Insurance details", JOptionPane.INFORMATION_MESSAGE);
  }
}

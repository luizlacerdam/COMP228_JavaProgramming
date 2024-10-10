package exercise1;

public class Health extends Insurance {
  public Health() {
    this.insuranceType = "Life";
  }
  @Override
  public void setInsuranceCost(double cost) {
    this.monthlyCost = cost;
  }

  @Override
  public void displayInfo() {
    System.out.println("Insurance type: Health");
    System.out.printf("Insurance monthly cost: %.2f%%\n", getMonthlyCost());
  }
}

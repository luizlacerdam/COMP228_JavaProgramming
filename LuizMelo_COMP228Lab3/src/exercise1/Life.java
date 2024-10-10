package exercise1;

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
    System.out.println("Insurance type: Life");
    System.out.printf("Insurance monthly cost: %.2f%%\n", getMonthlyCost());
  }
}

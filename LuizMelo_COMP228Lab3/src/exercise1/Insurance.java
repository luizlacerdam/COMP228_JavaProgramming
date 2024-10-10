package exercise1;

public abstract class Insurance {
  private String insuranceType;
  private double monthlyCost;

  public String getInsuranceType() {
    return insuranceType;
  }

  public double getMonthlyCost() {
    return monthlyCost;
  }

  public abstract void setInsuranceCost(double cost);

  public abstract void displayInfo();
}

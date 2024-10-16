package exercise5;

public class PartTimeEmployee extends Employee {
  public PartTimeEmployee(String name, double salary) {
    super(name, salary);
  }

  @Override
  public double calculateAnnualBonus() {
    return 500.00;
  }

}

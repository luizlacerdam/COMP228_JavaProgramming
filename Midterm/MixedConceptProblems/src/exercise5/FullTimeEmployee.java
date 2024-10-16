package exercise5;

public class FullTimeEmployee extends Employee {
  public FullTimeEmployee(String name, double salary) {
    super(name, salary);
  }

  @Override
  public double calculateAnnualBonus() {
    return salary * 0.1;
  }

}

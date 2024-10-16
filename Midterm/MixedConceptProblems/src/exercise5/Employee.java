package exercise5;

public abstract class Employee {
  private String name;
  protected double salary;

  public Employee(String name, double salary) {
    this.name = name;
    this.salary = salary;
  }

  public abstract double calculateAnnualBonus();
}

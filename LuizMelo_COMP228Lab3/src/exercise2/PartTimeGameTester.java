package exercise2;

public class PartTimeGameTester extends GameTester {
  private double payRate = 20;
  private double hours;

  public PartTimeGameTester(String name, double hours) {
    super(name, false);
    this.hours = hours;
  }
  @Override
  public double salary() {
    return hours * payRate;
  }
}

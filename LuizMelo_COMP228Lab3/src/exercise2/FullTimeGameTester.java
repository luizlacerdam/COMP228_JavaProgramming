package exercise2;

public class FullTimeGameTester extends GameTester {
private double baseSalary = 3000;

  public FullTimeGameTester(String name, boolean fulltime) {
    super(name, fulltime);
  }

  @Override
  public double salary() {
    return baseSalary;
  }
}

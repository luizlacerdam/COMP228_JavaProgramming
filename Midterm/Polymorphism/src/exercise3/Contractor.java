package exercise3;

public class Contractor implements Payable {
  private String name;
  private double hourlyRate;
  private int hoursorked;

  public Contractor(String name, double hourlyRate, int hoursorked) {
    this.name = name;
    this.hourlyRate = hourlyRate;
    this.hoursorked = hoursorked;
  }
  @Override
  public double pay() {
    return hoursorked * hourlyRate;
  }

}

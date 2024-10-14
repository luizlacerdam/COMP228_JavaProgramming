package exercise3;

public class Car extends Vehicle{

  private int fuelLevel;
  public Car(double speed, int fuelLevel) {
    super(speed);
    this.fuelLevel = fuelLevel;
  }
  @Override
  public void move() {
    System.out.println("Vehicle moving at " + speed + "km/h with a fuel level of " + fuelLevel + "%");
  }
}

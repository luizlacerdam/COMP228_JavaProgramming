package exercise4;

public class Bike extends Vehicle {
  public Bike(double speed) {
    super(speed);
  }

  @Override
  public void move() {
    System.out.println("Bike is moving at " + speed + " km/h");
  }

}

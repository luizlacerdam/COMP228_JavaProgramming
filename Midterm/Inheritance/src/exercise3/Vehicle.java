package exercise3;

public class Vehicle {
  protected double speed;

  public Vehicle(double speed) {
    this.speed = speed;
  }
  public void move() {
    System.out.println("Vehicle moving at " + speed + "km/h");
  }

}

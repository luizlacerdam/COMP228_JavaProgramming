package exercise4;

public abstract class Vehicle {
  protected double speed;

  public Vehicle(double speed) {
    this.speed = speed;
  }

  public abstract void move();
  public void accelerate(int increment) {
    speed += increment;
  }
}

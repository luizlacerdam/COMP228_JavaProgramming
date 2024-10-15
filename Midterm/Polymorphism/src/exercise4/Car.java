package exercise4;

public class Car extends Vehicle {
  private String brand;
  private String model;
  private int year;

  public Car(String brand, String model, int year, double speed) {
    super(speed);
    this.brand = brand;
    this.model = model;
    this.year = year;
  }

  @Override
  public void move() {
    System.out.println("The car is moving at " + speed + " km/h");
  }

}

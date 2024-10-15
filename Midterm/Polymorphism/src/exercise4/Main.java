package exercise4;

public class Main {
  public static void main(String[] args) {
    Vehicle bike = new Bike(20);
    bike.move();
    bike.accelerate(10);
    bike.move();
    Vehicle car = new Car("Toyota", "Corolla", 2020, 60);
    car.move();
    car.accelerate(20);
    car.move();
  }

}

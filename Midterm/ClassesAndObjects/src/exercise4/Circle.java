package exercise4;

public class Circle {
  double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double calculateArea() {
    return Math.PI * radius * radius;
  }

  public double calculateCircumference() {
    return 2 * Math.PI * radius;
  }
}

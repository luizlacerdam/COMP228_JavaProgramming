package exercise3;

public abstract class Student {
  private String name;
  protected double[] grades;

  protected Student(String name, double[] grades) {
    this.name = name;
    this.grades = grades;
  }

  public abstract double calculateAverage();
}

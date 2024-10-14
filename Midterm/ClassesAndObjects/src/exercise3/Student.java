package exercise3;

import java.util.Arrays;

public class Student {
  private String name;
  private double[] grades;

  public Student(String name, double[] grades) {
    this.name = name;
    this.grades = grades;
  }

  public double averageGrade() {
    double sum = 0;
    for (double number : grades) {
      sum += number;
    }
    return sum/grades.length;
  }
  public void printGrades() {
    System.out.println("Student Name: " + name);
    System.out.println("Grades: " + Arrays.toString(grades));
    System.out.println("Average Grade: " + averageGrade());
  }
}

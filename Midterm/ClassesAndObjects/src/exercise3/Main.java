package exercise3;

import java.sql.Array;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    double[] grades = {85.0, 90.5, 78.0};
    Student student = new Student("John", grades);
    student.printGrades();
  }
}

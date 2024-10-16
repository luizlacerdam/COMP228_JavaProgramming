package exercise3;

public class Main {
  public static void main(String[] args) {
    double[] grades = { 10, 10, 10, 10, 10 };
    Student graduateStudent = new GraduateStudent("John Doe", grades);
    Student undergraduateStudent = new UndergratuateStudent("Jane Doe", grades);

    System.out.println(graduateStudent.calculateAverage());
    System.out.println(undergraduateStudent.calculateAverage());
  }

}

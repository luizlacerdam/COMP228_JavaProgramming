package exercise3;

public class GraduateStudent extends Student {
  public GraduateStudent(String name, double[] grades) {
    super(name, grades);
  }
@Override
  public double calculateAverage() {
    double sum = 0;
    for (double grade : grades) {
      sum += grade;
    }
    return (sum / grades.length) * 1.1;
  }

}

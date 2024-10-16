package exercise5;

public class Main {
  public static void main(String[] args) {
    FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("John Doe", 50000.00);
    PartTimeEmployee partTimeEmployee = new PartTimeEmployee("Jane Doe", 20000.00);

    System.out.println(fullTimeEmployee.calculateAnnualBonus());
    System.out.println(partTimeEmployee.calculateAnnualBonus());
  }

}

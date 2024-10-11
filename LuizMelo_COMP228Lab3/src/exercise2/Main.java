package exercise2;

import java.util.Scanner;

public class Main {
  public static void main(String[] main) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the name of the game tester:");
    String name = scanner.nextLine();

    System.out.println("Choose the type of game tester:");
    System.out.println("1. Full-Time");
    System.out.println("2. Part-Time");
    int choice = scanner.nextInt();

    GameTester tester = null;

    if (choice == 1) {
      tester = new FullTimeGameTester(name);
    } else if (choice == 2) {
      System.out.println("Enter the number of hours worked:");
      int hoursWorked = scanner.nextInt();
      tester = new PartTimeGameTester(name, hoursWorked);
    } else {
      System.out.println("Invalid option.");
      System.exit(0);
    }

    System.out.println("\nGame Tester Information:");
    System.out.println("Name: " + tester.name);
    System.out.println("Employment Type: " + (tester.fulltime ? "Full-Time" : "Part-Time"));
    System.out.println("Salary: $" + tester.salary());


    scanner.close();
  }
}

package exercise2;

import javax.swing.*;

public class Main {
  public static void main(String[] args) {
    String name = JOptionPane.showInputDialog("Enter the name of the game tester:");

    String[] options = {"Full-Time", "Part-Time"};
    int choice = JOptionPane.showOptionDialog(null,
        "Choose the type of game tester:",
        "Game Tester Type",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null, options, options[0]);

    GameTester tester = null;

    if (choice == 0) {
      tester = new FullTimeGameTester(name);
    }
    else if (choice == 1) {
      String hoursWorkedStr = JOptionPane.showInputDialog("Enter the number of hours worked:");
      int hoursWorked = Integer.parseInt(hoursWorkedStr);
      tester = new PartTimeGameTester(name, hoursWorked);
    } else {
      JOptionPane.showMessageDialog(null, "Invalid option.");
      System.exit(0);
    }

    String testerInfo = "Game Tester Information:\n" +
        "Name: " + tester.name + "\n" +
        "Employment Type: " + (tester.fulltime ? "Full-Time" : "Part-Time") + "\n" +
        "Salary: $" + tester.salary();

    JOptionPane.showMessageDialog(null, testerInfo);

    System.exit(0);  // Exit the program
  }
}

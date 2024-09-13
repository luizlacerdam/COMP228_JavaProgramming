package exercise1;

import exercise1.Singer;
import java.util.Date;

public class Main {
  public static void main(String[] args) {
    Singer singer1 = new Singer();
    System.out.println("singer1 object no argument constructor:");
    System.out.println("exercise1.Singer ID: " + singer1.getId());
    System.out.println("exercise1.Singer Name: " + singer1.getName());
    System.out.println("exercise1.Singer Address: " + singer1.getAddress());
    System.out.println("Date of Birth: " + singer1.getDateOfBirthday());
    System.out.println("Number of Albums Published: " + singer1.getNumberOfAlbumsPublished());
    System.out.println("\nSetted values:");
    singer1.setAllAttributes(01, "Luiz Melo", "69 Progress Ave.", new Date(90, 10, 25), 5);
    System.out.println("exercise1.Singer ID: " + singer1.getId());
    System.out.println("exercise1.Singer Name: " + singer1.getName());
    System.out.println("exercise1.Singer Address: " + singer1.getAddress());
    System.out.println("Date of Birth: " + singer1.getDateOfBirthday());
    System.out.println("Number of Albums Published: " + singer1.getNumberOfAlbumsPublished());
  }
}

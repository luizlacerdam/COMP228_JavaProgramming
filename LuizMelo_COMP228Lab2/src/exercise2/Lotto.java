package exercise2;
import java.util.Random;
import javax.swing.JOptionPane;

public class Lotto {
  private Integer[] numbersArr = new Integer[3];
  private Random random = new Random();

  // random 1 to 9
  public Lotto() {
    for (Integer i = 0; i < numbersArr.length; i++) {
      numbersArr[i] = random.nextInt(9) + 1; // insert the random number 1 - 9 in the array
    }
  }

  public Integer[] getNumbers() {
    return numbersArr;
  }

  public int sumArrNumbers() {
    int sum = 0;
    for (int number : numbersArr) {
      sum += number;
    }
    return sum;
  }

  public static void gameInit() {
    boolean userWon = false;
    String userInput = JOptionPane.showInputDialog(null, "Enter a number between 3 and 27", "Lotto Game", JOptionPane.QUESTION_MESSAGE);
    Integer userNumber = Integer.parseInt(userInput);

    // loop for 5 rolls
    for (Integer i = 1; i <= 5; i++) {
      Lotto lotto = new Lotto(); //constructor will take care of the array

      Integer lottoSum = lotto.sumArrNumbers(); // summing the array

      Integer[] lottoNumbers = lotto.getNumbers(); //getter
      String lottoNumbersString = "Lotto numbers: " + lottoNumbers[0] + ", " + lottoNumbers[1] + ", " + lottoNumbers[2] + "\nSum: " + lottoSum;
      JOptionPane.showMessageDialog(null, lottoNumbersString, "Lotto Roll " + i, JOptionPane.INFORMATION_MESSAGE);

      if (userNumber == lottoSum) {
        JOptionPane.showMessageDialog(null, "Congratulations! You won the lotto game in " + i + " rolls!", "You Win!", JOptionPane.INFORMATION_MESSAGE);
        userWon = true;
        break; // End the game if the user wins breaking the for loop
      }
    }
    if (userWon == false) {
      JOptionPane.showMessageDialog(null, "Computer wins! Try again..", "Computer Win!", JOptionPane.INFORMATION_MESSAGE);
    }
  }
}

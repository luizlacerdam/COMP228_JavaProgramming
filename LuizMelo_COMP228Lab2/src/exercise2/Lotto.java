package exercise2;
import java.util.Random;
public class Lotto {
  private Integer[] numbersArr = new Integer[3];
  private Random random = new Random();

  // random 1 to 9
  public Lotto() {
    for (Integer i = 0; i < numbersArr.length; i++) {
      numbersArr[i] = random.nextInt(9) + 1;
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
}

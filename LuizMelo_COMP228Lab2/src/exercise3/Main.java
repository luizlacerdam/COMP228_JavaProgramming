package exercise3;

import exercise1.Test;

public class Main {
  public static void main(String[] args) {
    String mainNumber = Cellphone.stringCellphoneNumber(1234567); //
    System.out.println(mainNumber);

    String areaPlusNumber = Cellphone.stringCellphoneNumber(321,1234567);
    System.out.println(areaPlusNumber);

    String fullNumber = Cellphone.stringCellphoneNumber(1,321,1234567);
    System.out.println(fullNumber);

  }
}

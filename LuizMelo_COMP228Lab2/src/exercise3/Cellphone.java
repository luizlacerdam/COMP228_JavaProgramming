package exercise3;

public class Cellphone {
  public static String stringCellphoneNumber(Integer mainNumber) {
    return mainNumber.toString();
  }
  //overload method to return a string cellphone number + area code
  public static String stringCellphoneNumber(Integer areaCode, Integer mainNumber) {
    return areaCode.toString() + mainNumber.toString();
  }
  //overload method to return full cellphone number
  public static String stringCellphoneNumber(Integer countryCode, Integer areaCode, Integer mainNumber) {
    return "+" + countryCode.toString() + areaCode.toString() + mainNumber.toString();
  }
}

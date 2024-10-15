package exercise1;

public class CheckingAccount extends Account {

  public CheckingAccount(int accountNumber, double balance) {
    super(accountNumber, balance);
  }

  @Override
  public double calculateInterest() {
    return 0;
  }

}

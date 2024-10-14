package exercise4;

public class SavingAccount extends BankAccount{
  private double interestRate;
  public SavingAccount(int accountNumber, double balance, double interestRate) {
    super(accountNumber, balance);
    this.interestRate = interestRate;
  }
  public void applyInterest() {
    balance = balance * interestRate;
  }
}

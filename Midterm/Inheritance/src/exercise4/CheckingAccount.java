package exercise4;

public class CheckingAccount extends BankAccount{
  private double transactionFee;
  public CheckingAccount(int accountNumber, double balance, double transactionFee) {
    super(accountNumber, balance);
    this.transactionFee = transactionFee;
  }
  @Override
  public void withdraw(double amount) {
    double total = amount + transactionFee;
    if(total > balance) {
      System.out.println("Insufficient funds.");
    } else {
      balance -= total;
    }
  }
}

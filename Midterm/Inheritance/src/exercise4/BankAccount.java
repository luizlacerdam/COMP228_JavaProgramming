package exercise4;

public class BankAccount {
  protected int accountNumber;
  protected double balance;

  public BankAccount(int accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }
  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    if(amount > balance) {
      System.out.println("Insufficient funds.");
    } else {
      balance -= amount;
    }
  }
}

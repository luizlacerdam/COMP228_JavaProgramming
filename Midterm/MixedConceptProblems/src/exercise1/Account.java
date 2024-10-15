package exercise1;

public abstract class Account {
  private int accountNumber;
  private double balance;

  public Account(int accountNumber, double balance) {
    this.accountNumber = accountNumber;
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public abstract double calculateInterest();

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) {
    if (amount > balance) {
      System.out.println("Insufficient funds");
    } else {
      balance -= amount;
    }
  }
}

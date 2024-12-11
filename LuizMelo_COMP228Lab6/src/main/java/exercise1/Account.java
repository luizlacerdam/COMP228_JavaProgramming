package exercise1;

public class Account {
  private double balance;

  public Account(double initialBalance) {
      this.balance = initialBalance;
  }

  public synchronized void deposit(double amount) {
    if (amount > 0.0) {
      balance += amount;
      System.out.printf("Deposited: %.2f, New Balance: %.2f%n", amount, balance);
    }
  }

  public synchronized void withdraw(double amount) {
    if (amount > 0.0 && amount <= balance) {
      balance -= amount;
      System.out.printf("Withdrawn: %.2f, New Balance: %.2f%n", amount, balance);
    } else {
      System.out.printf("Withdrawal of %.2f failed. Insufficient funds. Balance: %.2f%n", amount, balance);
    }
  }

  public double getBalance() {
    return balance;
  }
}

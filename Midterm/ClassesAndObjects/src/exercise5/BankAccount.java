package exercise5;

public class BankAccount {
  String accountHolderName;
  double balance;

  public BankAccount(String name) {
    this.accountHolderName = name;
    this.balance = 0;
  }

  public void deposit(double amount) {
    balance += amount;
  }
  public void withdraw(double amount) {
    if (amount > balance) {
      System.out.println("No sufficient funds.");
    } else {
      balance -= amount;
    }
  }
  public double getBalance() {
    return balance;
  }
}

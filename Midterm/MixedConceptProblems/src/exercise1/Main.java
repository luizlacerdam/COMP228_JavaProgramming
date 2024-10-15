package exercise1;

public class Main {
  public static void main(String[] args) {
    Account savingsAccount = new SavingsAccount(123, 1000);
    Account checkingAccount = new CheckingAccount(456, 2000);

    savingsAccount.deposit(100);
    checkingAccount.deposit(200);

    savingsAccount.withdraw(200);
    checkingAccount.withdraw(300);

    System.out.println("Savings account balance: " + savingsAccount.getBalance());
    System.out.println("Checking account balance: " + checkingAccount.getBalance());

    System.out.println("Savings account interest: " + savingsAccount.calculateInterest());
    System.out.println("Checking account interest: " + checkingAccount.calculateInterest());
    savingsAccount.deposit(savingsAccount.calculateInterest());
    checkingAccount.deposit(checkingAccount.calculateInterest());
    System.out.println("Savings account balance after interest: " + savingsAccount.getBalance());
    System.out.println("Checking account balance after interest: " + checkingAccount.getBalance());
  }
}

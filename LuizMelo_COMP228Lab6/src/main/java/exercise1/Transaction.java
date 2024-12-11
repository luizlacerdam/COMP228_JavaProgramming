package exercise1;

public class Transaction implements Runnable { // Runnable interface, allowing it to be executed by a thread.
  private final Account account;
  private final double amount;
  private final String transactionType;

  public Transaction(Account account, double amount, String transactionType) {
    this.account = account;
    this.amount = amount;
    this.transactionType = transactionType;
  }

  @Override
  public void run() {
    if ("deposit".equalsIgnoreCase(transactionType)) {
      account.deposit(amount);
    } else if ("withdraw".equalsIgnoreCase(transactionType)) {
      account.withdraw(amount);
    } else {
      System.out.println("Invalid transaction type: " + transactionType);
    }
  }
}


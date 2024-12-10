package exercise1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
  public static void main(String[] args) {
    Account account = new Account(1000.0); // Initial balance

    // Create a list of transactions
    ArrayList<Transaction> transactions = new ArrayList<>();
    transactions.add(new Transaction(account, 200, "deposit"));
    transactions.add(new Transaction(account, 150, "withdraw"));
    transactions.add(new Transaction(account, 300, "deposit"));
    transactions.add(new Transaction(account, 500, "withdraw"));
    transactions.add(new Transaction(account, 700, "withdraw"));

    // Use ExecutorService to manage threads
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    for (Transaction transaction : transactions) {
      executorService.execute(transaction);
    }

    executorService.shutdown();
    while (!executorService.isTerminated()) {
      // Wait for all tasks to complete
    }

    // Final account balance
    System.out.printf("Final Account Balance: %.2f%n", account.getBalance());
  }
}

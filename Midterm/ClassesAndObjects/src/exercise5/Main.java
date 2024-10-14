package exercise5;

public class Main {
  public static void main(String[] args) {
    BankAccount bankAccount = new BankAccount("Luiz");
    bankAccount.deposit(500);
    System.out.println(bankAccount.getBalance());
    bankAccount.withdraw(200);
    System.out.println(bankAccount.getBalance());
    bankAccount.withdraw(400);
    System.out.println(bankAccount.getBalance());
  }
}

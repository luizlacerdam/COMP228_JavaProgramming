package exercise2;

public class Main {
  public static void main(String[] args) {
    Book book = new Book("The Da Vinci Code", "Dan Brown");
    Magazine magazine = new Magazine("National Geographic", "National Geographic Society");

    book.borrow();
    magazine.borrow();

    System.out.println("Book borrowed: " + book.isBorrowed());
    System.out.println("Magazine borrowed: " + magazine.isBorrowed());

    book.returnItem();
    magazine.returnItem();

    System.out.println("Book borrowed: " + book.isBorrowed());
    System.out.println("Magazine borrowed: " + magazine.isBorrowed());
  }

}

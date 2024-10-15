package exercise2;

public class Book implements Borrowable {
  private String title;
  private String author;
  private boolean isBorrowed;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isBorrowed = false;
  }
  public boolean isBorrowed() {
    return isBorrowed;
  }
  @Override
  public void borrow() {
    isBorrowed = true;
  }

  @Override
  public void returnItem() {
    isBorrowed = false;
  }

}

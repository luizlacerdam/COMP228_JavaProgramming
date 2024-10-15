package exercise2;

public class Magazine implements Borrowable {
  private String title;
  private String publisher;
  private boolean isBorrowed;

  public Magazine(String title, String publisher) {
    this.title = title;
    this.publisher = publisher;
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

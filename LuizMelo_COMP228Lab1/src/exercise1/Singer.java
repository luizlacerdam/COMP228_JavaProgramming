package exercise1;

import java.util.Date;

public class Singer {

  private int id;
  private String name;
  private String address;
  private Date dateOfBirthday;
  private int numberOfAlbumsPublished;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getDateOfBirthday() {
    return dateOfBirthday;
  }

  public void setDateOfBirthday(Date dateOfBirthday) {
    this.dateOfBirthday = dateOfBirthday;
  }

  public int getNumberOfAlbumsPublished() {
    return numberOfAlbumsPublished;
  }

  public void setNumberOfAlbumsPublished(int numberOfAlbumsPublished) {
    this.numberOfAlbumsPublished = numberOfAlbumsPublished;
  }
  public void setAllAttributes(int id, String name, String address, Date dateOfBirthday, int numberOfAlbumsPublished) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.dateOfBirthday = dateOfBirthday;
    this.numberOfAlbumsPublished = numberOfAlbumsPublished;
  }

  public Singer() {
  }

  public Singer(int id) {
    this.id = id;
  }

  public Singer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Singer(int id, String name, String address) {
    this.id = id;
    this.name = name;
    this.address = address;
  }

  public Singer(int id, String name, String address, Date dateOfBirthday) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.dateOfBirthday = dateOfBirthday;
  }

  public Singer(int id, String name, String address, Date dateOfBirthday,
      int numberOfAlbumsPublished) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.dateOfBirthday = dateOfBirthday;
    this.numberOfAlbumsPublished = numberOfAlbumsPublished;
  }
}

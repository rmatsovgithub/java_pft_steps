package model;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactData {
  private String firstName;
  private String lastName;
  private String phone;
  private String email;

  public ContactData(String firstName, String lastName, String phone, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;

  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPhone() {
    return phone;
  }
}

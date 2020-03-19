package model;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactData {
  private String firstName;
  private String lastName;
  private String phone;
  private String email;



  private String group;

  public ContactData(String firstName, String lastName, String phone, String email, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}

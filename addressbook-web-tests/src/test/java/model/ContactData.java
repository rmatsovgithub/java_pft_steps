package model;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactData {
  int id;
  private String firstName;
  private String lastName;
  private String phone;
  private String email;
  private String group;



  public ContactData(String firstName, String lastName, String phone, String email, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.lastName = lastName;
    this.phone = phone;
    this.email = email;
    this.group = group;
  }
  public ContactData(int id, String firstName, String lastName, String phone, String email, String group) {
    this.id = id;
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

  public int getId(){return id;}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;

  }

  @Override
  public int hashCode() {
    int result = firstName != null ? firstName.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }

  public void setId(int id)
  {
    this.id=id;

  }
}

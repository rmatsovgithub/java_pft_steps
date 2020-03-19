package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {


    app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().fillContactForm(new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com"));
    app.getContactHelper().submitContactCreation();
    app.getNavigationHelper().gotoHomePage();

  }
}

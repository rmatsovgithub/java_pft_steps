package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {


    app.getNavigationHelper().gotoNewContactPage();
    app.getContactHelper().createContact(new ContactData(null, "m", "+79787811058", "rmatsov@gmail.com", "test1"));
    app.getNavigationHelper().gotoHomePage();
  }


}

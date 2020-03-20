package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testGroupModification(){


    app.getNavigationHelper().gotoHomePage();
    if(! app.getNavigationHelper().isElementPresent(By.name("selected[]"))){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("R", "M", null, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

}

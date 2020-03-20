package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {


  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getNavigationHelper().isElementPresent(By.name("selected[]"))){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();

  }
}
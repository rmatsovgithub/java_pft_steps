package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ContactDeletionTests extends TestBase {


  @Test(enabled = false)
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getNavigationHelper().isElementPresent(By.name("selected[]"))){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContact();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
}
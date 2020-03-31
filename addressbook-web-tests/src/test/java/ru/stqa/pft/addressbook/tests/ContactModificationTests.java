package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactModificationTests extends TestBase {

  @Test(enabled = false)
  public void testGroupModification(){


    app.getNavigationHelper().gotoHomePage();
    if(! app.getNavigationHelper().isElementPresent(By.name("selected[]"))){
      app.getNavigationHelper().gotoNewContactPage();
      app.getContactHelper().createContact(new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com", "test1"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().initContactModification(before.get(before.size()-1).getId());
    ContactData contact=new ContactData(before.get(before.size()-1).getId(), "ASSASAs", "assdfdsdg", null, null, null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    before.remove(before.size()-1);
    before.add(contact);

    Comparator<? super ContactData> byId = ((o1, o2) -> Integer.compare(o1.getId(), o2.getId()));
    before.sort(byId);
    after.sort(byId);


    Assert.assertEquals(before, after);







  }

}

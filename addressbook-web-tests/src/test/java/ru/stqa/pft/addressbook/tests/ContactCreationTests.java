package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test(enabled = false)
  public void testContactCreation() {

    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoNewContactPage();
    ContactData newContact = new ContactData("r", "m", "+79787811058", "rmatsov@gmail.com", "test1");
    app.getContactHelper().createContact(newContact);
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    newContact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(newContact);
    Comparator<? super ContactData> byId = (с1, c2) -> Integer.compare(с1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}




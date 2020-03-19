package ru.stqa.pft.addressbook.tests;

import model.ContactData;
import model.GroupData;
import org.testng.annotations.Test;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactModificationTests extends TestBase {

  @Test
  public void testGroupModification(){


    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("R", "M", null, null, null), false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

}

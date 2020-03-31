package ru.stqa.pft.addressbook.appmanager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Роман on 19.03.2020.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void fillContactForm(ContactData contactData, boolean creation){
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getPhone());
    type(By.name("email"), contactData.getEmail());
    if(creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }


  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

    //click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    confirmDelete();
  }

  private void confirmDelete() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification(int id){
    String locator="//a[@href='edit.php?id=" + id+ "']";
    System.out.println(locator);
    click(By.xpath(locator));

  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void createContact(ContactData contactData) {

    fillContactForm(contactData, true);
    submitContactCreation();


  }


  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td.center"));
       for(WebElement element : elements){
      try {
        int id=Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
        String title = element.findElement(By.tagName("input")).getAttribute("title").substring(8);
        int pointer=title.indexOf(" ");
        String firstname = title.substring(0, pointer);
        String lastname = title.substring(pointer+1, title.length()-1);
        contacts.add(new ContactData(id, firstname, lastname , null, null, null));
      }catch (NoSuchElementException ex){
        //No operation
      }
    }

    return contacts;
  }
}


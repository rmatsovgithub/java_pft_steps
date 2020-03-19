package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * Created by Роман on 18.03.2020.
 */
public class  ApplicationManager {
  WebDriver wd;


  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  String browser;

  public ApplicationManager(String browser) {
    this.browser=browser;
  }


  public void init() {
    if(Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    } else wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/group.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
    contactHelper = new ContactHelper(wd);

  }



  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SessionHelper sessionHelper(){
    return sessionHelper();
  }
  
  public ContactHelper contactHelper() {return contactHelper(); }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }
}

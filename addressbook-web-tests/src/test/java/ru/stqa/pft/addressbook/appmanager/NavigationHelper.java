package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Роман on 18.03.2020.
 */
public class NavigationHelper {
  FirefoxDriver wd;

  public NavigationHelper(FirefoxDriver wd){
    this.wd = wd;
  }
  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }
}

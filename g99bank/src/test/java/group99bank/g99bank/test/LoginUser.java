package group99bank.g99bank.test;

//import java.io.FileInputStream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import group99bank.g99bank.pageObjects.LoginPage;
import group99bank.g99bank.resources.Base;

public class LoginUser extends Base {
  @Test
  public void f() {
	  
	  LoginPage lp = new LoginPage(driver);
	  //FileInputStream fis = new FileInputStream("/Users/admin/apps/");
	 String user="mngr95961";
	 String pass="YpUtunY";
	 lp.setLoginUser(user);
	 lp.setLoginPassword(pass);
	 lp.clickLoginBtn();
	 WebDriverWait w = new WebDriverWait(driver,10);
	 w.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
	 Assert.assertTrue(driver.getTitle().equals("Guru99 Bank Manager HomePage"));
	  
  }
}

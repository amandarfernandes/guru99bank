package group99bank.g99bank.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import group99bank.g99bank.pageObjects.LoginPage;
import group99bank.g99bank.resources.Base;

public class LoginUser extends Base {

	@BeforeMethod
	public void beforeTest() {
		initializeDriver();
	}

	@AfterMethod
	public void afterTest() {
		tearDown();
	}
	
	@DataProvider
	public Object[][] getUsers() throws IOException {
		return getUserData(FILE_NAME,SHEET_NAME);
	}
	
	@Test (dataProvider = "getUsers")
	public void login( String user, String pass)  
	{
		  LoginPage lp = new LoginPage(driver);
		  System.out.println(user+"||"+pass);
		  lp.setLoginUser(user);
		  lp.setLoginPassword(pass);
		  lp.clickLoginBtn();
		  
		  try {
			Alert errorAlert = driver.switchTo().alert();
			AssertJUnit.assertEquals(errorAlert.getText(), LOGIN_ERRMSG); 
			errorAlert.accept();
		  } 
		  catch (NoAlertPresentException e) {
			 WebDriverWait w = new WebDriverWait(driver,10);
			 w.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
			 AssertJUnit.assertEquals(driver.getTitle(),MGR_TITLE);
			 AssertJUnit.assertTrue(driver.findElement(By.cssSelector(".heading3 td")).getText().contains(user) );
		  }
	  
  }

}

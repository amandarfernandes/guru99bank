package group99bank.g99bank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	//locators
	@FindBy(css="input[name='uid']") private WebElement loginUser;
	@FindBy(css="input[name='password']") private WebElement loginPassword;
	@FindBy(css="input[name='btnLogin']") private WebElement signin; 

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void setLoginUser(String user) {
		loginUser.clear();
		loginUser.sendKeys(user);
	}
	
	public void setLoginPassword(String pass) {
		loginPassword.clear();
		loginPassword.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		signin.click();
	}
	
}

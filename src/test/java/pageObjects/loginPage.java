package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	public WebDriver driver;
	
	public loginPage(WebDriver rdriver) {
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//span[text()='Login']/parent::button")
	WebElement btnLogin;
	
	public void txtUserName(String username) {
		txtUsername.clear();
		txtUsername.sendKeys(username);
	}
	
	public void txtPassword(String password) {
		txtUsername.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}

}

package appFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.WaitHelper;

public class searchCompany {
	public WebDriver driver;
	public searchCompany(WebDriver driver) {
		this.driver=driver;
	}
	
	public void clickOnCreatedCompany(String companyname) {
		WaitHelper wait=new WaitHelper(driver);
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<=5; i++) {
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Config']/parent::div")));
			WebElement config= driver.findElement(By.xpath("//small[text()='Config']/parent::div"));

			try {
				wait.elementisvisible(config, 30);
				wait.WaitForElementToBeClicable(config, 30);
				config.click();
			} catch (Exception e) {
				
			}
		}
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebElement btncompanylist= driver.findElement(By.xpath("(//div[@aria-haspopup='listbox'])[1]"));
		wait.elementisvisible(btncompanylist, 30);
		wait.WaitForElementToBeClicable(btncompanylist, 30);
		Actions a=new Actions(driver);
		a.moveToElement(btncompanylist).perform();
		btncompanylist.click();
		driver.findElement(By.xpath("//input[@id='select-search']")).sendKeys(companyname);
		WebElement companyinList = driver.findElement(By.xpath("//span[contains(text(), '"+companyname+"')]/parent::div/parent::li"));
		wait.elementisvisible(companyinList, 30);
		wait.WaitForElementToBeClicable(companyinList, 30);
		a.moveToElement(companyinList).perform();
		companyinList.click();
//		wait.waituntilinvisibleofelement(companyinList, 30);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[text()='"+companyname+"'])[1]")));
	}

}

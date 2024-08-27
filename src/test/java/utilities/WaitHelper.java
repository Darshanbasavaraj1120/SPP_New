package utilities;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	public WebDriver driver;
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	public void WaitForElement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
	}	
	public void WaitForElementToBeClicable(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void presenceofanelementlocated(By linkleave, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(linkleave)));
	}
	public void elementisvisible(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void presenceofelement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	public void elementinteractable(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));  
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waituntilinvisibleofelement(WebElement element, long timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
}
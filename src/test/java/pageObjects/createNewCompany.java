package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewCompany {
	public WebDriver driver;
	public createNewCompany(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//small[text()='Company Settings']/parent::div")
	WebElement companySettings;
	
	@FindBy(xpath = "//span[text()='new company']/parent::h6/parent::div")
	WebElement newCompany;
	
	@FindBy(xpath = "//input[@id='companyname']")
	WebElement txtCompanyName;
	
	@FindBy(xpath = "//input[@name='dateofestablishment']")
	WebElement dateofEstablishment;
	
	@FindBy(xpath = "//input[@id='cinNumber']")
	WebElement txtCINNumber;
	
	@FindBy(xpath = "//input[@id='tan']")
	WebElement txtTan;
	
	@FindBy(xpath = "//input[@id='website']")
	WebElement txtWebsite;
	
	@FindBy(xpath = "//input[@id='address']")
	WebElement txtAddress1;
	
	@FindBy(xpath = "//input[@id='address2']")
	WebElement txtAddress2;
	
	@FindBy(xpath = "//input[@id='address3']")
	WebElement txtAddress3;
	
	@FindBy(xpath = "//input[@id='phonenumber1']")
	WebElement txtPhone1;
	
	@FindBy(xpath = "//input[@id='phonenumber2']")
	WebElement txtPhone2;
	
	@FindBy(xpath = "//input[@id='shortName']")
	WebElement txtShortName;
	
	@FindBy(xpath = "//input[@name='pf']")
	WebElement btnPF;
	
	@FindBy(xpath = "//input[@name='esi']")
	WebElement btnESI;
	
	@FindBy(xpath = "//input[@name='pt']")
	WebElement btnPT;
	
	@FindBy(xpath = "//input[@name='tds']")
	WebElement btnTDS;
	
	@FindBy(xpath = "//input[@name='tdsMartofeb']")
	WebElement btnTDSMartoFeb;
	
	@FindBy(xpath = "//input[@name='lwf']")
	WebElement btnLWF;
	
	@FindBy(xpath = "//input[@id='drag_and_drop']")
	WebElement fileUpload;
	
	@FindBy(xpath = "//span[text()='Back']/parent::button")
	WebElement btnBack;
	
	@FindBy(xpath = "//span[text()='Save']/parent::button")
	WebElement btnSave;
	
	@FindBy(xpath = "//input[@name='payCycle']/parent::div/child::div")
	WebElement btnPaycycle;
	
	@FindBy(xpath = "//div[@id='netSalaryRoundoff']")
	WebElement btnNetSalRoundOff;
	
	@FindBy(xpath = "//div[@id='Holiday']")
	WebElement btnHolidaysDefinedOn;
	
	@FindBy(xpath = "//div[@id='Weekly_off']")
	WebElement btnWeeklyOffDefinedOn;
	
	@FindBy(xpath = "//input[@id='cmpWiseRole']/parent::span")
	WebElement checkboxCompanyWiseRoleCreation;
	
	@FindBy(xpath = "//u[text()='Mandatory Setting']/parent::h5")
	WebElement btnMandatorySetting;
	
	@FindBy(xpath = "//u[text()=' Back To Payroll Setting']/parent::h6/parent::button")
	WebElement btnBacktoPayrollSetting;
	
	@FindBy(xpath = "//input[@name='monthyear']")
	WebElement dateMonthYear;
	
	
	public void selectPayCycle(String date) {
		WebElement element=driver.findElement(By.xpath("//li[text()='"+date+"']"));
		element.click();
	}

	public void mandatorySetting(String mandatorySetting) {
		WebElement element= driver.findElement(By.xpath("//h6[text()='"+mandatorySetting+"']/parent::div/child::span"));
		element.click();
	}

}

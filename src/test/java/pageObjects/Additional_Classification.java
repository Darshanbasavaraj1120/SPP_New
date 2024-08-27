package pageObjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Additional_Classification {
	
	public WebDriver driver;
	public Additional_Classification(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	@FindBy(xpath = "//small[text()='Config']/parent::div")
	WebElement configdashboard;

	@FindBy(xpath = "//div[@id='classifications']/parent::h6/parent::div")
	WebElement classificationtab;
	
	@FindBy(xpath = "//button[text()='Additional Classification']")
	WebElement Classificationadditional;

	@FindBy(xpath = "//button[contains(text(),'Classification')]")
	WebElement classificationsection;

	@FindBy(xpath = "//button[contains(text(),'Designation')]")
	WebElement designationsection;

	@FindBy(xpath = "//button[contains(text(),'Banks')]")
	WebElement bankssection;

	@FindBy(xpath = "//button[contains(text(),'Import')]")
	WebElement importsection;	

	@FindBy(xpath = "//button[@aria-label='Add']")
	WebElement addclassification;

	@FindBy(id = "classficationName")
	WebElement txtclassificationname;

	@FindBy(id = "printName")
	WebElement txtprintname;

	@FindBy(name = "mandatory")
	WebElement checkboxmandatory;

	@FindBy(name = "showInFormula")
	WebElement checkboxcheckinformulaeditor;

	@FindBy(name = "withoutMaster")
	WebElement checkboxwithoutmaster;

	@FindBy(id = "classficationName-helper-text")
	WebElement classificationnameerror;

	@FindBy(xpath = "//span[contains(text(),'Add Masters To ')]/parent::button")
	WebElement addclassificationmaster;

	@FindBy(id = "classDetName")
	WebElement txtclassificationmastername;

	@FindBy(id = "printName")
	WebElement txtclassificationmasterprintname;

	@FindBy(xpath = "//div[contains(text(),'Classification heading is not available in master table.')]")
	WebElement verifymasternotavailerror;

	@FindBy(id = "classDetName-helper-text")
	WebElement 	classificationmasternameerror;

	@FindBy(id = "printName-helper-text")
	WebElement classificationmasterprintnameerror;

	@FindBy(xpath = "//div[contains(text(),\"'Print Name' is not in the correct format.,'Print Name' must not be empty.\")]")
	WebElement printnamemissingerror;

	@FindBy(xpath = "//div[contains(text(),\"'Classfication Name' is not in the correct format.\")]")
	WebElement classificationnameformaterror;

	@FindBy(xpath = "//div[contains(text(),\"'Print Name' is not in the correct format.\")]")
	WebElement classificationprintnameformaterror;

	@FindBy(xpath = "//span[contains(text(),'Classification A')]")
	WebElement classificationcreated;

	@FindBy(xpath = "//span[contains(text(),'Add Masters To Classification A')]")
	WebElement classificationnameinmaster;

	@FindBy(xpath = "//button[@id='vertical-tab-0']/small/div/div/span")
	WebElement classificationname;

	@FindBy(xpath = "//button[@id='vertical-tab-0']/small/div/div/small")
	WebElement classificationprintname;

	@FindBy(xpath = "//button[@id='vertical-tab-1']/small/div/div/span")
	WebElement classificationname1;

	@FindBy(xpath = "//button[@id='vertical-tab-1']/small/div/div/small")
	WebElement classificationprintname1;

	@FindBy(xpath = "(//tbody/tr/td[2])[1]")
	WebElement classificationmastername;

	@FindBy(xpath = "//tbody/tr/td[1]")
	WebElement classificationmasterprintname;

	@FindBy(xpath = "(//tbody/tr/td[2])[2]")
	WebElement classificationmastername1;

	@FindBy(xpath = "//tbody/tr/td[2]")
	WebElement classificationmasterprintname1;

	@FindBy(xpath = "//small[contains(text(),'Classification')]/parent::div/following-sibling::div//p")
	WebElement classificationerror;

	@FindBy(xpath = "//small[text()='Salary']/parent::div")
	WebElement salarydashboard;

	@FindBy(xpath = "//span[text()='component and structure']/parent::h6/parent::div")
	WebElement componentandstructuretab;

	@FindBy(xpath = "//button[contains(text(),'Formula Editor')]")
	WebElement formulatedtorsection;

	@FindBy(xpath = "//input[@placeholder='Variable']")
	WebElement txtvariable;

	@FindBy(id = "formulaeditor")
	WebElement cheformulaeditor;
	
	@FindBy(xpath = "(//li[1])[2]")
	WebElement checkclassification;
	
	@FindBy(xpath = "//li[contains(text(),'(EmpDet{Classification A})')]")
	WebElement classifictiona;

	@FindBy(xpath = "//div[contains(text(),'Classfication Name Duplication not allowed') or contains(text(),'Classification Name Duplication not allowed')]")
	WebElement duplicateclassification;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation Mui-disabled MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation add_classification_two css-14vu4rh']")
	WebElement addclassificationmasterdisabled;
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeSmall MuiButton-containedSizeSmall MuiButton-disableElevation add_classification_two css-14vu4rh']")
	WebElement addclassificationmasterenabled;

	@FindBy(id = "vertical-tab-0")
	WebElement tabone;

	@FindBy(id = "vertical-tab-1")
	WebElement tabtwo;
	
	@FindBy(id = "vertical-tab-2")
	WebElement tabthree;

	@FindBy(xpath = "//small[contains(text(),'Classification B')]/parent::div/following-sibling::div/div/div")
	WebElement selectsecondwithoutmasterclassification;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1b25xg2']")
	WebElement classificationinput;

	@FindBy(xpath = "//div[contains(text(),'Classification assigned to ClassHeading, Cannot delete')]")
	WebElement deleteclassificationwithoutmaster;

	@FindBy(xpath = "//div[contains(text(),'Classification assigned to ClassHeading, Cannot delete')]")
	WebElement deleteclassificationwhichisassigned;

	@FindBy(xpath = "//span[contains(text(),'Add Designation')]/parent::button")
	WebElement btnadddesignation;

	@FindBy(id = "designationName-helper-text")
	WebElement designatinnamemandatoryerror;

	@FindBy(id = "designationName")
	WebElement txtdesinationname;

	@FindBy(xpath = "//div[text()='Designation is assigned to Employee']")
	WebElement deleteassigneddesignation;

	@FindBy(xpath = "//div[text()='Designation already exist']")
	WebElement designationduplicateerror;

	//Banks

	@FindBy(xpath = "//span[contains(text(),'Add New')]/parent::button")
	WebElement btnaddnew;

	@FindBy(id = "financialName")
	WebElement txtfinancialname;

	@FindBy(id = "accountType")
	WebElement accounttype;

	@FindBy(id = "address")
	WebElement txtaddress;

	@FindBy(id = "pincode")
	WebElement txtpincode;

	@FindBy(id = "branchCode")
	WebElement txtbranchcode;

	@FindBy(id = "micrCode")
	WebElement txtmicrcode;

	@FindBy(id = "ifscCode")
	WebElement txtifsccode;

	@FindBy(id = "accountNo")
	WebElement txtaccno;

	@FindBy(id = "email")
	WebElement txtemail;

	@FindBy(id = "financialName-helper-text")
	WebElement financialnameerror;

	@FindBy(id = "accountType-helper-text")
	WebElement accounttypeerror;

	@FindBy(id = "pincode-helper-text")
	WebElement pincodeerror;

	@FindBy(id = "branchCode-helper-text")
	WebElement branchcodeerror;

	@FindBy(id = "ifscCode-helper-text")
	WebElement ifsccodeerror;

	@FindBy(id = "micrCode-helper-text")
	WebElement micrcodeerror;

	@FindBy(id = "accountNo-helper-text")
	WebElement accountnumbererror;

	@FindBy(id = "email-helper-text")
	WebElement emailerror;

	@FindBy(xpath = "//div[contains(text(),'FinancialName already Exist')]")
	WebElement bankduplicateerrror;

	@FindBy(xpath = "//div[contains(text(),'Bank is assigned to employee')]")
	WebElement deleteassignedbank;

	@FindBy(xpath = "//span[text()='template']/parent::button")
	WebElement templatebutton;

	@FindBy(id = "drag_and_drop")
	WebElement draganddrop;

	@FindBy(xpath = "//span[text()='Upload File']/parent::button")
	WebElement btnuploadfile;
	
	@FindBy(xpath = "//small[contains(text(),'Excel Files Does Not Matches With Validation Rules')]")
	WebElement wrongexcelerror;
	
	@FindBy(xpath = "//small[contains(text(),'Designation Master Upload.xlsx')]")
	WebElement verifyfile;
	
	@FindBy(xpath = "//small[text()='remove']/parent::div")
	WebElement btnremove;
	
	@FindBy(xpath = "//div[text()='Records Saved Successfully']")
	WebElement savenotification;
	
	@FindBy(xpath = "//small[@class=' MuiBox-root css-fx09wr' and text()='Designation Master Upload.xlsx']")
	WebElement excelnameinsuccessstatus;
	
	@FindBy(xpath = "//small[text()='100' and  '0.013' and 'Mb . ' and '%']")
	WebElement successpercent;
	
	@FindBy(xpath = "//small[@class=' MuiBox-root css-eg4110' and text()='12']")
	WebElement total;
	
	@FindBy(xpath = "//small[@class=' MuiBox-root css-fx09wr' and text()='12']")
	WebElement success;	
	
	@FindBy(xpath = "//small[@class=' MuiBox-root css-1q57n33' and text()='0']")
	WebElement failed;
	
	@FindBy(xpath = "//button[text()='Designation']")
	WebElement designationtab;
	
	@FindBy(xpath = "//td[text()='3D Visualiser']")
	WebElement firstdesignation;
	
	@FindBy(xpath = "//td[text()='Aristo-care Executive']")
	WebElement tenthdesignation;
	
	@FindBy(xpath = "//button[@aria-label='Go to page 2']")
	WebElement secondpage;
	
	@FindBy(xpath = "//td[text()='ASSISTANT BRAND MANAGER']")
	WebElement lastdesignation;
	
	@FindBy(xpath = "//span[contains(text(),'Save')]/parent::button")
	WebElement btnsave;
	
	@FindBy(xpath = "//span[contains(text(),'Close')]/parent::button")
	WebElement btnclose;
	
	public void clickconfigdashboard() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(configdashboard));
		wait.until(ExpectedConditions.elementToBeClickable(configdashboard));
		configdashboard.click();
	}
	public void clickclassificationtab() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(classificationtab));
		wait.until(ExpectedConditions.elementToBeClickable(classificationtab));
		classificationtab.click();
	}
	
	public void clickClassificationadditional() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(Classificationadditional));
		wait.until(ExpectedConditions.elementToBeClickable(Classificationadditional));
		Classificationadditional.click();
	}
	
	
	public void clickclassificationsection() {
		classificationsection.click();
	}
	public String formualaclassString() {
		 return checkclassification.getText();
	}
	public WebElement getdesignationsection() {
		return designationsection;
	}
	public void clickdesignationsection() {
		designationsection.click();
	}
	public void clickbankssection() {
		bankssection.click();
	}
	public void clickimportsection() {
		importsection.click();
	}
	public void clickaddclassification() {
		addclassification.click();
	}
	public void setclassifiationname(String value) {
		txtclassificationname.sendKeys(value);
	}
	public void setprintname(String value) {
		txtprintname.sendKeys(value);
	}
	public void clickcheckboxmandatory() {
		checkboxmandatory.click();
	}
	public void clickcheckboxcheckinformulaeditor() {
		checkboxcheckinformulaeditor.click();
	}
	public void clickcheckboxwithoutmaster() {
		checkboxwithoutmaster.click();
	}
	public String getclassificationnameerror() {
		return classificationnameerror.getText();
	}
	public void clickaddclassificationmaster() {
		addclassificationmaster.click();
	}
	public void setclassifictionmastername(String value) {
		txtclassificationmastername.sendKeys(value);
	}
	public void setclassificationmasterprintname(String value) {
		txtclassificationmasterprintname.sendKeys(value);
	}
	public void verifymasternotavailerror() {
		verifymasternotavailerror.isDisplayed();	
	}
	public String getclassificationmasternameerror() {
		return classificationmasternameerror.getText();
	}
	public String getclassificationmasterprintnameerror() {
		return classificationmasterprintnameerror.getText();
	}
	public void verifyprintnamemissingerror() {
		printnamemissingerror.isDisplayed();
	}
	public void verifyclassificationnameformaterror() {
		classificationnameformaterror.isDisplayed();
	}
	public void verifyclassificationprintnameformaterror() {
		classificationprintnameformaterror.isDisplayed();
	}
	public void verifyclassificationcreated() {
		classificationcreated.isDisplayed();
	}
	public void verifyclassificationnameinmaster() {
		classificationnameinmaster.isDisplayed();
	}
	public String getclassificationname() {
		return classificationname.getText();
	}
	public String getclassificationprintname() {
		return classificationprintname.getText();
	}
	public String getclassificationname1() {
		return classificationname1.getText();
	}
	public String getclassificationprintname1() {
		return classificationprintname1.getText();
	}
	public void clickonclassificationaddclassificatiomaster() {
		WebElement element=driver.findElement(By.xpath("//span[contains(text(),'Add Masters To "+classificationname1.getText()+"')]/parent::button"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Add Masters To "+classificationname1.getText()+"')]/parent::button")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add Masters To "+classificationname1.getText()+"')]/parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add Masters To "+classificationname1.getText()+"')]/parent::button")));
		element.click();
	}
	public void clickocreatedclassification() {
		WebElement element= driver.findElement(By.xpath("//div[contains(text(),'Select  "+getclassificationname()+" ("+getclassificationname()+")')]"));
		System.out.println(element);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public void clickocreatedclassificationlist() {
		WebElement element= driver.findElement(By.xpath("//div[contains(text(),'Select  "+classificationmastername.getText()+" ("+classificationmasterprintname.getText()+")')]"));
		System.out.println(element);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	public String getclassificationmastername() {
		return  classificationmastername.getText();	
	}
	public String getclassificationmasterprintname() {
		return  classificationmasterprintname.getText();	
	}
	public String getclassificationmastername1() {
		return  classificationmastername1.getText();	
	}
	public String getclassificationmasterprintname1() {
		return  classificationmasterprintname1.getText();	
	}
	public String classificationmandatoryerror() {
		return classificationerror.getText();
	}
	public void clicksalarydashboard() {
		salarydashboard.click();
	}
	public void clickcomponentandstructuretab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(componentandstructuretab));
		wait.until(ExpectedConditions.elementToBeClickable(componentandstructuretab));
		componentandstructuretab.click();
	}
	public void clickformulatedtorsection() {
		formulatedtorsection.click();
	}
	public void clicktxtvariable(String value) {
		txtvariable.sendKeys(value);
	}
	public String verifyformulaeditor() {
		return formulatedtorsection.getText();
	}
	public WebElement classifictionainormulaeditor() {
		return classifictiona;
	}
	public String verifyformulatextboxdata() {
		return cheformulaeditor.getText();
	}
	public void verifyduplicateclassification() {
		duplicateclassification.isDisplayed();
	}
	public boolean verifyaddclassificationmasterdisabled() {
		return addclassificationmasterdisabled.isDisplayed();
	}
	public boolean verifyaddclassificationmasterenabled() {
		return addclassificationmasterenabled.isDisplayed();
	}
	public WebElement gettabone() {
		return tabone;
	}
	public void clicktabone() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tabone));
		wait.until(ExpectedConditions.elementToBeClickable(tabone));
		tabone.click();
	}
	public void clicktabtwo() {
		tabtwo.click();
	}
	public void clicktabthree() {
		tabthree.click();
	}
	public void verifyselectsecondwithoutmasterclassification() {
		selectsecondwithoutmasterclassification.click();
	}
	public void verifydeleteclassificationwithoutmaster() {
		deleteclassificationwithoutmaster.isDisplayed();
	}
	public void verifydeleteclassificationwhichisassigned() {
		deleteclassificationwhichisassigned.isDisplayed();
	}
	public void clickonadddesignation() {
		btnadddesignation.click();
	}
	public String getdesignatinnamemandatoryerror() {
		return designatinnamemandatoryerror.getText();
	}
	public void setdesinationname(String value) {
		txtdesinationname.sendKeys(value);
	}
	public void verifydesinationname() {
		deleteassigneddesignation.isDisplayed();
	}
	public void verifydesignationduplicateerror() {
		designationduplicateerror.isDisplayed();
	}
	public void clickbtnaddnew() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(btnaddnew));
		wait.until(ExpectedConditions.elementToBeClickable(btnaddnew));
		btnaddnew.click();
	}
	public String getfinancialnameerror() {
		return financialnameerror.getText();
	}
	public String getaccounttypeerror() {
		return accounttypeerror.getText();
	}
	public String getpincodeerror() {
		return pincodeerror.getText();
	}
	public String getbranchcodeerror() {
		return branchcodeerror.getText();
	}
	public String getifsccodeerror() {
		return ifsccodeerror.getText();
	}
	public String getmicrcodeerror() {
		return micrcodeerror.getText();
	}
	public String getaccountnumbererror() {
		return accountnumbererror.getText();
	}
	public String getemailerror() {
		return emailerror.getText();
	}
	public void setfinancialname(String value) {
		txtfinancialname.sendKeys(value);
	}
	public void clickaccounttype() {
		accounttype.click();
	}
	public void setaddress(String value) {
		txtaddress.sendKeys(value);
	}
	public void setpincode(String value) {
		txtpincode.sendKeys(value);
	}
	public void setbranchcode(String value) {
		txtbranchcode.sendKeys(value);
	}
	public void setifsccode(String value) {
		txtifsccode.sendKeys(value);
	}
	public void setmicrcode(String value) {
		txtmicrcode.sendKeys(value);
	}
	public void setaccountno(String value) {
		txtaccno.sendKeys(value);
	}
	public void setmail(String value) {
		txtemail.sendKeys(value);
	}
	public void verifybankduplicateerrror() {
		bankduplicateerrror.isDisplayed();	
	}
	public void verifydeleteassignedbank() {
		deleteassignedbank.isDisplayed();	
	}
	public void clickontemplate() {
		templatebutton.click();
	}
	public void uploadfile(String value) {
		draganddrop.sendKeys(value);
	}

//	public void clickuploadfile() {
//		Company_DocumentPage cmpdoc= new Company_DocumentPage(this.driver);
//		btnuploadfile.click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		String currentDirectory = System.getProperty("user.dir");
//		String downloadFilepath = (currentDirectory+"\\Download\\Designation Master Upload.xlsx");
//		try {
//			Robot robot = new Robot();
//		    robot.keyPress(KeyEvent.VK_ENTER);
//		    robot.keyRelease(KeyEvent.VK_ENTER);
//		    robot.delay(200);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	String home = System.getProperty("user.home");
//	String file = (home+"/Downloads/");
//	wait.until(cmpdoc.filepresent(file));
//}
	
	public void checkwrongexcelerror() {
		wrongexcelerror.isDisplayed();
	}
	public void clickuploadbutton() {
		btnuploadfile.click();
	}
	public void verifyfileinuploadsection() {
		verifyfile.isDisplayed();
	}
	public void clickremove() {
		btnremove.click();
	}
	public void verifysavenotification() {
		savenotification.isDisplayed();
	}
	public void excelnameverifyinsuccessstatus() {
		excelnameinsuccessstatus.isDisplayed();
	}
	public void verifysuccesspercent() {
		successpercent.isDisplayed();
	}
	public void verifytotal() {
		total.isDisplayed();
	}
	public void verifysuccess() {
		success.isDisplayed();
	}
	public void verifyfailed() {
		failed.isDisplayed();
	}
	public void clickdesignationtab() {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(designationtab));
		wait.until(ExpectedConditions.elementToBeClickable(designationtab));
		designationtab.click();
	}
	public void firstdesignationverify() {
		firstdesignation.isDisplayed();
	}
	public void tenthdesignationverify() {
		tenthdesignation.isDisplayed();
	}
	public void clicksecondpage() {
		Actions act= new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).perform();
		secondpage.click();
	}
	public void verifylastdesignation() {
		lastdesignation.isDisplayed();
	}
	public void setclassificationinput(String value) {
		classificationinput.sendKeys(value);
	}
	public void clicksave() {
		Actions act= new Actions(driver);
		act.moveToElement(btnsave).perform();
		btnsave.click();
	}
	public void clickonBtnclose() {
		btnclose.click();
	}
}

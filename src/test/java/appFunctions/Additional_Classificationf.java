package appFunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.Additional_Classification;

public class Additional_Classificationf {
	
	public WebDriver driver;
	Additional_Classification  clfpage;
	public Additional_Classificationf(WebDriver driver) {
		this.driver= driver;
	}
	public void checkclassificatiomastermandatoryfields() {
		clfpage =new Additional_Classification(this.driver);	
		clfpage.clickconfigdashboard();
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clickaddclassificationmaster();
		clfpage.clicksave();
		Assert.assertEquals("Field Required", clfpage.getclassificationmasternameerror());
		clfpage.clickonBtnclose();
//		Assert.assertEquals("Field Required", clfpage.getclassificationmasterprintnameerror());
	}
	public void withoutclassificationaddclassificationmasterandverify() {
		clfpage=new Additional_Classification(this.driver);
		clfpage.setclassifictionmastername("Abc");
//		clfpage.setclassificationmasterprintname("Abc");
		clfpage.clicksave();
		clfpage.verifymasternotavailerror();
	}
	public void checkclassificationmandatoryfields() {
		clfpage=new Additional_Classification(this.driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.clickaddclassification();
		clfpage.clicksave();
		Assert.assertEquals("Field Required", clfpage.getclassificationnameerror());
	}
	public void checkallclassificationvalidationsandnotifictions() {
		clfpage=new Additional_Classification(this.driver);
		clfpage.setclassifiationname("Abc");
		clfpage.clicksave();
//		clfpage.verifyprintnamemissingerror();

		clfpage.setclassifiationname("1");
//		clfpage.setprintname("Abc");
		clfpage.clicksave();
		clfpage.verifyclassificationnameformaterror();

//		clfpage.setprintname("1");
//		addcmppage.clicksave();
//		clfpage.verifyclassificationprintnameformaterror();
	}

	public void enteravalidclassificationdetailsandenablemandatorycheckboxandsave() {
		clfpage=new Additional_Classification(this.driver);
		clfpage.setclassifiationname(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
//		clfpage.setprintname(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
		clfpage.setclassifiationname("Classification A");
//		clfpage.setprintname("Class A");
		clfpage.clicksave();
		clfpage.verifyclassificationcreated();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.clicktabtwo();
		clfpage.verifyclassificationnameinmaster();	
	}

	public void addclassificationmaster() {
		clfpage=new Additional_Classification(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clicktabtwo();
		clfpage.clickonclassificationaddclassificatiomaster();
		clfpage.setclassifictionmastername("Classification 1");
//		clfpage.setclassificationmasterprintname("Class 1");
		clfpage.clicksave();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[contains(text(),'No Records To Show')]")));
		} catch (Exception e) {
		}
		driver.findElement(By.xpath("//td[contains(text(),'Classification 1')]")).isDisplayed();
	
		clfpage.clickonclassificationaddclassificatiomaster();
		clfpage.setclassifictionmastername("Classification 3");
//		clfpage.setclassificationmasterprintname("Class 3");
		clfpage.clicksave();
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h5[contains(text(),'No Records To Show')]")));
		} catch (Exception e) {
		}
		driver.findElement(By.xpath("//td[contains(text(),'Classification 3')]")).isDisplayed();
	}

	public void Verifyclassificationinemppage() {
		readexcel= new ReadExcel(this.driver);
		clfpage=new Additional_Classification(this.driver);
		Xls_Reader reader= new Xls_Reader(datafilepath);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[contains(text(),'Emp')]/parent::div")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[contains(text(),'Emp')]/parent::div")));
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		Actions act= new Actions(this.driver);
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (StaleElementReferenceException e) {
		}		

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='employee_details']/parent::h6/parent::div")));
		emppage.getEmployeedetails();
		emppage.getBtnaddemployee();
//		emppage.getTxtfirstname(reader.getCellData("Employee Details", 1, 2));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getTxtfirstname(reader.getCellData("Employee Details", 1, 2));
		emppage.getSelmaritalstatus();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 7, 2)+"')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("gender")));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("gender")));
		emppage.getSelgender();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 4, 2)+"')]")).click();
		emppage.setCalendardob(reader.getCellData("Employee Details", 5, 2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("04");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("2023");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
//		emppage.setCalendardateofsalary("10-04-2023");
		act.sendKeys(Keys.PAGE_UP).perform();
		wait1.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button"))));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		emppage.Btnnext();
	WebElement element=	driver.findElement(By.xpath("//span[contains(text(),'Select  "+classificationname1+"')]/parent::div/parent::div"));
	
	
	wait.until(ExpectedConditions.visibilityOf(element));
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	WebElement element1= driver.findElement(By.xpath("//li[contains(text(),'"+classificationmasterprintname+"')]"));
	wait.until(ExpectedConditions.visibilityOf(element1));
	wait.until(ExpectedConditions.elementToBeClickable(element1));
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("//li[contains(text(),'"+classificationmasterprintname+"')]");
	element1.click();
	}

	public void editclassificationenablemandatorycheckbox() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		Company_DetailsPage cmppage= new Company_DetailsPage(this.driver);
		Actions act= new Actions(driver);
		act.moveToElement(clfpage.getdesignationsection()).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmppage.clickeditgroup("Classification A");
		clfpage.clickcheckboxmandatory();
		addcmppage.clickoncompanysave();
		readexcel= new ReadExcel(this.driver);
		clfpage=new Additional_Classification(this.driver);
		Xls_Reader reader= new Xls_Reader(datafilepath);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[contains(text(),'Emp')]/parent::div")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[contains(text(),'Emp')]/parent::div")));
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='employee_details']/parent::h6/parent::div")));
		emppage.getEmployeedetails();
		emppage.getBtnaddemployee();
		emppage.getTxtfirstname(reader.getCellData("Employee Details", 1, 2));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getSelmaritalstatus();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 7, 2)+"')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("gender")));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("gender")));
		emppage.getSelgender();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 4, 2)+"')]")).click();
		emppage.setCalendardob(reader.getCellData("Employee Details", 5, 2));
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("04");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("2023");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
//		emppage.setCalendardateofsalary("10-04-2023");
		act.sendKeys(Keys.PAGE_UP).perform();
//		emppage.setCalendardateofsalary(reader.getCellData("Employee Details", 10, 2));
		wait1.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button"))));
		act.sendKeys(Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		emppage.Btnnext();
		emppage.Btnnext();
		Assert.assertEquals("Field Required", clfpage.classificationmandatoryerror());
	}
	public void editclassificationenableshowinformulaeditorcheckbox() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		Company_DetailsPage cmppage= new Company_DetailsPage(this.driver);
		Actions act= new Actions(driver);
		act.moveToElement(clfpage.getdesignationsection()).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		cmppage.clickeditgroup("Classification A");
		clfpage.clickcheckboxcheckinformulaeditor();
		addcmppage.clickoncompanysave();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		clfpage.clicksalarydashboard();
		clfpage.clickcomponentandstructuretab();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Formula Editor')]")));
		clfpage.clickformulatedtorsection();
		clfpage.clicksalarydashboard();
		clfpage.clicktxtvariable("Classification A");
		act.doubleClick(clfpage.classifictionainormulaeditor()).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//li[1])[3]")).click();
		Assert.assertEquals("(EmpDet{Classification A})", clfpage.formualaclassString());
	}
	public void checkduplicationofclassification() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clickaddclassification();
		clfpage.setclassifiationname("Classification A");
//		clfpage.setprintname("Class A");
		addcmppage.clicksave();
		clfpage.verifyduplicateclassification();
		addcmppage.clickonBtnclose();
		addcmppage.clickonBtndiscard();
		clfpage.clicktabtwo();
		clfpage.clickonclassificationaddclassificatiomaster();
		clfpage.setclassifictionmastername("Classification 1");
//		clfpage.setclassificationmasterprintname("Class 1");
		addcmppage.clicksave();
		clfpage.verifyduplicateclassification();
		addcmppage.clickonBtnclose();
		addcmppage.clickonBtndiscard();
	}
	public void addclassificationenablewithoutmastercheckbox() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Xls_Reader reader= new Xls_Reader(datafilepath);
		Actions act= new Actions(driver);
		clfpage.clickaddclassification();
		clfpage.setclassifiationname("Classification B");
//		clfpage.setprintname("Class B");
		clfpage.clickcheckboxwithoutmaster();
		addcmppage.clickoncompanysave();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vertical-tab-1")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vertical-tab-1")));
		act.moveToElement(clfpage.gettabone()).perform();
		driver.findElement(By.xpath("//button[@id='vertical-tab-1']")).isDisplayed();
		WebElement a=driver.findElement(By.xpath("(//button[@id='vertical-tab-1']//child::span)[1]"));
		 String b=a.getText();
		Assert.assertEquals("Classification A", b);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vertical-tab-1")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vertical-tab-1")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.clicktabthree();
		Assert.assertEquals(true, clfpage.verifyaddclassificationmasterdisabled());
		clfpage.clicktabone();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(true, clfpage.verifyaddclassificationmasterenabled());
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='employee_details']/parent::h6/parent::div")));
		emppage.getEmployeedetails();
		emppage.getBtnaddemployee();	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getTxtfirstname(reader.getCellData("Employee Details", 1, 2));
		emppage.getSelmaritalstatus();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 7, 2)+"')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("gender")));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("gender")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getSelgender();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 4, 2)+"')]")).click();
		emppage.setCalendardob(reader.getCellData("Employee Details", 5, 2));
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("04");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("2023");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
//		emppage.setCalendardateofsalary("10-04-2023");
		act.sendKeys(Keys.PAGE_UP).perform();
//		emppage.setCalendardateofsalary(reader.getCellData("Employee Details", 10, 2));
		wait1.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button"))));
		act.sendKeys(Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		emppage.Btnnext();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.verifyselectsecondwithoutmasterclassification();
		clfpage.setclassificationinput("Classification 2");
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//small[text()='Classification B']/parent::div/following-sibling::div/child ::div/child::div")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//li[1])[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath("//span[contains(text(),'Next')]//parent::button")));
}
	public void deleteassignedclassificationandverifynotification() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clicktabtwo();
		Company_DetailsPage cmppage= new Company_DetailsPage(this.driver);
		driver.findElement(By.xpath("//button[@id='vertical-tab-1']")).isDisplayed();
		WebElement a=driver.findElement(By.xpath("(//button[@id='vertical-tab-1']//child::span)[1]"));
		 String b=a.getText();
		Assert.assertEquals("Classification A", b);
		cmppage.clickdeletegroup("Classification A");
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		clfpage.verifydeleteclassificationwithoutmaster();
		branchpage.clickoncancel();
	}
	public void editclassificationmaster() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		ReadExcel readexcel=new ReadExcel(this.driver);
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clicktabtwo();
		String editrownum=readexcel.rowNo("Classification 1", "//table");
		int num1 = Integer.parseInt(editrownum);

		try {   
			num1 = Integer.parseInt(editrownum);
		} catch (NumberFormatException nfe) {
		  // Handle the condition when str is not a number.
		}
		
		int a=3;
		int row=num1+a;
		String b = Integer.toString(row);
		WebElement edit=driver.findElement(By.xpath("(//button[@aria-label='Edit'])["+b+"]"));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(edit);
		edit.click();
		clfpage.setclassifictionmastername("-Edit");
//		clfpage.setclassificationmasterprintname("-Edit");
		addcmppage= new Addcompany_PayrollPage(this.driver);
		addcmppage.clickoncompanysave();
	}
	
	public void deleteclassificationmaster() {
		ReadExcel readexcel=new ReadExcel(this.driver);
		clfpage=new Additional_Classification(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		driver.findElement(By.id("vertical-tab-2")).click();
		String rownum=readexcel.rowNo("Classification 2", "//table");
		int num2 = 0;
		try {   
			num2 = Integer.parseInt(rownum);
			} catch (NumberFormatException nfe) {
			  // Handle the condition when str is not a number.
			}
		int c=3;
		int row=num2+c;
		String f = Integer.toString(row);
		System.out.println(f);
		WebElement delete=driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+f+"]"));
		wait.until(ExpectedConditions.visibilityOf(delete));
		wait.until(ExpectedConditions.elementToBeClickable(delete));
		delete.click();
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
	}
	
	public void deleteclassification() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
				clfpage.clickclassificationtab();
			}
		} catch (Exception e) {
		}		
		
		clfpage.clickClassificationadditional();
		Company_DetailsPage cmppage= new Company_DetailsPage(this.driver);
		driver.findElement(By.id("vertical-tab-2")).click();
		cmppage.clickdeletegroup("Classification B");
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
	}
	
	public void assignclassificationtoemployeeanddelete() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Xls_Reader reader= new Xls_Reader(datafilepath);
		Actions act= new Actions(driver);
		AddCompany_payrollFunctions addcmp= new AddCompany_payrollFunctions(this.driver);
		SearchCompanyInlistFunctions searchcmp=new SearchCompanyInlistFunctions(this.driver);
		searchcmp.clickoncreatedcompany(addcmp.mandatorycompanyname);
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='employee_details']/parent::h6/parent::div")));
		emppage.getEmployeedetails();
		emppage.getBtnaddemployee();	
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getTxtfirstname(reader.getCellData("Employee Details", 1, 2));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getSelmaritalstatus();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 7, 2)+"')]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("gender")));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("gender")));
		emppage.getSelgender();
		driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 4, 2)+"')]")).click();
		emppage.setCalendardob(reader.getCellData("Employee Details", 5, 2));
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("01");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("04");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining("2023");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.setCalendardateofjoining(Keys.CONTROL+"a");
//		emppage.setCalendardateofsalary("10-04-2023");
		act.sendKeys(Keys.PAGE_UP).perform();
//		emppage.setCalendardateofsalary(reader.getCellData("Employee Details", 10, 2));
		wait1.until((ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button"))));
		act.sendKeys(Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		emppage.Btnnext();
		System.out.println("//span[contains(text(),'"+classificationname1+"')]/parent::div/parent::div");
		WebElement element=	driver.findElement(By.xpath("//span[contains(text(),'"+classificationname1+"')]/parent::div/parent::div"));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
//		WebElement element1= driver.findElement(By.xpath("li['"+classificationmasterprintname+"']"));
//		wait.until(ExpectedConditions.visibilityOf(element1));
//		wait.until(ExpectedConditions.elementToBeClickable(element1));
//		element1.click();
		driver.findElement(By.xpath("(//li[2])[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("branchId")));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getSelbranch().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//li[1])[2]")));
		driver.findElement(By.xpath("(//li[1])[2]")).click();
		emppage.getSelsalarystructure().click();
		driver.findElement(By.xpath("(//li[1])[2]")).click();
		emppage.getSelleavepolicy().click();
		driver.findElement(By.xpath("(//li[1])[2]")).click();
		act.sendKeys(Keys.PAGE_DOWN).perform();
		emppage.getSelattendancestructure();
		driver.findElement(By.xpath("(//li[1])[2]")).click();
		emppage.clickSeldesignation();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[contains(text(),'Close')]/parent::button")));
		driver.findElement(By.xpath("//li[contains(text(),'Tester')]")).click();
		emppage.getSelbank();
		driver.findElement(By.xpath("(//li[2])[1]")).click();
		driver.findElement(By.id("accountNo")).sendKeys("77266344071424");
		act.sendKeys(Keys.PAGE_UP).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]//parent::button")));
		emppage.Btnnext();
		emppage.getTxtpan("PANNOTAVBL");
		emppage.Btnnext();
		emppage.getTxtresidentno(reader.getCellData("Employee Details", 0, 42));
		emppage.getTxtresidentalname(reader.getCellData("Employee Details", 1, 42));
		emppage.getTxtresidentstreet(reader.getCellData("Employee Details", 2, 42));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		emppage.getTxtresidentlocality(reader.getCellData("Employee Details", 3, 42));
		emppage.getTxtresidentcity(reader.getCellData("Employee Details", 4, 42));		
		act.sendKeys(Keys.PAGE_DOWN).perform();
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("presentStateId")));
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("presentStateId")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emppage.getSelresidentstate()); emppage.getSelresidentstate().click();
		WebElement element1= driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 5, 42)+"')]"));
		act.moveToElement(element1).perform();
		element1.click();
		emppage.getTxtpresentpincode(reader.getCellData("Employee Details", 6, 42));
		act.sendKeys(Keys.PAGE_UP).perform();
		act.sendKeys(Keys.PAGE_UP).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		emppage.getCheckboxsameaddress().click();
		act.sendKeys(Keys.PAGE_UP).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(//input[@value='#12'])[2]")).isDisplayed();
		Assert.assertEquals(reader.getCellData("Employee Details", 0, 42), emppage.getTxtpermresno().getAttribute("value"));
		Assert.assertEquals(reader.getCellData("Employee Details", 1, 42), emppage.getTxtpermresname().getAttribute("value"));
		Assert.assertEquals(reader.getCellData("Employee Details", 2, 42), emppage.getTxtpermstreet().getAttribute("value"));
		Assert.assertEquals(reader.getCellData("Employee Details", 3, 42), emppage.getTxtpermlocality().getAttribute("value"));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		Assert.assertEquals(reader.getCellData("Employee Details", 4, 42), emppage.getTxtpermcity().getAttribute("value"));
		Assert.assertEquals(reader.getCellData("Employee Details", 5, 42), emppage.getTxtpermstate().getText());
		Assert.assertEquals(reader.getCellData("Employee Details", 6, 42), emppage.getTxtpermpincodevalue());
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Permanent Address is same as Present Address')]")));
//		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Permanent Address is same as Present Address')]")));
//		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Permanent Address is same as Present Address')]")));
		act.sendKeys(Keys.PAGE_UP).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		emppage.getCheckboxsameaddress().click();
//		emppage.getTxtpermresno().sendKeys(reader.getCellData("Employee Details", 0, 43));
//		emppage.getTxtpermresname().sendKeys(reader.getCellData("Employee Details", 1, 43));
//		emppage.getTxtpermstreet().sendKeys(reader.getCellData("Employee Details", 2, 43));
//		emppage.getTxtpermlocality().sendKeys(reader.getCellData("Employee Details", 3, 43));
//		emppage.getTxtpermcity().sendKeys(reader.getCellData("Employee Details", 4, 43));
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("permStateId")));
//		wait1.until(ExpectedConditions.elementToBeClickable(By.id("permStateId")));
//		act.moveToElement(emppage.getTxtpermstate()).perform();
//		emppage.getTxtpermstate().click();
//		WebElement statelist=driver.findElement(By.xpath("//li[contains(text(),'"+reader.getCellData("Employee Details", 5, 43)+"')]"));
//		act.moveToElement(statelist).perform();
//		statelist.click();
//		emppage.getTxtpermpincode(reader.getCellData("Employee Details", 6, 43));
//		act.sendKeys(Keys.PAGE_UP).perform();
		emppage.getTxtmobile(reader.getCellData("Employee Details", 7, 43));
		emppage.getTxtaltmobile(reader.getCellData("Employee Details", 8, 43));
		emppage.getTxtofficialmailid(reader.getCellData("Employee Details", 9, 43));
		act.sendKeys(Keys.PAGE_DOWN).perform();
		emppage.gettxtemail1(reader.getCellData("Employee Details", 10, 43));
		emppage.getTxtemergencynumber(reader.getCellData("Employee Details", 11, 43));
		act.sendKeys(Keys.PAGE_UP).perform();
		emppage.getBtnsaveancontinue();
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickClassificationadditional();
		clfpage.clicktabtwo();
		readexcel= new ReadExcel(this.driver);
		String rownum=readexcel.rowNo("Classification 1-Edit", "//table");
		int num2 = 0;
		try {   
			num2 = Integer.parseInt(rownum);
			} catch (NumberFormatException nfe) {
			}
		int c=1;
		int row=num2+c;
		String f = Integer.toString(row);
		System.out.println(f);
		WebElement delete=driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+f+"]"));
		wait.until(ExpectedConditions.visibilityOf(delete));
		wait.until(ExpectedConditions.elementToBeClickable(delete));
		delete.click();
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		clfpage.verifydeleteclassificationwhichisassigned();
		branchpage.clickoncancel();
	}
	
	public void checkdesignationmandatoryfieldsandvalidatons() {
		Actions act= new Actions(driver);
		clfpage=new Additional_Classification(this.driver);
		AddCompany_payrollFunctions addcmp= new AddCompany_payrollFunctions(this.driver);
		SearchCompanyInlistFunctions searchcmp=new SearchCompanyInlistFunctions(this.driver);
		searchcmp.clickoncreatedcompany(addcmp.mandatorycompanyname);
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}	
//		act.moveToElement(clfpage.getdesignationsection()).perform();
		clfpage.clickclassificationtab();
		clfpage.clickdesignationsection();
		try {
			clfpage.clickonadddesignation();
		} catch (Exception e) {
		}
		
		addcmppage= new Addcompany_PayrollPage(this.driver);
		addcmppage.clicksave();
		Assert.assertEquals("Field Required", clfpage.getdesignatinnamemandatoryerror());	
	}
	
	public void enterdesinationfieldandsave() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		clfpage.setdesinationname("Tester");
		addcmppage.clickoncompanysave();
		readexcel= new ReadExcel(this.driver);
		driver.findElement(By.xpath("//td[text()='Tester']")).isDisplayed();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.clickonadddesignation();
		Assert.assertEquals(true, readexcel.verifytext("Tester"));
		clfpage.setdesinationname("Developer");
		addcmppage.clickoncompanysave();
		readexcel= new ReadExcel(this.driver);
		driver.findElement(By.xpath("//td[text()='Developer']")).isDisplayed();
		Assert.assertEquals(true, readexcel.verifytext("Developer"));
	}
	
	public void editdesinationfieldandsave() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		Actions act= new Actions(driver);
		for(int i=0; i<5;i++)try {
			{
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}	
//		act.moveToElement(clfpage.getdesignationsection()).perform();
		clfpage.clickclassificationtab();
		clfpage.clickdesignationsection();
		String editrownum=readexcel.rowNo("Developer", "//table");
		WebElement element= driver.findElement(By.xpath("(//button[@aria-label='Edit'])["+editrownum+"]"));
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		clfpage.setdesinationname("-Edit");
		addcmppage.clickoncompanysave();
		driver.findElement(By.xpath("//td[text()='Developer-Edit']")).isDisplayed();
		Assert.assertEquals(true, readexcel.verifytext("Developer-Edit"));
	}
	
	public void deletedesinationfieldandsave() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		String editrownum=readexcel.rowNo("Developer-Edit", "//table");
		WebElement element= driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+editrownum+"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(),'Developer')]")));
	}
	public void deleteassigneddesinationandverifyvalidation() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		for(int i=0; i<5;i++)try {
			{
				Actions act= new Actions(driver);
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}
		clfpage.clickclassificationtab();
		clfpage.clickdesignationsection();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String editrownum=readexcel.rowNo("Tester", "//table");
		WebElement element= driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+editrownum+"]"));
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clfpage.verifydesinationname();
		driver.findElement(By.xpath("//span[text()='Cancel']/parent::button")).click();
	}
	
	public void checkdesignationduplication() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		clfpage.clickonadddesignation();
		clfpage.setdesinationname("Tester");
		addcmppage.clicksave();
		clfpage.verifydesignationduplicateerror();
		addcmppage.clickonBtnclose();
	}
	
	public void checkbanksectionmandatoryfieldsndvalidations() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		AddCompany_payrollFunctions addcmp= new AddCompany_payrollFunctions(this.driver);
		SearchCompanyInlistFunctions searchcmp=new SearchCompanyInlistFunctions(this.driver);
		searchcmp.clickoncreatedcompany(addcmp.mandatorycompanyname);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickbankssection();
		try {
			clfpage.clickbtnaddnew();
		} catch (Exception e) {
		}
		
		addcmppage.clicksave();
		Assert.assertEquals("Field Required", clfpage.getfinancialnameerror());	
		Assert.assertEquals("Field Required", clfpage.getaccounttypeerror());	
//		Assert.assertEquals("Field Required", clfpage.getbranchcodeerror());
		clfpage.setfinancialname("a");
		addcmppage.clicksave();
		Assert.assertEquals("Minimum 2 Character Required", clfpage.getfinancialnameerror());	
		clfpage.setfinancialname("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		addcmppage.clicksave();
		Assert.assertEquals("Maximum 75 Character Allowed", clfpage.getfinancialnameerror());	
		clfpage.setpincode("1");
		clfpage.setbranchcode("1");
		clfpage.setifsccode("1");
		clfpage.setmicrcode("1");
		clfpage.setaccountno("1");
		clfpage.setmail("a");
		addcmppage.clicksave();
//		Assert.assertEquals("Exact 6 digits required", clfpage.getpincodeerror());
//		Assert.assertEquals("Minimum 3 Character Required", clfpage.getbranchcodeerror());	
		Assert.assertEquals("Field Required", clfpage.getaccounttypeerror());	
		Assert.assertEquals("Invalid IFSC Code", clfpage.getifsccodeerror());
//		Assert.assertEquals("Minimum 3 Character Required", clfpage.getmicrcodeerror());
		Assert.assertEquals("Invalid A/C", clfpage.getaccountnumbererror());
//		Assert.assertEquals("Invalid email", clfpage.getemailerror());
		addcmppage.clickonBtnclose();
		addcmppage.clickonBtndiscard();
	}
	public void Enterbanksectionmandatoryfieldsndsave() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		clfpage.clickbtnaddnew();
		clfpage.setfinancialname("SBI");
		clfpage.clickaccounttype();
		addcmppage.selectdatafromlist("Salary Account");
		clfpage.setifsccode("SBIN0123456");
		clfpage.setbranchcode("123123");
		addcmppage.clickoncompanysave();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'SBI')]")));
		Assert.assertEquals(true, readexcel.verifytext("SBI"));
	}
	public void checkbankduplication() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickbankssection();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Add New')]/parent::button")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add New')]/parent::button")));
		clfpage.clickbtnaddnew();
		clfpage.setfinancialname("SBI");
		clfpage.clickaccounttype();
		addcmppage.selectdatafromlist("Salary Account");
		clfpage.setifsccode("SBIN0123456");
		clfpage.setbranchcode("123123");
		addcmppage.clicksave();
		clfpage.verifybankduplicateerrror();
		addcmppage.clickonBtnclose();
		addcmppage.clickonBtndiscard();
	}
	public void Enterbanksectionallfieldsndsave() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		clfpage.clickbtnaddnew();
		clfpage.setfinancialname("ICICI");
		clfpage.clickaccounttype();
		addcmppage.selectdatafromlist("Loan");
		clfpage.setaddress("Rajajinagar Banglore");
		clfpage.setpincode("561561");
		clfpage.setbranchcode("312313");
		clfpage.setifsccode("ICIC0878787");
		clfpage.setmicrcode("1231312");
		clfpage.setaccountno("231231232131322");
		clfpage.setmail("aabv@ytsdyu.afffak");
		addcmppage.clickoncompanysave();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'ICICI')]")));
		Assert.assertEquals(true, readexcel.verifytext("ICICI"));
	}
	
	public void editbankaccount() {
		clfpage=new Additional_Classification(this.driver);
		readexcel= new ReadExcel(this.driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for(int i=0; i<5;i++)try {
			{

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//small[text()='Emp']/parent::div")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//small[text()='Emp']/parent::div")));
				clfpage.clickconfigdashboard();
			}
		} catch (Exception e) {
		}		
		clfpage.clickclassificationtab();
		clfpage.clickbankssection();
		String editrownum=readexcel.rowNo("ICICI", "//table");
		WebElement edit=driver.findElement(By.xpath("(//button[@aria-label='Edit'])["+editrownum+"]"));
		wait.until(ExpectedConditions.visibilityOf(edit));		
		wait.until(ExpectedConditions.elementToBeClickable(edit));
		edit.click();
		clfpage.setfinancialname("Edit");
		clfpage.setaddress("Edit");
		addcmppage.clickoncompanysave();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'ICICIEdit')]")));
		Assert.assertEquals(true, readexcel.verifytext("ICICIEdit"));
	}
	
	public void deletebankaccount() {
		clfpage=new Additional_Classification(this.driver);
		readexcel= new ReadExcel(this.driver);
		try {
			clfpage.clickbankssection();
		} catch (Exception e) {
		}
		String editrownum=readexcel.rowNo("ICICIEdit", "//table");
		WebElement edit=driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+editrownum+"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", edit);
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(),'ICICIEdit')]")));
	}
	
	public void deleteassignedbankaccountandverifyvalidations() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage= new Addcompany_PayrollPage(this.driver);
		readexcel= new ReadExcel(this.driver);
		clfpage.clickbankssection();
		String editrownum=readexcel.rowNo("SBI", "//table");
		WebElement edit=driver.findElement(By.xpath("(//button[@aria-label='Delete'])["+editrownum+"]"));
		edit.click();
		BranchPage branchpage= new BranchPage(this.driver);
		branchpage.clickondeleteconfirm();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'SBI')]")));
		clfpage.verifydeleteassignedbank();
	}
	
	public void downloadexeeltemplate() {
		clfpage=new Additional_Classification(this.driver);
		addcmppage = new Addcompany_PayrollPage(this.driver);
		
		AddCompany_payrollFunctions addcmp= new AddCompany_payrollFunctions(this.driver);
		SearchCompanyInlistFunctions searchcmp=new SearchCompanyInlistFunctions(this.driver);
		searchcmp.clickoncreatedcompany(addcmp.mandatorycompanyname);
		EmployeeDetailsPage emppage= new EmployeeDetailsPage(this.driver);
		for(int i=0; i<5;i++)try {
			{
				Actions act= new Actions(driver);
				emppage.getLinkemp().click();
				act.moveToElement(emppage.getLinkemp()).perform();
				emppage.getLinkemp().click();
			}
		} catch (Exception e) {
		}	
//		act.moveToElement(clfpage.getdesignationsection()).perform();
		clfpage.clickclassificationtab();
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Import')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Import')]")));
//		addcmppage.clickonBtnclose();
		clfpage.clickimportsection();
		clfpage.clickontemplate();
		Actions act= new Actions(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.sendKeys(Keys.ENTER).perform();
		clfpage.clickuploadfile();	
	}
	
	public void uploadwrongexceltemplate() {
		clfpage=new Additional_Classification(this.driver);
		File file=new File(datafilepath);
		clfpage.uploadfile(file.getAbsolutePath());
		clfpage.checkwrongexcelerror();
	}
	
	public void uploadvalidexcelandverifydata() {
		clfpage=new Additional_Classification(this.driver);
		File file=new File(validdesignationfilepath);
		clfpage.uploadfile(file.getAbsolutePath());
		clfpage.verifyfileinuploadsection();
		clfpage.clickremove();
		clfpage.uploadfile(file.getAbsolutePath());
		clfpage.clickuploadbutton();
//		clfpage.verifysavenotification();
		clfpage.excelnameverifyinsuccessstatus();
		clfpage.verifysuccesspercent();
		clfpage.verifytotal();
		clfpage.verifysuccess();
		clfpage.verifyfailed();
	}
	
	public void verifyimporteddesigantions() {
		clfpage=new Additional_Classification(this.driver);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).perform();
		clfpage.clickdesignationtab();
		clfpage.firstdesignationverify();
		clfpage.tenthdesignationverify();
		clfpage.clicksecondpage();
		clfpage.verifylastdesignation();	
	}
	

}

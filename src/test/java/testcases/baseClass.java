package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.loginPage;
import utilities.ReadConfig;


public class baseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String baseurl=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public WebDriver driver;
	
	public Logger logger;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws InterruptedException, IOException
	{	
		logger=Logger.getLogger("SPP Testing");
		PropertyConfigurator.configure("Log4j.properties");
		logger=Logger.getLogger("saralpro");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(br.equals("firefox"))
		{
			driver=new FirefoxDriver();	
		}
		else if(br.equals("ie"))
		{
			driver=new InternetExplorerDriver();
		}
		else if(br.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		loginPage lp=new loginPage(driver);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(baseurl);
		lp.txtUserName(readconfig.getUsername());
		lp.txtPassword(readconfig.getPassword());
		lp.clickLogin();
//		addcmpf=new AddCompany_payrollFunctions(driver);
//		Assert.assertEquals("Classification", addcmppage.getVerifydashboard());
	}
		@AfterClass 
		public void teardown(){
			driver.quit();
		}	  
}

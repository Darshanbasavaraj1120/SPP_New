package testcases;

import org.testng.annotations.Test;

import appFunctions.searchCompany;

public class sampleTest extends baseClass {
	
	@Test(priority = 0)
	public void sampletest() {
		searchCompany search=new searchCompany(driver);
		search.clickOnCreatedCompany("Automation");
	}

}

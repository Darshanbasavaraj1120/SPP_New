package utilities;


import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ReadExcel {
	static Workbook book;;
	static Sheet sheet;
	public WebDriver driver;
	public ReadExcel(WebDriver rdriver)
	{
		driver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	public String rowNo(String value,String xpath)
	{
		WebElement table =driver.findElement(By.xpath(xpath));
		WebElement tbody=table.findElement(By.tagName("tbody"));
		List<WebElement> rows=tbody.findElements(By.tagName("tr"));
		String rowNo="";
		for(int i=0;i<rows.size();i++)
		{
			WebElement row = tbody.findElement(By.xpath("//tbody/tr["+(i+1)+"]"));
			String text =row.getText();
			System.out.println(text);
			if(row.getText().trim().contains(value))
			{
				rowNo=Integer.toString(i+1); 
				break;
			}
		}
		return rowNo;
	}

	public boolean verifytext(String hastext) {
		String table=driver.findElement(By.xpath("//table")).getText();
		System.out.println(table);
		boolean text=table.contains(hastext);
		return text;
	}

	public String tablevalue(int row,int column) {
		String value=driver.findElement(By.xpath("//tbody/tr["+row+"]/td["+column+"]")).getText();
		return value;
	}
	public boolean istextexist(String xpath,String text) {
		String value=driver.findElement(By.xpath(xpath)).getText().trim();
		System.out.println(value);
		if(value.contains(text))
		{
			System.out.println("value exist");
			return true;
		}
		return false;
	}
	public String getserialnumber(String value) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]/ancestor::div[@class='MuiBox-root css-3kckjd']")).getAttribute("value");

	}

}

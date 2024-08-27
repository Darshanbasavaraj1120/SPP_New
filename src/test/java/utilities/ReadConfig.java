package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;




public class ReadConfig{
	
	Properties pro;
	
	public ReadConfig()
	{
		File src=new File("./Configuration/config.properties");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println(" Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}

	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	public String getcompanyname()
	{
		String companyname=pro.getProperty("companyname");
		return companyname;
	}
	public static Boolean isFileDownloaded(String fileName) {
        boolean flag = false;
        String home =System.getProperty("user.home");
        String dirPath = (home+"//Downloads"); 
        File dir = new File(dirPath);
        System.out.println(dirPath);
        File[] files = dir.listFiles();
        if (files.length == 0 || files == null) {
            System.out.println("The directory is empty");
            flag = false;
        } else {
            for (File listFile : files) {
                if (listFile.getName().contains(fileName)) {
                    System.out.println(fileName + " is present");
                    break;
                }
                flag = true;
            }
        }
        return flag;
    }
//	public void uploadfile(String path,String element )
//	{
//		WebElement upload_file = driver.findElement(By.xpath(element));
//		upload_file.sendKeys(path);
//	}
	
}

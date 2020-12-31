package Urgent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Class1 {	   
	static WebDriver driver;
	@Test()
	public void LoginSF() throws Exception
	{
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\ChromeDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	    
		//navigate to amazon
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);
	}
}


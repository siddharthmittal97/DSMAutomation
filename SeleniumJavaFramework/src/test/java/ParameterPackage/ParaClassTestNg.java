package ParameterPackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class ParaClassTestNg {
	WebDriver driver = null;
	
	@Test()
	public void Setup()
	{
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test()
	public void VerfyError() {
		driver.get("https://accounts.google.com/signin");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String a = driver.findElement(By.xpath("//div[contains(text(),'Enter an email or phone number')]")).getText();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String Actual = "Enter a email or phone number";
		Assert.assertEquals(a,Actual);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}
	@AfterTest()
	@Parameters({"Username"})
	public void CorrectName(String Username) {
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.id("identifierId")).sendKeys(Username);
	driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
	}
}

package SalesforceLeadsCreation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class Leads {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("siddharthautomation@mirketa.com");
		driver.findElement(By.id("password")).sendKeys("qwerty12345");
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		WebElement a = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
		a.sendKeys("Lead");
		driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']")).submit();
		WebElement b = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
		b.submit();
	}

}

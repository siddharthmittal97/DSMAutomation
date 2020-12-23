package SalesforcePackage;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
public class Automation1 {

	public static void main(String[] args) throws InterruptedException {
		//properties Prop;
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		
		//Prop = new Properties();
		
		//login
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		//Thread.sleep(80000);-------80 seconds wait
		
		driver.manage().window().maximize();
		
		//login1
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("siddharthautomation@mirketa.com");
		driver.findElement(By.id("password")).sendKeys("qwerty12345");
		driver.findElement(By.id("Login")).click();
		
		//App launcher
		//driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();	 
		//driver.findElement(By.xpath("//button[@class='slds-button slds-show']"));
		//Thread.sleep(6000);
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		
	    //driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		
	     //driver.findElement(By.className("slds-icon-waffle")).click();
	     //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	     
	     
	     //driver.findElement(By.className("slds-input")).sendKeys("RRD");
	     //WebElement a = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
	     //driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
	     //Thread.sleep(3000);
	     //a.sendKeys("Accounts");
	     //Thread.sleep(1000);
	     //Actions actions = new Actions(driver);
	     //actions.sendKeys(Keys.RETURN);
	     driver.get("https://ap16.lightning.force.com/lightning/o/Account/home");
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//div[contains(text(),'New')]")).click();
	     
	     //driver.navigate("https://ap16.lightning.force.com/lightning/o/Account/home");
	     //Actions actions = new Actions(driver);
	     //WebElement elementLocator = driver.findElement(By.xpath("//input[@placeholder='Search apps and items...']"));
	     //actions.Enter(elementLocator).perform();
	     //a.submit();
	     //driver.findElement(By.id("input-63")).sendKeys("Accounts");
	     //driver.findElement(By.id("input-88")).sendKeys("RRD");
	     //List<WebElement> app = driver.findElements(By.xpath("//input[@placeholder='Search apps and items...']"));
	     
	}

}

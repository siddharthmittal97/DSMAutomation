package SFAutomation;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
public class Account {
	public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			String projectpath = System.getProperty("user.dir");
			System.out.println("projectpath : "+projectpath);
			System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
			
			 // 
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--disable-notifications");
			 
			 WebDriver driver = new ChromeDriver(options);
			 
			 /*
			 driver.get("https://login.salesforce.com/");
			 driver.manage().window().maximize();
			 */
			    
		    driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		    driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		    driver.get("https://login.salesforce.com");
		    driver.manage().window().maximize();
		    
			 //WebElement input = driver.findElement(By.cssSelector("#nav-cart"));
			 //System.out.println("L"+input);
			 
			 //Actions actions = new Actions(driver);
			 //WebElement elementLocator = driver.findElement(By.cssSelector("#nav-cart"));
			 //actions.doubleClick(elementLocator).perform();
			        
			 WebElement username  = driver.findElement(By.xpath("//input[@id='username']")); 
			 username.sendKeys("siddharthautomation@mirketa.com");    
			 //getting the element & inserting username
			 WebElement password  = driver.findElement(By.id("password"));
			 password.sendKeys("qwerty12345");
			 Actions actions = new Actions(driver);
			 WebElement elementLocator = driver.findElement(By.id("Login"));
			 actions.doubleClick(elementLocator).perform();
			 
			 Thread.sleep(200);
			 //WebElement search = driver.findElement(By.xpath("//input[@id='852:0']"));
			 //System.out.println(search);
			 //search.sendKeys("Users");
			 /*
			 Actions actions2 = new Actions(driver);
			 WebElement elementLocator1 = driver.findElement(By.xpath("//button[@class='slds-button slds-show']"));
			 actions2.click(elementLocator1).perform();		 
			 */
	}

}

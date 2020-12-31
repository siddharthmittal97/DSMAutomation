//import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.firefox.FirefoxDriver;
public class SiddharthCode1 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub	
		
		//Get the Path
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
	    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\SeleniumJavaFramework\\Drivers\\chromedriver\\chromedriver.exe");
		
		//initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
       
        driver.get("https://test.salesforce.com/");
        
        Thread.sleep(100);// 1 minute gap 
        driver.manage().window().maximize();
        
        //getting the element & inserting username 
        //WebElement username  = driver.findElement(By.id("username"));
        //username.sendKeys("vandana.roy@mirketalr.com");
        
        WebElement username  = driver.findElement(By.xpath("//input[@id='username']")); 
        username.sendKeys("vandana.roy@mirketalr.com");
        
       //getting the element & inserting username
        WebElement password  = driver.findElement(By.id("password"));
        password.sendKeys("Password");
        //password.submit();
       
        //Click Actions
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.id("Login"));
        actions.doubleClick(elementLocator).perform();
        
        Thread.sleep(3000);
        String expectedTitle = "Lightning Experience";
        String actualTitle = "";
        actualTitle = driver.getTitle();
        System.out.println("actualTitle");
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        //Lightning Experience
        
        //alert
        //Thread.sleep(3000);
        //driver.switchTo().alert().accept();
        
       /*
        Actions actions = new Actions(driver);
        WebElement elementLocator = driver.findElement(By.xpath("//span[@class='slds-truncate'][contains(text(),'Accounts')]"));
        actions.doubleClick(elementLocator).perform();
       
        
        
        System.out.println( "Page title is:" +driver.getTitle());
        
        List<WebElement> listofInputElements = driver.findElements(By.xpath("//input"));
        int count = listofInputElements.size();
        System.out.println("Count is equal to : "+count);
        //Click
        //driver.findElement(By.id("Login")).click();
        
        //Click Actions
        //Actions actions = new Actions(driver);
        //WebElement elementLocator = driver.findElement(By.id("Login"));
        //actions.doubleClick(elementLocator).perform();
       // driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        System.out.println("Selenium Webdriver Script in Chrome");
       */
	}
}

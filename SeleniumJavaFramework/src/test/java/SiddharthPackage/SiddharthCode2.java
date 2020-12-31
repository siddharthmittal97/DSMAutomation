package SiddharthPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SiddharthCode2 {

	public static void main(String[] args) throws InterruptedException {
		
		//setting the path
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		
		// initialise the chrome driver
		 WebDriver driver = new ChromeDriver();
		 
		 // fetching 
		 driver.get("https://test.salesforce.com/");
		 
		 //giving the gap till the page fully loads
	     Thread.sleep(3000);
	     
	     //maximize the window
	     driver.manage().window().maximize();
		
	     //find element & send keys 
	     WebElement username  = driver.findElement(By.xpath("//input[@id='username']")); 
	     username.sendKeys("vandana.roy@mirketalr.com");
	     WebElement password  = driver.findElement(By.id("password"));
	     password.sendKeys("Password");// you can enter also here 
	     password.submit();
	     //Just Checking the print
	     System.out.println("Test fully passed");
	     Thread.sleep(3000);
	     WebElement app = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
	     app.click();
	}

}

package flipkart;
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
public class fliplogin {	
	public static WebDriver driver;//so that it does not occupy the extra space so we have declare as static
	public void login() throws Exception 
	{	
	driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys("siddharthmittal97@gmail.com");
	driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("Hondacivic97");
	driver.findElement(By.xpath("//div[3]//button[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.name("q")).sendKeys("samsung mobiles");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//WebElement wb = driver.findElement(By.name("q"));
	//wb.submit();
	//Actions act = new Actions(driver);
	
	}
	
	public static void main(String[] args) throws Exception {
	{
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    //driver.get("https://test.salesforce.com/");
		driver.navigate().to("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(5000);
		fliplogin v = new fliplogin();
		v.login();
	}
}
}




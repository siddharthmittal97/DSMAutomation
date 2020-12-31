package LearningPackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Learning1 {
	public static WebDriver driver;
	public static void main(String[] args) throws Exception {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		
	    //driver.get("https://test.salesforce.com/");
		driver.navigate().to("https://www.flipkart.com/");
		
		// Using Thread 
		Thread.sleep(2000);
		
		//Using Implicit wait
		//driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS) ;
		
		
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		Learning1 call = new Learning1();
		call.logic();
	}
	
	  public void logic() throws Exception {
		  
		//driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys("siddharthmittal97@gmail.com");
		  
		//driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("siddharthmittal97@gmail.com");
		  
		driver.findElement(By.xpath("/descendant::input[@type='text'][2]")).sendKeys("siddharthmittal97@gmail.com");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("Password");
		driver.findElement(By.xpath("//div[3]//button[1]")).click();
		//Thread.sleep(2000);
		//driver.findElement(By.name("q")).sendKeys("iphone");
		//WebElement a = driver.findElement(By.name("q"));
		
		WebDriverWait wait=new WebDriverWait(driver, 20); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys("iphone"); 
        WebElement a = driver.findElement(By.name("q"));
        a.submit();
        
		//a.submit();
		//Thread.sleep(8000);
        //JavascriptExecutor js = (JavascriptExecutor) driver;       
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
}

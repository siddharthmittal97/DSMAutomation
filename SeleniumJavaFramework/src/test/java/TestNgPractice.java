import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgPractice {
public static WebDriver driver;

@BeforeTest
  public void Setup() throws Exception {
	  String projectpath = System.getProperty("user.dir");
	  System.out.println("projectpath : "+projectpath);
	  System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.navigate().to("https://www.flipkart.com/");
	  Thread.sleep(2000);
}
@Test
 public void Maximize() {
		//Using Implicit wait
	    //driver.manage().timeouts().implicitlyWait(180,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	  
	}

@Test
public void Login() throws Exception
 {
	   driver.findElement(By.xpath("/descendant::input[@type='text'][2]")).sendKeys("siddharthm@gmail.com");
	   driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("Password");
	   driver.findElement(By.xpath("//div[3]//button[1]")).click();
	  /*
	   String ActualError = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/span[2]/span[1]")).getText();
	   String ExpectedError = "Please enter valid Email ID/Mobile number";
	   Assert.assertEquals(ActualError,ExpectedError);
	   */
	   //Thread.sleep(2000);
	   //driver.findElement(By.name("q")).sendKeys("iphone");
	   //WebElement a = driver.findElement(By.name("q"));
}
@Test
public void SearchBox() 
{
	    WebDriverWait wait=new WebDriverWait(driver, 20); 
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        driver.findElement(By.name("q")).sendKeys("iphone"); 
        WebElement a = driver.findElement(By.name("q"));
        a.submit();
  }
@Test
public void Copy() throws Exception {
	 Thread.sleep(8000);
	 List<WebElement> s = driver.findElements(By.xpath("//div[@class='_3wU53n']"));
	  System.out.println("Check Size" +s.size());
	 for(int i=1;i<s.size();i++)
	 {
		System.out.println(s);
	 }
}
@AfterTest
public void close()
{
	   driver.close();
}
}


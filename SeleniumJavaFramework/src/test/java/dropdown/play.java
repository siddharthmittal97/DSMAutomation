package dropdown;
//import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class play {
	public static WebDriver driver;
	@BeforeTest
	public void setup() throws Exception 
	 {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromeDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/signup");
		Thread.sleep(5000);
		driver.manage().window().maximize();
	}
	
	//Test Case 1 
	//Send First Name & Last Name & Phone No
	@Test
	public void rr() throws Exception 
	{
		Thread.sleep(2000);
		WebElement t = driver.findElement(By.name("firstname"));
		t.sendKeys("Siddharth");
		Thread.sleep(5000);
		driver.findElement(By.name("lastname")).sendKeys("Mittal");
		driver.findElement(By.name("reg_email__")).sendKeys("");;
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
	}
		
	
	//Test Case 2 
	//Fetch all the day from the drop-down
		@Test 
		public void day() 
		{
		//get all the date 	
		WebElement c = driver.findElement(By.id("day"));
		Select captureday = new Select(c);
		//WebElement a = captureday.getFirstSelectedOption();
		List<WebElement> a = captureday.getOptions();
		   for(WebElement e :a)
		   {
			String p = e.getText();
			System.out.println(p);
		   }
		 }
		
		//Test Case 3 
		//Fetch only the selected option
		@Test
		public void month() throws InterruptedException
		{
		//get only selected option	
	      Thread.sleep(5000);
		  WebElement mon = driver.findElement(By.id("month"));
		  Select dayobj = new Select(mon);
		  List<WebElement> b = dayobj.getAllSelectedOptions();
		  for(WebElement e :b)
		   {
			String y1 = e.getText();
			System.out.println(y1);
			Assert.assertEquals(y1, "Sept");
		   }
		 
		}
		
		//Test Case 2 
		//Fetch all the year from the drop-down
		@Test
		public void year() throws InterruptedException
		{
			Thread.sleep(5000);
			WebElement year = driver.findElement(By.id("year"));
			Select select = new Select(year);
	        List<WebElement> listyears = select.getOptions();
	        for(int i=0;i<listyears.size();i++)
	        {
	        	String val = listyears.get(i).getText();
	            System.out.println(val);
	        }
	        //System.out.println(listyears);
	        }
		}				

 
	
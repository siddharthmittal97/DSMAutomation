package Perfect;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.common.collect.Table.Cell;

public class SF {
	WebDriver driver = null;
	public void Setup() 
	{
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
	}
	public void Login() throws Exception 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("siddharthautomation@mirketa.com");
		driver.findElement(By.id("password")).sendKeys("Password");
		driver.findElement(By.id("rememberUn")).click();
		
		driver.findElement(By.id("Login")).click();
		driver.get("https://ap16.lightning.force.com/lightning/o/Account/home");
		Thread.sleep(9000);
	    driver.findElement(By.xpath("//div[contains(text(),'New')]")).click();
	    Thread.sleep(10000);
		File a = new File("C:\\Users\\user\\Desktop\\Selenium Code\\Password.xlsx");
		FileInputStream fs = new FileInputStream(a);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);	
		String data = sheet.getRow(3).getCell(0).getStringCellValue();
		WebElement c = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
	    c.sendKeys(data);
	    Thread.sleep(8000);
	    long data2 =  (long) sheet.getRow(3).getCell(1).getNumericCellValue();
	    String strCellValue = String.valueOf(data2);
	    driver.findElement(By.xpath("//div[contains(@class,'full forcePageBlock forceRecordLayout')]//div[1]//div[1]//div[1]//div[2]//div[2]//div[1]//div[1]//div[1]//input[1]")).sendKeys(strCellValue);
	    //driver.findElement(By.xpath(""));
	    driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--brand uiButton forceActionButton']//span[contains(@class,'label bBody')]")).click();
	   
	}

	public static void main(String[] args) throws Exception {
		SF a = new SF();
		a.Setup();
        a.Login();
	}

}

//System.out.println(sheet);

/*
	String data = sheet.getRow(3).getCell(0).getStringCellValue();
	WebElement c = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/article[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
	for(int i = 0;i<2;i++)
	{
		c.sendKeys(data+i);
	}
*/

//for (Row myrow : sheet) {
//   for (org.apache.poi.ss.usermodel.Cell mycell : myrow) {  	
  // }
// }

//driver.findElement(By.)
//driver.findElement(By.cssSelector("input.input")).sendKeys(data);		


//List<WebElement> d2 = driver.findElements(By.xpath("//input"));
//d2.
package Task;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	    WebDriver driver = null;
	    
	    
	    public void forgotpassword() {
		driver.findElement(By.id("forgot_password_link")).click();
		}
	    
	    public static void main(String[] args) throws Exception {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://login.salesforce.com/";
		driver.get(baseUrl);
		Thread.sleep(2000);
		
		/*
		 File a = new File("C:\\Users\\user\\Desktop\\Selenium Code\\Password.xlsx");
		
		FileInputStream fs = new FileInputStream(a);
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheetAt(0);
		String data = sheet.getRow(3).getCell(0).getStringCellValue();
		System.out.println(data);
		//String data2 = sheet.getRow(1).getCell(1).getStringCellValue();
		//WebElement username  = driver.findElement(By.xpath("//input[@id='username']")); 
	    //username.sendKeys(data);
	    //WebElement password  = driver.findElement(By.id("password"));
	    //password.sendKeys(data2);
	    //Thread.sleep(3000);
	    //driver.manage().window().maximize();
	    //password.submit();
	     * 
	     */
	}

}

package SiddharthPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Siddharthclass1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		googlesearch();
	}	
    public static void googlesearch() {
    	String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.google.com/");
        driver.manage().window().maximize(); 
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Mirketa Salesforce Company\n");
    }
}

package AmazonPackage;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Amazon2 {
	public static void main(String[] args) throws Exception {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		
		//set the property
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    
		//navigate to amazon
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		
		//maximize 
		driver.manage().window().maximize();
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		
		//Sign in 
		//Username
		driver.findElement(By.name("email")).sendKeys("siddharthmittal97@gmail.com");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		driver.findElement(By.className("a-button-input")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		
		//Password Sending 
		driver.findElement(By.name("password")).sendKeys("Password");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		driver.findElement(By.id("signInSubmit")).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS );
		
		//Choosing Hamburger menu
		driver.findElement(By.id("nav-hamburger-menu")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		
		//Choosing the Women's Fashion
		driver.findElement(By.xpath("//div[@id='hmenu-container']//ul[1]//li[12]//a[1]")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		
		// Western Wear Selection
		driver.findElement(By.xpath("//div[@id='hmenu-container']//ul[11]//li[4]//a[1]")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		
		//Scroll until that Element is not found 
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement Element = driver.findElement(By.cssSelector("body.a-aui_157141-c.a-aui_72554-c.a-aui_dropdown_187959-c.a-aui_pci_risk_banner_210084-c.a-aui_perf_130093-c.a-aui_tnr_v2_180836-c.a-aui_ux_145937-c.a-meter-animate:nth-child(2) div.a-fixed-left-flipped-grid.s-padding-left-small.s-padding-right-small.s-span-page.a-spacing-top-small:nth-child(31) div.a-fixed-left-grid-inner div.a-fixed-left-grid-col.a-col-right:nth-child(1) div.lp.s-padding-left-small.twoColumn div.a-section:nth-child(1) section.sl-sobe-card-desktop.celwidget.csm-placement-id-4e516b8e-f327-4164-8404-514aa9e0827c.csm-widget-ref-QANav11CTA_en_IN.csm-pageid-11400137031.csm-widget-type-navigationeditorial:nth-child(22) div.sl-sobe-carousel div.sl-sobe-carousel-viewport div.sl-sobe-carousel-viewport-row ol.sl-sobe-carousel-viewport-row-inner li.sl-sobe-carousel-sub-card.celwidget.csm-placement-id-4e516b8e-f327-4164-8404-514aa9e0827c_3.csm-widget-ref-QANav11CTA_en_IN_3.csm-pageid-11400137031.csm-widget-type-navigationeditorial-tile.csm-widget-tile-3:nth-child(3) a.sl-sobe-carousel-sub-card-image > img.a-dynamic-image.sl-sobe-carousel-sub-card-img"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		Element.click();
		
		
		//Choosing Baby if you want
		//Select wew = new Select(driver.findElement(By.name("url")));
		//new.selectByValue("search-alias=baby");
		
		//Choosing 1 Star & above
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(2000);
		driver.findElement(By.className("a-icon a-icon-star-medium a-star-medium-1")).click();
	}

}

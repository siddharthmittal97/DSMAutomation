package DSMAutomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ExcelDSM.Exceldsm;
/*  
 * Object Model 
 */

public class Elements 
{	
  Exceldsm Excel = new Exceldsm();
  String Path ="C:\\\\Users\\\\user\\\\Desktop\\\\Selenium Code\\\\DSM.xlsx";
  WebDriver driver;
 
 By username        = By.xpath("//input[@id='username']");
 By password        = By.id("password");
 By Login           = By.id("Login");
 By OpenAppLauncher = By.xpath("//div[@class='slds-icon-waffle']");
 By ClickMore       = By.xpath("//*[@class='slds-button slds-p-horizontal--small']/button");
 By InputDSM        = By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input");
 By ZeroIndex       = By.xpath("//div[@tabindex='0']");
 By HomePageText    = By.xpath("//span[@class='appName slds-context-bar__label-action slds-context-bar__app-name']/span[@title='Duplicate Search and Merge']");
 By SearchMergeTab  = By.xpath("//a[@title='Search and Merge']");
 By Screen1Text1    = By.xpath("//div[@class='slds-col slds-size_10-of-12']/h3");
 By Screen1Text2    = By.xpath(("//div[@id='queryDiv']/label/p"));
 By Screen1Text3    = By.xpath("//label[@class='uiLabel-left form-element__label uiLabel slds-m-top_small']/p");
 By Screen1Italics  = By.xpath("//label[@class='uiLabel-left form-element__label uiLabel slds-m-top_small']/i");
 By HelpIcon1       = By.xpath("//span[@class='helpIcon']");
 By HelpText1       = By.xpath("//div[@class='slds-modal__content slds-p-around_medium']/p");
 By CloseHelpText1  = By.xpath("//button[@title='Cancel']");
 By PreviousText1   = By.xpath("//span[@class='slds-float_right slds-p-top_x-small']/b");
 By SelectObjects   = By.xpath("//select[@name='selectObject']");
 By FirstNextButton = By.xpath("//button[@class='slds-button slds-button_neutral slds-float_right Custom_btn btn1']");
 
 public Elements(WebDriver driver)
  {
	 this.driver=driver;
  }
 
 public void Setup() throws Exception
  {
	 String projectpath = System.getProperty("user.dir");
	 System.out.println("projectpath : "+projectpath);
	 System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromeDrivers\\chromedriver.exe");
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--disable-notifications");
	 driver = new ChromeDriver(options);
	 driver.get("https://login.salesforce.com");
	 Thread.sleep(2000);
	 driver.manage().window().maximize();
  }
 
 public void InputUsername()
  {
	 
	 Excel.ExcelReader1(Path);
	 String Userdata = Excel.getData(0,1,0);
	 driver.findElement(username).sendKeys(Userdata);
  }

 
 public void InputPassword()
  {
	 Excel.ExcelReader1(Path);
	 String PasswordDSM = Excel.getData(0,1,1);
	 driver.findElement(password).sendKeys(PasswordDSM);
  }
 
 
 public void LoginClick()
  {
	 driver.findElement(Login).click();
	 System.out.println("Login Sucessful");
  }
 
 public void OPENDSM() throws Exception
  {
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
	 driver.findElement(OpenAppLauncher).click();
	 Thread.sleep(2000);
	 driver.findElement(ClickMore).click();
	 Thread.sleep(1000);
	 driver.findElement(InputDSM).sendKeys("Duplicate Search and Merge");
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
	 Thread.sleep(5000);
	 driver.findElement(ZeroIndex).click();
	 Thread.sleep(1500);
  }
 
 public void HomeText()
  {
	 Excel.ExcelReader1(Path);
	 String ExpectedHomeText = Excel.getData(0,3,0);
	 String ActualHomeText = driver.findElement(HomePageText).getText();
	 Assert.assertEquals(ExpectedHomeText, ActualHomeText);
  }

 public void LandOnSearchAndMergeTab() throws Exception
  {
	 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
	 Thread.sleep(5000);
	 WebElement b = driver.findElement(SearchMergeTab);
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
     executor.executeScript("arguments[0].click();", b);	
     Thread.sleep(5000);
     System.out.println("Landed on DSM");
  }
 
public void Screen1Text1Verify() 
  {
	Excel.ExcelReader1(Path);
	String ExpectedText1 = Excel.getData(0,4,0);
	String ActualText1 = driver.findElement(Screen1Text1).getText();
	Assert.assertEquals(ExpectedText1, ActualText1);
  }

public void Screen1Text2Verify() 
  {
	Excel.ExcelReader1(Path);
	String ExpectedText2 = Excel.getData(0,5,0);
	String ActualText2 = driver.findElement(Screen1Text2).getText();
	Assert.assertEquals(ExpectedText2, ActualText2);
  }

public void Screen1Text3Verify() 
  {
	Excel.ExcelReader1(Path);
	String ExpectedText3 = Excel.getData(0,6,0);
	String ActualText3 = driver.findElement(Screen1Text3).getText();
	Assert.assertEquals(ExpectedText3, ActualText3);
  }

public void Screen1Text4Verify() 
  {
	Excel.ExcelReader1(Path);
	String ExpectedText4 = Excel.getData(0,7,0);
	String ActualText4 = driver.findElement(Screen1Italics).getText();
	Assert.assertEquals(ExpectedText4, ActualText4);
  }

public void HelpIconClick1() throws Exception
  {
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
	Thread.sleep(4000);
	driver.findElement(HelpIcon1).click();
  }

public void HelpTextScreen1Verification() throws Exception
  {
	Thread.sleep(2500);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
	String ExpectedHelpText1 = Excel.getData(0,8,0);
	String ActualHelpText1 = driver.findElement(HelpText1).getText();
	Assert.assertEquals(ExpectedHelpText1, ActualHelpText1);
  }

public void ClosingHelpText1() throws Exception
  {
	Thread.sleep(2500);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
	driver.findElement(CloseHelpText1).click();
  }

public void FirstPreviousText()
  {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
	String ExpectedPreviousText1 = Excel.getData(0,9,0);
	String ActualPreviousText1 = driver.findElement(PreviousText1).getText();
	Assert.assertEquals(ExpectedPreviousText1, ActualPreviousText1);	
  }

public void ChooseObejcts()
  {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
    WebElement fetchobj = driver.findElement(SelectObjects);
    Select select = new Select(fetchobj);        
    String expected[] = {"Please Select", "Order", "Account", "Contact", "Lead", "Opportunity" , "mir"};
    List<WebElement> a = select.getOptions();
    for(int i=0;i<a.size();i++)
    {
     //String val = a.get(i).getText();
     //System.out.println(val);
     Assert.assertEquals(expected[i], a.get(i).getText());
    }
   }

public void ToastMessageScreen1()
  {
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(FirstNextButton).click();
  }

public void ChooseLead()
  {
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebElement fetchobj = driver.findElement(SelectObjects);
	Select select = new Select(fetchobj);
	select.selectByIndex(4);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(FirstNextButton).click();	
  }


}

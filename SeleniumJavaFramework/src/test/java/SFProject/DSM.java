package SFProject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class DSM {
	    public static WebDriver driver;
	    static WebElement button;
	    Logger log = Logger.getLogger(DSM.class);
	    //public static void main(String[] args) throws Exception {
        @BeforeTest() 	
	    public void Setup() {	
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath : "+projectpath);
		System.setProperty("webdriver.chrome.driver" , projectpath+"\\Drivers\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
        }
		
        
        //Test Case 1 
        //**************************Login to Salesforce******************************************
        @Test(priority=1)
        public void LoginToDSM() {
		driver.get("https://login.salesforce.com");
		log.info("Sucessfully Enter into the Salesforce Login Page");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("advityaQAtesting@mirketa.com");
		driver.findElement(By.id("password")).sendKeys("Mirketa90+");
		//driver.findElement(By.id("rememberUn")).click();
		driver.findElement(By.id("Login")).click();
		log.info("Login Sucessful");
		System.out.println("Login Sucessful");
        }
		
        
        //Test Case 2 
        // *********************Opening DSM APP**************************************** 
        @Test(priority=2)
        public void Hamberger() throws Exception {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS );
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		driver.findElement(By.xpath("//*[@class='slds-button slds-p-horizontal--small']/button")).click();
		Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grow slds-input-has-icon slds-input-has-icon_left-right']/input")).sendKeys("Duplicate Search and Merge");		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@tabindex='0']")).click();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);
		String Actual = driver.findElement(By.xpath("//span[@class='appName slds-context-bar__label-action slds-context-bar__app-name']/span[@title='Duplicate Search and Merge']")).getText();
		//System.out.println(Actual);
		Assert.assertEquals(Actual, "Duplicate Search and Merge", "Test Case Fail Please have a look Urgently");
		Thread.sleep(5000);
		System.out.println("Landed on the Home Page of DSM");
	    }
        
        
        //****************************Going to the Search & Merge Tab****************************
        @Test(priority=3)
        public void SearchAndMergeTab() throws Exception {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS );
		Thread.sleep(5000);		
		//If you want to acess the Dashboard
		/*WebElement a = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", a);	
        Thread.sleep(5000);
        */        
		WebElement b = driver.findElement(By.xpath("//a[@title='Search and Merge']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", b);	
        Thread.sleep(5000);
		//driver.navigate().to("https://advitya-qa-testing-dev-ed.lightning.force.com/lightning/n/advitya__Manage_Saved_Search");
		//driver.get("https://advitya-qa-testing-dev-ed.lightning.force.com/lightning/n/advitya__Manage_Saved_Search");
        }
        
        
        //Test Case 1 
        //**********************Verifying the Text on the Top of Search and Merge**************** 
        @Test(priority=4)
        public void Scrren1Text1() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        String ActualText = driver.findElement(By.xpath("//div[@class='slds-col slds-size_10-of-12']/h3")).getText();
        Assert.assertEquals(ActualText, "Either select a previously run data cleanup job or create a new data cleanup job by selecting the data object that requires data de-duplication.", "Test Case Fail Please have a look Urgently");
        Thread.sleep(2000);
        }
        
        
        //Test Case 2
        //*****************Verify the Text Under Pick a Saved Job*********************************
        @Test(priority=5)
        public void Scrren1Text2() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        String ActualText2 = driver.findElement(By.xpath("//div[@id='queryDiv']/label/p")).getText();
        Assert.assertEquals(ActualText2,"Select a data cleanup job from the list of previously run jobs.","Test Case Fail Please have a look Urgently");
        Thread.sleep(3000);	
        }
        
        
        //********************* Verify the Text Under Pick the object that requires data cleanup Text**********
        @Test(priority=6)
        public void Screen1Text3() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        String ActualText3 = driver.findElement(By.xpath("//label[@class='uiLabel-left form-element__label uiLabel slds-m-top_small']/p")).getText();
        Assert.assertEquals(ActualText3,"Select an object that requires data cleanup from the list of objects.","Test Case Fail Please have a look Urgently");
        Thread.sleep(3000);
        }
        
        //***************************Verify the Italics text on the First Screen*********************
        @Test(priority=7)
        public void Screen1ItalicsText4() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        String ActualText4 = driver.findElement(By.xpath("//label[@class='uiLabel-left form-element__label uiLabel slds-m-top_small']/i")).getText();
        Assert.assertEquals(ActualText4,"(The dropdown shows objects on which you have sufficient permissions to modify)","Test Case Fail Please have a look Urgently");
        Thread.sleep(2000);
       }
        
        //***************************** Verify All the Objects*****************************
        @Test(priority=8)
        public void ListOfObjects() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        WebElement fetchobj = driver.findElement(By.xpath("//select[@name='selectObject']"));
        Select select = new Select(fetchobj);        
        String expected[] = {"Please Select", "Order", "Account", "Contact", "Lead", "Opportunity" , "mir"};
        List<WebElement> a = select.getOptions();
        for(int i=0;i<a.size();i++)
           {
        	String val = a.get(i).getText();
        	System.out.println(val);
        	Assert.assertEquals(expected[i], a.get(i).getText());
           }
        Thread.sleep(5000);
        }
        
        
        //***************************Text Before Previous Button****************************
        @Test(priority=9)
        public void FirstPreviousText() throws Exception {
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Actual5 = driver.findElement(By.xpath("//span[@class='slds-float_right slds-p-top_x-small']/b")).getText();
        String Expected5 = "Create Duplicate Search Criteria";
        Assert.assertEquals(Actual5, Expected5);
        }
        
        //****************************Toast Message Appear************************************
        @Test(priority=10)
        public void FirstScreenNextClick() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral slds-float_right Custom_btn btn1']")).click();
        System.out.println("Toast message appear");
        }
        
        //****************************Choose Lead Object + Then Move Next************************
        @Test(priority=11)
        public void SelectAnyObject() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
        WebElement fetchobj = driver.findElement(By.xpath("//select[@name='selectObject']"));
        Select select = new Select(fetchobj);
        select.selectByIndex(4);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral slds-float_right Custom_btn btn1']")).click();
        Thread.sleep(2000);
        }
        
        //**************************************SECOND SCREEN STARTED********************************
        //************************************** Top Text Verification + Dynamic Text ***************
        /*
        @Test(priority=12)
        public void Screen2Text1() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String dynamic = driver.findElement(By.xpath("//span[@class='blueColor']")).getText();
        String SText1 = driver.findElement(By.xpath("//div[@class='slds-col slds-size_10-of-12']/h3")).getText();
        Assert.assertEquals(SText1, "You have selected the following source object for searching data duplicates:"+dynamic);
        }
        */
        
        
        //**************************************Text Under 2(a) *************************************
        @Test(priority=13)
        public void Screen2Text2() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String SText2 = driver.findElement(By.xpath("//label[@class='mycolor']/p")).getText();
        Assert.assertEquals(SText2, "Pick up to 5 fields that you want to use for searching for the duplicates. Read help text to learn more.");
        }
        
        //***************************************** Text Under 2(b) *********************************
        @Test(priority=14)
        public void Screen2Text3() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String SText3 = driver.findElement(By.xpath("//label/p[contains(text(),'Enter the exact duplicate search value corresponding to a field for searching duplicates. Read help to learn more.')]")).getText();
        String ExpectedSecondText3 = "Enter the exact duplicate search value corresponding to a field for searching duplicates. Read help to learn more.";
        Assert.assertEquals(SText3, ExpectedSecondText3);
        }
        
        
        //******************************************Choosing Last Name *******************************
        @Test(priority=15)
        public void ChooseField1() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Select obj = new Select(driver.findElement(By.xpath("//select[@name='field1']")));
        obj.selectByIndex(1);
        Thread.sleep(3000);  
        }
		
        
        //*********************************Choosing First Name***************************************
        @Test(priority=16)
        public void ChooseField2() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Select obj2 = new Select(driver.findElement(By.xpath("//select[@name='field2']")));
        obj2.selectByIndex(2);
        Thread.sleep(2000);
        }
        
        
        //****************************Bottom Text Verification***************************************
        @Test(priority=17)
        public void NextPreviousTextCheck() throws Exception {
        Thread.sleep(2000);	
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral btn1 slds-m-left_small']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", button);
        String ActualNextButtonText = driver.findElement(By.xpath("//span[@class='btnlabel labelalign ']/b")).getText();
        String ExpectedSecondScreenButtonText = "Create Duplicates Merge Logic";
        Assert.assertEquals(ActualNextButtonText, ExpectedSecondScreenButtonText);        
        Thread.sleep(2000);
        String ExpectedSecondPreviousText = "Pick a job or Create a new job"; 
        String ActualSecondPreviousText = driver.findElement(By.xpath("//span[@class='btnlabel']/b")).getText();
        Assert.assertEquals(ActualSecondPreviousText, ExpectedSecondPreviousText);
        Thread.sleep(2500);
        }
        
        
        //***************************** Next Button Click *********************************************
        @Test(priority=18)
        public void SecondScreenNextClick() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral btn1 slds-m-left_small']"));
        button.click();
        Thread.sleep(2000);
        }
        
        
        //*****************************Third Screen Started***********************************************
        //**************************** 3A Text Verification **********************************************
        @Test(priority=19)
        public void Screen3Text1() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Actual3A = driver.findElement(By.xpath(" //p[contains(text(),'You can pick up to 3 different criteria for system to automatically identify the record that you would like to keep. You can change the record to be retained on the search results page in the next step.')]")).getText();
        String Expected3A = "You can pick up to 3 different criteria for system to automatically identify the record that you would like to keep. You can change the record to be retained on the search results page in the next step.";
        Assert.assertEquals(Actual3A, Expected3A);
        }
        
        
        //**************************** 3B Text Verification **********************************************
        @Test(priority=20)
        public void Screen3Text2() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Actual3B = driver.findElement(By.xpath("//p[contains(text(),'Select fields for fuzzy search.')]")).getText();
        String Expected3B = "'Select fields for fuzzy searc.'";
        Assert.assertEquals(Actual3B, Expected3B);
        Thread.sleep(2000);
        }     
        
        //********************************Buttons Text Verification**********************************************
        @Test(priority=21)
        public void ThirdPreviousText() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Actual3Previous = driver.findElement(By.xpath("//span[@class='btnlabel']/b")).getText();
        String Expected3Previous = "Update Duplicate Search Criteria";
        Assert.assertEquals(Actual3Previous, Expected3Previous);
        Thread.sleep(1000);
        } 
        
        
        //************************** Next Button Text *********************************************************
        @Test(priority=22)
        public void ThirdNextText() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String Actual3Next = driver.findElement(By.xpath("//span[@class='btnlabel labelalign ']/b")).getText();
        String Expected3Next = "View Duplicate Records";
        Assert.assertEquals(Actual3Next, Expected3Next);
        Thread.sleep(1000);
        }
        
        //************************* Next Button Click (Third Screen)***********************************************
        @Test(priority=23)
        public void ThirdScreenNextClick() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral btn1 slds-m-left_small']")).click();
        } 
        
        
        @AfterTest() 
        public void quit()
        {
        	//driver.quit();
        }
}

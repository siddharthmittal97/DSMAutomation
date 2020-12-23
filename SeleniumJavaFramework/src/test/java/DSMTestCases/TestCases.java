package DSMTestCases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import DSMAutomation.Elements;
import ExcelDSM.Exceldsm;
public class TestCases {	
	static WebDriver driver;
	Elements login = new Elements(driver);	
	
	@Test(priority=1,description="Test Case 1 Login Verification")
	public void LoginSF() throws Exception
	{		
	//Importing the Elements Class 
		
		login.Setup();
		login.InputUsername();
		login.InputPassword();
		login.LoginClick();
	}
	
	@Test(priority=2,description="Test Case 2 DSM APP Open")
	public void OpenAPP() throws Exception
	{
		Thread.sleep(2000);
		login.OPENDSM();
	}
	
	@Test(priority=3,description="Test Case 3 Home Page Text Verification")
	public void AppTitleVerify() throws Exception
	{
		Thread.sleep(2000);
		login.HomeText();
	}
	
	@Test(priority=4,description="Test Case 4 Screen1Text 1 Verificaion")
	public void Screen1Text1() throws Exception
	{
		login.LandOnSearchAndMergeTab();
		login.Screen1Text1Verify();		
	}
	
	@Test(priority=5,description="Test Case 5 Screen1Text2 Verificaion")
	public void Screen1Text2() throws Exception
	{
		login.Screen1Text2Verify();		
	}
	
	@Test(priority=6,description="Test Case 6 Screen1Text3 Verificaion")
	public void Screen1Text3() throws Exception
	{
		login.Screen1Text3Verify();	
	}
	
	@Test(priority=7,description="Test Case 7 ItalicsText Verification")
	public void Scrren1Text4() throws Exception
	{
		login.Screen1Text4Verify();	
	}
	
	@Test(priority=8,description="Test Case 8 Help Icon Click Verification")
	public void HelpIcon1Open() throws Exception
	{
	    login.HelpIconClick1();
	}
	
	@Test(priority=9,description="Test Case 9 Help Text Verification")
	public void HelpText1() throws Exception
	{
		login.HelpTextScreen1Verification();
	}
	
	@Test(priority=10,description="Test Case 10 Closing Help Text")
	public void CloseHelpText1() throws Exception
	{
		login.ClosingHelpText1();
	}
	
	@Test(priority=11,description="Test Case 11 Text Before Previous Text")
	public void PreviousText1()
	{
		login.FirstPreviousText();
	}
	
	@Test(priority=12,description="Test Case 12 Verify Objects")
	public void VerifyObjects()
	{
		login.ChooseObejcts();
	}
	
	@Test(priority=13,description="Test Case 13 Toast Appear")
	public void ToastMessage1()
	{
		login.ToastMessageScreen1();
	}
	
	@Test(priority=14,description="Test Case 14 Choose Lead")
	public void ChooseLeadObject()
	{
		login.ChooseLead();
	}
}

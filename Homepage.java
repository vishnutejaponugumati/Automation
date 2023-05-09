package com.test.automation.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.test.automation.uiAutomation.excelReader.ExcelUtils;
import com.test.automation.uiAutomation.testBase.Testbase;

public class Homepage {
	ExcelUtils excel_Reader;
	public static String FilePath ="src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx";
	public static String SheetName = "LoginTestData";
	public static final Logger log = Logger.getLogger(Testbase.class.getName());

	/*public static String username ;
	public static String Password;*/
	//ExcelUtils excel_Reader;
	WebDriver driver;
	@FindBy(xpath="//A[@class='login']")
	WebElement signin;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement loginPassword;
	
	@FindBy(xpath="//input[@name='loginPatientInfo']")
	WebElement loginSubmitButton;
	
	@FindBy(xpath="//LI[text()='Authentication failed.']")
	WebElement loginAuthentication;
	@FindBy(xpath="//*[@class='header_user_info'][1]")
	WebElement Logedusername;
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithInvalid() throws Exception {
		// TODO Auto-generated method stub
		signin.click();
		excel_Reader.setExcelFile(FilePath.toString(), SheetName.toString());
		String username = "testlogin";
		String Password = "mX+3bS_=u";
		//int password1 = Integer.parseInt(Password);
		System.out.println("Username is : "+username);
		System.out.println("Password is : "+Password);

		log.info(username+" is entered in username text box" );
		log.info(Password+" is entered in Password text box" );

		loginEmailAddress.sendKeys(username);
		loginPassword.sendKeys(Password);
		loginSubmitButton.click();
		log.info("Click action is performed on Submit button");

		
	}
	public void loginWithvalid() throws Exception {
		// TODO Auto-generated method stub
		signin.click();
		excel_Reader.setExcelFile(FilePath.toString(), SheetName.toString());
		String username = excel_Reader.getCellData(2, 0).toString();
		String Password = excel_Reader.getCellData(2, 1).toString();
		
		System.out.println("Username is : "+username);
		System.out.println("Password is : "+Password);

		log.info(username+" is entered in username text box" );
		log.info(Password+" is entered in Password text box" );

		loginEmailAddress.sendKeys(username);
		loginPassword.sendKeys(Password);
		loginSubmitButton.click();
		log.info("Click action is performed on Submit button");

		
	}
	/* @DataProvider(name="Authentication")

	    public Object[][] Authentication() throws Exception{

	         Object[][] testObjArray = excel_Reader.getExcelData("src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx","LoginTestData");

	         return (testObjArray);

			}*/

	  

	 
	  // Here we are calling the Data Provider object with its Name
	 
	
	public String getInvalidLoginText() {
		return loginAuthentication.getText();
		// TODO Auto-generated method stub
	}
	public String getloginUserName() {
		// TODO Auto-generated method stub
return Logedusername.getText();
	}
}

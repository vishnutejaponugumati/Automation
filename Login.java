package com.test.automation.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.excelReader.ExcelUtils;
import com.test.automation.uiAutomation.testBase.Testbase;

public class Login {
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
	
	@FindBy(xpath="//INPUT[@id='email']")
	WebElement loginEmailAddress;
	
	@FindBy(xpath="//INPUT[@id='passwd']")
	WebElement loginPassword;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	WebElement loginSubmitButton;
	
	@FindBy(xpath="//LI[text()='Authentication failed.']")
	WebElement loginAuthentication;
	@FindBy(xpath="//*[@class='header_user_info'][1]")
	WebElement Logedusername;
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void loginWithInvalid() throws Exception {
		// TODO Auto-generated method stub
		signin.click();
		excel_Reader.setExcelFile(FilePath.toString(), SheetName.toString());
		String username = excel_Reader.getCellData(1, 0).toString();
		String Password = excel_Reader.getCellData(1, 1).toString();
		System.out.println("Username is : "+username);
		System.out.println("Password is : "+Password);

		log.info(username+" is entered in username text box" );
		log.info(Password+" is entered in Password text box" );

		loginEmailAddress.sendKeys(username);
		loginPassword.sendKeys(Password);
		loginSubmitButton.click();
		log.info("Click action is performed on Submit button");

		
	}
	 @Test(dataProvider="Authentication")

	public void loginWithvalid(String username,String Password) throws Exception {
		// TODO Auto-generated method stub
		signin.click();
		
		
		System.out.println("Username is : "+username);
		System.out.println("Password is : "+Password);

		log.info(username+" is entered in username text box" );
		log.info(Password+" is entered in Password text box" );

		loginEmailAddress.sendKeys(username);
		loginPassword.sendKeys(Password);
		loginSubmitButton.click();
		log.info("Click action is performed on Submit button");

		
	}
	 @DataProvider
	    public Object[][] Authentication() throws Exception{

	       //  Object[][] testObjArray = excel_Reader.getExcelData("src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx","LoginTestData");

	        // return (testObjArray);
		 //return new Object[][]{{"automation@gmail.com", "gsgsdsdg"}, {"testmail3887640@gt.com", "DFGBHNJM"}};
		 Object[][] data = new Object[3][2];

			// 1st row
			data[0][0] ="sampleuser1@gdfg.sdf";
			data[0][1] = "abcdef";

			// 2nd row
			data[1][0] ="testuser2@dsfsdf.ds";
			data[1][1] = "zxcvb";
			
			// 3rd row
			data[2][0] ="guestuser3@dfsd.cd";
			data[2][1] = "pass123";

			return data;
		 	}

	  

	 
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

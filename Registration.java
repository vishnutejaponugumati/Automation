package com.test.automation.uiAutomation.uiActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.Random;

import com.test.automation.uiAutomation.excelReader.ExcelUtils;

public class Registration   {
	ExcelUtils excel_Reader;
	public static String FilePath ="src/main/java/com/test/automation/uiAutomation/data/TestData.xlsx";
	public static String SheetName = "RegistrationTestData";
	WebDriver driver;
	@FindBy(xpath="//A[@class='login']")
	WebElement signin;
	
	@FindBy(xpath="//INPUT[@id='email_create']")
	WebElement createEmail;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	WebElement SubmitCreate;
	
	@FindBy(xpath="//*[@id='id_gender1']")
	WebElement genderMale;
	
	@FindBy(xpath="//*[@id='id_gender2']")
	WebElement genderFemale;
	
	@FindBy(xpath="//INPUT[@id='customer_firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//INPUT[@id='customer_lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//*[@id='days']")
	WebElement day;
	
	@FindBy(xpath="//*[@id='months']")
	WebElement month;
	
	@FindBy(xpath="//*[@id='years']")
	WebElement years;
	
	@FindBy(xpath="//*[@id='company']")
	WebElement company;
	
	@FindBy(xpath="//*[@id='address1']")
	WebElement address1;
	
	@FindBy(xpath="//*[@id='city']")
	WebElement city;
	
	@FindBy(xpath="//*[@id='id_state']")
	WebElement state;
	
	@FindBy(xpath="//*[@name='postcode']")
	WebElement postalcode;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	WebElement mobile;
	
	@FindBy(xpath="//*[@id='submitAccount']")
	WebElement submitAccount;
	
	@FindBy(xpath="//*[@class='header_user_info'][1]")
	WebElement Logedusername;
	
	@FindBy(xpath="//*[text()='An account using this email address has already been registered. Please enter a valid password or request a new one. ']")
	WebElement alreadyRegistered;
	
	public Registration(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void tegistrationToApplication() throws Exception {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;

		signin.click();
		excel_Reader.setExcelFile(FilePath.toString(), SheetName.toString());
		Random rand = new Random();
		int randnum = rand.nextInt(10000000);
		String email = "testmail"+randnum+"@gt.com";
		System.out.println(email);
		 String firstname= excel_Reader.getCellData(1, 1).toString();
		 String lastname= excel_Reader.getCellData(1, 2).toString();
		 String Password=excel_Reader.getCellData(1, 3).toString();
		 String Company= excel_Reader.getCellData(1, 4).toString();
		 String Address1= excel_Reader.getCellData(1, 5).toString();
		 String City= excel_Reader.getCellData(1, 6).toString();
		 String Postalcode= excel_Reader.getCellData(1, 7);
		 String Mobile=excel_Reader.getCellData(1, 8);
		createEmail.sendKeys(email);
		SubmitCreate.click();
		genderMale.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		password.sendKeys(Password);
		Select Day = new Select(day);
		Day.selectByIndex(5);
		Select Month = new Select(month);
		Month.selectByIndex(5);
		Select Year = new Select(years);
		years.sendKeys("1993");
		company.sendKeys(Company);
		address1.sendKeys(Address1);
		city.sendKeys(City);
		Select State = new Select(state);
		State.selectByIndex(5);
		postalcode.sendKeys(Postalcode);
		mobile.sendKeys(Mobile);
		submitAccount.click();
		
	}
	public String getLoginUserName() {
		return Logedusername.getText();
		// TODO Auto-generated method stub
	}
	
	
	
}

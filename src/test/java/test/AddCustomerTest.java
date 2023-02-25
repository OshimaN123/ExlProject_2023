package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import page.AddCustomerPage;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {
	WebDriver driver;
ExcelReader excelRead=new ExcelReader("testData\\2023-02-19--TF_TestData.xlsx");
	
	String UserName=excelRead.getCellData("LoginInfo", "UserName", 2);
	String PassWord=excelRead.getCellData("LoginInfo", "Password", 2);
	String fullName=excelRead.getCellData("AddContactInfo", "FullName", 2);
	String company=excelRead.getCellData("AddContactInfo", "CompanyName", 2);
	String mail=excelRead.getCellData("AddContactInfo", "Email", 2);
	String Phone=excelRead.getCellData("AddContactInfo", "Phone", 2);
	String Address=excelRead.getCellData("AddContactInfo", "Address", 2);
	String City=excelRead.getCellData("AddContactInfo", "City", 2);
	String Country=excelRead.getCellData("AddContactInfo", "Country", 2);
	String State=excelRead.getCellData("AddContactInfo", "State", 2);
	String Zip=excelRead.getCellData("AddContactInfo", "Zip", 2);


	@Test
	public void userShouldBeAbleToAddCustomer() throws InterruptedException  {
		
		
		driver=BrowserFactory.init();
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.InsertUserName(UserName);
		loginPage.InsertPassword(PassWord);
		loginPage.clickOnSignInButton();
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardPage();
		dashboardPage.clickCustomerMenuElement();
		dashboardPage.clickAddCustomerMenuElement();
		
		AddCustomerPage addCustomerPage=PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.validateAddContactPage();
		
		addCustomerPage.insertFullName(fullName);
		addCustomerPage.insertPhone(Phone);
		addCustomerPage.selectCompany(company);
		addCustomerPage.insertEmail(mail);
		addCustomerPage.insertAddress(Address);
		addCustomerPage.selectCountry(Country);
		addCustomerPage.insertCity(City);
		addCustomerPage.insertZip(Zip);
		addCustomerPage.saveButton();
		addCustomerPage.validateProfilePage();
		dashboardPage.clickListAddCustomerMenuElement();
		
		addCustomerPage.validateInsertedNameAndDeleteOriginal();
		addCustomerPage.TestAlert();
	}

}

package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {
	WebDriver driver;
	ExcelReader excelRead=new ExcelReader("testData\\2023-02-19--TF_TestData.xlsx");
	
	String UserName=excelRead.getCellData("LoginInfo", "UserName", 2);
	String PassWord=excelRead.getCellData("LoginInfo", "Password", 2);
	
	@Test
	public void validUserShouldBeAbleToLogin() {
		driver=BrowserFactory.init();
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.InsertUserName(UserName);
		loginPage.InsertPassword(PassWord);
		loginPage.clickOnSignInButton();
		DashboardPage dashboardPage=PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashBoardPage();
		BrowserFactory.TearDown();
		
	}

}

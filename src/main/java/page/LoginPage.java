package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"username\"]")WebElement UserName_Element;
	@FindBy(how=How.XPATH, using="//*[@id=\"password\"]")WebElement PassWord_Element;
	@FindBy(how=How.XPATH, using="/html/body/div/div/div/form/div[3]/button")WebElement SignIn_Element;
public LoginPage(WebDriver driver){
		this.driver=driver;
		
	}
	
	public void InsertUserName(String userName) {
		UserName_Element.sendKeys(userName);
		
	}
	public void InsertPassword(String password) {
		PassWord_Element.sendKeys(password);
	}
	public void clickOnSignInButton() {
		SignIn_Element.click();
	}

	public void performLogin(String userName,String password) {
		UserName_Element.sendKeys(userName);
		PassWord_Element.sendKeys(password);
		SignIn_Element.click();
	}
}
